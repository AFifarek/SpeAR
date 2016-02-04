package com.rockwellcollins.spear.translate.lustre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Specification;

import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.Constant;
import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.NamedType;
import jkind.lustre.Node;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.Program;
import jkind.lustre.Type;
import jkind.lustre.TypeDef;
import jkind.lustre.VarDecl;

public class TranslateSpecification {

	private static final String CONJUNCTION_ID = "CONJUNCT";
	private static final String HISTORICAL_CONJUNCT_ID = "HISTORICAL_CONJUNCT";
	private static final String PROPERTY_SUFFIX = "_PROP";
	private static final String SHADOW_SUFFIX = "_shadow";
	
	public static Program translate(com.rockwellcollins.spear.Specification s, Set<EObject> references) {
		TranslateSpecification translate = new TranslateSpecification();
		return translate.translateSpecification(s,references);
	}
	
	private List<TypeDef> getTypeDefs(Specification s, Set<EObject> references) {
		List<TypeDef> typedefs = new ArrayList<>();
		for (com.rockwellcollins.spear.TypeDef spearTypeDef : s.getTypedefs()) {
			String name = spearTypeDef.getName();
			TypeDef lustreTypeDef = TranslateDecl.translate(spearTypeDef, name);
			typedefs.add(lustreTypeDef);
		}
		
		for(EObject reference : references) {
			if (reference instanceof com.rockwellcollins.spear.TypeDef) {
				com.rockwellcollins.spear.TypeDef spearTypeDef = (com.rockwellcollins.spear.TypeDef) reference;
				String name = spearTypeDef.getName();
				TypeDef lustreTypeDef = TranslateDecl.translate(spearTypeDef, name);
				typedefs.add(lustreTypeDef);
			}
		}
		return typedefs;
	}

	private List<Constant> getConstants(Specification s, Set<EObject> references) {
		List<Constant> constants = new ArrayList<>();
		for (com.rockwellcollins.spear.Constant spearConstant : s.getConstants()) {
			String name = spearConstant.getName();
			Constant lustreConstant = TranslateDecl.translate(spearConstant, name);
			constants.add(lustreConstant);
		}
		
		for(EObject reference : references) {
			if (reference instanceof com.rockwellcollins.spear.Constant) {
				com.rockwellcollins.spear.Constant spearConstant = (com.rockwellcollins.spear.Constant) reference;
				String name = spearConstant.getName();
				Constant lustreConstant = TranslateDecl.translate(spearConstant, name);
				constants.add(lustreConstant);
			}
		}
		return constants;
	}

	private List<VarDecl> getVariables(List<com.rockwellcollins.spear.Variable> variables) {
		List<VarDecl> list = new ArrayList<>();
		for (com.rockwellcollins.spear.Variable var : variables) {
			String name = var.getName();
			VarDecl lustreVariable = TranslateDecl.translate(var, name);
			list.add(lustreVariable);
		}
		return list;
	}

	private List<VarDecl> createShadowVariables(List<VarDecl> variables) {
		List<VarDecl> shadowVariables = new ArrayList<>();
		for (VarDecl v : variables) {
			String name = v.id + SHADOW_SUFFIX;
			shadowVariables.add(new VarDecl(name, v.type));
		}
		return shadowVariables;
	}

	private List<VarDecl> getMacrosVarDecls(List<Macro> macros) {
		List<VarDecl> list = new ArrayList<>();
		for (com.rockwellcollins.spear.Macro macro : macros) {
			Type t = TranslateType.translate(macro.getType());
			String name = macro.getName();
			list.add(new VarDecl(name, t));
		}
		return list;
	}

	private List<Equation> makeEquationsForShadowVars(List<VarDecl> state, List<VarDecl> shadowState) {
		List<Equation> equations = new ArrayList<>();
		for (int i = 0; i < state.size(); i++) {
			Equation eq = new Equation(Collections.singletonList(new IdExpr(state.get(i).id)),
					new IdExpr(shadowState.get(i).id));
			equations.add(eq);
		}
		return equations;
	}

	private List<VarDecl> getConstraintVarDecls(List<Constraint> constraints) {
		List<VarDecl> constraintDecls = new ArrayList<>();
		for (Constraint c : constraints) {
			if (c instanceof FormalConstraint) {
				FormalConstraint fc = (FormalConstraint) c;
				constraintDecls.add(new VarDecl(fc.getName(), NamedType.BOOL));
			}
		}
		return constraintDecls;
	}

	private List<Equation> makeEquationsForConstraints(EList<Constraint> constraints) {
		List<Equation> equations = new ArrayList<>();
		for (Constraint c : constraints) {
			if (c instanceof FormalConstraint) {
				FormalConstraint fc = (FormalConstraint) c;
				List<IdExpr> lhs = Collections.singletonList(new IdExpr(c.getName()));
				Expr rhs = TranslateExpr.translate(fc.getExpr());
				equations.add(new Equation(lhs, rhs));
			}
		}
		return equations;
	}

	private List<VarDecl> getPropertyVarDecls(List<VarDecl> properties) {
		List<VarDecl> decls = new ArrayList<>();
		for (VarDecl vd : properties) {
			decls.add(new VarDecl(vd.id + TranslateSpecification.PROPERTY_SUFFIX, NamedType.BOOL));
		}
		return decls;
	}

	private List<Equation> getPropertyEquations(List<VarDecl> decls) {
		List<Equation> equations = new ArrayList<>();
		for (VarDecl vd : decls) {
			List<IdExpr> LHS = Collections.singletonList(new IdExpr(vd.id + PROPERTY_SUFFIX));
			Expr RHS = new BinaryExpr(new IdExpr(TranslateSpecification.HISTORICAL_CONJUNCT_ID), BinaryOp.IMPLIES,
					new IdExpr(vd.id));
			equations.add(new Equation(LHS, RHS));
		}
		return equations;
	}

