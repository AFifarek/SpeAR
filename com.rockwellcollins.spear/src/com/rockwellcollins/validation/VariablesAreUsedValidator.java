package com.rockwellcollins.validation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.Variable;

public class VariablesAreUsedValidator extends AbstractSpearJavaValidator {
	
	@Check
	public void checkSpecificationVariables(Specification s) {
		Set<String> set = new HashSet<>();
		for(IdExpr ide : EcoreUtil2.getAllContentsOfType(s, IdExpr.class)) {
			set.add(ide.getId().getName());
		}
		
		for(Constant c : s.getConstants()) {
			if(!set.contains(c.getName())) {
				warning("Constant " + c.getName() + " is defined, but never referenced.",c,SpearPackage.Literals.ID_REF__NAME);
			}
		}
		
		for(Macro m : s.getMacros()) {
			if(!set.contains(m.getName())) {
				warning("Macro " + m.getName() + " is defined, but never referenced.",m,SpearPackage.Literals.ID_REF__NAME);
			}
		}
		
		for(Variable v : s.getInputs()) {
			if(!set.contains(v.getName())) {
				warning("Input " + v.getName() + " is defined, but never referenced.",v,SpearPackage.Literals.ID_REF__NAME);
			}
		}
		
		for(Variable v : s.getOutputs()) {
			if(!set.contains(v.getName())) {
				warning("Input " + v.getName() + " is defined, but never referenced.",v,SpearPackage.Literals.ID_REF__NAME);
			}
		}
		
		for(Variable v : s.getState()) {
			if(!set.contains(v.getName())) {
				warning("Input " + v.getName() + " is defined, but never referenced.",v,SpearPackage.Literals.ID_REF__NAME);
			}
		}
	}
	
	@Check
	public void checkSpecificationTypes(Specification s) {
		
	}

}
