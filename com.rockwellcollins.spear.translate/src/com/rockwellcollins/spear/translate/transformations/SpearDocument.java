package com.rockwellcollins.spear.translate.transformations;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Specification;

public class SpearDocument {

	public String mainName;
	public Map<String, File> files = new HashMap<>();

	public SpearDocument(Specification main) {
		this.mainName = main.getName();
		for (File file : FindDependencies.instance(main).getCalledFiles()) {
			files.put(file.getName(), file);
		}
	}
	
	public void mapFiles(Function<File,File> function) {
		files.replaceAll((filename,file) -> function.apply(file));
	}
	
	public Specification getMain() {
		return (Specification) files.get(mainName);
	}
}
