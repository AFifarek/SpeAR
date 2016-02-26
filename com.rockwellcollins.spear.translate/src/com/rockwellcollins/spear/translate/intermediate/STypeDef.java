package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.lustre.TranslateDecl;

public class STypeDef extends SAst {

	public static List<STypeDef> convertList(Collection<TypeDef> list, SNode context) {
		List<STypeDef> converted = new ArrayList<>();
		for(TypeDef typedef : list) {
			converted.add(new STypeDef(typedef,context));
		}
		return converted;
	}
	
	public static List<jkind.lustre.TypeDef> toLustre(Collection<STypeDef> set, SNode context) {
		List<jkind.lustre.TypeDef> lustre = new ArrayList<>();
		for(STypeDef stypedef : set) {
			lustre.add(stypedef.toLustre(context));
		}
		return lustre;
	}
	
	private TypeDef typedef;
	public String name;

	public STypeDef(TypeDef typedef, SNode context) {
		this.typedef = typedef;
		this.name = context.scope.getUniqueGlobalNameAndRegister(context.name,typedef.getName());
		
		if (typedef instanceof EnumTypeDef) {
			EnumTypeDef etd = (EnumTypeDef) typedef;
			for(EnumValue ev : etd.getValues()) {
				context.scope.getUniqueGlobalNameAndRegister(context.name, ev.getName());	
			}
		}
	}
	
	public jkind.lustre.TypeDef toLustre(SNode context) {
		return (jkind.lustre.TypeDef) TranslateDecl.translate(typedef, context);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
