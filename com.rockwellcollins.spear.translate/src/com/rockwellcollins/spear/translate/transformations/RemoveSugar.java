package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.AfterUntilExpr;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.IfThenElseExpr;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.WhileExpr;
import com.rockwellcollins.spear.language.CreateExpr;
import com.rockwellcollins.spear.util.SpearSwitch;

public class RemoveSugar extends SpearSwitch<Void> {
	
	public static void transform(SpearDocument p) {
		for(File f : p.files) {
			transform(f);
		}
	}
	
	private static File transform(File f) {
		//remove after/until expressions
		for(AfterUntilExpr afe : EcoreUtil2.getAllContentsOfType(f, AfterUntilExpr.class)) {
			if(afe.getUntil() != null) {
				EcoreUtil2.replace(afe,CreateExpr.createTriggers(afe.getAfter(), CreateExpr.createNot(afe.getUntil())));
			} else {
				EcoreUtil2.replace(afe,CreateExpr.createOnce(afe.getAfter()));
			}
		}
		
		//remove before expressions
		//remove never
		for(UnaryExpr ue : EcoreUtil2.getAllContentsOfType(f, UnaryExpr.class)) {
			if(ue.getOp().equals("before")) {
				EcoreUtil2.replace(ue, CreateExpr.createNot(CreateExpr.createOnce(ue.getExpr())));
			}
			
			if(ue.getOp().equals("never")) {
				EcoreUtil2.replace(ue, CreateExpr.createHistorically(CreateExpr.createNot(ue.getExpr())));
			}
		}

		//remove while
		for(WhileExpr wh : EcoreUtil2.getAllContentsOfType(f, WhileExpr.class)) {
			EcoreUtil2.replace(wh, CreateExpr.createImplication(wh.getCond(), wh.getThen()));
		}
		
		//remove optional ite
		for(IfThenElseExpr ite : EcoreUtil2.getAllContentsOfType(f, IfThenElseExpr.class)) {
			if(ite.getElse() == null) {
				EcoreUtil2.replace(ite, CreateExpr.createImplication(ite.getCond(), ite.getThen()));
			}
		}
		
		return f;
	}

}
