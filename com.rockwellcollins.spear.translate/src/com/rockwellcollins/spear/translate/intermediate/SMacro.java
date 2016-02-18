package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.translate.experimental.Naming;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.LustreUtil;
import jkind.lustre.Type;
import jkind.lustre.VarDecl;

public class SMacro extends SAst {

	public static List<SMacro> convertList(List<Macro> list, SNode context) {
		List<SMacro> converted = new ArrayList<>();
		for(Macro m : list) {
			converted.add(new SMacro(m,context));
		}
		return converted;
	}
	
	private Macro macro;
	public String name;

	public SMacro(Macro m, SNode context) {
		this.macro = m;
		this.name = context.scope.getUniqueNameAndRegister(m.getName());
	}
	
	public VarDecl getVarDecl(Naming naming) {
		Type t = TranslateType.translate(macro.getType(), naming);
		return new VarDecl(name,t);	
	}
	
	public Equation getEquation(Naming naming) {
		Expr e = TranslateExpr.translate(macro.getExpr(), naming);
		return LustreUtil.eq(new IdExpr(name), e);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
