package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Pattern;

public class SPattern {

	public static List<SPattern> build(List<Pattern> list, SProgram context) {
		List<SPattern> built = new ArrayList<>();
		for(Pattern p : list) {
			built.add(SPattern.build(p, context));
		}
		return built;
	}
	
	public static SPattern build(Pattern p, SProgram context) {
		return new SPattern(p,context);
	}
	
	public String name;
	
	public SPattern(Pattern p, SProgram program) {
		this.name = program.scope.getName(p.getName());
	}
}
