package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Specification;

public class SSpecification extends SFile {

	public Naming scope;
	
	public List<STypeDef> typedefs = new ArrayList<>();
	public List<SConstant> constants = new ArrayList<>();
	public List<SPattern> patterns = new ArrayList<>();
	
	public List<SVariable> inputs = new ArrayList<>();
	public List<SVariable> outputs = new ArrayList<>();
	public List<SVariable> state = new ArrayList<>();
	
	public List<SConstraint> assumptions = new ArrayList<>();
	public List<SConstraint> requirements = new ArrayList<>();
	public List<SConstraint> behaviors = new ArrayList<>();
	
	public List<SMacro> macros = new ArrayList<>();
	
	public SSpecification(Specification s, SProgram program) {
		//the specification's name will be in the global scope
		this.name = program.scope.getName(s.getName());
		
		//create a new scope
		this.scope = new Naming(program.scope);
		
		this.typedefs.addAll(STypeDef.build(s.getTypedefs(), program));
		this.constants.addAll(SConstant.build(s.getConstants(), program));
		this.patterns.addAll(SPattern.build(s.getPatterns(), program));
		
		this.inputs.addAll(SVariable.build(s.getInputs(), this));
		this.outputs.addAll(SVariable.build(s.getOutputs(), this));
		this.state.addAll(SVariable.build(s.getState(), this));
		this.macros.addAll(SMacro.build(s.getMacros(), this));
		this.assumptions.addAll(SConstraint.build(s.getAssumptions(), this));
		this.requirements.addAll(SConstraint.build(s.getRequirements(), this));
		this.behaviors.addAll(SConstraint.build(s.getBehaviors(), this));
	}
}
