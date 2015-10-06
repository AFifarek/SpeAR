package spear.validation;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import spear.language.ArrayAccessExpr;
import spear.language.ArrayExpr;
import spear.language.ArrayType;
import spear.language.BinaryExpr;
import spear.language.BoolExpr;
import spear.language.CallRef;
import spear.language.Constant;
import spear.language.Divide;
import spear.language.Enumerator;
import spear.language.ErrorUnit;
import spear.language.ExistsExpr;
import spear.language.Expr;
import spear.language.FnCallExpr;
import spear.language.ForallExpr;
import spear.language.IdExpr;
import spear.language.NamedUnit;
import spear.language.IfThenElseExpr;
import spear.language.RecordAccessExpr;
import spear.language.IntExpr;
import spear.language.Macro;
import spear.language.Minus;
import spear.language.Multiply;
import spear.language.NormUnit;
import spear.language.Plus;
import spear.language.PreExpr;
import spear.language.Procedure;
import spear.language.ProdUnit;
import spear.language.QuotUnit;
import spear.language.RealExpr;
import spear.language.ReciUnit;
import spear.language.RecordExpr;
import spear.language.RecordField;
import spear.language.RecordFieldExpr;
import spear.language.RecordType;
import spear.language.Scalar;
import spear.language.LanguageFactory;
import spear.language.SumExpr;
import spear.language.Type;
import spear.language.UnaryExpr;
import spear.language.Unit;
import spear.language.Utils;
import spear.language.Variable;
import spear.language.util.LanguageSwitch;


public class UnitChecker extends LanguageSwitch<NormUnit> {

	@Override
	public NormUnit caseArrayAccessExpr(ArrayAccessExpr object) {
		return scalar;
	}

	private static Comparator<NamedUnit> COMPARATOR = new Comparator<NamedUnit>() {
		public int compare(NamedUnit o1, NamedUnit o2) {
			return o1.getId().getName().compareTo(o2.getId().getName());
		}
	};
	private static LanguageFactory f = LanguageFactory.eINSTANCE;
	private Scalar scalar = f.createScalar();

	private LanguageJavaValidator validator;

	public UnitChecker(LanguageJavaValidator validator) {
		this.validator = validator;
	}
	
	@Override
	public NormUnit caseBinaryExpr(BinaryExpr re) {
		NormUnit l = doSwitch(re.getLeft());
		NormUnit r = doSwitch(re.getRight());
		if(isError(l) || isError(r)) {
			if(TypeChecker.isOpArithmetic(re.getOp())) {
				return errorUnit();
			} else {
				return scalar;
			}
		} else if (isScalar(l) && isScalar(r)) {
			return scalar;
		} else if (((isScalar(l) ? 1 : 0) + (isScalar(r) ? 1 : 0)) == 1) {
			if(isScalar(l)) {
				error("Binary relation between scalar and "+SpecDSLErrorPrinter.toString(r)+".", re);
			} else {
				error("Binary relation between "+SpecDSLErrorPrinter.toString(l)+" and scalar.", re);
			}
			return errorUnit();
		}
		if (re.getOp() instanceof Multiply) {
			List<Unit> us = new LinkedList<Unit>();
			us.addAll(copy(r.getNumerators()));
			us.addAll(copy(l.getNumerators()));
			us.addAll(invert(copy(r.getDenominators())));
			us.addAll(invert(copy(l.getDenominators())));
			return normalizeStep2(us);
		} else if (re.getOp() instanceof Divide) {
			List<Unit> us = new LinkedList<Unit>();
			us.addAll(copy(r.getDenominators()));
			us.addAll(copy(l.getNumerators()));
			us.addAll(invert(copy(r.getNumerators())));
			us.addAll(invert(copy(l.getDenominators())));
			return normalizeStep2(us);
		} else if(equals(l, r, re) 
				&&(re.getOp() instanceof Plus || re.getOp() instanceof Minus)) {
			return l;
		} else if(equals(l, r, re)) {
				return scalar;
		} else {
			unitMisMatch(l,r,re);
			return errorUnit();
		}
	}

	@Override
	public NormUnit caseBoolExpr(BoolExpr object) {
		return scalar;
	}

	@Override
	public NormUnit caseExpr(Expr expr) {
		validator.error("Illegal expr object(" + expr.getClass().getName()
				+ ") encountered while unit checking.", expr);
		return errorUnit();
	}

	@Override
	public NormUnit caseRecordAccessExpr(RecordAccessExpr object) {
		TypeChecker tu = new TypeChecker(validator);
		Type t = TypeChecker.resolveNamedType(tu.getType(object.getRecord()));
		NormUnit retval = scalar;
		if (t instanceof RecordType) {
			RecordType rt = (RecordType) t;
			for (RecordField rf : rt.getFields()) {
				if (rf.getName().equals(object.getField())) {
					retval = normalize(rf.getUnit());
				}
			}
		}
		return retval;
	}

