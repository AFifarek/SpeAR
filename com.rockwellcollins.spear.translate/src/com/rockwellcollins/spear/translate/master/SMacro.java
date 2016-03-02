package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.NameMap;

import jkind.lustre.Equation;
import jkind.lustre.VarDecl;

public class SMacro {

	public static List<SMacro> build(List<Macro> list, NameMap map) {
		List<SMacro> built = new ArrayList<>();
		for(Macro m : list) {
			built.add(SMacro.build(m, map));
		}
		return built;
	}
	
	public static List<VarDecl> toVarDecls(List<SMacro> list, NameMap map) {
		List<VarDecl> decls = new ArrayList<>();
		for(SMacro smacro : list) {
			decls.add(smacro.toVarDecl(map));
		}
		return decls;
	}
	
	public static List<Equation> toEquations(List<SMacro> list, NameMap map) {
		List<Equation> equations = new ArrayList<>();
		for(SMacro smacro : list) {
			equations.add(smacro.toEquation(map));
		}
		return equations;
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
	
	public jkind.lustre.VarDecl toVarDecl(NameMap map) {
		jkind.lustre.Type type = TranslateType.translate(this.type, map);
		return new jkind.lustre.VarDecl(this.name,type);
	}
	
	public jkind.lustre.Equation toEquation(NameMap map) {
		jkind.lustre.IdExpr LHS = new jkind.lustre.IdExpr(this.name);
		jkind.lustre.Expr RHS = TranslateExpr.translate(expression, map);
		return new jkind.lustre.Equation(LHS,RHS);
	}
}
