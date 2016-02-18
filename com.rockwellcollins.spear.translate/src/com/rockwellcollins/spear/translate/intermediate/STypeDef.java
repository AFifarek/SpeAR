package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.lustre.TranslateDecl;

public class STypeDef extends SAst {

	public static List<STypeDef> convertList(Collection<TypeDef> list, SProgram context) {
		List<STypeDef> converted = new ArrayList<>();
		for(TypeDef typedef : list) {
			converted.add(new STypeDef(typedef,context));
		}
		return converted;
	}
	
	public static List<jkind.lustre.TypeDef> toLustre(Collection<STypeDef> typedefs, SProgram context) {
		List<jkind.lustre.TypeDef> lustre = new ArrayList<>();
		for(STypeDef stypedef : typedefs) {
			lustre.add(stypedef.toLustre(context));
		}
		return lustre;
	}
	
	private TypeDef typedef;
	public String name;

	public STypeDef(TypeDef typedef, SProgram context) {
		this.typedef = typedef;
		this.name = context.scope.getUniqueNameAndRegister(typedef.getName());
	}
	
	public jkind.lustre.TypeDef toLustre(SProgram context) {
		return (jkind.lustre.TypeDef) TranslateDecl.translate(typedef, context);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
