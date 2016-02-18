package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.lustre.TranslateType;

import jkind.lustre.Equation;
import jkind.lustre.IdExpr;
import jkind.lustre.LustreUtil;
import jkind.lustre.VarDecl;

public class SVariable extends SAst {

	public static List<SVariable> convertList(List<Variable> list, SNode context) {
		List<SVariable> converted = new ArrayList<>();
		for(Variable v : list) {
			converted.add(new SVariable(v,context));
		}
		return converted;
	}

	public static List<VarDecl> toVarDecl(List<SVariable> list, SNode context) {
		List<VarDecl> lustre = new ArrayList<>();
		for(SVariable svar : list) {
			lustre.add(svar.toVarDecl(context));
		}
		return lustre;
	}
	
	public static List<VarDecl> toShadowVarDecl(List<SVariable> list, SNode context) {
		List<VarDecl> lustre = new ArrayList<>();
		for(SVariable svar : list) {
			lustre.add(svar.toShadowVarDecl(context));
		}
		return lustre;
	}
	
	public static List<Equation> assignVarToShadowVars(List<SVariable> list, SNode context) {
		List<Equation> lustre = new ArrayList<>();
		for(SVariable svar : list) {
			lustre.add(svar.assignVarToShadowVar(context));
		}
		return lustre;
	}
	
	private static final String SHADOW_SUFFIX = "_SHADOW";
	public String name;
	private String shadowName;
	private Variable variable;
	
	public SVariable(Variable v, SNode context) {
		this.name = context.scope.getUniqueNameAndRegister(v.getName());
		this.shadowName = context.scope.getUniqueNameAndRegister(v.getName() + SHADOW_SUFFIX);
		this.variable = v;
	}
	
	public VarDecl toVarDecl(SNode context) {
		return new VarDecl(name,TranslateType.translate(variable.getType(), context));
	}
	
	public VarDecl toShadowVarDecl(SNode context) {
		return new VarDecl(shadowName,TranslateType.translate(variable.getType(), context));
	}
	
	public Equation assignVarToShadowVar(SNode context) {
		IdExpr LHS = new IdExpr(this.name);
		IdExpr RHS = new IdExpr(this.shadowName);
		return LustreUtil.eq(LHS, RHS);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
