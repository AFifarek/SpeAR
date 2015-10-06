package spear.validation;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import spear.language.And;
import spear.language.ArrayAccessExpr;
import spear.language.ArrayExpr;
import spear.language.ArrayType;
import spear.language.BinaryExpr;
import spear.language.BinaryOp;
import spear.language.BoolExpr;
import spear.language.BooleanType;
import spear.language.CallRef;
import spear.language.Constant;
import spear.language.Divide;
import spear.language.Domain;
import spear.language.DomainExpr;
import spear.language.DomainType;
import spear.language.EnumerationType;
import spear.language.Enumerator;
import spear.language.EqualTo;
import spear.language.ErrorType;
import spear.language.ExistsExpr;
import spear.language.Exponentiation;
import spear.language.Expr;
import spear.language.FnCallExpr;
import spear.language.ForallExpr;
import spear.language.GreaterThan;
import spear.language.GreaterThanEqual;
import spear.language.IdExpr;
import spear.language.IfThenElseExpr;
import spear.language.Implies;
import spear.language.IntExpr;
import spear.language.IntegerSubRangeType;
import spear.language.IntegerType;
import spear.language.LanguageFactory;
import spear.language.LessThan;
import spear.language.LessThanEqual;
import spear.language.Macro;
import spear.language.Minus;
import spear.language.Modulus;
import spear.language.Multiply;
import spear.language.NamedType;
import spear.language.Not;
import spear.language.NotEqual;
import spear.language.Or;
import spear.language.Plus;
import spear.language.PreExpr;
import spear.language.Procedure;
import spear.language.QuantificationExpr;
import spear.language.QuantifiedVariable;
import spear.language.RealExpr;
import spear.language.RealType;
import spear.language.RecordAccessExpr;
import spear.language.RecordExpr;
import spear.language.RecordField;
import spear.language.RecordFieldExpr;
import spear.language.RecordType;
import spear.language.SumExpr;
import spear.language.TupleType;
import spear.language.Type;
import spear.language.TypeDef;
import spear.language.UnaryExpr;
import spear.language.UnaryMinus;
import spear.language.UnaryOp;
import spear.language.Utils;
import spear.language.Variable;
import spear.language.Xor;
import spear.language.util.LanguageSwitch;


/**
 * Type check a specification.
 */
public class TypeChecker extends LanguageSwitch<Type> {



	public static LanguageFactory f = LanguageFactory.eINSTANCE;
	private LanguageJavaValidator validator;

	public TypeChecker(LanguageJavaValidator validator) {
		this.validator = validator;
	}

	
	private void error(String str, EObject obj) {
		if(null != validator) {
			validator.error(str,obj);
		}
	}
	

	private void warning(String str, EObject obj) {
		if(validator != null) {
			validator.warning(str,obj);
		}
	}
	
	private Type errorType() {
		return f.createErrorType();
	}
	
	private Type tupleType() {
		return f.createTupleType();		
	}
	
	public static Boolean isOpArithmetic(EObject e) {
		if (e instanceof BinaryOp) {
			BinaryOp bop = (BinaryOp) e;
			return (bop instanceof Plus) || (bop instanceof Minus)
					|| (bop instanceof Multiply) || (bop instanceof Divide)
					|| (bop instanceof Exponentiation);
		} else if (e instanceof UnaryOp) {
			UnaryOp uop = (UnaryOp) e;
			return ((uop instanceof UnaryMinus));
		} else {
			return false;
		}
	}

	public static Boolean isOpComparative(EObject e) {
		if (e instanceof BinaryOp) {
			BinaryOp bop = (BinaryOp) e;
			return (bop instanceof LessThan) || (bop instanceof GreaterThan)
					|| (bop instanceof LessThanEqual)
					|| (bop instanceof GreaterThanEqual);
		} else {
			return false;
		}
	}

	public static Boolean isOpEquality(EObject e) {
		if (e instanceof BinaryOp) {
			BinaryOp bop = (BinaryOp) e;
			return (bop instanceof EqualTo) || (bop instanceof NotEqual);
		} else {
			return false;
		}
	}

	public static Boolean isOpLogical(EObject e) {
		if (e instanceof BinaryOp) {
			BinaryOp bop = (BinaryOp) e;
			return (bop instanceof And) || (bop instanceof Or)
					|| (bop instanceof Xor) || (bop instanceof Implies);
		} else if (e instanceof UnaryOp) {
			UnaryOp uop = (UnaryOp) e;
			return (uop instanceof Not);
		} else {
			return false;
		}
	}

