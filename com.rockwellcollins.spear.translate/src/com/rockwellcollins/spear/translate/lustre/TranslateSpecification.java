package com.rockwellcollins.spear.translate.lustre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.Definitions;
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
import jkind.lustre.builders.NodeBuilder;
import jkind.lustre.builders.ProgramBuilder;

public class TranslateSpecification {

	public static Program translate(com.rockwellcollins.spear.Specification s, Map<EObject,EObject> references) {
		TranslateSpecification translate = new TranslateSpecification(s);
		Program normal = translate.translateSpecification(s,references);
		Program extended = translate.addAnalysisProperties(s, normal);
		return extended; 
	}

	private static final String CONJUNCTION_ID = "CONJUNCT";
	private static final String HISTORICAL_CONJUNCT_ID = "HISTORICAL_CONJUNCT";
	private static final String PROPERTY_SUFFIX = "_PROP";
	private static final String SHADOW_SUFFIX = "_shadow";

	private String specificationName; 
	private Map<String,String> mapping;
	private Set<String> globals;

	public TranslateSpecification(Specification s) {
		this.specificationName = s.getName();
		mapping = new HashMap<>();
		globals = new HashSet<>();
		for(Node n : HelperNodes.getPLTL()) {
			mapping.put(n.id, n.id);
		}
	}
	
	private String getUniqueName(String proposed) {
		String newName = proposed;
		Integer unique = 0;
		while(mapping.containsKey(newName)) {
			newName = proposed + "_" + unique;
		}
		return newName;
	}
	
	private String prependSpecification(String name) {
		return specificationName + "_" + name;
	}
	
	private List<TypeDef> getTypeDefs(Specification s, Map<EObject,EObject> references) {
		List<TypeDef> typedefs = new ArrayList<>();
		for (com.rockwellcollins.spear.TypeDef spearTypeDef : s.getTypedefs()) {
			String original = spearTypeDef.getName();
			String proposed = prependSpecification(original);
			String renamed = getUniqueName(proposed);
			mapping.put(original, renamed);
			globals.add(renamed);
			TypeDef lustreTypeDef = (TypeDef) TranslateDecl.translate(spearTypeDef, mapping);
			typedefs.add(lustreTypeDef);
		}
		
		for(EObject reference : references.keySet()) {
			if (reference instanceof com.rockwellcollins.spear.TypeDef) {
				EObject root = references.get(reference);
				com.rockwellcollins.spear.TypeDef spearTypeDef = (com.rockwellcollins.spear.TypeDef) reference;
				String original = spearTypeDef.getName();
				String proposed = original;
				if (root instanceof Definitions) {
					Definitions definitions = (Definitions) root;
					proposed = definitions.getName() + "_" + original;
				}
				String renamed = getUniqueName(proposed);
				mapping.put(original, renamed);
				globals.add(renamed);
				TypeDef lustreTypeDef = (TypeDef) TranslateDecl.translate(spearTypeDef, mapping);
				typedefs.add(lustreTypeDef);
			}
		}
		return typedefs;
	}

	private List<Constant> getConstants(Specification s, Map<EObject,EObject> references) {
		List<Constant> constants = new ArrayList<>();
		for (com.rockwellcollins.spear.Constant spearConstant : s.getConstants()) {
			String original = spearConstant.getName();
			String proposed = prependSpecification(original);
			String renamed = getUniqueName(proposed);
			mapping.put(original, renamed);
			globals.add(renamed);
			Constant lustreConstant = (Constant) TranslateDecl.translate(spearConstant, mapping);
			constants.add(lustreConstant);
		}
		
		for(EObject reference : references.keySet()) {
			if (reference instanceof com.rockwellcollins.spear.Constant) {
				EObject root = references.get(reference);
				com.rockwellcollins.spear.Constant spearConstant = (com.rockwellcollins.spear.Constant) reference;
				String original = spearConstant.getName();
				String proposed = original;
				if (root instanceof Definitions) {
					Definitions definitions = (Definitions) root;
					proposed = definitions.getName() + "_" + original;
				}
				String renamed = getUniqueName(proposed);
				mapping.put(original, renamed);
				globals.add(renamed);
				Constant lustreConstant = (Constant) TranslateDecl.translate(spearConstant, mapping);
				constants.add(lustreConstant);
			}
		}
		return constants;
	}

