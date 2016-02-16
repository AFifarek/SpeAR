package com.rockwellcollins.spear.translate.lustre;

import java.util.List;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.PatternCall;
import com.rockwellcollins.spear.Specification;

public class CheckForUnsupported {

	public static boolean check(Specification s) {
//		List<SpecificationCall> specificationCalls = EcoreUtil2.getAllContentsOfType(s, SpecificationCall.class);
		List<PatternCall> patternCalls = EcoreUtil2.getAllContentsOfType(s, PatternCall.class);
//		int unsupportedElements = specificationCalls.size() + patternCalls.size();
		int unsupportedElements = patternCalls.size();
		return (unsupportedElements > 0);
	}
}
