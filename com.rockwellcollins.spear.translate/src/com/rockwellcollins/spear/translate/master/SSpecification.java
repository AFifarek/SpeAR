package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.naming.NameMap;

import jkind.lustre.Node;
import jkind.lustre.VarDecl;
import jkind.lustre.builders.NodeBuilder;

public class SSpecification extends SFile {
	
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
	}
	
	public List<VarDecl> getShadowedVariables() {
		List<VarDecl> shadow = new ArrayList<>();
		for(SCall call : calls.values()) {
			shadow.addAll(call.getShadowVariablesForCall(map));
		}
		return shadow;
	}
	
	public Node toBaseLustre(SProgram top, NameMap map) {
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
		builder.addInputs(SVariable.toShadowVarDecl(outputs, map));
		builder.addInputs(SVariable.toShadowVarDecl(state, map));
		
		/*
		 * We need to figure out how to get the shadow variables from called specs and 
		 * create variables as inputs to feed them so they're nondeterministic.
		 * 
		 * We need to go into the called spec and
		 * 1. set up inputs in the caller, for the callee's shadow variables
		 * 2. set up inputs in the caller, for the callee's called specs (recursion required)
		 * 3. somehow deal with this in the map so when we're 
		 */
		for(SCall call : this.calls.values()) {
			builder.addInputs(call.getShadowVariablesForCall(map));	
		}
		
		/*
		 * We must add
		 * 1. the true locals
		 * 2. locals for the assumptions
		 * 3. locals for the requirements
		 * 4. locals for the behaviors */
		builder.addLocals(SVariable.toVarDecl(state, map));
		builder.addLocals(SConstraint.toVarDecl(assumptions,map));
		builder.addLocals(SConstraint.toVarDecl(requirements, map));
		builder.addLocals(SConstraint.toVarDecl(behaviors, map));
		
		/* We just add the true outputs  */
		builder.addOutputs(SVariable.toVarDecl(outputs, map));

		/*
		 * We need to add:
		 * 1. Equations assigning the shadow variable to their true variables.
		 * 2. Equations assigning the assumptions, requirements, and behaviors.
		 */
		builder.addEquations(SVariable.toShadowAssignmentEquations(outputs,map));
		builder.addEquations(SVariable.toShadowAssignmentEquations(state,map));
		builder.addEquations(SConstraint.toEquation(assumptions, map));
		builder.addEquations(SConstraint.toEquation(requirements, map));
		builder.addEquations(SConstraint.toEquation(behaviors, map));
		
		return builder.build();
	}
}
