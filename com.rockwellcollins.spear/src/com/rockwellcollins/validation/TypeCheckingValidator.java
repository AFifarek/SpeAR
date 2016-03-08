package com.rockwellcollins.validation;

import org.eclipse.xtext.validation.Check;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.typing.SpearType;
import com.rockwellcollins.spear.typing.SpearTypeChecker;
import com.rockwellcollins.spear.units.SpearUnitChecker;

public class TypeCheckingValidator extends AbstractSpearJavaValidator {
	
	/***********************************************************************************************/
	//Type Checking
	/***********************************************************************************************/
	@Check
	public void typeCheckNamedTypeDef(NamedTypeDef nt) {
		SpearTypeChecker tc = new SpearTypeChecker(getMessageAcceptor());
		SpearType type = tc.checkNamedType(nt);
		if(type != SpearTypeChecker.ERROR) {
			new SpearUnitChecker(getMessageAcceptor()).checkNamedTypeDef(nt);			
		}
	}
	
	@Check
	public void typeCheckConstant(Constant c) {
		SpearTypeChecker tc = new SpearTypeChecker(getMessageAcceptor());
		if(tc.checkConstant(c)) {
			new SpearUnitChecker(getMessageAcceptor()).checkConstant(c);	
		}
	}
	
	@Check
	public void typeCheckMacro(Macro m) {
		SpearTypeChecker tc = new SpearTypeChecker(getMessageAcceptor());
		if(tc.checkMacro(m)) {
			new SpearUnitChecker(getMessageAcceptor()).checkMacro(m);	
		}
	}
	
	@Check
	public void typeCheckFormalConstraint(FormalConstraint fc) {
		SpearTypeChecker tc = new SpearTypeChecker(getMessageAcceptor());
		boolean checkUnits = tc.checkFormalConstraint(fc);
		if(checkUnits) {
			new SpearUnitChecker(getMessageAcceptor()).checkFormalConstraint(fc);			
		}
	}
}
