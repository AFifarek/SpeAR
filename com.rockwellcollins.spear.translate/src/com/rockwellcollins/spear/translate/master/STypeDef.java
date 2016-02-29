package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.util.SpearSwitch;

public class STypeDef {

	public static List<STypeDef> build(List<TypeDef> list, SProgram context) {
		List<STypeDef> processed = new ArrayList<>();
		for(TypeDef td : list) {
			processed.add(STypeDef.build(td, context));
		}
		return processed;
	}
	
	public static STypeDef build(TypeDef td, SProgram context) {
		STypeDefBuilder builder = new STypeDefBuilder(context);
		return builder.doSwitch(td);
	}
	
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
