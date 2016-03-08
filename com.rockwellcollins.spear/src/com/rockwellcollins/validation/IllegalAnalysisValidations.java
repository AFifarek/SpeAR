package com.rockwellcollins.validation;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;

import com.rockwellcollins.spear.CallToSpec;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.PatternCall;

/**
 * This class will create validations that highlight anything that is unsupported.
 * @author lgwagner
 *
 */
public class IllegalAnalysisValidations extends AbstractSpearJavaValidator {

	@Check
	public void flagPatternCalls(PatternCall pc) {
		warning("Pattern calls are not yet supported for analysis.", pc, null);
	}
	
	@Check
	public void flagIllegalExpressionsInPatterns(Pattern p) {
		for(CallToSpec call : EcoreUtil2.getAllContentsOfType(p, CallToSpec.class)) {
			error("Specification calls are unsupported inside of patterns.", call, null);
		}
		
		for(PatternCall call : EcoreUtil2.getAllContentsOfType(p, PatternCall.class)) {
			error("Pattern calls are unsupported inside of patterns.", call, null);
		}
	}
}
