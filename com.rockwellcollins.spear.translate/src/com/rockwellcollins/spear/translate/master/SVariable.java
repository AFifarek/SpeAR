package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.Variable;

public class SVariable {

	public static List<SVariable> build(List<Variable> list, SSpecification context) {
		List<SVariable> processed = new ArrayList<>();
		for(Variable v : list) {
			processed.add(SVariable.build(v, context));
		}
		return processed;
	}
	
	public static SVariable build(Variable v, SSpecification context) {
		return new SVariable(v,context);
	}
	
	public String name;
	public Type type;
	
	public SVariable(Variable v, SSpecification context) {
		this.name=context.scope.getName(v.getName());
		this.type=v.getType();
	}
}
