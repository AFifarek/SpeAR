package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.NameMap;

import jkind.lustre.VarDecl;

public class SPVariable {

	public static List<SPVariable> build(List<Variable> list, Pattern p, NameMap map) {
		List<SPVariable> processed = new ArrayList<>();
		for(Variable v : list) {
			processed.add(SPVariable.build(v, p, map));
		}
		return processed;
	}
	
	public static List<VarDecl> toVarDecl(List<SPVariable> list, NameMap map) {
		List<VarDecl> lustre = new ArrayList<>();
		for(SPVariable svar : list) {
			lustre.add(svar.toLustre(map));
		}
		return lustre;
	}
	
	public static SPVariable build(Variable v, Pattern p, NameMap map) {
		return new SPVariable(v,p,map);
	}
	
	public String name;
	public Type type;
	
	public SPVariable(Variable v, Pattern p, NameMap map) {
		this.name=map.getName(p, v.getName());
		this.type=v.getType();
	}
	
	public VarDecl toLustre(NameMap map) {
		jkind.lustre.Type type = TranslateType.translate(this.type, map);
		return new jkind.lustre.VarDecl(this.name,type);
	}
}
