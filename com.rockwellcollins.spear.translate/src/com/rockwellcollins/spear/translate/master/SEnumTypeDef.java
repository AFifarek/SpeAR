package com.rockwellcollins.spear.translate.master;

import java.util.HashSet;
import java.util.Set;

import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.File;

public class SEnumTypeDef extends STypeDef {

	public Set<String> values = new HashSet<>();
	
	public SEnumTypeDef(EnumTypeDef etd, SProgram context) {
		File root = Utilities.getRoot(etd);
		this.name=etd.getName();
		for(EnumValue ev : etd.getValues()) {
			String value = context.scope.getFileBasedName(root.getName(), ev.getName());
			this.values.add(value);
		}
	}
}
