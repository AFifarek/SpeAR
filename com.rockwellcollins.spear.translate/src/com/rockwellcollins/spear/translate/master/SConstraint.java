package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.translate.naming.NameMap;
import com.rockwellcollins.spear.util.SpearSwitch;

public class SConstraint {

	public static List<SConstraint> build(List<Constraint> list, NameMap map) {
		List<SConstraint> built = new ArrayList<>();
		for(Constraint c : list) {
			built.add(SConstraint.build(c, map));
		}
		return built;
	}
	
	public static SConstraint build(Constraint c, NameMap map) {
		SConstraintBuilder builder = new SConstraintBuilder(map);
		return builder.doSwitch(c);
	}
	
	public String name;
	
	private static class SConstraintBuilder extends SpearSwitch<SConstraint> {
		
		private NameMap map;
		
		private SConstraintBuilder(NameMap map) {
			this.map=map;
		}
		
		@Override
		public SConstraint caseFormalConstraint(FormalConstraint fc) {
			return SFormalConstraint.build(fc, map);
		}
		
		@Override
		public SConstraint defaultCase(EObject o) {
			throw new RuntimeException("Expected a File object, received: " + o.toString());
		}
	}
}
