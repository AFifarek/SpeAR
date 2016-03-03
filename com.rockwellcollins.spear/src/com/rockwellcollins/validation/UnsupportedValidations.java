package com.rockwellcollins.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;

import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.PatternCall;
import com.rockwellcollins.spear.SpearPackage;
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
	public void flagTotalSpecificationCall(NormalizedCall nc) {
		error("Total Specification Calls are unsupported when written by the user.", nc, null);
	}
	
	@Check
	public void flagSpecificationCallsWithinMacros(Macro m) {
		List<SpecificationCall> calls = EcoreUtil2.getAllContentsOfType(m, SpecificationCall.class);
		for(SpecificationCall call : calls) {
			error("Specification calls cannot occur inside of Macros.", call, null);
		}
	}
	
	@Check
	public void flagSpecificationCall(SpecificationCall call) {
		EObject container = call.eContainer();
		
		if(container instanceof Macro) {
			return;
		}
		
		if (container instanceof BinaryExpr) {
			BinaryExpr be = (BinaryExpr) container;
			EObject beContainer = be.eContainer();
			
			if(beContainer instanceof Expr) {
				error("Specification calls may not be embedded within expressions.", call, null);
			}
			
			Set<String> ops = new HashSet<>();
			ops.add("==");
			ops.add("equal to");
			ops.add("is equal to");
			
			if(!ops.contains(be.getOp())) {
				error("Specification calls may only be used to equate call results to local specification variables.", be, SpearPackage.Literals.BINARY_EXPR__OP);
			}
		} else {
			error("Specification calls must immediately equate results to variables.", call, null);			
		}
	}
}
