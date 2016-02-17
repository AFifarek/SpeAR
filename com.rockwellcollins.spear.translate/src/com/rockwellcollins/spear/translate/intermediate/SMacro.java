package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Macro;

public class SMacro extends SAst {

	public static List<SMacro> convertList(List<Macro> list, SNode context) {
		List<SMacro> converted = new ArrayList<>();
		for(Macro m : list) {
			converted.add(new SMacro(m,context));
		}
		return converted;
	}
	
	private Macro macro;
	public String name;

	public SMacro(Macro m, SNode context) {
		this.macro = m;
		this.name = context.scope.getUniqueNameAndRegister(m.getName());
	}
	
	@Override
	public String toString() {
		return name;
	}
}
