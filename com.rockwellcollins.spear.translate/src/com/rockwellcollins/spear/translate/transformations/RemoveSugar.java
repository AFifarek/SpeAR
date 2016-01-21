package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.AfterUntilExpr;
import com.rockwellcollins.spear.IfThenElseExpr;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.WhileExpr;
import com.rockwellcollins.spear.language.CreateExpr;
import com.rockwellcollins.spear.util.SpearSwitch;

public class RemoveSugar extends SpearSwitch<Void> {
	
	public static Specification transform(Specification s) {
		
		//remove after/until expressions
		for(AfterUntilExpr afe : EcoreUtil2.getAllContentsOfType(s, AfterUntilExpr.class)) {
			if(afe.getUntil() != null) {
				EcoreUtil2.replace(afe,CreateExpr.createTriggers(afe.getAfter(), CreateExpr.createNot(afe.getUntil())));
			} else {
				EcoreUtil2.replace(afe,CreateExpr.createOnce(afe.getAfter()));
			}
		}
		
		//remove before expressions
		//remove never
		for(UnaryExpr ue : EcoreUtil2.getAllContentsOfType(s, UnaryExpr.class)) {
			if(ue.getOp().equals("before")) {
				EcoreUtil2.replace(ue, CreateExpr.createNot(CreateExpr.createOnce(ue.getExpr())));
			}
			
			if(ue.getOp().equals("never")) {
				EcoreUtil2.replace(ue, CreateExpr.createHistorically(CreateExpr.createNot(ue.getExpr())));
			}
		}

		//remove while
		for(WhileExpr wh : EcoreUtil2.getAllContentsOfType(s, WhileExpr.class)) {
			EcoreUtil2.replace(wh, CreateExpr.createImplication(wh.getCond(), wh.getThen()));
		}
		
		//remove optional ite
		for(IfThenElseExpr ite : EcoreUtil2.getAllContentsOfType(s, IfThenElseExpr.class)) {
			if(ite.getElse() == null) {
				EcoreUtil2.replace(ite, CreateExpr.createImplication(ite.getCond(), ite.getThen()));
			}
		}
		
		return s;
	}

}
