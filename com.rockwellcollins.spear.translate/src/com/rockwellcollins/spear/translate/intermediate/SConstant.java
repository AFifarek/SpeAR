package com.rockwellcollins.spear.translate.intermediate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.translate.experimental.Naming;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.Ast;
import jkind.lustre.Expr;
import jkind.lustre.Type;

public class SConstant extends SAst {

	public static Set<SConstant> convertList(Collection<Constant> list, SProgram context) {
		Set<SConstant> converted = new HashSet<>();
		for (Constant c : list) {
			converted.add(new SConstant(c, context));
		}
		return converted;
	}

	private Constant constant;
	public String name;

	public SConstant(Constant c, SProgram context) {
		this.constant = c;
		this.name = context.scope.getUniqueNameAndRegister(c.getName());
	}
	
	public Ast toLustre(Naming naming) {
		Type t = TranslateType.translate(constant.getType(), naming);
		Expr e = TranslateExpr.translate(constant.getExpr(), naming);
		return new jkind.lustre.Constant(this.name,t,e);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
