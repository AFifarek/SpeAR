package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;

import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
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
	
	public static List<VarDecl> getVarDecls(List<SConstraint> list, SNode context) {
		List<VarDecl> lustre = new ArrayList<>();
		for(SConstraint sconstraint : list) {
			lustre.add(sconstraint.getVarDecl(context));
		}
		return lustre;
	}
	
	public static List<Equation> getEquations(List<SConstraint> list, SNode context) {
		List<Equation> lustre = new ArrayList<>();
		for(SConstraint sconstraint : list) {
			lustre.add(sconstraint.getEquation(context));
		}
		return lustre;
	}
	
	public static List<VarDecl> getPropertyVarDecls(List<SConstraint> list, SNode context) {
		List<VarDecl> lustre = new ArrayList<>();
		for(SConstraint sconstraint : list) {
			lustre.add(sconstraint.getPropertyVarDecl(context));
		}
		return lustre;
	}
	
	public static List<Equation> getPropertyEquations(List<SConstraint> list, jkind.lustre.Expr conjunct, SNode context) {
		List<Equation> lustre = new ArrayList<>();
		for(SConstraint sconstraint : list) {
			lustre.add(sconstraint.getPropertyEquation(conjunct, context));
		}
		return lustre;
	}
	
	public static List<String> getProperties(List<SConstraint> list, SNode context) {
		List<String> lustre = new ArrayList<>();
		for(SConstraint sconstraint : list) {
			lustre.add(sconstraint.propertyName);
		}
		return lustre;
	}
	
	private Constraint constraint;
	public String name;
	public String propertyName;
	
	private static final String PROPERTY_SUFFIX = "_property";

	public SConstraint(Constraint c, SNode context) {
		this.constraint = c;
		this.name = context.scope.getUniqueNameAndRegister(c.getName());
		this.propertyName = context.scope.getUniqueNameAndRegister(c.getName() + PROPERTY_SUFFIX);
	}
	
	public VarDecl getVarDecl(SNode context) {
		return new VarDecl(name,NamedType.BOOL);
	}
	
	public Equation getEquation(SNode context) {
		IdExpr ie = new IdExpr(name);
		if (constraint instanceof FormalConstraint) {
			FormalConstraint fc = (FormalConstraint) constraint;
			return LustreUtil.eq(ie, TranslateExpr.translate(fc.getExpr(), context));
		}
		return LustreUtil.eq(new IdExpr(name), new BoolExpr(true));
	}
	
	public VarDecl getPropertyVarDecl(SNode context) {
		return new VarDecl(this.propertyName,NamedType.BOOL);
	}
	
	public Equation getPropertyEquation(jkind.lustre.Expr conjunct, SNode context) {
		IdExpr lhs = new IdExpr(this.propertyName);
		BinaryExpr rhs = new BinaryExpr(conjunct, BinaryOp.ARROW, new IdExpr(this.name));
		return LustreUtil.eq(lhs, rhs);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