	@Override
	public NormUnit caseFnCallExpr(FnCallExpr object) {
		
		CallRef cr = object.getId();
		// TODO If uninterpreted functions are permitted this case will need
		// attention.
		if(!(cr instanceof Procedure)) {
			return null;
		}
		Procedure p = (Procedure)object.getId();
		List<Variable> formalargs = Utils.getInputs(p);
		if(formalargs.size()!=object.getArgs().size()) {
			/* NB: No error will be thrown here. If these
			 * sizes are not equivalent then the type checker would
			 * have thrown an error.
			 */
		} else {
			for(int i = 0;i< object.getArgs().size() ; i++) {
				Expr arg = object.getArgs().get(i);
				NormUnit fu = normalize(formalargs.get(i).getUnit());
				NormUnit au = doSwitch(arg);
				if(!equals(au,fu,arg)) {
					unitMisMatch(fu,au,arg);
				}
			}
		}	
		// TODO: this needs to be fixed when I make a new type definition
//		return normalize(Utils.getOutput(p).getUnit());
		return null;
	} 

	@Override
	public NormUnit caseIdExpr(IdExpr object) {
		return doSwitch(object.getId());
	}
	
	@Override
	public NormUnit caseIfThenElseExpr(IfThenElseExpr object) {
		doSwitch(object.getIfExpr());
		NormUnit thn = doSwitch(object.getThenExpr());
		NormUnit els = doSwitch(object.getElseExpr());
		if(equals(thn,els,object)) {
			return thn;
		} else {
			unitMisMatch(thn,els,object);
			return scalar;
		}
	}

	@Override
	public NormUnit caseIntExpr(IntExpr ie) {
		return normalize(ie.getUnit());

	}

	@Override
	public NormUnit casePreExpr(PreExpr object) {
		return doSwitch(object.getExpr());
	}
	

	@Override
	public NormUnit caseRealExpr(RealExpr re) {
		return normalize(re.getUnit());
	}



	@Override
	public NormUnit caseRecordExpr(RecordExpr object) {
		return scalar;
	}

	@Override
	public NormUnit caseRecordFieldExpr(RecordFieldExpr object) {
		return scalar;
	}

	@Override
	public NormUnit caseUnaryExpr(UnaryExpr object) {
		return doSwitch(object.getExpr());
	}

	@Override
	public NormUnit caseVariable(Variable object) {
		return normalize(object.getUnit());
	}
	
	
	@Override
	public NormUnit caseConstant(Constant object) {
		return normalize(object.getUnit());
	}
	
	@Override
	public NormUnit caseMacro(Macro m) {
		return normalize(m.getUnit());
	}
	
	@Override
	public NormUnit caseEnumerator(Enumerator obj) {
		return scalar;
	}


	public boolean equals(NormUnit u1, NormUnit u2, EObject o) {
		if (isScalar(u1) && isScalar(u2)) {
			return true;
		} else if ((isScalar(u1) ? 1 : 0) + (isScalar(u2) ? 1 : 0) == 1) {
			return false;
		} else if (u1 instanceof ErrorUnit || u2 instanceof ErrorUnit) {
			return true;
		}

		boolean eq = true;
		eq = u1.getDenominators().size() == u2.getDenominators().size()
				&& u1.getNumerators().size() == u2.getNumerators().size();
		for (int i = 0; eq && i < u1.getDenominators().size(); i++) {
			if (!u1.getDenominators().get(i).getId().getName()
					.equals(u2.getDenominators().get(i).getId().getName())) {
				eq = false;
				break;
			}
		}
		for (int i = 0; eq && i < u1.getNumerators().size(); i++) {
			if (!u1.getNumerators().get(i).getId().getName()
					.equals(u2.getNumerators().get(i).getId().getName())) {
				eq = false;
				break;
			}
		}
		return eq;
	}

	private void error(String msg, EObject o) {
		validator.error(msg, o);
	}

	private NormUnit errorUnit() {
		return f.createErrorUnit();
	}
	
	private boolean isScalar(EObject o) {
		return o instanceof Scalar;
	}

	private boolean isError(EObject o) {
		return o instanceof ErrorUnit;
	}
	public NormUnit normalize(Unit u) {
		if (u == null || isScalar(u)) {
			return scalar;
		} else if (u instanceof NormUnit) {
			return copy((NormUnit) u);
		} else {
			List<Unit> nonnormal = new LinkedList<Unit>();
			nonnormal.add(copy(u));
			List<Unit> listnormform = normalizeStep1(nonnormal);
			NormUnit nf = normalizeStep2(listnormform);
			return nf;
		}
	}
	
