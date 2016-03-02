package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

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
			}	
		}
	}
	
	public Program getLogicalEntailment() {
		ProgramBuilder program = new ProgramBuilder();
		for(SFile f : map.mapping.values()) {
			program.addTypes(STypeDef.toLustre(f.typedefs, map));
			program.addConstants(SConstant.toLustre(f.constants, map));
			
			if (f instanceof SSpecification) {
				SSpecification spec = (SSpecification) f;
				program.addNode(spec.toBaseLustre(this, map));
			}
		}
		program.setMain(main.name);
		
		return program.build();
	}
}
