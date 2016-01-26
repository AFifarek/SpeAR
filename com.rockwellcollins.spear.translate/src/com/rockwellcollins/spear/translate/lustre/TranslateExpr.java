package com.rockwellcollins.spear.translate.lustre;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.ArrayAccessExpr;
import jkind.lustre.ArrayExpr;
import jkind.lustre.ArrayUpdateExpr;
import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.BoolExpr;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.IfThenElseExpr;
import jkind.lustre.IntExpr;
import jkind.lustre.RealExpr;
import jkind.lustre.RecordExpr;
import jkind.lustre.UnaryExpr;
import jkind.lustre.UnaryOp;

public class TranslateExpr extends SpearSwitch<Expr> {

	public static Expr translate(com.rockwellcollins.spear.Expr e) {
		return new TranslateExpr().doSwitch(e);
	}
	
	@Override
	public Expr caseArrayAccessExpr(com.rockwellcollins.spear.ArrayAccessExpr aae) {
		return new ArrayAccessExpr(doSwitch(aae.getArray()), doSwitch(aae.getIndex()));
	}
	
	@Override
	public Expr caseArrayUpdateExpr(com.rockwellcollins.spear.ArrayUpdateExpr aue) {
		return new ArrayUpdateExpr(doSwitch(aue.getAccess().getArray()),doSwitch(aue.getAccess().getIndex()),doSwitch(aue.getValue()));
	}
	
	@Override
	public Expr caseIdExpr(com.rockwellcollins.spear.IdExpr ide) {
		return new IdExpr(ide.getId().getName());
	}
	
	@Override
	public Expr casePreviousExpr(com.rockwellcollins.spear.PreviousExpr prev) {
		return new BinaryExpr(doSwitch(prev.getInit()), BinaryOp.ARROW, new UnaryExpr(UnaryOp.PRE, doSwitch(prev.getVar())));
	}
	
	@Override
	public Expr caseIfThenElseExpr(com.rockwellcollins.spear.IfThenElseExpr ite) {
		return new IfThenElseExpr(doSwitch(ite.getCond()), doSwitch(ite.getThen()), doSwitch(ite.getElse()));
	}

	@Override
	public Expr caseRecordExpr(com.rockwellcollins.spear.RecordExpr re) {
		Map<String,Expr> fields = new LinkedHashMap<>();
		for(com.rockwellcollins.spear.RecordFieldExpr rfe : re.getFieldExprs()) {
			fields.put(rfe.getName(), doSwitch(rfe.getExpr()));
		}
		return new RecordExpr(re.getType().getName(),fields);
	}
	
	@Override
	public Expr caseArrayExpr(com.rockwellcollins.spear.ArrayExpr ae) {
		List<Expr> list = new ArrayList<>();
		for(com.rockwellcollins.spear.Expr expr : ae.getExprs()) {
			list.add(doSwitch(expr));
		}
		return new ArrayExpr(list);
	}
	
	@Override
	public Expr caseBoolLiteral(com.rockwellcollins.spear.BoolLiteral bl) {
		switch(bl.getValue()) {
			case "TRUE":
			case "true":
				return new BoolExpr(true);
				
			case "FALSE":
			case "false":
				return new BoolExpr(false);
				
			default:
				throw new RuntimeException("Unexpected boolean literal encountered.");
		
		}
	}

	@Override
	public Expr caseIntLiteral(com.rockwellcollins.spear.IntLiteral il) {
		return new IntExpr(il.getValue());
	}
	
	@Override
	public Expr caseRealLiteral(com.rockwellcollins.spear.RealLiteral rl) {
		return new RealExpr(new BigDecimal(rl.getValue()));
	}	
	
	@Override
	public Expr caseExpr(com.rockwellcollins.spear.Expr e) {
		throw new RuntimeException("Expr is not handled.");
	}
	
	@Override
	public Expr defaultCase(EObject o) {
		throw new RuntimeException("Unexpected element provided.");
	}
}
