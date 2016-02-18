package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.experimental.Naming;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.Ast;
import jkind.lustre.VarDecl;

public class SVariable extends SAst {

	public static List<SVariable> convertList(List<Variable> list, SNode context) {
		List<SVariable> converted = new ArrayList<>();
		for(Variable v : list) {
			converted.add(new SVariable(v,context));
		}
		return converted;
	}
	
	private static final String SHADOW_SUFFIX = "_SHADOW";
	public String name;
	private String shadowName;
	private Variable variable;
	
	public SVariable(Variable v, SNode context) {
		this.name = context.scope.getUniqueNameAndRegister(v.getName());
		this.shadowName = context.scope.getUniqueNameAndRegister(v.getName() + SHADOW_SUFFIX);
		this.variable = v;
	}
	
	public Ast toVarDecl(Naming naming) {
		return new VarDecl(name,TranslateType.translate(variable.getType(), naming));
	}
	
	public Ast toShadowVarDecl(Naming naming) {
		return new VarDecl(shadowName,TranslateType.translate(variable.getType(), naming));
	}
	
	@Override
	public String toString() {
		return name;
	}
}
