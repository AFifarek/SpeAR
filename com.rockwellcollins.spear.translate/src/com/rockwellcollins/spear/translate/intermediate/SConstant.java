package com.rockwellcollins.spear.translate.intermediate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.rockwellcollins.spear.Constant;

public class SConstant extends SAst {

	public static Set<SConstant> convertList(Collection<Constant> list, SProgram context) {
		Set<SConstant> converted = new HashSet<>();
		for (Constant c : list) {
			converted.add(new SConstant(c, context));
		}
		return converted;
	}

	private Constant constant;
	public String name;

	public SConstant(Constant c, SProgram context) {
		this.constant = c;
		this.name = context.scope.getUniqueNameAndRegister(c.getName());
	}

	@Override
	public String toString() {
		return name;
	}
}
