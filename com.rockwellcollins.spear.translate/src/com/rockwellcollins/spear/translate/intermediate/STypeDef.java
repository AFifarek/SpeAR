package com.rockwellcollins.spear.translate.intermediate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.rockwellcollins.spear.TypeDef;

public class STypeDef extends SAst {

	public static Set<STypeDef> convertList(Collection<TypeDef> typedefs, SProgram context) {
		Set<STypeDef> converted = new HashSet<>();
		for(TypeDef typedef : typedefs) {
			converted.add(new STypeDef(typedef,context));
		}
		return converted;
	}
	
	private TypeDef typedef;
	public String name;

	public STypeDef(TypeDef typedef, SProgram context) {
		this.typedef = typedef;
		this.name = context.scope.getUniqueNameAndRegister(typedef.getName());
	}
	
	@Override
	public String toString() {
		return name;
	}
}
