package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.Specification;

public class SSpecification extends SFile {

	public SSpecification(Specification s, SProgram context) {
		//the specification's name will be in the global scope
		this.name = context.scope.getName(s.getName());
	}
	
}
