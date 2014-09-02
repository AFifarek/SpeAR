package spear.translator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import org.eclipse.emf.ecore.EObject;

import spear.language.After;
import spear.language.ArrayAccessExpr;
import spear.language.ArrayExpr;
import spear.language.ArrayType;
import spear.language.Before;
import spear.language.Between;
import spear.language.BinaryExpr;
import spear.language.BinaryFormula;
import spear.language.BoolExpr;
import spear.language.Constant;
import spear.language.DomainExpr;
import spear.language.Enumerator;
import spear.language.ExistsExpr;
import spear.language.Exponentiation;
import spear.language.Expr;
import spear.language.ForallExpr;
import spear.language.QuantifiedVariable;
import spear.language.QuantificationExpr;
import spear.language.RecordAccessExpr;
import spear.language.RecordFieldExpr;
import spear.language.FnCallExpr;
import spear.language.Global;
import spear.language.IdExpr;
import spear.language.IfThenElseExpr;
import spear.language.Initial;
import spear.language.IntExpr;
import spear.language.KSUPattern;
import spear.language.Macro;
import spear.language.NamedFormula;
import spear.language.PreExpr;
import spear.language.RealExpr;
import spear.language.RecordExpr;
import spear.language.Scope;
import spear.language.SumExpr;
import spear.language.Type;
import spear.language.UnaryExpr;
import spear.language.UnaryFormula;
import spear.language.Utils;
import spear.language.Variable;
import spear.language.While;
import spear.language.util.LanguageSwitch;
import spear.validation.IntegerConstantSimplification;
import spear.validation.LanguageJavaValidator;
import spear.validation.TypeChecker;


/*
 * Convert all syntax components that are contained within the PatternProperty
 * to jkind expressions. Temporal operators and KSU patterns are 
 * converted to nodes.
 * 
 */
