package com.rockwellcollins.spear.translate.lustre;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.translate.experimental.Manager;
import com.rockwellcollins.spear.typing.SpearType;
import com.rockwellcollins.spear.typing.SpearTypeChecker;
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
import jkind.lustre.NodeCallExpr;
import jkind.lustre.RealExpr;
import jkind.lustre.RecordAccessExpr;
import jkind.lustre.RecordExpr;
import jkind.lustre.RecordUpdateExpr;
import jkind.lustre.UnaryExpr;
import jkind.lustre.UnaryOp;

public class TranslateExpr extends SpearSwitch<Expr> {

	public static Expr translate(com.rockwellcollins.spear.Expr e, Manager naming) {
		return new TranslateExpr(naming).doSwitch(e);
	}

	private Manager naming;

	public TranslateExpr(Manager naming) {
		this.naming=naming;
	}
	
	@Override
	public Expr caseBinaryExpr(com.rockwellcollins.spear.BinaryExpr binary) {
		Expr left = doSwitch(binary.getLeft());
		Expr right = doSwitch(binary.getRight());
		
		switch (binary.getOp()) {
			case "and":
			case "or":
			case "xor":
			case ">":
			case ">=":
			case "<":
			case "<=":
			case "<>":
			case "+":
			case "-":
			case "*":
				BinaryOp op = BinaryOp.fromString(binary.getOp());
				return new BinaryExpr(left, op, right);

			case "/":
				SpearType leftType = SpearTypeChecker.typeCheck(binary.getLeft());
				if(leftType.equals(SpearTypeChecker.INT)) {
					return new BinaryExpr(left, BinaryOp.INT_DIVIDE, right);
				}
				return new BinaryExpr(left, BinaryOp.DIVIDE, right);
				
			case "implies":
				return new BinaryExpr(left, BinaryOp.IMPLIES, right);
				
			case "==":
				return new BinaryExpr(left, BinaryOp.EQUAL, right);
				
			/*
			 * Note: these are treated as reserved words in our translation. Conflicts are
			 * actively renamed by RemoveLustreKeywords.
			 */
			//TODO : evaluate whether the PLTL node is actually available, now we just assume
			case "since":
			case "triggers":
				List<Expr> args = new ArrayList<>();
				args.add(left);
				args.add(right);
				return new NodeCallExpr(binary.getOp(),args);
				
			default:
				throw new RuntimeException("Unsupported binary operator " + binary.getOp() + " provided.");
		}
	}
	
	@Override
	public Expr caseUnaryExpr(com.rockwellcollins.spear.UnaryExpr unary) {
		Expr sub = doSwitch(unary.getExpr());
		
		switch (unary.getOp()) {
			case "not":
			case "-":
				return new UnaryExpr(UnaryOp.fromString(unary.getOp()), sub);
	
			/*
			 * Note: these are treated as reserved words in our translation. Conflicts are
			 * actively renamed by RemoveLustreKeywords.
			 */
			//TODO : evaluate whether the PLTL node is actually available, now we just assume
			case "once":
			case "historically":
			case "initially":
				List<Expr> args = new ArrayList<>();
				args.add(sub);
				return new NodeCallExpr(unary.getOp(),args);
				
			default:
				throw new RuntimeException("Unsupported unary operator " + unary.getOp() + " provided.");
		}
	}
	
	@Override
	public Expr caseRecordAccessExpr(com.rockwellcollins.spear.RecordAccessExpr rae) {
		return new RecordAccessExpr(doSwitch(rae.getRecord()),rae.getField().getName());
	}
	
	@Override
	public Expr caseRecordUpdateExpr(com.rockwellcollins.spear.RecordUpdateExpr rue) {
		return new RecordUpdateExpr(doSwitch(rue.getRecord()),rue.getField().getName(),doSwitch(rue.getValue()));
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
		String id = naming.lookup(ide.getId().getName());
		if(id == null) {
			throw new RuntimeException("Mapping did not contain the referenced variable: " + ide.getId().getName());
		}
		return new IdExpr(id);
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
		for(com.rockwellcollins.spear.FieldExpr fe : re.getFieldExprs()) {
			fields.put(fe.getField().getName(), doSwitch(fe.getExpr()));
		}
		return new RecordExpr(naming.lookup(re.getType().getName()),fields);
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
	public Expr defaultCase(EObject o) {
		throw new RuntimeException("Unexpected element provided.");
	}
}
