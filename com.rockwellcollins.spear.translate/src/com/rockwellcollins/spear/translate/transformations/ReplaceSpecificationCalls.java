package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.MIdExpr;
import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.SpecificationCall;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ReplaceSpecificationCalls extends SpearSwitch<EObject> {

	public static void replace(SpearDocument p) {
		p.mapFiles(ReplaceSpecificationCalls::replace);
	}
	
	private static File replace(File f) {
		File updated = (File) new ReplaceSpecificationCalls().doSwitch(f);
		return updated;
	}
	
	@Override
	public Expr caseBinaryExpr(BinaryExpr be) {
		Expr left = (Expr) this.doSwitch(be.getLeft());
		Expr right = (Expr) this.doSwitch(be.getRight());
		
		if (right instanceof SpecificationCall) {
			SpecificationCall specificationCall = (SpecificationCall) right;
			this.doSwitch(specificationCall.getSpec());
			
			NormalizedCall replacement = f.createNormalizedCall();
			replacement.setSpec(specificationCall.getSpec());
			replacement.getArgs().addAll(specificationCall.getArgs());
			
			if (left instanceof MIdExpr) {
				MIdExpr multipleIdExpr = (MIdExpr) left;
				replacement.getIds().addAll(multipleIdExpr.getIds());
				EcoreUtil2.replace(be, replacement);
				return replacement;
			}
			
			if (left instanceof IdExpr) {
				IdExpr idExpr = (IdExpr) left;
				replacement.getIds().add(idExpr.getId());
				EcoreUtil2.replace(be, replacement);
				return replacement;
			}
			
			throw new RuntimeException("Unexpected pairing of SpecificationCall and IdExprs: " + be.toString());
		}
		return be;
	}
	
	@Override
	public EObject defaultCase(EObject o) {
		for(EObject sub : o.eContents()) {
			this.doSwitch(sub);
		}
		return o;
	}
	
	SpearFactory f = SpearFactory.eINSTANCE;
}
