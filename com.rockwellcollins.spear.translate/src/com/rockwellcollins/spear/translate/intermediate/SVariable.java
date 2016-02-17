package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Variable;

public class SVariable extends SAst {

	public static List<SVariable> convertList(List<Variable> list, SNode context) {
		List<SVariable> converted = new ArrayList<>();
		for(Variable v : list) {
			converted.add(new SVariable(v,context));
		}
		return converted;
	}
	
	private Variable variable;
	public String name;

	public SVariable(Variable v, SNode context) {
		this.variable = v;
		this.name = context.scope.getUniqueNameAndRegister(v.getName());
	}
	
	@Override
	public String toString() {
		return name;
	}
}
