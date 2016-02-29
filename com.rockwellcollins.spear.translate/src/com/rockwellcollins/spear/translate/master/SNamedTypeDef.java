package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.Type;

public class SNamedTypeDef extends STypeDef {

	private Type type;

	public SNamedTypeDef(NamedTypeDef ntd, SProgram context) {
		File root = Utilities.getRoot(ntd);
		this.name = context.scope.getFileBasedName(root.getName(),ntd.getName());
		this.type = ntd.getType();
	}
}