	private List<VarDecl> getVariables(List<com.rockwellcollins.spear.Variable> variables) {
		List<VarDecl> list = new ArrayList<>();
		for (com.rockwellcollins.spear.Variable var : variables) {
			String original = var.getName();
			String renamed = getUniqueName(original);
			mapping.put(original, renamed);
			VarDecl lustreVariable = (VarDecl) TranslateDecl.translate(var, mapping);
			list.add(lustreVariable);
		}
		return list;
	}

	private List<VarDecl> createShadowVariables(List<VarDecl> variables) {
		List<VarDecl> shadowVariables = new ArrayList<>();
		for (VarDecl v : variables) {
			String original = v.id + SHADOW_SUFFIX;
			String renamed = getUniqueName(original);
			mapping.put(original, renamed);
			shadowVariables.add(new VarDecl(renamed, v.type));
		}
		return shadowVariables;
	}

	private List<VarDecl> getMacrosVarDecls(List<Macro> macros) {
		List<VarDecl> list = new ArrayList<>();
		for (com.rockwellcollins.spear.Macro macro : macros) {
			String original = macro.getName();
			String renamed = getUniqueName(original);
			mapping.put(original, renamed);
			Type t = TranslateType.translate(macro.getType(),mapping);
			list.add(new VarDecl(renamed, t));
		}
		return list;
	}

	private List<Equation> makeEquationsForShadowVars(List<VarDecl> state, List<VarDecl> shadowState) {
		List<Equation> equations = new ArrayList<>();
		for (int i = 0; i < state.size(); i++) {
			List<IdExpr> LHS = Collections.singletonList(new IdExpr(mapping.get(state.get(i).id)));
			IdExpr RHS = new IdExpr(mapping.get(shadowState.get(i).id));
			Equation eq = new Equation(LHS,RHS);
			equations.add(eq);
		}
		return equations;
	}
	
	private List<Equation> makeEquationForMacros(List<Macro> macros) {
		List<Equation> equations = new ArrayList<>();
		for(Macro m : macros) {
			List<IdExpr> LHS = Collections.singletonList(new IdExpr(mapping.get(m.getName())));
			Expr RHS = TranslateExpr.translate(m.getExpr(),mapping);
			equations.add(new Equation(LHS,RHS));
		}
		return equations;
	}

	private List<VarDecl> getConstraintVarDecls(List<Constraint> constraints) {
		List<VarDecl> constraintDecls = new ArrayList<>();
		for (Constraint c : constraints) {
			if (c instanceof FormalConstraint) {
				FormalConstraint fc = (FormalConstraint) c;
				String original = fc.getName();
				String renamed = getUniqueName(original);
				mapping.put(original, renamed);
				constraintDecls.add(new VarDecl(renamed, NamedType.BOOL));
			}
		}
		return constraintDecls;
	}

	private List<Equation> makeEquationsForConstraints(List<Constraint> constraints) {
		List<Equation> equations = new ArrayList<>();
		for (Constraint c : constraints) {
			if (c instanceof FormalConstraint) {
				FormalConstraint fc = (FormalConstraint) c;
				List<IdExpr> lhs = Collections.singletonList(new IdExpr(mapping.get(fc.getName())));
				Expr rhs = TranslateExpr.translate(fc.getExpr(),mapping);
				equations.add(new Equation(lhs, rhs));
			}
		}
		return equations;
	}
	
