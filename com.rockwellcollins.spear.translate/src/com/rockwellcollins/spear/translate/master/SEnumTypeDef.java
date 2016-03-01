package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.translate.naming.NameMap;

import jkind.lustre.EnumType;
import jkind.lustre.TypeDef;

public class SEnumTypeDef extends STypeDef {

	public String definitionName;
	public List<String> values = new ArrayList<>();
	
	public SEnumTypeDef(EnumTypeDef etd, NameMap map) {
		this.name = map.getFileBasedName(etd);
		this.definitionName=map.getDefinitionsName(etd);
		
		for(EnumValue ev : etd.getValues()) {
			String value = map.getFileBasedName(ev);
			this.values.add(value);
		}
	}

	@Override
	public TypeDef toLustre(NameMap naming) {
		jkind.lustre.EnumType type = new EnumType(this.definitionName, values);
		return new TypeDef(this.name, type);
	}
}
