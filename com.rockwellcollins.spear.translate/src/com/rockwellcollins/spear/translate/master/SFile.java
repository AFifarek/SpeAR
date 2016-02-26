package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.util.SpearSwitch;

public class SFile {
	
	public static SFile build(File f, SProgram context) {
		SFileBuilder builder = new SFileBuilder(context);
		return builder.doSwitch(f);
	}
	
	public static List<SFile> buildList(List<File> list, SProgram context) {
		List<SFile> converted = new ArrayList<>();
		SFileBuilder builder = new SFileBuilder(context);
		for(File f : list) {
			converted.add(builder.doSwitch(f));
		}
		return converted;
	}
	
	public String name;

	private static class SFileBuilder extends SpearSwitch<SFile> {
		
		private SProgram context;
		
		private SFileBuilder(SProgram context) {
			this.context=context;
		}
		
		@Override
		public SFile caseSpecification(Specification s) {
			return new SSpecification(s,context);
		}
		
		@Override
		public SFile caseDefinitions(Definitions d) {
			return new SDefinitions(d,context);
		}
		
		@Override
		public SFile defaultCase(EObject o) {
			throw new RuntimeException("Expected a File object, received: " + o.toString());
		}
	}
}


