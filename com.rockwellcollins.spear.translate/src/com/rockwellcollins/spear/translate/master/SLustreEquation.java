package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.LustreEquation;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.lustre.TranslateExpr;
import com.rockwellcollins.spear.translate.naming.NameMap;
import com.rockwellcollins.spear.utilities.Utilities;

import jkind.lustre.Equation;
import jkind.lustre.IdExpr;

public class SLustreEquation {

	public static List<SLustreEquation> build(List<LustreEquation> list, NameMap map) {
		List<SLustreEquation> built = new ArrayList<>();
		for(LustreEquation eq : list) {
			built.add(SLustreEquation.build(eq, map));
		}
		return built;
	}
	
	public static List<jkind.lustre.Equation> toLustre(List<SLustreEquation> list, NameMap map) {
		List<jkind.lustre.Equation> equations = new ArrayList<>();
		for(SLustreEquation seq : list) {
			equations.add(seq.toLustre(map));
		}
		return equations;
	}
	
	public static SLustreEquation build(LustreEquation eq, NameMap map) {
		return new SLustreEquation(eq,map);
	}
	
	public List<String> ids = new ArrayList<>();
	public Expr expression;

	public SLustreEquation(LustreEquation eq, NameMap map) {
		Pattern p = (Pattern) Utilities.getTopContainer(eq);
		for(Variable v : eq.getIds()) {
			this.ids.add(map.lookup(p, v.getName()));
		}
		this.expression = eq.getRhs();
	}
	
	public Equation toLustre(NameMap map) {
		List<IdExpr> lhs = new ArrayList<>();
		for(String id : ids) {
			lhs.add(new IdExpr(id));
		}
		jkind.lustre.Expr rhs = TranslateExpr.translate(expression, map);
		return new Equation(lhs,rhs);
	}
}