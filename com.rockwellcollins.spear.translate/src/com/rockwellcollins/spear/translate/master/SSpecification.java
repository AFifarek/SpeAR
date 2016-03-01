package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.naming.NameMap;

import jkind.lustre.Node;
import jkind.lustre.builders.NodeBuilder;

public class SSpecification extends SFile {
	
	public List<SVariable> inputs = new ArrayList<>();
	public List<SVariable> outputs = new ArrayList<>();
	public List<SVariable> state = new ArrayList<>();
	
	public List<SConstraint> assumptions = new ArrayList<>();
	public List<SConstraint> requirements = new ArrayList<>();
	public List<SConstraint> behaviors = new ArrayList<>();
	
	public List<SMacro> macros = new ArrayList<>();
	
	public SSpecification(Specification s, NameMap map) {
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
	}

	public Node toBaseLustre(NameMap map) {
		NodeBuilder builder = new NodeBuilder(name);
		
		builder.addInputs(SVariable.toLustre(inputs, map));
		builder.addLocals(SVariable.toLustre(state, map));
		builder.addOutputs(SVariable.toLustre(outputs, map));

		return builder.build();
	}
}
