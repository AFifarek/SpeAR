package com.rockwellcollins.spear.translate.experimental;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.actions.SpearRuntimeOptions;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.BoolExpr;
import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.IntExpr;
import jkind.lustre.LustreUtil;
import jkind.lustre.NamedType;
import jkind.lustre.Node;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.UnaryExpr;
import jkind.lustre.UnaryOp;
import jkind.lustre.VarDecl;
import jkind.lustre.builders.NodeBuilder;

public class SpearNode extends SpearAst {

	public String name;
	public List<Variable> inputs = new ArrayList<>();
	public List<Variable> outputs = new ArrayList<>();
	public List<Variable> state = new ArrayList<>();
	public List<Macro> macros = new ArrayList<>();
	public List<Constraint> assumptions = new ArrayList<>();
	public List<Constraint> requirements = new ArrayList<>();
	public List<Constraint> behaviors = new ArrayList<>();

	public Specification sourceSpecification;

	private NameManager naming;
	private static final String SHADOW_SUFFIX = "SHADOW";
	private static final String CONJUNCT_ID = "CONJUNCT";
	private static final String HISTORICAL_CONJUNCT_ID = "HISTORICAL_CONJUNCT";
	private static final String COUNTER_ID = "COUNTER";
	private static final String CONSISTENCY_CHECK_ID = "CONSISTENCY";

	public SpearNode(Specification s) {
		this.sourceSpecification = s;
		name = s.getName();
		inputs.addAll(s.getInputs());
		outputs.addAll(s.getOutputs());
		state.addAll(s.getState());
		macros.addAll(s.getMacros());

		assumptions.addAll(s.getAssumptions());
		requirements.addAll(s.getRequirements());
		behaviors.addAll(s.getBehaviors());
	}

	private VarDecl processVariable(Variable v) {
		String renamed = naming.getUniqueNameAndRegister(v.getName());
		return new VarDecl(renamed, TranslateType.translate(v.getType(), naming));
	}

	private List<VarDecl> processVariables(List<Variable> variables) {
		List<VarDecl> processed = new ArrayList<>();
		for (Variable v : variables) {
			processed.add(processVariable(v));
		}
		return processed;
	}

	private String getShadowVarName(String name) {
		return name + "_" + SHADOW_SUFFIX;
	}

	private VarDecl processShadowVar(Variable v) {
		String original = getShadowVarName(v.getName());
		String renamed = naming.getUniqueNameAndRegister(original);
		return new VarDecl(renamed, TranslateType.translate(v.getType(), naming));
	}

	private List<VarDecl> processShadowVars(List<Variable> variables) {
		List<VarDecl> processed = new ArrayList<>();
		for (Variable v : variables) {
			processed.add(processShadowVar(v));
		}
		return processed;
	}

	private VarDecl getMacroVarDecl(Macro m) {
		String original = m.getName();
		String renamed = naming.getUniqueNameAndRegister(original);
		return new VarDecl(renamed, TranslateType.translate(m.getType(), naming));
	}

	private List<VarDecl> getMacroVarDecls(List<Macro> macrolist) {
		List<VarDecl> processed = new ArrayList<>();
		for (Macro m : macrolist) {
			processed.add(getMacroVarDecl(m));
		}
		return processed;
	}

	private VarDecl getConstraintVarDecl(Constraint c) {
		String original = c.getName();
		String renamed = naming.getUniqueNameAndRegister(original);
		return new VarDecl(renamed, NamedType.BOOL);
	}

	private List<VarDecl> getConstraintVarDecls(List<Constraint> constraints) {
		List<VarDecl> processed = new ArrayList<>();
		for (Constraint c : constraints) {
			processed.add(getConstraintVarDecl(c));
		}
		return processed;
	}

	private Equation getShadowVarEquation(Variable v) {
		IdExpr LHS = new IdExpr(naming.lookup(v.getName()));
		IdExpr RHS = new IdExpr(naming.lookup(getShadowVarName(v.getName())));
		return LustreUtil.eq(LHS, RHS);
	}

	private List<Equation> getShadowVarEquations(List<Variable> variables) {
		List<Equation> equations = new ArrayList<>();
		for (Variable v : variables) {
			equations.add(getShadowVarEquation(v));
		}
		return equations;
	}

	private Equation getConstraintEquation(Constraint c) {
		IdExpr LHS = new IdExpr(naming.lookup(c.getName()));
		if (c instanceof FormalConstraint) {
			FormalConstraint fc = (FormalConstraint) c;
			Expr RHS = TranslateExpr.translate(fc.getExpr(), naming);
			return LustreUtil.eq(LHS, RHS);
		} else {
			return LustreUtil.eq(LHS, new BoolExpr(true));
		}
	}

	private List<Equation> getConstraintEquations(List<Constraint> constraints) {
		List<Equation> equations = new ArrayList<>();
		for (Constraint c : constraints) {
			equations.add(getConstraintEquation(c));
		}
		return equations;
	}

	private Expr getConjunctExpr(Iterator<Constraint> iterator) {
		Constraint c = iterator.next();
		IdExpr idExpr = new IdExpr(naming.lookup(c.getName()));
		if (iterator.hasNext()) {
			return new BinaryExpr(idExpr, BinaryOp.AND, getConjunctExpr(iterator));
		} else {
			return idExpr;
		}
	}

