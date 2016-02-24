package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.VarDecl;

public class SVariable extends SAst {

	public static List<SVariable> convertList(List<Variable> list, SNode context) {
		List<SVariable> converted = new ArrayList<>();
		for(Variable v : list) {
			converted.add(new SVariable(v,context));
		}
		return converted;
	}

	public static List<VarDecl> toVarDecl(List<SVariable> list, SNode context) {
		List<VarDecl> lustre = new ArrayList<>();
		for(SVariable svar : list) {
			lustre.add(svar.toVarDecl(context));
		}
		return lustre;
	}
	
	public String name;
	protected Variable variable;
	
	public SVariable(Variable v, SNode context) {
		this.name = context.scope.getUniqueLocalNameAndRegister(v.getName());
		this.variable = v;
	}
	
	public VarDecl toVarDecl(SNode context) {
		return new VarDecl(name,TranslateType.translate(variable.getType(), context));
	}
	
	@Override
	public String toString() {
		return name;
	}
}
