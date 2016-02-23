package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.VarDecl;

public class SAddArg extends SAst {

	public static List<VarDecl> convert(Collection<SAddArg> list, SNode context) {
		List<VarDecl> lustre = new ArrayList<>();
		for(SAddArg arg : list) {
			lustre.add(arg.toLustre(context));
		}
		return lustre;
	}
	
	public static List<Expr> getArgExpressions(Collection<SAddArg> list) {
		List<Expr> args = new ArrayList<>();
		for(SAddArg arg : list) {
			args.add(new IdExpr(arg.name));
		}
		return args;
	}
	
	public String name;
	public Type type;

	public SAddArg(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	public VarDecl toLustre(SNode context) {
		return new VarDecl(name,TranslateType.translate(type, context));
	}
}
