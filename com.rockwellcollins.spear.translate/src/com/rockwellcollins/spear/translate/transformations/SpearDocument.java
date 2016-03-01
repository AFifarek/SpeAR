package com.rockwellcollins.spear.translate.transformations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Specification;

public class SpearDocument {

	public String mainName;
	public List<File> files = new ArrayList<>();

	public SpearDocument(Specification main) {
		this.mainName = main.getName();
		for (File file : FindDependencies.instance(main).getCalledFiles()) {
			files.add(file);
		}
	}
}
