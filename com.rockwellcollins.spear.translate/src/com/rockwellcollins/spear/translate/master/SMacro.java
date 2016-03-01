package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.naming.NameMap;

public class SMacro {

	public static List<SMacro> build(List<Macro> list, NameMap map) {
		List<SMacro> built = new ArrayList<>();
		for(Macro m : list) {
			built.add(SMacro.build(m, map));
		}
		return built;
	}
	
	public static SMacro build(Macro m, NameMap map) {
		return new SMacro(m,map);
	}
	
	public String name;
	public Type type;
	public Expr expression;
	
	public SMacro(Macro m, NameMap map) {
		this.name=map.getName(m);
		this.type=m.getType();
		this.expression=m.getExpr();
	}
}
