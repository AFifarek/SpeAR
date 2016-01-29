package com.rockwellcollins.spear.translate.lustre;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.rockwellcollins.spear.Specification;

import jkind.lustre.Constant;
import jkind.lustre.Program;
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
	
	private List<TypeDef> getSpecificationTypeDefs(Specification s) {
		List<TypeDef> typedefs = new ArrayList<>();
		for(com.rockwellcollins.spear.TypeDef spearTypeDef : s.getTypedefs()) {
			TypeDef lustreTypeDef = TranslateTypeDef.translate(spearTypeDef);
			typedefs.add(lustreTypeDef);
			globalNames.add(lustreTypeDef.id);
		}
		return typedefs;
	}
	
	private List<Constant> getSpecificationConstants(Specification s) {
		List<Constant> constants = new ArrayList<>();
		for(com.rockwellcollins.spear.Constant spearConstant : s.getConstants()) {
			Constant lustreConstant = TranslateSpecification.translate(spearConstant);
			constants.add(lustreConstant);
			globalNames.add(lustreConstant.id);
		}
		return constants;
	}
	
	private List<VarDecl> getSpecificationVariables(List<com.rockwellcollins.spear.Variable> variables) {
		List<VarDecl> list = new ArrayList<>();
		for(com.rockwellcollins.spear.Variable var : variables) {
			VarDecl lustreVariable = TranslateSpecification.translate(var);
			list.add(lustreVariable);
			localNames.add(lustreVariable.id);
		}
		return list;
	}
	
	private List<VarDecl> createShadowVariables(List<VarDecl> variables) {
		ArrayList<VarDecl> shadowVariables = new ArrayList<>();
		for(VarDecl v : variables) {
			String name = getUniqueLocalName(v.id + SHADOW_SUFFIX);
			shadowVariables.add(new VarDecl(name,v.type));
		}
		return shadowVariables;
	}

	
	public Program translate(Specification s) {
		List<TypeDef> typedefs = getSpecificationTypeDefs(s);
		List<Constant> constants = getSpecificationConstants(s);
		
		//these represent the original inputs, outputs, and locals of a SpeAR specification
		List<VarDecl> inputs = getSpecificationVariables(s.getInputs());
		List<VarDecl> outputs = getSpecificationVariables(s.getOutputs());
		List<VarDecl> state = getSpecificationVariables(s.getState());
		
		/*
		 * These will be used to create nondeterministic inputs for the node
		 */
		List<VarDecl> shadowOutputs = createShadowVariables(outputs);
		List<VarDecl> shadowState = createShadowVariables(state);
		
		List<VarDecl> nodeInputs = new ArrayList<>();
		nodeInputs.addAll(inputs);
		nodeInputs.addAll(shadowOutputs);
		
		

		
		
		return null;
	}







}
