package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.translate.experimental.Naming;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;

import jkind.lustre.BoolExpr;
import jkind.lustre.Equation;
import jkind.lustre.IdExpr;
import jkind.lustre.LustreUtil;
import jkind.lustre.NamedType;
import jkind.lustre.VarDecl;

public class SConstraint extends SAst {
	
	public static List<SConstraint> convertList(List<Constraint> list, SNode context) {
		List<SConstraint> converted = new ArrayList<>();
		for(Constraint c : list) {
			converted.add(new SConstraint(c,context));
		}
		return converted;
	}
	
	private Constraint constraint;
	public String name;

	public SConstraint(Constraint c, SNode context) {
		this.constraint = c;
		this.name = context.scope.getUniqueNameAndRegister(c.getName());
	}
	
	public VarDecl getVarDecl(Naming naming) {
		return new VarDecl(name,NamedType.BOOL);
	}
	
	public Equation getEquation(Naming naming) {
		IdExpr ie = new IdExpr(name);
		if (constraint instanceof FormalConstraint) {
			FormalConstraint fc = (FormalConstraint) constraint;
			return LustreUtil.eq(ie, TranslateExpr.translate(fc.getExpr(), naming));
		}
		return LustreUtil.eq(new IdExpr(name), new BoolExpr(true));
	}
	
	@Override
	public String toString() {
		return name;
	}

}
