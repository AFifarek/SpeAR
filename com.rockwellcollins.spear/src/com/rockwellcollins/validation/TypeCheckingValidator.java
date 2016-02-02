package com.rockwellcollins.validation;

import org.eclipse.xtext.validation.Check;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.typing.SpearType;
import com.rockwellcollins.spear.typing.SpearTypeChecker;
import com.rockwellcollins.spear.units.UnitChecker;

public class TypeCheckingValidator extends AbstractSpearJavaValidator {
	
	/***********************************************************************************************/
	//Type Checking
	/***********************************************************************************************/
	@Check
	public void typeCheckNamedTypeDef(NamedTypeDef nt) {
		SpearTypeChecker tc = new SpearTypeChecker(getMessageAcceptor());
		SpearType type = tc.checkNamedType(nt);
		if(type != SpearTypeChecker.ERROR) {
			new UnitChecker(getMessageAcceptor()).checkNamedTypeDef(nt);			
		}
	}
	
	@Check
	public void typeCheckConstant(Constant c) {
		SpearTypeChecker tc = new SpearTypeChecker(getMessageAcceptor());
		if(tc.checkConstant(c)) {
			new UnitChecker(getMessageAcceptor()).checkConstant(c);	
		}
	}
	
	@Check
	public void typeCheckMacro(Macro m) {
		SpearTypeChecker tc = new SpearTypeChecker(getMessageAcceptor());
		if(tc.checkMacro(m)) {
			new UnitChecker(getMessageAcceptor()).checkMacro(m);	
		}
	}
	
	@Check
	public void typeCheckFormalConstraint(FormalConstraint fc) {
		SpearTypeChecker tc = new SpearTypeChecker(getMessageAcceptor());
		if(tc.checkFormalConstraint(fc)) {
			new UnitChecker(getMessageAcceptor()).checkFormalConstraint(fc);			
		}
	}
}
