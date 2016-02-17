package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.experimental.Naming;

public class SNode extends SAst {

	public static Set<SNode> convertList(Collection<Specification> list, SProgram context, boolean called) {
		Set<SNode> converted = new HashSet<>();
		for(Specification s : list) {
			converted.add(new SNode(s,context,called));
		}
		return converted;
	}
	
	private String name;
	private boolean called;
	
	protected Naming scope;
	
	public List<SVariable> inputs = new ArrayList<>();
	public List<SVariable> outputs = new ArrayList<>();
	public List<SVariable> state = new ArrayList<>();
	public List<SMacro> macros = new ArrayList<>();
	public List<SConstraint> assumptions = new ArrayList<>();
	public List<SConstraint> requirements = new ArrayList<>();
	public List<SConstraint> behaviors = new ArrayList<>();
	
	public Map<NormalizedCall,SNode> calls = new HashMap<>();
	
	public SNode(Specification s, SProgram program, boolean called) {
		//capture the name in the Program context
		this.name = program.scope.getUniqueNameAndRegister(s.getName());
		this.called = called;
		
		if(!this.called) {
			//process the global stuff first
			program.typedefs.addAll(STypeDef.convertList(s.getTypedefs(), program));
			program.constants.addAll(SConstant.convertList(s.getConstants(), program));
		}
		
		for(NormalizedCall call : EcoreUtil2.getAllContentsOfType(s, NormalizedCall.class)) {
			SNode calledNode = new SNode(call.getSpec(), program, true);
			calls.put(call, calledNode);
		}

		//set the local scope before processing local elements
		scope = new Naming(program.scope);
		inputs.addAll(SVariable.convertList(s.getInputs(), this));
		outputs.addAll(SVariable.convertList(s.getOutputs(), this));
		state.addAll(SVariable.convertList(s.getState(), this));
		macros.addAll(SMacro.convertList(s.getMacros(), this));
		assumptions.addAll(SConstraint.convertList(s.getAssumptions(), this));
		requirements.addAll(SConstraint.convertList(s.getRequirements(), this));
		behaviors.addAll(SConstraint.convertList(s.getBehaviors(), this));
	}
	
	@Override
	public String toString() {
		return "node "+ name + " (" + StringUtils.join(inputs, ";") + ") returns (" + StringUtils.join(outputs, ";") + ")";
	}
}
