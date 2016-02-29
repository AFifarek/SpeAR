package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.util.SpearSwitch;

public class SConstraint {

	public static List<SConstraint> build(List<Constraint> list, SSpecification context) {
		List<SConstraint> built = new ArrayList<>();
		for(Constraint c : list) {
			built.add(SConstraint.build(c, context));
		}
		return built;
	}
	
	public static SConstraint build(Constraint c, SSpecification context) {
		SConstraintBuilder builder = new SConstraintBuilder(context);
		return builder.doSwitch(c);
	}
	
	public String name;
	
	private static class SConstraintBuilder extends SpearSwitch<SConstraint> {
		
		private SSpecification context;
		
		private SConstraintBuilder(SSpecification context) {
			this.context=context;
		}
		
		@Override
		public SConstraint caseFormalConstraint(FormalConstraint fc) {
			return SFormalConstraint.build(fc, context);
		}
		
		@Override
		public SConstraint defaultCase(EObject o) {
			throw new RuntimeException("Expected a File object, received: " + o.toString());
		}
	}
}
