package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Type;

public class SArrayTypeDef extends STypeDef {
	
	public Type baseType;
	public Integer size;
	
	public SArrayTypeDef(ArrayTypeDef atd, SProgram context) {
		File root = Utilities.getRoot(atd);
		this.name = context.scope.getFileBasedName(root.getName(), atd.getName());
		this.baseType = atd.getBase();
		this.size = atd.getSize();
	}
}
