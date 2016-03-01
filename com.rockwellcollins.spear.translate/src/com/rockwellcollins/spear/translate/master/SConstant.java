package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.NameMap;

public class SConstant {
	
	public static SConstant build(Constant c, NameMap nameMap) {
		return new SConstant(c,nameMap);
	}
	
	public static List<SConstant> build(List<Constant> list, NameMap nameMap) {
		List<SConstant> built = new ArrayList<>();
		for(Constant c : list) {
			built.add(SConstant.build(c, nameMap));
		}
		return built;
	}
	
	public static List<jkind.lustre.Constant> toLustre(List<SConstant> list, NameMap nameMap) {
		List<jkind.lustre.Constant> lustre = new ArrayList<>();
		for(SConstant sc : list) {
			lustre.add(sc.toLustre(nameMap));
		}
		return lustre;
	}
	
	public String name;
	public Type type;
	public Expr expr;
	
	public SConstant(Constant c, NameMap nameMap) {
		this.name=nameMap.getFileBasedName(c);
		this.type=c.getType();
		this.expr=c.getExpr();
	}
	
	public jkind.lustre.Constant toLustre(NameMap nameMap) {
		jkind.lustre.Type type = TranslateType.translate(this.type, nameMap);
		jkind.lustre.Expr expression = TranslateExpr.translate(this.expr, nameMap);
		return new jkind.lustre.Constant(this.name,type,expression);
	}
}
