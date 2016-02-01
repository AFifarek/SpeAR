package com.rockwellcollins.spear.translate.lustre;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.PatternCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.SpecificationCall;
import com.rockwellcollins.spear.util.SpearSwitch;

public class CheckForUnsupported extends SpearSwitch<Void> {

	public static boolean check(Specification s) {
		CheckForUnsupported check = new CheckForUnsupported();
		check.doSwitch(s);
		return check.unsupported;
	}
	
	public boolean unsupported = false;

	@Override
	public Void caseSpecification(Specification s) {
		for(SpecificationCall call : EcoreUtil2.getAllContentsOfType(s, SpecificationCall.class)) {
			unsupported = true;
		}
		
		for(PatternCall call : EcoreUtil2.getAllContentsOfType(s, PatternCall.class)) {
			unsupported = true;
		}
		return null;
	}
}