	private VarDecl getConjunctVarDecl() {
		String original = CONJUNCT_ID;
		String renamed = naming.getUniqueNameAndRegister(original);
		return new VarDecl(renamed, NamedType.BOOL);
	}
	
	private Equation getConjunctEquation() {
		List<Constraint> constraints = new ArrayList<>();
		constraints.addAll(assumptions);
		constraints.addAll(requirements);
		return LustreUtil.eq(new IdExpr(naming.lookup(CONJUNCT_ID)), getConjunctExpr(constraints.iterator()));
	}


	private VarDecl getHistoricalConjunctVarDecl() {
		String original = HISTORICAL_CONJUNCT_ID;
		String renamed = naming.getUniqueNameAndRegister(original);
		return new VarDecl(renamed, NamedType.BOOL);
	}
	
	private Equation addHistoricalConjuctEquation() {
		return LustreUtil.eq(new IdExpr(naming.lookup(HISTORICAL_CONJUNCT_ID)),
				new NodeCallExpr("historically", new IdExpr(naming.lookup(CONJUNCT_ID))));
	}

	public Node getBaseLustre(NameManager globalNaming) {
		naming = new NameManager(globalNaming);
		NodeBuilder node = new NodeBuilder(name);
		// inputs are true inputs and shadow vars for outputs and state
		node.addInputs(processVariables(inputs));
		node.addInputs(processShadowVars(outputs));
		node.addInputs(processShadowVars(state));

		// locals are state and macros
		node.addLocals(processVariables(state));
		node.addLocals(getMacroVarDecls(macros));

		// all constraints are locals, even the english ones (they're set to
		// TRUE)
		node.addLocals(getConstraintVarDecls(assumptions));
		node.addLocals(getConstraintVarDecls(requirements));
		node.addLocals(getConstraintVarDecls(behaviors));
		node.addLocal(getConjunctVarDecl());
		node.addLocal(getHistoricalConjunctVarDecl());

		// outputs are true outputs
		node.addOutputs(processVariables(outputs));

		// assign the shadow vars
		node.addEquations(getShadowVarEquations(outputs));
		node.addEquations(getShadowVarEquations(state));

		node.addEquations(getConstraintEquations(assumptions));
		node.addEquations(getConstraintEquations(requirements));
		node.addEquations(getConstraintEquations(behaviors));

		node.addEquation(getConjunctEquation());
		node.addEquation(addHistoricalConjuctEquation());

		return node.build();
	}

	private List<String> getBehaviorProperties() {
		List<String> properties = new ArrayList<>();
		for (Constraint c : behaviors) {
			properties.add(naming.lookup(c.getName()));
		}
		return properties;
	}

	public Node addLogicalProperties(Node base) {
		NodeBuilder node = new NodeBuilder(base);
		node.addProperties(getBehaviorProperties());
		return node.build();
	}

	private VarDecl getCounterVarDecl() {
		String original = COUNTER_ID;
		String renamed = naming.getUniqueNameAndRegister(original);
		return new VarDecl(renamed, NamedType.INT);
	}

	private VarDecl getConsistencyVarDecl() {
		String original = CONSISTENCY_CHECK_ID;
		String renamed = naming.getUniqueNameAndRegister(original);
		return new VarDecl(renamed, NamedType.INT);
	}

	private Equation getCounterEquation() {
		Expr pre_counter_plus_one = new BinaryExpr(new UnaryExpr(UnaryOp.PRE, new IdExpr(naming.lookup(COUNTER_ID))),
				BinaryOp.PLUS, new IntExpr(1));
		Expr RHS = new BinaryExpr(new IntExpr(1), BinaryOp.ARROW, pre_counter_plus_one);
		return LustreUtil.eq(new IdExpr(naming.lookup(COUNTER_ID)), RHS);
	}

	private Equation getConsistencyEquation() {
		Expr relational = new BinaryExpr(new IdExpr(naming.lookup(COUNTER_ID)), BinaryOp.GREATEREQUAL,
				new IntExpr(SpearRuntimeOptions.consistencyDepth));
		Expr RHS = new UnaryExpr(UnaryOp.NOT,
				new BinaryExpr(new IdExpr(naming.lookup(HISTORICAL_CONJUNCT_ID)), BinaryOp.AND, relational));
		return LustreUtil.eq(new IdExpr(naming.lookup(CONSISTENCY_CHECK_ID)), RHS);
	}

	private List<String> getSupportIds() {
		List<String> supports = new ArrayList<>();
		for(Constraint c : assumptions) {
			supports.add(naming.lookup(c.getName()));
		}
		
		for(Constraint c : requirements) {
			supports.add(naming.lookup(c.getName()));
		}
		return supports;
	}
	
	public Node addConsistencyProperties(Node base) {
		NodeBuilder node = new NodeBuilder(base);
		node.addLocal(getCounterVarDecl());
		node.addLocal(getConsistencyVarDecl());
		
		node.addEquation(getCounterEquation());
		node.addEquation(getConsistencyEquation());
		
		node.addProperty(naming.lookup(CONSISTENCY_CHECK_ID));
		node.addSupports(getSupportIds());
		
		return node.build();
	}
}
