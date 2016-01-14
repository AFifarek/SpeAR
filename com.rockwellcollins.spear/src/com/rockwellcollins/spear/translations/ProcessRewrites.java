package com.rockwellcollins.spear.translations;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.SpearFactory;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ProcessRewrites extends SpearSwitch<Void> {
	SpearFactory factory = SpearFactory.eINSTANCE;

	@Override
	public Void caseUnaryExpr(UnaryExpr ue) {
		if(ue.getOp().equals("after")) {	
			UnaryExpr once = factory.createUnaryExpr();
			once.setOp("once");
			once.setExpr(ue.getExpr());
			EcoreUtil2.replace(ue, once);
		}
		
		if(ue.getOp().equals("before")) {
			UnaryExpr once = factory.createUnaryExpr();
			once.setOp("once");
			once.setExpr(ue.getExpr());
			UnaryExpr not = factory.createUnaryExpr();
			not.setOp("not");
			not.setExpr(once);
			EcoreUtil2.replace(ue, not);
		}
		
		return null;
	}
}
