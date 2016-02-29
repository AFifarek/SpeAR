package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Definitions;

public class SDefinitions extends SFile {
	
	public Naming scope;
	
	public List<STypeDef> typedefs = new ArrayList<>();
	public List<SConstant> constants = new ArrayList<>();
	public List<SPattern> patterns = new ArrayList<>();

	public SDefinitions(Definitions d, SProgram context) {
		//register the definitions name in the global scope
		this.name = context.scope.getName(d.getName());
		
		typedefs.addAll(STypeDef.build(d.getTypedefs(), context));
		constants.addAll(SConstant.build(d.getConstants(), context));
		patterns.addAll(SPattern.build(d.getPatterns(), context));
	}
}
