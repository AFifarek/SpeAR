package com.rockwellcollins.spear.translate.lustre;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.master.SCall;
import com.rockwellcollins.spear.translate.master.SDefinitions;
import com.rockwellcollins.spear.translate.master.SFile;
import com.rockwellcollins.spear.translate.master.SProgram;
import com.rockwellcollins.spear.translate.master.SSpecification;
import com.rockwellcollins.spear.translate.master.Utilities;
import com.rockwellcollins.spear.translate.naming.NameMap;
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
import jkind.lustre.TupleExpr;
import jkind.lustre.UnaryExpr;
import jkind.lustre.UnaryOp;
import jkind.lustre.VarDecl;

public class TranslateExpr extends SpearSwitch<Expr> {

	public static Expr translate(com.rockwellcollins.spear.Expr e, NameMap map) {
		return new TranslateExpr(map).doSwitch(e);
	}

	private NameMap map;

	public TranslateExpr(NameMap map) {
		this.map=map;
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
		String id = map.lookup(ide.getId());
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
		return new RecordExpr(map.lookup(re.getType()),fields);
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
	public Expr caseNormalizedCall(com.rockwellcollins.spear.NormalizedCall nc) {
		
		SSpecification callingSpec = (SSpecification) map.mapping.get(Utilities.getRoot(nc));
		
		List<Expr> args = new ArrayList<>();
		for(com.rockwellcollins.spear.Expr e : nc.getArgs()) {
			args.add(this.doSwitch(e));
		}
		
		SCall call = callingSpec.calls.get(nc);
		for(VarDecl vd : call.getShadowVariablesForCall(map)) {
			args.add(new IdExpr(vd.id));
		}
		
		Expr RHS = new NodeCallExpr(call.called.name,args);
		List<Expr> tuplelist = new ArrayList<>();
		for(IdRef ref : nc.getIds()) {
			tuplelist.add(this.doSwitch(ref));
		}
		
		if(tuplelist.size() == 1) {
			return new BinaryExpr(tuplelist.get(0), BinaryOp.EQUAL, RHS);
		} else {
			return new BinaryExpr(new TupleExpr(tuplelist), BinaryOp.EQUAL, RHS);
		}

		//		SNode node_context = (SNode) context;
//		SNode called = node_context.calls.get(nc);
//		List<Expr> nodeCallArgs = new ArrayList<>();
//		for(com.rockwellcollins.spear.Expr arg : nc.getArgs()) {
//			nodeCallArgs.add(this.doSwitch(arg));
//		}
//		
//		List<SAddArg> directArgs = node_context.directCalledArgs.get(nc);
//		List<Expr> directArgExpressions = SAddArg.getArgExpressions(directArgs);
//		
//		List<SAddArg> indirectArgs = node_context.indirectCalledArgs.get(nc);
//		List<Expr> indirectArgExpressions = SAddArg.getArgExpressions(indirectArgs);
//		
//
//		nodeCallArgs.addAll(directArgExpressions);
//		nodeCallArgs.addAll(indirectArgExpressions);
//		Expr RHS = new NodeCallExpr(called.name, nodeCallArgs);
//		
//		List<Expr> tupleList = new ArrayList<>();
//		for(IdRef ref : nc.getIds()) {
//			tupleList.add(this.doSwitch(ref));
//		}
//
//		if(tupleList.size() == 1) {
//			return new BinaryExpr(tupleList.get(0), BinaryOp.EQUAL, RHS);
//		} else {
//			return new BinaryExpr(new TupleExpr(tupleList), BinaryOp.EQUAL, RHS);				
//		}
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
	public Expr caseVariable(Variable v) {
		return new IdExpr(map.lookup(v));
	}
	
	@Override
	public Expr caseMacro(Macro m) {
		return new IdExpr(map.lookup(m));
	}
	
	@Override
	public Expr caseConstant(Constant c) {
		return new IdExpr(map.lookup(c));
	}
	
	@Override
	public Expr caseEnumValue(EnumValue ev) {
		return new IdExpr(map.lookup(ev));
	}
	
	@Override
	public Expr defaultCase(EObject o) {
		throw new RuntimeException("Unexpected element provided: " + o.toString());
	}
}
