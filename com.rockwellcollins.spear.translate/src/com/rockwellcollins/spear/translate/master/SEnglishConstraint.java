package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.EnglishConstraint;
import com.rockwellcollins.spear.translate.naming.NameMap;

import jkind.lustre.NamedType;

public class SEnglishConstraint extends SConstraint {

	public static SEnglishConstraint build(EnglishConstraint ec, NameMap map) {
		return new SEnglishConstraint(ec,map);
	}
	
	public String text;
	
	public SEnglishConstraint(EnglishConstraint ec, NameMap map) {
		this.name = map.getName(ec);
		this.text = ec.getText();
	}

	@Override
	public jkind.lustre.VarDecl toVarDecl(NameMap map) {
		return new jkind.lustre.VarDecl(this.name, NamedType.BOOL);
	}

	@Override
	public jkind.lustre.Equation toEquation(NameMap map) {
		jkind.lustre.IdExpr lhs = new jkind.lustre.IdExpr(this.name);
		jkind.lustre.Expr rhs = new jkind.lustre.BoolExpr(true);
		return new jkind.lustre.Equation(lhs,rhs);
	}
}