	private Expr conjunctify(Iterator<VarDecl> it) {
		VarDecl next = it.next();
		IdExpr idExpr = new IdExpr(mapping.get(next.id));
		if (it.hasNext()) {
			return new BinaryExpr(idExpr, BinaryOp.AND, conjunctify(it));
		} else {
			return idExpr;
		}
	}
	
	private Equation conjunctAssumptionsAndRequirements(List<VarDecl> assumptionVarDecls,List<VarDecl> behaviorVarDecls) {
		List<VarDecl> all = new ArrayList<>();
		all.addAll(assumptionVarDecls);
		all.addAll(behaviorVarDecls);

		if (all.size() == 0) {
			return null;
		}

		Iterator<VarDecl> iterate = all.iterator();
		return new Equation(Collections.singletonList(new IdExpr(mapping.get(CONJUNCTION_ID))), conjunctify(iterate));
	}

	private List<VarDecl> getPropertyVarDecls(List<VarDecl> properties) {
		List<VarDecl> decls = new ArrayList<>();
		for (VarDecl vd : properties) {
			String original = vd.id + TranslateSpecification.PROPERTY_SUFFIX;
			String renamed = getUniqueName(original);
			mapping.put(original, renamed);
			decls.add(new VarDecl(renamed, NamedType.BOOL));
		}
		return decls;
	}

	private List<Equation> getPropertyEquations(List<VarDecl> decls) {
		List<Equation> equations = new ArrayList<>();
		for (VarDecl vd : decls) {
			List<IdExpr> LHS = Collections.singletonList(new IdExpr(mapping.get(vd.id + PROPERTY_SUFFIX)));
			Expr RHS = new BinaryExpr(new IdExpr(mapping.get(TranslateSpecification.HISTORICAL_CONJUNCT_ID)), BinaryOp.IMPLIES, new IdExpr(mapping.get(vd.id)));
			equations.add(new Equation(LHS, RHS));
		}
		return equations;
	}

	private List<String> getPropertyStrings(List<VarDecl> decls) {
		List<String> properties = new ArrayList<>();
		for (VarDecl vd : decls) {
			properties.add(mapping.get(vd.id));
		}
		return properties;
	}

	private VarDecl getConjuctVarDecl() {
		String original = CONJUNCTION_ID;
		String renamed = getUniqueName(original);
		mapping.put(original, renamed);
		return new VarDecl(renamed, NamedType.BOOL);
	}

	private VarDecl getHistoricalConjuctVarDecl() {
		String original = HISTORICAL_CONJUNCT_ID;
		String renamed = getUniqueName(original);
		mapping.put(original, renamed);
		return new VarDecl(renamed, NamedType.BOOL);
	}
	
	private Equation createHistoricalConjunct() {
		List<IdExpr> LHS = Collections.singletonList(new IdExpr(mapping.get(TranslateSpecification.HISTORICAL_CONJUNCT_ID)));
		Expr RHS = new NodeCallExpr("historically",	Collections.singletonList(new IdExpr(mapping.get(TranslateSpecification.CONJUNCTION_ID))));
		Equation historicalConjunct = new Equation(LHS, RHS);
		return historicalConjunct;
	}

