package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.translate.naming.NameMap;

public class SFormalConstraint extends SConstraint {
	
	public static SFormalConstraint build(FormalConstraint fc, NameMap map) {
		return new SFormalConstraint(fc,map);
	}
	
	public Expr expression;
	
	public SFormalConstraint(FormalConstraint fc, NameMap map) {
		this.name = map.getName(fc);
		this.expression = fc.getExpr();
	}

}
