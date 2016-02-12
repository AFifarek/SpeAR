package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.MIdExpr;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.SpecificationCall;
import com.rockwellcollins.spear.TotalSpecificationCall;

public class ReplaceSpecificationCalls {

	public static Specification replace(Specification s) {
		SpearFactory f = SpearFactory.eINSTANCE;

		for(BinaryExpr be : EcoreUtil2.getAllContentsOfType(s, BinaryExpr.class)) {
			//we don't worry about the operator because we have a validator that flags anythign but equals
			if(be.getLeft() instanceof MIdExpr && be.getRight() instanceof SpecificationCall) {
				MIdExpr left = (MIdExpr) be.getLeft();
				SpecificationCall right = (SpecificationCall) be.getRight();
				
				TotalSpecificationCall replacement = f.createTotalSpecificationCall();
				for(IdRef ref : left.getIds()) {
					replacement.getIds().add(ref);
				}
				replacement.getIds().addAll(left.getIds());
				replacement.setSpec(right.getSpec());
				replacement.getArgs().addAll(right.getArgs());
				EcoreUtil2.replace(be, replacement);
			}
		}
		return s;
	}
}
