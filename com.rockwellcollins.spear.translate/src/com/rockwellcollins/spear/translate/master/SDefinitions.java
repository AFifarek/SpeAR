package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.Definitions;

public class SDefinitions extends SFile {

	public SDefinitions(Definitions d, SProgram context) {
		this.name = context.scope.getName(d.getName());
	}
}
