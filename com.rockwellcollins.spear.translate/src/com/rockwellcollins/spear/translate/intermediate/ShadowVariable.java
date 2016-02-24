package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.Equation;
import jkind.lustre.IdExpr;
import jkind.lustre.LustreUtil;
import jkind.lustre.VarDecl;

public class ShadowVariable {

	public static List<ShadowVariable> create(Collection<SVariable> list, SNode context) {
		List<ShadowVariable> created = new ArrayList<>();
		for(SVariable sv : list) {
			created.add(new ShadowVariable(sv,context));
		}
		return created;
	}
	
	public static List<VarDecl> getVarDecls(Collection<ShadowVariable> list, SNode context) {
		List<VarDecl> lustre = new ArrayList<>();
		for(ShadowVariable sv : list) {
			lustre.add(sv.getVarDecl(context));
		}
		return lustre;
	}
	
	public static List<Equation> getEquations(Collection<ShadowVariable> list, SNode context) {
		List<Equation> lustre = new ArrayList<>();
		for(ShadowVariable sv : list) {
			lustre.add(sv.getShadowEquation(context));
		}
		return lustre;
	}
	
	private static final String SHADOW_SUFFIX = "_SHADOW";
	
	public String name;
	public Type type;
	
	private String shadowedName;
	
	public ShadowVariable(SVariable v, SNode context) {
		this.shadowedName = v.name;
		this.type = v.variable.getType();
		String proposed = v.name + SHADOW_SUFFIX;
		this.name = context.scope.getUniqueLocalNameAndRegister(proposed);
	}
	
	public VarDecl getVarDecl(SNode context) {
		return new VarDecl(name,TranslateType.translate(type, context));
	}
	
	public Equation getShadowEquation(SNode context) {
		IdExpr LHS = new IdExpr(this.shadowedName);
		IdExpr RHS = new IdExpr(this.name);
		return LustreUtil.eq(LHS, RHS);
	}
}
