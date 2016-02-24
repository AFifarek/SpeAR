package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.lustre.PLTL;

import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.LustreUtil;
import jkind.lustre.NamedType;
import jkind.lustre.Node;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.VarDecl;
import jkind.lustre.builders.NodeBuilder;

public class SNode extends SContextElement {

	public static Set<SNode> convertList(Collection<Specification> list, SProgram context) {
		Set<SNode> converted = new HashSet<>();
		for(Specification s : list) {
			converted.add(new SNode(s,context));
		}
		return converted;
	}
	
	public String name;
	
	public List<SVariable> inputs = new ArrayList<>();
	public List<SVariable> outputs = new ArrayList<>();
	public List<SVariable> state = new ArrayList<>();
	public List<ShadowVariable> shadow_outputs = new ArrayList<>();
	public List<ShadowVariable> shadow_state = new ArrayList<>();
	public List<SMacro> macros = new ArrayList<>();
	public List<SConstraint> assumptions = new ArrayList<>();
	public List<SConstraint> requirements = new ArrayList<>();
	public List<SConstraint> behaviors = new ArrayList<>();
	
	public Map<NormalizedCall,SNode> calls = new HashMap<>();
	public Map<NormalizedCall,List<SAddArg>> directCalledArgs = new HashMap<>();
	public Map<NormalizedCall,List<SAddArg>> indirectCalledArgs = new HashMap<>();

	private static final String CONJUNCT_ID = "conjunct";
	private static final String HISTORICAL_CONJUNCT = "historic_conjunct";

	private String conjunctName;
	private String historicConjunctName;
	
	public SNode(Specification s, SProgram program) {
		//capture the name in the Program context
		this.name = program.scope.getUniqueNameAndRegister(s.getName());
		
		//process the global stuff first
		//TODO: this does not account for duplicates
		
		//set the local scope before processing local elements
		scope = new Naming(program.scope);
		for(NormalizedCall call : EcoreUtil2.getAllContentsOfType(s, NormalizedCall.class)) {
			/*
			 * What we need to do:
			 * 1. Create an SNode for the called node
			 * 2. Create additional args in the calling node to match the shadow vars in the called node.
			 *    - lets name them callX_specificationName_arg0
			 * 3. Map these calls to these additional args for lookup later
			 */
			SNode calledNode = new SNode(call.getSpec(), program);
			indirectCalledArgs.put(call, getIndirectArgs(calledNode));
			directCalledArgs.put(call, getDirectCalledArgs(this,calledNode,call.hashCode()));
			
			program.calledNodes.add(calledNode);
			calls.put(call, calledNode);
		}

		//set the local scope before processing local elements
		inputs.addAll(SVariable.convertList(s.getInputs(), this));
		outputs.addAll(SVariable.convertList(s.getOutputs(), this));
		state.addAll(SVariable.convertList(s.getState(), this));
		
		//create the shadow variables
		shadow_outputs.addAll(ShadowVariable.create(outputs, this));
		shadow_state.addAll(ShadowVariable.create(state, this));
		
		macros.addAll(SMacro.convertList(s.getMacros(), this));
		assumptions.addAll(SConstraint.convertList(s.getAssumptions(), this));
		requirements.addAll(SConstraint.convertList(s.getRequirements(), this));
		behaviors.addAll(SConstraint.convertList(s.getBehaviors(), this));
		
		this.conjunctName = scope.getUniqueNameAndRegister(CONJUNCT_ID);
		this.historicConjunctName = scope.getUniqueNameAndRegister(HISTORICAL_CONJUNCT);
	}
	
	private List<SAddArg> getIndirectArgs(SNode calledNode) {
		List<SAddArg> indirect = new ArrayList<>();
		for(NormalizedCall nce : calledNode.directCalledArgs.keySet()) {
			indirect.addAll(calledNode.directCalledArgs.get(nce));
		}
		return indirect;
	}

	private List<SAddArg> getDirectCalledArgs(SNode caller, SNode calledNode, Integer callNumber) {
		List<SAddArg> args = new ArrayList<>();
		List<ShadowVariable> shadowVars = new ArrayList<>();
		shadowVars.addAll(calledNode.shadow_outputs);
		shadowVars.addAll(calledNode.shadow_state);
		
		for(ShadowVariable sv : shadowVars) {
			String proposed = caller.name + "_call" + callNumber + "_" + calledNode.name + "_" + sv.name;
			String renamed = scope.getUniqueNameAndRegister(proposed);
			args.add(new SAddArg(renamed, sv.type));
		}
		return args;
	}
	
	public Collection<Node> getCalledNodes() {
		Set<Node> nodes = new HashSet<>();
		for(SNode called : calls.values()) {
			nodes.add(called.getLogicalEntailment().build());
		}
		return nodes;
	}
	
	private VarDecl getConjuctVarDecl() {
		return new VarDecl(this.conjunctName, NamedType.BOOL);
	}
	
