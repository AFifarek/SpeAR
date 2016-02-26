package com.rockwellcollins.spear.translate.master;

import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.util.SpearSwitch;

public class STypeDef {

	public String name;
	
	private static class STypeDefBuilder extends SpearSwitch<STypeDef> {
		
		private SProgram context;
		
		private STypeDefBuilder(SProgram context) {
			this.context=context;
		}
		
		@Override
		public STypeDef caseNamedTypeDef(NamedTypeDef ntd) {
			return new SNamedTypeDef(ntd,context);
		}
	}
}
