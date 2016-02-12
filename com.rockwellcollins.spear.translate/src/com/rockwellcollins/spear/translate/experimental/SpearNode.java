package com.rockwellcollins.spear.translate.experimental;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.Node;
import jkind.lustre.VarDecl;
import jkind.lustre.builders.NodeBuilder;

public class SpearNode extends SpearAst {

	
	public String name;
	public List<Variable> inputs = new ArrayList<>();
	public List<Variable> outputs = new ArrayList<>();
	public List<Variable> state = new ArrayList<>();
	public List<Macro> macros = new ArrayList<>();
	public List<Constraint> equations = new ArrayList<>();
	public List<Constraint> properties = new ArrayList<>();
	
	public Specification sourceSpecification;
	
	private NameManager naming;
	private static final String SHADOW_SUFFIX = "SHADOW";
	
	
	public SpearNode(Specification s) {
		this.sourceSpecification = s;
		name = s.getName();
		inputs.addAll(s.getInputs());
		outputs.addAll(s.getOutputs());
		state.addAll(s.getState());
		macros.addAll(s.getMacros());
		
		equations.addAll(s.getAssumptions());
		equations.addAll(s.getRequirements());
		equations.addAll(s.getBehaviors());
		
		properties.addAll(s.getBehaviors());
	}
	
	private VarDecl processVariable(Variable v) {
		String renamed = naming.getUniqueNameAndRegister(v.getName());
		return new VarDecl(renamed, TranslateType.translate(v.getType(), naming));
	}

	private List<VarDecl> processVariables(List<Variable> variables) {
		List<VarDecl> processed = new ArrayList<>();
		for(Variable v : variables) {
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
		for(Variable v : variables) {
			processed.add(processShadowVar(v));
		}
		return processed;
	}

	private List<VarDecl> getMacroVarDecls(List<Macro> macrolist) {
		List<VarDecl> processed = new ArrayList<>();
		for(Macro m : macrolist) {
			processed.add(processMacro(m));
		}
	}
	
	public Node toLustre(NameManager globalNaming) {
		naming = new NameManager(globalNaming);
		NodeBuilder node = new NodeBuilder(name);
		//inputs are true inputs and shadow vars for outputs and state
		node.addInputs(processVariables(inputs));
		node.addInputs(processShadowVars(outputs));
		node.addInputs(processShadowVars(state));
		
		//locals are state and macros
		node.addLocals(processVariables(state));
		node.addLocals(getMacroVarDecls(macros));
		return null;
	}






}