	private <T extends EObject> T copy(T o) {
		return EcoreUtil.copy(o);
	}
	private EList<NamedUnit> copy(EList<NamedUnit> ids) {
		EList<NamedUnit> retval = new BasicEList<NamedUnit>();
		for(NamedUnit id : ids) {
			retval.add(copy(id));
		}
		return retval;
	}
	private List<Unit> normalizeStep1(List<Unit> _set) {
		int i = 0;
		List<Unit> set = new LinkedList<Unit>();
		set.addAll(_set);
		while (i < set.size()) {
			Unit t = set.get(i);
			if (t instanceof ProdUnit) {
				set.remove(i);
				set.add(copy(((ProdUnit) t).getLeft()));
				set.add(copy(((ProdUnit) t).getRight()));
			} else if (t instanceof QuotUnit) {
				set.remove(i);
				set.add(copy(((QuotUnit) t).getLeft()));
				ReciUnit rt = f.createReciUnit();
				rt.setUnit(copy(((QuotUnit) t).getRight()));
				set.add(rt);
			} else if (t instanceof ReciUnit
					&& ((ReciUnit) t).getUnit() instanceof ReciUnit) {
				set.remove(i);
				set.set(i, copy(((ReciUnit) ((ReciUnit) t).getUnit()).getUnit()));
			} else if (t instanceof ReciUnit
					&& ((ReciUnit) t).getUnit() instanceof ProdUnit) {
				set.remove(i);
				ProdUnit pt = (ProdUnit) ((ReciUnit) t).getUnit();
				ReciUnit rtl = f.createReciUnit();
				ReciUnit rtr = f.createReciUnit();
				rtl.setUnit(copy(pt.getLeft()));
				rtr.setUnit(copy(pt.getRight()));
				set.add(rtl);
				set.add(rtr);
			} else if (t instanceof ReciUnit
					&& ((ReciUnit) t).getUnit()instanceof QuotUnit) {
				QuotUnit qt = (QuotUnit) ((ReciUnit) t).getUnit();
				Unit n = copy(qt.getLeft());
				Unit d = copy(qt.getRight());
				qt.setLeft(d);
				qt.setRight(n);
			} else if (t instanceof NamedUnit
					&& ((NamedUnit) t).getId().getUnit() != null) {
				set.set(i, copy(((NamedUnit) t).getId().getUnit()));
			} else if (t instanceof ReciUnit
					&& ((ReciUnit) t).getUnit() instanceof NamedUnit
					&& ((NamedUnit) ((ReciUnit) t).getUnit()).getId().getUnit() != null) {
				set.set(i, copy(((NamedUnit) ((ReciUnit) t).getUnit()).getId()
						.getUnit()));
			} else {
				i++;
			}
		}
		return set;
	}
	
	private NormUnit normalizeStep2(List<Unit> set) {
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) instanceof ReciUnit) {
				ReciUnit rt = (ReciUnit) set.get(i);
				NamedUnit nt1 = (NamedUnit) rt.getUnit();
				for (int j = 0; j < set.size(); j++) {
					if (!(set.get(j) instanceof NamedUnit)) {
						continue;
					}
					NamedUnit nt2 = (NamedUnit) set.get(j);
					if (nt1.getId().getName().equals(nt2.getId().getName())) {
						set.remove(i);
						set.remove(i<j ? j-1 : j);
						i = 0;
						break;
					}
				}
			}
		}
		if (set.size() == 0) {
			return scalar;
		} else if (set.size() == 1) {
			NormUnit nt = f.createNormUnit();
			nt.getNumerators().add((NamedUnit) set.get(0));
			return nt;
		} else {
			NormUnit nt = f.createNormUnit();
			for (Unit t : set) {
				if (t instanceof ReciUnit) {
					nt.getDenominators().add((NamedUnit) ((ReciUnit) t).getUnit());
				} else if (t instanceof NamedUnit){
					nt.getNumerators().add((NamedUnit) t);
				} else {
					System.out.println("Bad Unit found in normalize2 "+SpecDSLErrorPrinter.toString(t));
				}
			}
			ECollections.sort(nt.getDenominators(), COMPARATOR);
			ECollections.sort(nt.getNumerators(), COMPARATOR);
			return nt;
		}
	}
	
	private void unitMisMatch(NormUnit a, NormUnit b, EObject o) {
		error("Expected unit "+SpecDSLErrorPrinter.toString(a)
				+" but received "+SpecDSLErrorPrinter.toString(b),o);
	}
	
	private ReciUnit invert(Unit u) {
		ReciUnit r = f.createReciUnit();
		r.setUnit(u);
		return r;
	}
	
	private List<ReciUnit> invert(EList<NamedUnit> us) {
		List<ReciUnit> rs = new LinkedList<ReciUnit>();
		for(Unit u : us) {
			rs.add(invert(u));
		}
		return rs;
	}

	@Override
	public NormUnit caseForallExpr(ForallExpr object) {
		return scalar;
	}

	@Override
	public NormUnit caseExistsExpr(ExistsExpr object) {
		return scalar;
	}
	
	@Override
	public NormUnit caseSumExpr(SumExpr object) {
		return scalar;
	}
	@Override
	public NormUnit caseArrayExpr(ArrayExpr o) {
		return scalar;
	}
}