	public static Boolean isTypeNumeric(Type e) {
		e = resolveNamedType(e);
		if (e instanceof RealType || e instanceof IntegerType || e instanceof EnumerationType 
				|| e instanceof IntegerSubRangeType) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean isTypeLogical(EObject e) {
		return (e instanceof BooleanType);
	}

	public static Boolean isTypeInteger(EObject e) {
		return (e instanceof IntegerType);
	}

	public static Boolean isTypeReal(EObject e) {
		return (e instanceof RealType);
	}
	
	private Type assignType(Type expected, Type actual, EObject ast) {
		if(isError(expected) || isError(actual)) {
			return errorType();
		}
		
		if(!typeAssignable(actual,expected,ast)) {
			error("Expected type "+SpecDSLErrorPrinter.toString(expected)+", but found type "
					+SpecDSLErrorPrinter.toString(actual),ast);
			return errorType();
		}
		
		return actual;
	}
	
	private boolean integerAssignable(Type t, EObject ast) {
		if (	t instanceof IntegerType
				||t instanceof IntegerSubRangeType
				||t instanceof ErrorType) {
			return true;
		} 
		error("Expected Integer, found "+SpecDSLErrorPrinter.toString(t)+".",ast);
		return false;
	}
	
	private Type warnNamedTypeImplicitCoercion(Type expected, Type actual, EObject ast) {
		if(actual instanceof NamedType) {
			warning("Implicit coercion from type "
					+ SpecDSLErrorPrinter.toString(expected) + " to type "
					+ SpecDSLErrorPrinter.toString(actual)+".", ast);
		}
		
		return resolveNamedType(actual);
	}
	
	public boolean typeAssignable(Type expected, Type actual, EObject ast) {

		// NB: We are treating integer sub-ranges as integers.
		if (expected instanceof IntegerType || expected instanceof IntegerSubRangeType) {
			return integerAssignable(warnNamedTypeImplicitCoercion(expected,actual,ast),ast);
		}

		if(		expected instanceof RealType
				||expected instanceof BooleanType) {
			return expected.getClass() == warnNamedTypeImplicitCoercion(expected,actual,ast).getClass();
		}

		if(expected instanceof NamedType) {
			if(actual instanceof NamedType && ((NamedType)actual).getId().getName().equals(((NamedType)expected).getId().getName())) {
				return true;
			} else if(actual instanceof NamedType) {
				Type resolvedet = warnNamedTypeImplicitCoercion(expected,((NamedType)expected).getId().getType(), ast);
				Type resolvedat = warnNamedTypeImplicitCoercion(actual,((NamedType)actual).getId().getType(), ast);
				return typeAssignable(resolvedet,resolvedat,ast);
				
			} else { 
				Type resolvedet = warnNamedTypeImplicitCoercion(expected,((NamedType)expected).getId().getType(), expected);
				return typeAssignable(resolvedet,actual,ast);
			}
		}
		
		if(expected instanceof ArrayType
				   && (warnNamedTypeImplicitCoercion(expected,actual,ast)) instanceof ArrayType) {
				ArrayType expected_ = (ArrayType) expected;
				ArrayType actual_ = (ArrayType)warnNamedTypeImplicitCoercion(expected,actual,ast);
				return typeAssignable(expected_.getType(),actual_.getType(),ast) 
						&& expected_.getLength() == expected_.getLength();
		}
		
		error("Expected type "+SpecDSLErrorPrinter.toString(expected)+", but found type "
				+SpecDSLErrorPrinter.toString(actual),ast);
		return false;
	}

	public static boolean isTypeFinite(Type type) {
		type = resolveNamedType(type);
		if(type instanceof IntegerSubRangeType
			|| type instanceof EnumerationType
			|| type instanceof BooleanType) {
			return true;
		} else if(type instanceof ArrayType) {
			ArrayType at = (ArrayType)type;
			return isTypeFinite(at.getType());
		} else if(type instanceof RecordType) {
			RecordType rt = (RecordType)type;
			boolean flag = true;
			for( RecordField rf : rt.getFields()) {
				flag = flag && isTypeFinite(rf.getType());
			}
			return flag;
		} else {
			return false;
		}
	}
	
	
	public static boolean isExprLiteral(Expr e) {
		if (e instanceof IntExpr
			|| e instanceof RealExpr
			|| e instanceof BoolExpr) {
			return true;
		} else if (e instanceof RecordExpr) {
			RecordExpr re = (RecordExpr) e;
			boolean all_literal = true;
			for (RecordFieldExpr rfe : re.getRecordFields()) {
				all_literal = all_literal && isExprLiteral(rfe.getExpr());
			}
			return all_literal;
		} else if (e instanceof IdExpr) {
			IdExpr ide = (IdExpr) e;
			return (ide.getId() instanceof Constant || ide.getId() instanceof Enumerator);
		} else if (e instanceof UnaryExpr) {
			UnaryExpr ue = (UnaryExpr) e;
			return isExprLiteral(ue.getExpr());
		} else if (e instanceof BinaryExpr) {
			BinaryExpr be = (BinaryExpr) e;
			return isExprLiteral(be.getLeft()) && isExprLiteral(be.getRight());
		} else if (e instanceof ArrayExpr) {
			ArrayExpr ae = (ArrayExpr) e;
			boolean all_literal = true;
			for(Expr expr : ae.getExprs()) {
				all_literal = all_literal && isExprLiteral(expr);
			}
			return all_literal;
		} else {
			return false;
		}
	}

	public static boolean isError(EObject o) {
		return (o instanceof ErrorType);
	}
	

	private Type getDomainElementType(Type _actual, EObject ast) {
		Type actual = resolveNamedType(_actual);
		if (actual instanceof IntegerSubRangeType) {
			return f.createIntegerType();
		} else if (actual instanceof EnumerationType) {
			return _actual;
		} else if (actual instanceof ArrayType) {
			ArrayType at = (ArrayType)actual;
			return at.getType();
		} else if (actual instanceof RecordType) {
			return _actual;
		} else {
			error("Expected array, integer sub-range, record, or enumerated type, found "+SpecDSLErrorPrinter.toString(actual),ast);
			return errorType();
		}
	}

	public Type getType(EObject e) {
		Type t = doSwitch(e);
		return t;
	}

	public static Type resolveNamedType(Type t) {
		if (t instanceof NamedType)
			return resolveNamedType(((NamedType) t).getId().getType());
		else
			return t;
	}



	@Override
	public Type caseExpr(Expr expr) {
		error("Illegal expr object(" + expr 
				+ ") encountered while type checking.", expr);
		return errorType();
	}
	
	@Override
	public Type caseArrayAccessExpr(ArrayAccessExpr o) {

		// We must be indexing an array.
		Type tltype = getType(o.getArray());
		Type maybe_arrtyp = resolveNamedType(tltype);
		if(!(maybe_arrtyp instanceof ArrayType)) {
			error("Only arrays may be indexed",o.getArray());
			return errorType();
		} 

		ArrayType arrtyp = (ArrayType) maybe_arrtyp;
		if(!typeAssignable(f.createIntegerType(),getType(o.getIndex()),o.getIndex())) {
			error("Arrays may only be indexed by integers.",o.getIndex());
			return errorType();
		}

		if(o.getExpr() != null) {
			Type acttyp = getType(o.getExpr());
			if(typeAssignable(arrtyp.getType(),acttyp,o)) {
				return tltype;
			} else {
				error("Cannot assign type "+SpecDSLErrorPrinter.toString(arrtyp.getType())+" with value from type "
						+SpecDSLErrorPrinter.toString(acttyp),o.getExpr());
				return errorType();
			}
		}
		else {
			return arrtyp.getType();
		}
	}

	@Override
	public Type caseFnCallExpr(FnCallExpr fce) {
		
		CallRef cr = fce.getId();
		// TODO: If spear eventually supports unimplemented functions type 
		// support will need to be added here.
		if(!(cr instanceof Procedure)) {
			error("Only relations may be invocked.",fce);
			return errorType();
		}
		
		Procedure p = (Procedure)fce.getId();	
		List<Variable> inputs_List = Utils.getInputs(p);
		
		if (inputs_List.size() != fce.getArgs().size()) {
			error("Function " + p.getName() + " expects " + inputs_List.size() + " arguments "
					+ " but "+fce.getArgs().size()+" arguments provided.", fce);
			return errorType();
		} else {
//			for (int i = 0; i < inputs.size(); i++) {
			for (Variable v : inputs_List) {
				Type declaredType = v.getType();				
//				Type exprType = getType(fce.getArgs().get(i));
//				typeAssignable(declaredType,exprType,fce.getArgs().get(i));
				Type exprType = getType(fce);
				typeAssignable(declaredType,exprType,fce);
			}
			// TODO: have to get this working properly

			// Idea: instead of trying to make this a list of output elements I could just create a temporary internal type that would pack all outputs into it
//			TupleType tmpOutputType = tupleType();
//			for (Variable v : Utils.getOutputs(p)) {
//				Type tempType = new Type();
//				
//			}
			
//			return Utils.getOutput(p).getType();
			return errorType();
		}
	}

	@Override
	public Type caseIfThenElseExpr(IfThenElseExpr ite) {
		Type ifType = getType(ite.getIfExpr());
		Type thenType = getType(ite.getThenExpr());
		Type elseType = getType(ite.getElseExpr());
		typeAssignable(f.createBooleanType(),ifType, ite);
		return assignType(thenType, elseType, ite);
	}

	@Override
	public Type caseRecordAccessExpr(RecordAccessExpr fie) {
		Type tltype = getType(fie.getRecord());
		Type baseType = resolveNamedType(tltype);
		if (isError(baseType)) {
			return errorType();
		} 
		
		if (baseType instanceof RecordType) {
			RecordType rt = (RecordType) baseType;
			// TODO: I believe this check could be pushed up to the grammar
			// if scoping and cross-referencing is done correct.
			for (RecordField rf : rt.getFields()) {
				if (rf.getName().equals(fie.getField().getName())) {
					if(fie.getExpr() == null) {
						return rf.getType();
					} else {
						if(typeAssignable(rf.getType(),getType(fie.getExpr()),fie.getExpr())) {
							return tltype;
						} else {
							return errorType();
						}
					}
				}
			}

			validator.error("Record type "+SpecDSLErrorPrinter.toString(tltype)+" has no field named "+fie.getField().getName(),fie);
			return errorType();
		} else {
			error(SpecDSLErrorPrinter.toString(tltype)+" is a non-record type.", fie.getRecord());
			return errorType();
		}

	}

	@Override
	public Type caseIdExpr(IdExpr idExpr) {
		return getType(idExpr.getId());
	}

	
	// Type checking quantified variables can be complicated. The first step is
	// find the first binder that binds this quantified variable. Once this 
	// binder has been found there are two cases: 1) the type of the domain is
	// a container type where the element is atomic, in this case the quantified
	// variable has the type of the this element type 2) the type of the domain
	// is a quantified variable, in this case we must do a recursive lookup to 
	// get the type of this quantified variable.
	@Override
	public Type caseQuantifiedVariable(QuantifiedVariable qr) {
		QuantificationExpr qp = Utils.getBinder(qr);
		Type typ = getType(qp.getDomain());
		return getDomainElementType(typ,qp.getDomain());
	}
	
	
	@Override 
	public Type caseDomain(Domain d) {
		if(d instanceof DomainExpr) {
			return getType(((DomainExpr)d).getDomain());
		} else {
			return ((DomainType)d).getDomain();
		}
	}
	
	@Override
	public Type caseVariable(Variable v) {
		return v.getType();
	}
	
	@Override
	public Type caseMacro(Macro m) {
		return m.getType();
	}

	@Override
	public Type caseConstant(Constant c) {
		return c.getType();
	}
	
	@Override
	public Type caseEnumerator(Enumerator e) {
		NamedType nt = f.createNamedType();
		nt.setId(EcoreUtil2.getContainerOfType(e, TypeDef.class));
		return nt;
	}
	
	@Override
	public Type casePreExpr(PreExpr pe) {
		return getType(pe.getExpr());
	}

	@Override
	public Type caseBinaryExpr(BinaryExpr be) {
		BinaryOp bop = be.getOp();
		Type leftType = getType(be.getLeft());
		Type rightType = getType(be.getRight());

		if (isError(leftType) || isError(rightType)) {
			return errorType();
		} else if (isOpArithmetic(bop) && isTypeNumeric(leftType)
				&& isTypeNumeric(rightType)
				&& typeAssignable(leftType, rightType, be)) {
			// XXX: Because integer subranges and enumeration types are coerced
			// to be used as integers there is a possibility that the computed
			// value may not be a valid value of the return type. This should 
			// either be removed, only allowed when values can be checked 
			// statically, or additionally properties created.
			return leftType;
		} else if (isOpComparative(bop) && isTypeNumeric(leftType) && isTypeNumeric(leftType) 
				&& typeAssignable(leftType,rightType,be)) {
			return f.createBooleanType();
		} else if (isOpEquality(bop) && typeAssignable(leftType, rightType, be)) {
			return f.createBooleanType();
		} else if (isOpLogical(bop) && isTypeLogical(leftType) && isTypeLogical(rightType)) {
			return f.createBooleanType();
		} else if(bop instanceof Modulus && typeAssignable(f.createIntegerType(),leftType,be.getLeft()) 
			&& typeAssignable(f.createIntegerType(),rightType,be.getRight()) ) {
			// XXX: A related problem to the one that exists above can occur 
			//here
			return leftType;
		} 
		error(	"Binary operator " + SpecDSLErrorPrinter.toString(bop)
					+ " is not defined on arguments of type "
					+ SpecDSLErrorPrinter.toString(leftType) + " and "
					+ SpecDSLErrorPrinter.toString(rightType) + ".", be);
		return errorType();
	}


	@Override
	public Type caseRecordExpr(RecordExpr re) {
		Type maybe_rectyp = re.getType().getType();
		if(!(maybe_rectyp instanceof RecordType)) {
			error("Not a record type.",re);
			return errorType();
		}
		RecordType rectyp = (RecordType) maybe_rectyp;
		RecordField[] initfields = new RecordField[rectyp.getFields().size()];
		for(RecordFieldExpr fe : re.getRecordFields()) {
			int i = 0;
			boolean found = false;
			for(RecordField ft : rectyp.getFields() ) {
				if(ft.getName().equals(fe.getField().getName())) {
					found=true;
					if(initfields[i]!=null) {
						error("Record field "+ft.getName()+" initialized twice.",re);
					}
					else {
						initfields[i] = ft;
					}
					typeAssignable(ft.getType(),getType(fe.getExpr()),fe);
				}
				i++;
			}
			if(!found) {
				error("The record type "+SpecDSLErrorPrinter.toString(rectyp)+" has no field named "
						+ fe.getField().getName(),fe);
			}
		}
		
		for(int i = 0; i<initfields.length; i++) {
			if(initfields[i]==null) {
				error("Field "+rectyp.getFields().get(i).getName()+" never initialized.",re);
			}
		}
		
		NamedType nt = f.createNamedType();
		nt.setId(re.getType());
		return nt;
	}

	@Override
	public Type caseUnaryExpr(UnaryExpr ue) {
		UnaryOp uop = ue.getOp();
		Type seType = getType(ue.getExpr());

		if (isError(seType)) {
			return errorType();
		} else if (isOpArithmetic(uop)) {
			if (isTypeNumeric(seType)) {
				return seType;
			}
		} else if (isOpLogical(uop)) {
			if (isTypeLogical(seType)) {
				return seType;
			}
		}
		error("Operator " + SpecDSLErrorPrinter.toString(uop) + " not defined on arguments of type "
			+ SpecDSLErrorPrinter.toString(seType), ue);
		return errorType();
	}

	@Override
	public Type caseRealExpr(RealExpr re) {
		return f.createRealType();
	}

	@Override
	public Type caseIntExpr(IntExpr ie) {
		return f.createIntegerType();
	}

	@Override
	public Type caseBoolExpr(BoolExpr be) {
		return f.createBooleanType();
	}
	
	@Override
	public Type caseQuantificationExpr(QuantificationExpr qp) {
		if(qp instanceof SumExpr) {
			if(typeAssignable(f.createIntegerType(),getType(qp.getExpr()),qp.getExpr())) {
				return f.createIntegerType();
			}
		} else if(qp instanceof ForallExpr
				 || qp instanceof ExistsExpr) {
			if( typeAssignable(f.createBooleanType(),getType(qp.getExpr()),qp.getExpr())) {	
				return f.createBooleanType();
			}
		}
		return errorType();
	}


	@Override
	public Type caseArrayExpr(ArrayExpr o) {
		Type first = null;
		for(Expr e : o.getExprs()) {
			if(first == null) {
				first = getType(e);
			} else if( ! typeAssignable(first,getType(e),e) ) {
				error("Array elements must be of a uniform type.",e);
				return errorType();
			}
		}
		ArrayType arraytype = f.createArrayType();
		arraytype.setType(first);
		return arraytype;
	}
}
