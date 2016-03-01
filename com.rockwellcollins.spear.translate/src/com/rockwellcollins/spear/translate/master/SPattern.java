package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.translate.naming.NameMap;

public class SPattern {

	public static List<SPattern> build(List<Pattern> list, NameMap map) {
		List<SPattern> built = new ArrayList<>();
		for(Pattern p : list) {
			built.add(SPattern.build(p, map));
		}
		return built;
	}
	
	public static SPattern build(Pattern p, NameMap map) {
		return new SPattern(p,map);
	}
	
	public String name;
	
	public SPattern(Pattern p, NameMap map) {
		this.name = map.getFileBasedName(p);
	}
}
