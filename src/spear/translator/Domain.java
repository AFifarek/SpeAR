package spear.translator;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jkind.lustre.Expr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import spear.language.ArrayType;
import spear.language.BooleanType;
import spear.language.EnumerationType;
import spear.language.Enumerator;
import spear.language.IntegerSubRangeType;
import spear.language.NamedType;
import spear.language.RecordType;
import spear.language.TypeDef;
import spear.language.Utils;
import spear.language.util.LanguageSwitch;
import spear.validation.IntegerConstantSimplification;
import spear.validation.TypeChecker;

public class Domain extends LanguageSwitch<List<jkind.lustre.Expr>> {
	
	
	@Override
	public List<jkind.lustre.Expr> caseEnumerationType(EnumerationType object) {
		List<jkind.lustre.Expr> rlist = new LinkedList<>();
		for(Enumerator etor : object.getEnumerators()) {
			rlist.add(new jkind.lustre.IdExpr(Utils.getFQN(etor)));
		}
		return rlist;
	}


	@Override
	public List<Expr> caseIntegerSubRangeType(IntegerSubRangeType object) {
		List<jkind.lustre.Expr> rlist = new LinkedList<>();
		for(BigInteger i = IntegerConstantSimplification.simplify(object.getLow());
			i.compareTo(IntegerConstantSimplification.simplify(object.getHigh()))<=0;
			i = i.add(BigInteger.ONE)) {
			rlist.add(new jkind.lustre.IntExpr(i));
		}
		return rlist;
	}
	
	// Build all possible array values recursively.
	private List<jkind.lustre.Expr> caseArrayType(ArrayType object,BigInteger i) {
		List<jkind.lustre.Expr> rlist = new LinkedList<>();
		List<jkind.lustre.Expr> values =  doSwitch(object.getType());
		if(i.compareTo(BigInteger.ZERO)<=0) {
			for(jkind.lustre.Expr e : values) {
				List<jkind.lustre.Expr> singleton = new LinkedList<>();
				singleton.add(e);
				rlist.add(new jkind.lustre.ArrayExpr(singleton));
			}
		} else {
			for(jkind.lustre.Expr e : caseArrayType(object,i.subtract(BigInteger.ONE))) {
				jkind.lustre.ArrayExpr ae = (jkind.lustre.ArrayExpr)e;
				for(jkind.lustre.Expr v : values) {
					List<jkind.lustre.Expr> extension = new LinkedList<>();
					extension.addAll(ae.elements);
					extension.add(v);
					rlist.add(new jkind.lustre.ArrayExpr(extension));
				}
			}
		}
		return rlist;
	}
	
	@Override
	public List<jkind.lustre.Expr> caseArrayType(ArrayType object) {
		return caseArrayType(object,IntegerConstantSimplification.simplify(object.getLength()));
	}

	// Build all possible record values recursively.
	private List<jkind.lustre.Expr> caseRecordType(TypeDef td, RecordType rt, int i) {
		
		List<jkind.lustre.Expr> rlist = new LinkedList<>();
		if(i <= 0) {
			List<jkind.lustre.Expr> values = doSwitch(rt.getFields().get(i).getType());
			for(jkind.lustre.Expr e : values) {
				Map<String,jkind.lustre.Expr> singleton = new HashMap<>();
				singleton.put(rt.getFields().get(i).getName(), e);
				rlist.add(new jkind.lustre.RecordExpr(Utils.getFQN(td), singleton));
			}
		} else {
			List<jkind.lustre.Expr> values = doSwitch(rt.getFields().get(i).getType());
			for(jkind.lustre.Expr e :caseRecordType(td,rt,i-1)) {
				jkind.lustre.RecordExpr re = (jkind.lustre.RecordExpr)e;
				for(jkind.lustre.Expr v : values) {
					Map<String,jkind.lustre.Expr> extension = new HashMap<>();
					extension.putAll(re.fields);
					extension.put(rt.getFields().get(i).getName(), v);
					rlist.add(new jkind.lustre.RecordExpr(Utils.getFQN(td),extension));
				}
			}
			
		}
		return rlist;
	}
	
	@Override
	public List<Expr> caseRecordType(RecordType object) {
		return caseRecordType(EcoreUtil2.getContainerOfType(object,  TypeDef.class)
				,object,object.getFields().size()-1);
	}
	
	@Override
	public List<jkind.lustre.Expr> caseNamedType(NamedType object) {
		return doSwitch(TypeChecker.resolveNamedType(object));
	}
	
	@Override
	public List<jkind.lustre.Expr> defaultCase(EObject object) {
		return null;
	}


	@Override
	public List<Expr> caseBooleanType(BooleanType object) {
		List<jkind.lustre.Expr> rlist = new LinkedList<>();
		rlist.add(new jkind.lustre.BoolExpr(true));
		rlist.add(new jkind.lustre.BoolExpr(false));
		return rlist;
	}


}
