package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Constraint;

public class SConstraint extends SAst {
	
	public static List<SConstraint> convertList(List<Constraint> list, SNode context) {
		List<SConstraint> converted = new ArrayList<>();
		for(Constraint c : list) {
			converted.add(new SConstraint(c,context));
		}
		return converted;
	}
	
	private Constraint constraint;
	public String name;

	public SConstraint(Constraint c, SNode context) {
		this.constraint = c;
		this.name = context.scope.getUniqueNameAndRegister(c.getName());
	}
	
	@Override
	public String toString() {
		return name;
	}

}
