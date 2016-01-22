package com.rockwellcollins.spear.translate.lustre;

import java.util.HashMap;
import java.util.Map;

import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.Ast;

public class TranslateDeclarations extends SpearSwitch<Void> {

	public Map<String,Ast> programElements = new HashMap<>();
	
	@Override
	public Void caseConstant(com.rockwellcollins.spear.Constant c) {
//		String name = c.getName();		
//		Type t = TranslateType.translate(c.getType());
//		Expr e = TranslateExpr.translate(c.getExpr());
//		programElements.put(name, new Constant(name,t,e));
		return null;
	}
	
	@Override
	public Void caseSpecification(com.rockwellcollins.spear.Specification s) {
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
	
	@Override
	public Void caseTypeDef(com.rockwellcollins.spear.TypeDef td) {
		
		return null;
	}
}
