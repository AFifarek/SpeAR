package com.rockwellcollins.spear.utilities;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.BoolLiteral;
import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.IntLiteral;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.RealLiteral;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ConstantChecker extends SpearSwitch<Boolean> {

	public static Boolean isConstant(Constant c) {
		return isConstant(c.getExpr());
	}
	
	public static Boolean isConstant(Expr e) {
		ConstantChecker cc = new ConstantChecker();
		return cc.doSwitch(e);
	}
	
	@Override
	public Boolean caseRealLiteral(RealLiteral e) {
		return true;
	}
	
	@Override
	public Boolean caseIntLiteral(IntLiteral e) {
		return true;
	}
	
	@Override
	public Boolean caseBoolLiteral(BoolLiteral e) {
		return true;
	}
	
	@Override
	public Boolean caseIdExpr(IdExpr e) {
		if (e.getId() instanceof Constant || e.getId() instanceof EnumValue) {
			return true;
		}
		
		if (e.getId() instanceof Macro) {
			Macro macro = (Macro) e.getId();
			return doSwitch(macro);
		}
		
		// variable is the last case
		return false;
	}
	
	@Override
	public Boolean caseExpr(Expr e) {
		for(EObject sub : e.eContents()) {
			Boolean subIsConstant = doSwitch(sub);
			if(!subIsConstant) {
				return false;
			}
		}
		return true;
	}
}
