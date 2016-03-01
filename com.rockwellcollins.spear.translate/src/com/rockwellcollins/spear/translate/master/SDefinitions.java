package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.translate.naming.NameMap;

public class SDefinitions extends SFile {

	public SDefinitions(Definitions d, NameMap map) {
		//register the definitions name in the global scope
		this.name = map.getName(d);
		
		typedefs.addAll(STypeDef.build(d.getTypedefs(), map));
		constants.addAll(SConstant.build(d.getConstants(), map));
		patterns.addAll(SPattern.build(d.getPatterns(), map));
	}
}
