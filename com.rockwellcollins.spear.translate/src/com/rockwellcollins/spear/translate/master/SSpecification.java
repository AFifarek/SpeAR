package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.lustre.PLTL;
import com.rockwellcollins.spear.translate.naming.NameMap;

import jkind.lustre.BinaryOp;
import jkind.lustre.BoolExpr;
import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.NamedType;
import jkind.lustre.Node;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.VarDecl;
import jkind.lustre.builders.NodeBuilder;

public class SSpecification extends SFile {

	private String assertionName;
	private static final String ASSERTION = "assertions";
	
	public List<SMacro> macros = new ArrayList<>();
	public List<SVariable> inputs = new ArrayList<>();
	public List<SVariable> outputs = new ArrayList<>();
	public List<SVariable> state = new ArrayList<>();
	public List<SConstraint> assumptions = new ArrayList<>();
	public List<SConstraint> requirements = new ArrayList<>();
	public List<SConstraint> behaviors = new ArrayList<>();
	public Map<NormalizedCall, SCall> calls = new HashMap<>();


	public SSpecification(Specification s, NameMap map) {
		//this initializes the map to include an entry for this object
		map.addFile(s, this);
		
		//set the name
		this.name = map.getName(s);
		
		this.typedefs.addAll(STypeDef.build(s.getTypedefs(), map));
		this.constants.addAll(SConstant.build(s.getConstants(), map));
		this.patterns.addAll(SPattern.build(s.getPatterns(), map));
		this.inputs.addAll(SVariable.build(s.getInputs(), map));
		this.outputs.addAll(SVariable.build(s.getOutputs(), map));
		this.state.addAll(SVariable.build(s.getState(), map));
		this.macros.addAll(SMacro.build(s.getMacros(), map));
		this.assumptions.addAll(SConstraint.build(s.getAssumptions(), map));
		this.requirements.addAll(SConstraint.build(s.getRequirements(), map));
		this.behaviors.addAll(SConstraint.build(s.getBehaviors(), map));
		
		this.calls.putAll(SCall.build(EcoreUtil2.getAllContentsOfType(s, NormalizedCall.class), map));
		
		this.assertionName = map.getName(s,ASSERTION);
	}
	
	public Node toBaseLustre(NameMap map) {
		NodeBuilder builder = new NodeBuilder(name);
		
		/*
		 * We must add:
		 * 1. the true inputs
		 * 2. the shadow inputs for the outputs
		 * 3. the shadow inputs for the state
		 * 4. the args from any calls that also need shadow inputs
		 * 5. the args from any call's, calls that need shadow args
		 */
		builder.addInputs(SVariable.toVarDecl(inputs, map));
		builder.addInputs(SVariable.toVarDecl(state, map));
		builder.addInputs(SVariable.toVarDecl(outputs, map));
		
		/*
		 * We must add
		 * 2. locals for the macros
		 * 2. locals for the assumptions
		 * 3. locals for the requirements
		 * 4. locals for the behaviors */
		builder.addLocals(SMacro.toVarDecls(macros,map));
		builder.addLocals(SConstraint.toVarDecl(assumptions,map));
		builder.addLocals(SConstraint.toVarDecl(requirements, map));
		builder.addLocals(SConstraint.toVarDecl(behaviors, map));
		
		builder.addOutput(getAssertionVarDecl());
		

		/*
		 * For now, we're not allowing Macros to contain specification calls
		 */
		builder.addEquations(SMacro.toEquations(macros,map));
		builder.addEquations(SConstraint.toEquation(assumptions, map));
		builder.addEquations(SConstraint.toEquation(requirements, map));
		builder.addEquations(SConstraint.toPropertyEquations(behaviors, assertionName, map));
		builder.addEquation(getAssertionEquation());
		
		/*
		 * Add property ids
		 */
		builder.addProperties(SConstraint.toPropertyIds(behaviors,map));
		
		return builder.build();
	}
	
	private VarDecl getAssertionVarDecl() {
		return new VarDecl(this.assertionName, NamedType.BOOL);
	}

	private Expr conjunctify(Iterator<SConstraint> it) {
		SConstraint current = it.next();
		jkind.lustre.IdExpr expr = new jkind.lustre.IdExpr(current.name);
			
		if(it.hasNext()) {
			return new jkind.lustre.BinaryExpr(expr, BinaryOp.AND, conjunctify(it));
		} else {
			return expr;
		}
	}
	
	private Equation getAssertionEquation() {
		List<SConstraint> conjunct = new ArrayList<>();
		conjunct.addAll(assumptions);
		conjunct.addAll(requirements);
		
		Expr RHS;
		if(conjunct.isEmpty()) {
			RHS = new BoolExpr(true);
		} else {
			RHS = conjunctify(conjunct.iterator());
		}
		
		return new Equation(new IdExpr(this.assertionName), new NodeCallExpr(PLTL.historically().id, RHS));
	}
	
	
}
