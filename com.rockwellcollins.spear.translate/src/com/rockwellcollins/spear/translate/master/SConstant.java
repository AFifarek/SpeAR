package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Type;

public class SConstant {
	
	public static SConstant build(Constant c, SProgram context) {
		return new SConstant(c,context);
	}
	
	public static List<SConstant> build(List<Constant> list, SProgram context) {
		List<SConstant> built = new ArrayList<>();
		for(Constant c : list) {
			built.add(SConstant.build(c, context));
		}
		return built;
	}
	
	public String name;
	public Type type;
	public Expr expr;
	
	public SConstant(Constant constant, SProgram context) {
		File root = Utilities.getRoot(constant);
		this.name=context.scope.getFileBasedName(root.getName(), constant.getName());
		this.type=constant.getType();
		this.expr=constant.getExpr();
	}
}
