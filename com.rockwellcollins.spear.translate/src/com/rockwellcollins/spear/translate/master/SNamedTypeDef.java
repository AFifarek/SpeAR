package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.NameMap;

import jkind.lustre.TypeDef;

public class SNamedTypeDef extends STypeDef {

	public Type type;

	public SNamedTypeDef(NamedTypeDef ntd, NameMap map) {
		this.name = map.getFileBasedName(ntd);
		this.type = ntd.getType();
	}

	@Override
	public TypeDef toLustre(NameMap naming) {
		jkind.lustre.Type t = TranslateType.translate(type, naming);
		return new TypeDef(this.name,t);
	}
}
