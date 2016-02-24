package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Macro;
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
	
	public static List<VarDecl> getVarDecls(List<SMacro> list, SNode context) {
		List<VarDecl> lustre = new ArrayList<>();
		for(SMacro smacro : list) {
			lustre.add(smacro.getVarDecl(context));
		}
		return lustre;
	}
	
	public static List<Equation> getEquations(List<SMacro> list, SNode context) {
		List<Equation> lustre = new ArrayList<>();
		for(SMacro smacro : list) {
			lustre.add(smacro.getEquation(context));
		}
		return lustre;
	}
	
	private Macro macro;
	public String name;

	public SMacro(Macro m, SNode context) {
		this.macro = m;
		this.name = context.scope.getUniqueLocalNameAndRegister(m.getName());
	}
	
	public VarDecl getVarDecl(SNode context) {
		Type t = TranslateType.translate(macro.getType(), context);
		return new VarDecl(name,t);	
	}
	
	public Equation getEquation(SNode context) {
		Expr e = TranslateExpr.translate(macro.getExpr(), context);
		return LustreUtil.eq(new IdExpr(name), e);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
