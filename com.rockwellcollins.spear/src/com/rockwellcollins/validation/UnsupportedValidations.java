package com.rockwellcollins.validation;

import org.eclipse.xtext.validation.Check;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.PatternCall;

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
	public void flagTotalSpecificationCall(NormalizedCall nc) {
		error("Total Specification Calls are unsupported when written by the user.", nc, null);
	}
}
