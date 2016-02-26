package com.rockwellcollins.spear.translate.master;

import java.util.HashMap;
import java.util.Map;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.transformations.SpearDocument;

public class SProgram {
	
	public SSpecification main;
	public Map<String,SFile> deps = new HashMap<>();
	
	public Naming scope = new Naming();
	
	public SProgram(Specification main, SpearDocument document) {
		Specification mainSpec = (Specification) document.files.get(main.getName());
		this.main = new SSpecification(mainSpec, this);
		
		for(File file : document.files.values()) {
			SFile sfile = SFile.build(file, this);
			deps.put(sfile.name, sfile);
		}
	}

}
