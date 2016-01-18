package com.rockwellcollins.ui.contentassist;

import com.rockwellcollins.spear.BaseUnit;
import com.rockwellcollins.spear.DerivedUnit;
import com.rockwellcollins.spear.EnglishConstraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.util.SpearSwitch;

/**
 * @author lgwagner
 *
 * This is called by the SpearDocumentationProvider.
 * 
 * Here is where you should define what string should be displayed for the 
 * documentation when the user hovers over text in a specification.
 * 
 */
public class SpearDescriptionFetcher extends SpearSwitch<String> {
	
	@Override
	public String caseBaseUnit(BaseUnit base) {
		if(base.getDescription() != null) {
			return base.getDescription();
		}
		return null;
	}
	
	@Override
	public String caseDerivedUnit(DerivedUnit derived) {
		if(derived.getDescription() != null) {
			return derived.getDescription();
		}
		return null;
	}
	
	@Override
	public String caseFormalConstraint(FormalConstraint fc) {
		return fc.getDescriptor();
	}
	
	@Override
	public String caseEnglishConstraint(EnglishConstraint ec) {
		return ec.getText();
	}


}
