package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Type;

public class SMacro {

	public static List<SMacro> build(List<Macro> list, SSpecification context) {
		List<SMacro> built = new ArrayList<>();
		for(Macro m : list) {
			built.add(SMacro.build(m, context));
		}
		return built;
	}
	
	public static SMacro build(Macro m, SSpecification context) {
		return new SMacro(m,context);
	}
	
	public String name;
	public Type type;
	public Expr expression;
	
	public SMacro(Macro m, SSpecification context) {
		this.name=context.scope.getName(m.getName());
		this.type=m.getType();
		this.expression=m.getExpr();
	}
}
