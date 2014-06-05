// TODO This class is incomplete; it does not implement all relevant caseX methods.
package spear.validation;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import spear.language.BooleanType;
import spear.language.Divide;
import spear.language.Enumerator;
import spear.language.EnumerationType;
import spear.language.EqualTo;
import spear.language.GreaterThan;
import spear.language.GreaterThanEqual;
import spear.language.NamedUnit;
import spear.language.IntegerType;
import spear.language.LessThan;
import spear.language.LessThanEqual;
import spear.language.Minus;
import spear.language.Multiply;
import spear.language.NamedType;
import spear.language.NormUnit;
import spear.language.Not;
import spear.language.NotEqual;
import spear.language.Or;
import spear.language.Plus;
import spear.language.RealType;
import spear.language.RecordExpr;
import spear.language.RecordField;
import spear.language.RecordType;
import spear.language.Scalar;
import spear.language.util.LanguageSwitch;

public class SpecDSLErrorPrinter extends LanguageSwitch<Void> {
	
	@Override
	public Void caseRecordExpr(RecordExpr object) {
		doSwitch(object.getType());
		return null;
	}

	@Override
	public Void caseEqualTo(EqualTo object) {
		write("==");
		return null;
	}

	@Override
	public Void caseNotEqual(NotEqual object) {
		write("<>");
		return null;
	}

	@Override
	public Void caseOr(Or object) {
		write("or");
		return null;
	}

	@Override
	public Void caseNot(Not object) {
		write("not");
		return null;
	}

	private StringBuilder sb = null;
	public SpecDSLErrorPrinter() {
		sb = new StringBuilder();
	}
	
	public SpecDSLErrorPrinter(EObject t) {
		sb = new StringBuilder();
		doSwitch(t);
	}
	private void write(String s) {
		sb.append(s);
	}
	
	public static String toString(EObject t) {
		SpecDSLErrorPrinter p = new SpecDSLErrorPrinter(t);
		return p.toString();
	}
	
	public String toString() {
		return sb.toString();
	}

	@Override 
	public Void caseRecordType(RecordType r) {
			write("{ ");
			Iterator<RecordField> typeit = r.getFields().iterator();
			while(typeit.hasNext()) {
				RecordField rf = typeit.next();
				write(rf.getName()+" : ");
				doSwitch(rf.getType());
				if(typeit.hasNext()) {
					sb.append(", ");
				}
			}
			write(" }");
			return null;
}
	@Override
	public Void caseEnumerationType(EnumerationType e) {
		write("[ ");
		Iterator<Enumerator> typeit = e.getEnumerators().iterator();
		while(typeit.hasNext()) {
			write(typeit.next().getName());
			if(typeit.hasNext()) {
				write(", ");
			}
		}
		write(" ]");
		return null;
	}

	@Override
	public Void caseNamedType(NamedType nt) {
		write(nt.getId().getName());
		return null;
	}
	
	@Override
	public Void caseRealType(RealType X) {
		write("real");
		return null;
	}

	@Override
	public Void caseIntegerType(IntegerType X) {
		write("int");
		return null;
	}

	@Override
	public Void caseBooleanType(BooleanType X) {
		write("bool");
		return null;
	}
	
	@Override
	public Void caseMultiply(Multiply X) {
		write("*");
		return null;
	}
	
	@Override
	public Void caseDivide(Divide X) {
		write("/");
		return null;
	}
	
	@Override
	public Void casePlus(Plus X) {
		write("+");
		return null;
	}
	
	@Override
	public Void caseMinus(Minus X) {
		write("-");
		return null;
	}
	
	@Override
	public Void caseScalar(Scalar X) {
		write("scalar");
		return null;
	}
	
	@Override
	public Void caseNamedUnit(NamedUnit id) {
		write(id.getId().getName());
		return null;
	}
	
	@Override
	public Void caseNormUnit(NormUnit nu) {
		int nsize = nu.getNumerators().size();
		int dsize = nu.getDenominators().size();
		
		if (dsize>0 && nsize>1) { 
			write("(");
		}
		Iterator<NamedUnit> it = nu.getNumerators().iterator();
		while(it.hasNext()) {
			doSwitch(it.next());
			if(it.hasNext()) {
				write("*");
			}
		}
		if(dsize>0 && nsize>1) {
			write(")");
		}
		
		if(dsize>0) {
			write("/");
			if(dsize>1) {
				write("(");
			}
			it = nu.getDenominators().iterator();
			while(it.hasNext()) {
				doSwitch(it.next());
				if(it.hasNext()) {
					write("*");
				}
			}
			if(dsize>1) {
				write(")");
			}
		}
		
		return null;
	}

	@Override
	public Void caseLessThan(LessThan object) {
		write("<");
		return null;
	}

	@Override
	public Void caseGreaterThan(GreaterThan object) {
		write(">");
		return null;
	}

	@Override
	public Void caseLessThanEqual(LessThanEqual object) {
		write("<=");
		return null;
	}

	@Override
	public Void caseGreaterThanEqual(GreaterThanEqual object) {
		write(">=");
		return null;
	}
	
}
