package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.Expr;
import jkind.lustre.Type;

public class SConstant extends SAst {

	public static List<SConstant> convertList(Collection<Constant> list, SProgram context) {
		List<SConstant> converted = new ArrayList<>();
		for (Constant c : list) {
			converted.add(new SConstant(c, context));
		}
		return converted;
	}
	
	public static List<jkind.lustre.Constant> toLustre(Collection<SConstant> list, SProgram context) {
		List<jkind.lustre.Constant> lustre = new ArrayList<>();
		for(SConstant sconstant : list) {
			lustre.add(sconstant.toLustre(context));
		}
		return lustre;
	}

	private Constant constant;
	public String name;

	public SConstant(Constant c, SProgram context) {
		this.constant = c;
		this.name = context.scope.getUniqueNameAndRegister(c.getName());
	}
	
	public jkind.lustre.Constant toLustre(SProgram context) {
		Type t = TranslateType.translate(constant.getType(), context);
		Expr e = TranslateExpr.translate(constant.getExpr(), context);
		return new jkind.lustre.Constant(this.name,t,e);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
