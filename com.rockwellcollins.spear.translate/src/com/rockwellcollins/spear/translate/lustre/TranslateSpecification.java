package com.rockwellcollins.spear.translate.lustre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Specification;

import jkind.lustre.Constant;
import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.NamedType;
import jkind.lustre.Program;
import jkind.lustre.Type;
import jkind.lustre.TypeDef;
import jkind.lustre.VarDecl;

public class TranslateSpecification {

	public static Constant translate(com.rockwellcollins.spear.Constant c) {
		return new Constant(c.getName(),TranslateType.translate(c.getType()),TranslateExpr.translate(c.getExpr()));
	}
	
	public static VarDecl translate(com.rockwellcollins.spear.Variable v) {
		return new VarDecl(v.getName(),TranslateType.translate(v.getType()));
	}
	
	public TranslateSpecification(Set<String> globalNames) {
		this.globalNames = globalNames;
		this.localNames = new HashSet<>();
	}

	private Set<String> globalNames;
	private Set<String> localNames;
	private final String SHADOW_SUFFIX = "_shadow";
	
	private String getUniqueGlobalName(String proposed) {
		String unique = proposed;
		
		//TODO: do unique renaming
		return unique;
	}
	
	private String getUniqueLocalName(String proposed) {
		String unique = proposed;

		//TODO: do unique renaming
		return unique;
	}
	
	private List<TypeDef> getTypeDefs(Specification s) {
		List<TypeDef> typedefs = new ArrayList<>();
		for(com.rockwellcollins.spear.TypeDef spearTypeDef : s.getTypedefs()) {
			TypeDef lustreTypeDef = TranslateTypeDef.translate(spearTypeDef);
			typedefs.add(lustreTypeDef);
			globalNames.add(lustreTypeDef.id);
		}
		return typedefs;
	}
	
	private List<Constant> getConstants(Specification s) {
		List<Constant> constants = new ArrayList<>();
		for(com.rockwellcollins.spear.Constant spearConstant : s.getConstants()) {
			Constant lustreConstant = TranslateSpecification.translate(spearConstant);
			constants.add(lustreConstant);
			globalNames.add(lustreConstant.id);
		}
		return constants;
	}
	
	private List<VarDecl> getVariables(List<com.rockwellcollins.spear.Variable> variables) {
		List<VarDecl> list = new ArrayList<>();
		for(com.rockwellcollins.spear.Variable var : variables) {
			VarDecl lustreVariable = TranslateSpecification.translate(var);
			list.add(lustreVariable);
			localNames.add(lustreVariable.id);
		}
		return list;
	}
	
	private List<VarDecl> createShadowVariables(List<VarDecl> variables) {
		List<VarDecl> shadowVariables = new ArrayList<>();
		for(VarDecl v : variables) {
			String name = getUniqueLocalName(v.id + SHADOW_SUFFIX);
			shadowVariables.add(new VarDecl(name,v.type));
		}
		return shadowVariables;
	}

	private List<VarDecl> getMacrosVarDecls(List<Macro> macros) {
		List<VarDecl> list = new ArrayList<>();
		for(com.rockwellcollins.spear.Macro macro : macros) {
			Type t = TranslateType.translate(macro.getType());
			String name = getUniqueLocalName(macro.getName());
			list.add(new VarDecl(name,t));
		}
		return list;
	}
	
	private List<Equation> makeEquationsForShadowVars(List<VarDecl> state, List<VarDecl> shadowState) {
		List<Equation> equations = new ArrayList<>();
		for(int i=0; i<state.size(); i++) {
			Equation eq = new Equation(Collections.singletonList(new IdExpr(state.get(i).id)),new IdExpr(shadowState.get(i).id));
			equations.add(eq);
		}
		return equations;
	}
	
	private List<VarDecl> getConstraintVarDecls(List<Constraint> constraints) {
		List<VarDecl> constraintDecls = new ArrayList<>();
		for(Constraint c : constraints) {
			if (c instanceof FormalConstraint) {
				FormalConstraint fc = (FormalConstraint) c;
				constraintDecls.add(new VarDecl(fc.getName(), NamedType.BOOL));
			}
		}
		return constraintDecls;
	}
	
	private List<Equation> makeEquationsForConstraints(EList<Constraint> constraints) {
		List<Equation> equations = new ArrayList<>();
		for(Constraint c : constraints) {
			if (c instanceof FormalConstraint) {
				FormalConstraint fc = (FormalConstraint) c;
				List<IdExpr> lhs = Collections.singletonList(new IdExpr(c.getName()));
				Expr rhs = TranslateExpr.translate(fc.getExpr());
				equations.add(new Equation(lhs,rhs));
			}
		}
		return equations;
	}
	
	public Program translate(Specification s) {
		String mainNodeName = s.getName();
		List<TypeDef> typedefs = getTypeDefs(s);
		List<Constant> constants = getConstants(s);
		
		//these represent the original inputs, outputs, and locals of a SpeAR specification
		List<VarDecl> inputs = getVariables(s.getInputs());
		List<VarDecl> outputs = getVariables(s.getOutputs());
		List<VarDecl> state = getVariables(s.getState());
		
		/*
		 * These will be used to create nondeterministic inputs for all the computed values in a Specification
		 */
		List<VarDecl> shadowState = createShadowVariables(state);
		List<VarDecl> shadowOutputs = createShadowVariables(outputs);
				
		List<VarDecl> nodeInputs = new ArrayList<>();
		nodeInputs.addAll(inputs);
		nodeInputs.addAll(shadowState);
		nodeInputs.addAll(shadowOutputs);
		
		List<VarDecl> macroVarDecls = getMacrosVarDecls(s.getMacros());
		List<VarDecl> assumptionVarDecls = getConstraintVarDecls(s.getAssumptions());
		List<VarDecl> behaviorVarDecls = getConstraintVarDecls(s.getBehaviors());
		List<VarDecl> requirementVarDecls = getConstraintVarDecls(s.getRequirements());

		List<VarDecl> nodeLocals = new ArrayList<>();
		nodeLocals.addAll(state);
		nodeLocals.addAll(macroVarDecls);
		nodeLocals.addAll(assumptionVarDecls);
		nodeLocals.addAll(behaviorVarDecls);
		nodeLocals.addAll(requirementVarDecls);
		
		List<VarDecl> nodeOutputs = new ArrayList<>();
		nodeOutputs.addAll(outputs);
		
		List<Equation> equations = new ArrayList<>();
		equations.addAll(makeEquationsForShadowVars(state,shadowState));
		equations.addAll(makeEquationsForShadowVars(outputs,shadowOutputs));
		equations.addAll(makeEquationsForConstraints(s.getAssumptions()));
		equations.addAll(makeEquationsForConstraints(s.getBehaviors()));
		equations.addAll(makeEquationsForConstraints(s.getRequirements()));
		
		Equation conjunct = conjunctAssumptionsAndBehaviors(assumptionVarDecls,behaviorVarDecls);
		equations.add(conjunct);
		
		
		
		

		
		
		return null;
	}

	private Equation conjunctAssumptionsAndBehaviors(List<VarDecl> assumptionVarDecls, List<VarDecl> behaviorVarDecls) {
		return null;
	}

}
