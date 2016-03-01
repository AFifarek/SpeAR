package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.EnglishConstraint;
import com.rockwellcollins.spear.translate.naming.NameMap;

public class SEnglishConstraint extends SConstraint {

	public String text;
	
	public SEnglishConstraint(EnglishConstraint ec, NameMap map) {
		this.name = map.getName(ec);
		this.text = ec.getText();
	}
}
