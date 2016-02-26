package com.rockwellcollins.spear.translate.transformations;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.master.Naming;

public class SpearDocument {

	public Map<String, File> files = new HashMap<>();
	public Naming scope;

	public SpearDocument(Specification main) {
		for (File file : FindDependencies.instance(main).getCalledFiles()) {
			files.put(file.getName(), file);
		}
	}
	
	public void mapFiles(Function<File,File> function) {
		files.replaceAll((filename,file) -> function.apply(file));
	}
}