	private Expr getConjunctExpr(Iterator<SConstraint> iterator) {
		SConstraint sc = iterator.next();
		IdExpr idExpr = new IdExpr(sc.name);
		if (iterator.hasNext()) {
			return new BinaryExpr(idExpr, BinaryOp.AND, getConjunctExpr(iterator));
		} else {
			return idExpr;
		}
	}
	
	private Equation getConjunctEquation(Naming naming) {
		List<SConstraint> conjunctElements = new ArrayList<>();
		conjunctElements.addAll(assumptions);
		conjunctElements.addAll(requirements);

		IdExpr lhs = new IdExpr(this.conjunctName);
		Expr rhs = getConjunctExpr(conjunctElements.iterator());
		return LustreUtil.eq(lhs,rhs);
	}
	
	private VarDecl getHistoricalConjunctVarDecl() {
		return new VarDecl(this.historicConjunctName, NamedType.BOOL);
	}
	
	private Equation getHistoricalConjunctEquation(Naming naming) {
		IdExpr lhs = new IdExpr(this.historicConjunctName);
		NodeCallExpr rhs = new NodeCallExpr(naming.lookup(PLTL.historically().id),new IdExpr(this.conjunctName));
		return LustreUtil.eq(lhs,rhs);
	}
	
	private Collection<VarDecl> getDirectVarDecls(SNode context) {
		List<VarDecl> dvd = new ArrayList<>();
		for(List<SAddArg> list : directCalledArgs.values()) {
			dvd.addAll(SAddArg.convert(list, context));
		}
		return dvd;
	}
	
	private Collection<VarDecl> getIndirectVarDecls(SNode context) {
		List<VarDecl> dvd = new ArrayList<>();
		for(List<SAddArg> list : this.indirectCalledArgs.values()) {
			dvd.addAll(SAddArg.convert(list, context));
		}
		return dvd;
	}
	
	private NodeBuilder getBaseLustre() {
		NodeBuilder builder = new NodeBuilder(this.name);
		
		/*
		 * The inputs for the node are:
		 * 1. the true inputs
		 * 2. the shadow variables for the outputs
		 * 3. the shadow variables for the state
		 */
		builder.addInputs(SVariable.toVarDecl(inputs, this));
		builder.addInputs(ShadowVariable.getVarDecls(shadow_outputs, this));
		builder.addInputs(ShadowVariable.getVarDecls(shadow_state, this));
		builder.addInputs(getDirectVarDecls(this));
		builder.addInputs(getIndirectVarDecls(this));
		
		/*
		 * The locals are:
		 * 1. the true state
		 * 2. the assumptions
		 * 3. the requirements
		 * 4. the behaviors
		 */
		builder.addLocals(SVariable.toVarDecl(state, this));
		builder.addLocals(SConstraint.getVarDecls(assumptions, this));
		builder.addLocals(SConstraint.getVarDecls(requirements, this));
		builder.addLocals(SConstraint.getVarDecls(behaviors, this));
		
		/*
		 * The outputs are only the true outputs of the specification
		 */
		builder.addOutputs(SVariable.toVarDecl(outputs, this));
		
		/*
		 * The equations are:
		 * 1. assignments of the true outputs to their shadow variables
		 * 2. assignments of the true state to their shadow variables
		 * 3. assignment of the assumptions
		 * 4. assignment of the requirements
		 * 5. assignment of the behaviors
		 */
		builder.addEquations(ShadowVariable.getEquations(shadow_outputs, this));
		builder.addEquations(ShadowVariable.getEquations(shadow_state, this));
		builder.addEquations(SConstraint.getEquations(assumptions, this));
		builder.addEquations(SConstraint.getEquations(requirements, this));
		builder.addEquations(SConstraint.getEquations(behaviors, this));

		return builder;
	}

	public NodeBuilder getLogicalEntailment() {
		NodeBuilder base = this.getBaseLustre();
		/*
		 * We must extend the base node with
		 * 1. the conjunct local
		 * 2. the historical conjunct local
		 * 3. the properties
		 */
		base.addLocal(this.getConjuctVarDecl());
		base.addLocal(this.getHistoricalConjunctVarDecl());
		base.addLocals(SConstraint.getPropertyVarDecls(behaviors, this));
		
		/*
		 * We must extend the base node equations with
		 * 1. the conjunct equation
		 * 2. the historical conjunct equation
		 * 3. the property equations
		 */
		base.addEquation(this.getConjunctEquation(this.scope));
		base.addEquation(this.getHistoricalConjunctEquation(this.scope));
		base.addEquations(SConstraint.getPropertyEquations(behaviors, new IdExpr(this.historicConjunctName), this));
		
		/*
		 * We must add each property to the list of properties
		 */
		base.addProperties(SConstraint.getProperties(behaviors, this));
		return base;
	}
	
	@Override
	public String toString() {
		return "node "+ name + " (" + StringUtils.join(inputs, ";") + ") returns (" + StringUtils.join(outputs, ";") + ")";
	}
}
