package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;

public class SFormalConstraint extends SConstraint {
	
	public static SFormalConstraint build(FormalConstraint fc, SSpecification context) {
		return new SFormalConstraint(fc,context);
	}
	
	public Expr expression;
	
	public SFormalConstraint(FormalConstraint fc, SSpecification context) {
		this.name = context.scope.getName(fc.getName());
		this.expression = fc.getExpr();
	}

}
