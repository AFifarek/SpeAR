package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.EnglishConstraint;

public class SEnglishConstraint extends SConstraint {

	public String text;
	
	public SEnglishConstraint(EnglishConstraint ec, SSpecification context) {
		this.name = context.scope.getName(ec.getName());
		this.text = ec.getText();
	}
}