	public Program translateSpecification(Specification s, Map<EObject,EObject> references) {
		ProgramBuilder program = new ProgramBuilder();
		
		//lets add PLTL first to save its names
		for (Node n : HelperNodes.getPLTL()) {
			program.addNode(n);
		}

		//these elements will have global scoping
		String mainNodeName = s.getName();
		program.setMain(mainNodeName);
		mapping.put(mainNodeName,mainNodeName);
		
		program.addTypes(getTypeDefs(s,references));
		program.addConstants(getConstants(s,references));

		NodeBuilder mainNode = new NodeBuilder(mainNodeName);
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

		/*
		 * The inputs to a node representing the specification are:
		 * 1. The true inputs of the specification
		 * 2. The shadow inputs (or nondeterministic inputs) representing the state variables
		 * 3. The shadow inputs (or nondeterministic inputs) representing the outputs
		 */
		mainNode.addInputs(inputs);
		mainNode.addInputs(shadowState);
		mainNode.addInputs(shadowOutputs);

		/*
		 * Macros, assumptions, requirements, and behaviors are all local variables and thus
		 * must be declared.
		 */
		List<VarDecl> macroVarDecls = getMacrosVarDecls(s.getMacros());
		List<VarDecl> assumptionVarDecls = getConstraintVarDecls(s.getAssumptions());
		List<VarDecl> requirementVarDecls = getConstraintVarDecls(s.getRequirements());
		mainNode.addLocals(state);
		mainNode.addLocals(macroVarDecls);
		mainNode.addLocals(assumptionVarDecls);
		mainNode.addLocals(requirementVarDecls);
		
		/*
		 * In addition we create a few unique signals that are the conjunct of all the
		 * assumptions and requirements. The next block of code addresses that.
		 */
		mainNode.addLocal(getConjuctVarDecl());
		mainNode.addLocal(getHistoricalConjuctVarDecl());
		
		/*
		 * The node outputs are the outputs that are assigned to the corresponding shadow inputs
		 */
		mainNode.addOutputs(outputs);

		/*
		 * We must create equations that assign the true state and outputs to their corresponding shadow variables.
		 */
		mainNode.addEquations(makeEquationsForShadowVars(state, shadowState));
		mainNode.addEquations(makeEquationsForShadowVars(outputs, shadowOutputs));
		
		/*
		 * We must create an equation for each macro.
		 */
		mainNode.addEquations(makeEquationForMacros(s.getMacros()));
		
		/*
		 * Equations are created for each assumption, requirement, and behavior.
		 */
		mainNode.addEquations(makeEquationsForConstraints(s.getAssumptions()));
		mainNode.addEquations(makeEquationsForConstraints(s.getRequirements()));

		/*
		 * We must create an equation that takes the conjunct of each assumption and requirements.
		 * 
		 * For example, if we have assumptions a0 and a1 and requirements r0 and r1 this will be:
		 * 		CONJUNCT = a0 and a1 and r0 and r1;
		 */
		Equation conjunct = conjunctAssumptionsAndRequirements(assumptionVarDecls, requirementVarDecls);
		mainNode.addEquation(conjunct);
		
		/*
		 * We must create an equation that represents whether the CONJUNCT equation has been true from the 
		 * beginning of execution until the current time step.
		 */
		Equation historicalConjunct = createHistoricalConjunct();
		mainNode.addEquation(historicalConjunct);

		program.addNode(mainNode.build());
		return program.build();
	}
	
	public Program addAnalysisProperties(Specification s, Program p) {
		NodeBuilder nodeBuilder = new NodeBuilder(p.getMainNode());
		
		/*
		 * We must add the following VarDecls to the Node to account for the analysis.
		 */
		List<VarDecl> behaviorVarDecls = getConstraintVarDecls(s.getBehaviors());
		List<VarDecl> propertyVarDecls = getPropertyVarDecls(behaviorVarDecls);
		nodeBuilder.addLocals(behaviorVarDecls);
		nodeBuilder.addLocals(propertyVarDecls);
		
		/*
		 * We must add the following property information to account for analysis.
		 */
		List<Equation> propertyEquations = getPropertyEquations(behaviorVarDecls);
		nodeBuilder.addEquations(makeEquationsForConstraints(s.getBehaviors()));
		nodeBuilder.addEquations(propertyEquations);

		/*
		 * Here we add properties for the analysis
		 */
		nodeBuilder.addProperties(getPropertyStrings(propertyVarDecls));
		
		ProgramBuilder programBuilder = new ProgramBuilder(p);
		programBuilder.clearNodes();
		for(Node n : p.nodes) {
			if(!n.id.equals(p.main)) {
				programBuilder.addNode(n);
			}
		}
		Node main = nodeBuilder.build();
		programBuilder.addNode(main);
		programBuilder.setMain(main.id);
		return programBuilder.build();
	}
}
