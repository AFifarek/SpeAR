package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.NameMap;

import jkind.lustre.ArrayType;
import jkind.lustre.TypeDef;

public class SArrayTypeDef extends STypeDef {
	
	public Type base;
	public Integer size;
	
	public SArrayTypeDef(ArrayTypeDef atd, NameMap map) {
		this.name = map.getFileBasedName(atd);
		this.base = atd.getBase();
		this.size = atd.getSize();
	}

	@Override
	public TypeDef toLustre(NameMap context) {
		jkind.lustre.Type baseType = TranslateType.translate(base, context);
		jkind.lustre.Type arrayType = new ArrayType(baseType,size);
		return new TypeDef(name,arrayType);
	}
}
