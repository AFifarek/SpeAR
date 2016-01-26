package com.rockwellcollins.spear.translate.lustre;

import java.util.HashMap;
import java.util.Map;

import jkind.lustre.Ast;
import jkind.lustre.Program;

public class TranslateDeclarations {

	public Map<String,Ast> programElements = new HashMap<>();
	public Map<String,String> renamed = new HashMap<>();
	
	private String getUniqueKey(String string) {
		Integer unique = 0;
		String name = string;
		while(programElements.containsKey(name)) {
			name = string + "_" + unique;
			unique++;
		}
		return name;
	}
	
	public void insert(String name, Ast element) {
		String uniqueName = getUniqueKey(name);
		if(!uniqueName.equals(name)) {
			renamed.put(name,uniqueName);
		}
		programElements.put(uniqueName, element);
	}
	
	public Program caseSpecification(com.rockwellcollins.spear.Specification s) {
		//helper nodes
		
		//build infrastructure
			//unique names
			//
		
		//process types
		//process constants
		//process macros
		
		//process inputs
		//process outputs
		//process state
		
		//process assumptions
		//process properties	
		return null;
	}
}