public class LustreExpressionTranslator extends
		LanguageSwitch<jkind.lustre.Expr> {
	private final LustreBinaryOperatorTranslator transbinop = new LustreBinaryOperatorTranslator();
	private final LustreUnaryOperatorTranslator transunop = new LustreUnaryOperatorTranslator();
	private LanguageJavaValidator validator;
	
	/*
	 * A set of locals that must be added to a calling procedure due to
	 * internal procedure invocations.
	 */
	public Map<String,jkind.lustre.Type> newlocals;
	
	public LustreExpressionTranslator() {
		newlocals = new HashMap<String,jkind.lustre.Type>();
	}

	@Override
	public jkind.lustre.Expr caseInitial(Initial i) {
		return makeCallExpr("initial", oneOperandToArg(i.getExpr()));
	}

	
	@Override
	public jkind.lustre.Expr caseNamedFormula(NamedFormula nf) {
		return doSwitch(nf.getSpec());
	}
	
	@Override
	public jkind.lustre.Expr caseKSUPattern(KSUPattern ksup) {
		List<jkind.lustre.Expr> args = new LinkedList<jkind.lustre.Expr>();
		Scope scope = ksup.getScope();
		if (scope instanceof Global) {
		} else if (scope instanceof Before) {
			Before before = (Before) scope;
			args.add(addPre(before.getExpr()));
		} else if (scope instanceof After) {
			After after = (After) scope;
			args.add(addPre(after.getExpr()));
			if (after.getUntilExpr() != null) {
                args.add(addPre(after.getUntilExpr()));
            }
		} else if (scope instanceof Between) {
			Between between = (Between) scope;
			args.add(addPre(between.getStart()));
			args.add(addPre(between.getEnd()));
		} else if (scope instanceof While) {
			While whl = (While) scope;
			args.add(addPre(whl.getExpr()));
		}

		if (ksup.getFormula() instanceof BinaryFormula) {
			BinaryFormula bf = (BinaryFormula) ksup.getFormula();
			args.add(addPre(bf.getLeft()));
			args.add(addPre(bf.getRight()));
		} else {
			UnaryFormula uf = (UnaryFormula) ksup.getFormula();
			args.add(addPre(uf.getExpr()));
		}
		return makeCallExpr(scopeToString(ksup), args);
	}

	private String scopeToString(KSUPattern ksup) {
		String scopestr;
		if (ksup.getScope() instanceof After) {
			After after = (After) ksup.getScope();
			String until = after.getUntilExpr() != null ? "_until" : "";
			scopestr = after.getScope() + until;
		} else {
			scopestr = ksup.getScope().getScope();
		}
		return scopestr + "_" + (ksup.getFormula().getOp()).getString();
	}
	
	private List<jkind.lustre.Expr> oneOperandToArg(Expr e) {
		List<jkind.lustre.Expr> args = new LinkedList<jkind.lustre.Expr>();
		args.add(doSwitch(e));
		return args;
	}

	private jkind.lustre.Expr makeCallExpr(String fn,
			List<jkind.lustre.Expr> args) {
		return new jkind.lustre.NodeCallExpr(fn, args);
	}

	
	@Override
	public jkind.lustre.Expr caseBinaryExpr(BinaryExpr be) {
		if(be.getOp() instanceof Exponentiation) {
			return new jkind.lustre.IntExpr(IntegerConstantSimplification.simplify(be));
		} else {
			return mkBinaryExpr(doSwitch(be.getLeft()),
					transbinop.doSwitch(be.getOp()), doSwitch(be.getRight()));
		}
	}

	@Override
	public jkind.lustre.Expr caseUnaryExpr(UnaryExpr ue) {
		return mkUnaryExpr(transunop.doSwitch(ue.getOp()),
				doSwitch(ue.getExpr()));
	}

	@Override
	public jkind.lustre.Expr casePreExpr(PreExpr pe) {
		return mkUnaryExpr(jkind.lustre.UnaryOp.PRE,
				doSwitch(pe.getExpr()));
	}

	@Override
	public jkind.lustre.Expr caseIdExpr(IdExpr id) {
		return doSwitch(id.getId());
	}

	@Override
	public jkind.lustre.Expr caseVariable(Variable v) {
		return new jkind.lustre.IdExpr(v.getName());
	}
	
	@Override
	public jkind.lustre.Expr caseQuantifiedVariable(QuantifiedVariable v) {
		return new jkind.lustre.IdExpr(v.getName());
	}

	@Override
	public jkind.lustre.Expr caseBoolExpr(BoolExpr b) {
		return new jkind.lustre.BoolExpr(Boolean.parseBoolean(b.getValue()));
	}

	@Override
	public jkind.lustre.Expr caseIntExpr(IntExpr i) {
		return new jkind.lustre.IntExpr(BigInteger.valueOf(i.getValue()));
	}

	@Override
	public jkind.lustre.Expr caseRealExpr(RealExpr r) {
		return new jkind.lustre.RealExpr(new BigDecimal(r.getValue()));
	}

	@Override
	public jkind.lustre.Expr caseMacro(Macro m) {
		return doSwitch(m.getExpr());
	}
	
	@Override
	public jkind.lustre.Expr caseConstant(Constant m) {
		return doSwitch(m.getExpr());
	}
	
	private HashMap<FnCallExpr,jkind.lustre.VarDecl> fvals;
	public void setFnCallExprMap(HashMap<FnCallExpr,jkind.lustre.VarDecl> fvals) {
		this.fvals = fvals;
	}
	
	@Override
	public jkind.lustre.Expr caseEnumerator(Enumerator e) {
		return new jkind.lustre.IdExpr(Utils.getFQN(e));
	}

	@Override 
	public jkind.lustre.Expr caseFnCallExpr(FnCallExpr fncall) {
		return new jkind.lustre.IdExpr(fvals.get(fncall).id);
	}


	private jkind.lustre.UnaryExpr mkUnaryExpr(jkind.lustre.UnaryOp op,
			jkind.lustre.Expr expr) {
		return new jkind.lustre.UnaryExpr(op,expr);
	}
	
	private jkind.lustre.BinaryExpr mkBinaryExpr(jkind.lustre.Expr lexpr, 
			jkind.lustre.BinaryOp op, jkind.lustre.Expr rexpr) {
		return new jkind.lustre.BinaryExpr(lexpr,op,rexpr);
	}

	@Override
	public jkind.lustre.Expr caseRecordExpr(RecordExpr object) {
		Map<String,jkind.lustre.Expr> map = new HashMap<String,jkind.lustre.Expr>();
		for(RecordFieldExpr rfe : object.getRecordFields()) {
			map.put(rfe.getField().getName(), doSwitch(rfe.getExpr()));
		}
		return new jkind.lustre.RecordExpr(Utils.getFQN(object.getType()), map);
	}

	@Override
	public jkind.lustre.Expr caseIfThenElseExpr(IfThenElseExpr object) {
		return new jkind.lustre.IfThenElseExpr(doSwitch(object.getIfExpr())
				, doSwitch(object.getThenExpr()), doSwitch(object.getElseExpr()));
	}
	


	private int preNestingDepth(EObject eo) {
		int depth = 0;
		
		List<PreExpr> presatdepth = Utils.getAllContentsOfType(eo, PreExpr.class);
		for ( PreExpr preexpr : presatdepth) {
			int tdepth = 1 + preNestingDepth(preexpr.getExpr());
			if(tdepth > depth) {
				depth = tdepth;
			}
		}
		return depth;
	}
	
	private jkind.lustre.Expr addPre(Expr nf) {
		int predepth = preNestingDepth(nf);
		if(predepth == 0) {
			return doSwitch(nf);
		} else {
			jkind.lustre.BoolExpr t = new jkind.lustre.BoolExpr(true);
			jkind.lustre.Expr newexpr = doSwitch(nf);
			newexpr = new jkind.lustre.BinaryExpr(t,jkind.lustre.BinaryOp.ARROW,newexpr);
			return newexpr;
		}
	}
	
	private jkind.lustre.Expr extensionalInterpretation(QuantificationExpr qr,jkind.lustre.BinaryOp op) {
		TypeChecker tc = new TypeChecker(validator);
		String name = qr.getVariable().getName();
		Type typ = TypeChecker.resolveNamedType(tc.getType(qr.getDomain()));
		jkind.lustre.Expr originalbody = doSwitch(qr.getExpr());
		jkind.lustre.Expr qvarreplacementexpr = null;
		jkind.lustre.Expr finalexpr = null;
		if(typ instanceof ArrayType && qr.getDomain() instanceof DomainExpr) {
			ArrayType at = (ArrayType) typ;
			jkind.lustre.Expr array = doSwitch(((DomainExpr)qr.getDomain()).getDomain());
			int len = IntegerConstantSimplification.simplify(at.getLength()).intValue();
			qvarreplacementexpr = new jkind.lustre.ArrayAccessExpr(array, 0);
			finalexpr = originalbody.accept(new QuantifiedVariableReplacementVisitor(name,qvarreplacementexpr));
			for(int i = 1; i<len; i++) {
				qvarreplacementexpr = new jkind.lustre.ArrayAccessExpr(array, i);
				finalexpr = new jkind.lustre.BinaryExpr(finalexpr,op,originalbody.accept(new QuantifiedVariableReplacementVisitor(name,qvarreplacementexpr)));
			}
		} else {
			Domain de = new Domain();
			List<jkind.lustre.Expr> values = de.doSwitch(typ);
			qvarreplacementexpr = values.get(0);
			finalexpr = originalbody.accept(new QuantifiedVariableReplacementVisitor(name,qvarreplacementexpr));
			for(int i = 1; i<values.size(); i++) {
				qvarreplacementexpr = values.get(i);
				finalexpr = new jkind.lustre.BinaryExpr(finalexpr,op,originalbody.accept(new QuantifiedVariableReplacementVisitor(name,qvarreplacementexpr)));
			}
		}
		return finalexpr;
	}


	@Override
	public jkind.lustre.Expr caseForallExpr(ForallExpr o) {
		jkind.lustre.Expr e = extensionalInterpretation(o,jkind.lustre.BinaryOp.AND);
		return e;
	}

	@Override
	public jkind.lustre.Expr caseExistsExpr(ExistsExpr o) {
		return extensionalInterpretation(o,jkind.lustre.BinaryOp.OR);
	}

	@Override
	public jkind.lustre.Expr caseSumExpr(SumExpr o) {
		return extensionalInterpretation(o,jkind.lustre.BinaryOp.PLUS);
	}

	
	@Override
	public jkind.lustre.Expr caseArrayExpr(ArrayExpr o) {
		List<jkind.lustre.Expr> exprs = new LinkedList<>();
		for(Expr e : o.getExprs()) {
			exprs.add(doSwitch(e));
		}
		return new jkind.lustre.ArrayExpr(exprs);
	}

	@Override
	public jkind.lustre.Expr caseRecordAccessExpr(RecordAccessExpr o) {
			if(o.getExpr()==null) {
				return new jkind.lustre.RecordAccessExpr(doSwitch(o.getRecord()), o.getField().getName());
			} else {
				return new jkind.lustre.RecordUpdateExpr(doSwitch(o.getRecord()), o.getField().getName(),doSwitch(o.getExpr()));
			}
	}

	@Override
	public jkind.lustre.Expr caseArrayAccessExpr(ArrayAccessExpr o) {
		if(o.getExpr()==null) {
			return new jkind.lustre.ArrayAccessExpr(doSwitch(o.getArray()), doSwitch(o.getIndex()));
		} else {
			return new jkind.lustre.ArrayUpdateExpr(doSwitch(o.getArray()), doSwitch(o.getIndex()),doSwitch(o.getExpr())); 
		}
	}
}