	private List<String> getPropertyStrings(List<VarDecl> decls) {
		List<String> properties = new ArrayList<>();
		for (VarDecl vd : decls) {
			properties.add(vd.id);
		}
		return properties;
	}
	
	private VarDecl getHistoricalConjuctVarDecl() {
		return new VarDecl(HISTORICAL_CONJUNCT_ID, NamedType.BOOL);
	}

	private VarDecl getConjuctVarDecl() {
		return new VarDecl(CONJUNCTION_ID, NamedType.BOOL);
	}

	public Program translateSpecification(Specification s, Set<EObject> references) {
		String mainNodeName = s.getName();
		List<TypeDef> typedefs = getTypeDefs(s,references);
		List<Constant> constants = getConstants(s,references);

		// these represent the original inputs, outputs, and locals of a SpeAR
		// specification
		List<VarDecl> inputs = getVariables(s.getInputs());
		List<VarDecl> outputs = getVariables(s.getOutputs());
		List<VarDecl> state = getVariables(s.getState());

		/*
		 * These will be used to create nondeterministic inputs for all the
		 * computed values in a Specification
		 */
		List<VarDecl> shadowState = createShadowVariables(state);
		List<VarDecl> shadowOutputs = createShadowVariables(outputs);

		List<VarDecl> nodeInputs = new ArrayList<>();
		nodeInputs.addAll(inputs);
		nodeInputs.addAll(shadowState);
		nodeInputs.addAll(shadowOutputs);

		List<VarDecl> macroVarDecls = getMacrosVarDecls(s.getMacros());
		List<VarDecl> assumptionVarDecls = getConstraintVarDecls(s.getAssumptions());
		List<VarDecl> requirementVarDecls = getConstraintVarDecls(s.getRequirements());
		List<VarDecl> behaviorVarDecls = getConstraintVarDecls(s.getBehaviors());

		List<VarDecl> nodeLocals = new ArrayList<>();
		nodeLocals.addAll(state);
		nodeLocals.addAll(macroVarDecls);
		nodeLocals.addAll(assumptionVarDecls);
		nodeLocals.addAll(requirementVarDecls);
		nodeLocals.addAll(behaviorVarDecls);
		nodeLocals.add(getConjuctVarDecl());
		nodeLocals.add(getHistoricalConjuctVarDecl());
		List<VarDecl> propertyVarDecls = getPropertyVarDecls(behaviorVarDecls);
		nodeLocals.addAll(propertyVarDecls);

		List<VarDecl> nodeOutputs = new ArrayList<>();
		nodeOutputs.addAll(outputs);

		List<Equation> equations = new ArrayList<>();
		equations.addAll(makeEquationsForShadowVars(state, shadowState));
		equations.addAll(makeEquationsForShadowVars(outputs, shadowOutputs));
		equations.addAll(makeEquationForMacros(s.getMacros()));
		equations.addAll(makeEquationsForConstraints(s.getAssumptions()));
		equations.addAll(makeEquationsForConstraints(s.getRequirements()));
		equations.addAll(makeEquationsForConstraints(s.getBehaviors()));

		Equation conjunct = conjunctAssumptionsAndRequirements(assumptionVarDecls, requirementVarDecls);
		equations.add(conjunct);

		List<IdExpr> LHS = Collections.singletonList(new IdExpr(TranslateSpecification.HISTORICAL_CONJUNCT_ID));
		Expr RHS = new NodeCallExpr("historically",
				Collections.singletonList(new IdExpr(TranslateSpecification.CONJUNCTION_ID)));

		Equation historicalConjunct = new Equation(LHS, RHS);
		equations.add(historicalConjunct);

		List<Equation> propertyEquations = getPropertyEquations(behaviorVarDecls);
		equations.addAll(propertyEquations);

		List<String> properties = getPropertyStrings(propertyVarDecls);

		Node main = new Node(mainNodeName, nodeInputs, nodeOutputs, nodeLocals, equations, properties, null, null);

		List<Node> nodes = new ArrayList<>();
		for (Node n : HelperNodes.getPLTL()) {
			nodes.add(n);
		}

		nodes.add(main);

		Program p = new Program(typedefs, constants, nodes, mainNodeName);
		return p;
	}

	private List<Equation> makeEquationForMacros(List<Macro> macros) {
		List<Equation> equations = new ArrayList<>();
		for(Macro m : macros) {
			List<IdExpr> LHS = Collections.singletonList(new IdExpr(m.getName()));
			Expr RHS = TranslateExpr.translate(m.getExpr());
			equations.add(new Equation(LHS,RHS));
		}
		return equations;
	}

	private Expr conjunctify(Iterator<VarDecl> it) {
		VarDecl next = it.next();
		IdExpr idExpr = new IdExpr(next.id);
		if (it.hasNext()) {
			return new BinaryExpr(idExpr, BinaryOp.AND, conjunctify(it));
		} else {
			return idExpr;
		}
	}

	private Equation conjunctAssumptionsAndRequirements(List<VarDecl> assumptionVarDecls,
			List<VarDecl> behaviorVarDecls) {
		List<VarDecl> all = new ArrayList<>();
		all.addAll(assumptionVarDecls);
		all.addAll(behaviorVarDecls);

		if (all.size() == 0) {
			return null;
		}

		Iterator<VarDecl> iterate = all.iterator();
		return new Equation(Collections.singletonList(new IdExpr(CONJUNCTION_ID)), conjunctify(iterate));
	}

}
