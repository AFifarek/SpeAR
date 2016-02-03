package com.rockwellcollins.validation;

import org.eclipse.xtext.validation.Check;

import com.rockwellcollins.spear.PatternCall;
import com.rockwellcollins.spear.SpecificationCall;

/**
 * This class will create validations that highlight anything that is unsupported.
 * @author lgwagner
 *
 */
public class UnsupportedValidations extends AbstractSpearJavaValidator {

	@Check
	public void flagPatternCalls(PatternCall pc) {
		warning("Pattern calls are not yet supported for analysis.", pc, null);
	}
	
	@Check
	public void flagSpecificationCall(SpecificationCall sc) {
		warning("Specification calls are not yet supported for analysis.", sc, null);
	}
}
