package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.translate.naming.NameMap;
import com.rockwellcollins.spear.translate.transformations.SpearDocument;

import jkind.lustre.Program;
import jkind.lustre.builders.ProgramBuilder;

public class SProgram {

	public static SProgram build(SpearDocument doc) {
		return new SProgram(doc);
	}
	
	public SSpecification main;
	public Map<String,SFile> deps = new HashMap<>();
	
	public NameMap map;
	
	public SProgram(SpearDocument document) {
		//initialize the map
		map = new NameMap();
		
		//copy the files from the SpeAR document
		List<File> files = new ArrayList<>(document.files);
		
		//this is a gross way to traverse the list in reverse order, but so be it.
		for(int i=files.size()-1; i>=0; i--) {
			File f = files.get(i);
			SFile sfile = SFile.build(f, map);
			if(f.getName().equals(document.mainName)) {
				this.main = (SSpecification) sfile;
			} else {
				deps.put(sfile.name, sfile);	
			}
		}
	}
	
	public Program getLogicalEntailment() {
		ProgramBuilder program = new ProgramBuilder();
	
		program.addTypes(STypeDef.toLustre(main.typedefs, map));
		program.addConstants(SConstant.toLustre(main.constants, map));
		
		for(SFile f : deps.values()) {
			program.addTypes(STypeDef.toLustre(f.typedefs, map));
			program.addConstants(SConstant.toLustre(f.constants, map));
			
			if (f instanceof SSpecification) {
				SSpecification spec = (SSpecification) f;
				program.addNode(spec.toBaseLustre(map));
			}
		}
		
		return program.build();
	}
}
