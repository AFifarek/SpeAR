package spear.validation;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;

import spear.language.After;
import spear.language.ArrayType;
import spear.language.Before;
import spear.language.Between;
import spear.language.BinaryExpr;
import spear.language.BinaryFormula;
import spear.language.BinaryOp;
import spear.language.Constant;
import spear.language.Divide;
import spear.language.Domain;
import spear.language.DomainExpr;
import spear.language.DomainType;
import spear.language.Enumerator;
import spear.language.EnumerationType;
import spear.language.Exponentiation;
import spear.language.Expr;
import spear.language.FnCallExpr;
import spear.language.IdExpr;
import spear.language.IntegerSubRangeType;
import spear.language.Module;
import spear.language.NamedUnit;
import spear.language.Initial;
import spear.language.Macro;
import spear.language.Multiply;
import spear.language.NamedFormula;
import spear.language.NamedType;
import spear.language.NormUnit;
import spear.language.Procedure;
import spear.language.QuantificationExpr;
import spear.language.Type;
import spear.language.TypeDef;
import spear.language.UnaryFormula;
import spear.language.UnitDef;
import spear.language.Utils;
import spear.language.Variable;
import spear.language.VariableRef;
import spear.language.While;


/**
 * All checks necessary to ensure the specification is well-formed.
 * Well-formedness is required for translation and reasoning.
 */
public class LanguageJavaValidator extends AbstractLanguageJavaValidator {

	private final TypeChecker tc = new TypeChecker(this);
	private final UnitChecker uc = new UnitChecker(this);

	private void checkAndAddToMap(TreeMap<String, EObject> s, String key, EObject e) {
		if (s.containsKey(key)) {
			EObject ee = s.get(key);
			error("Identifier " + key + " previously defined.", e);
			error("Identifier " + key + " defined multiple times in specification.", ee);
		}
		s.put(key, e);
	}

	/**
	 * Check that constants, macros, variables, properties, functions, and types
	 * all have unique names.
	 */
	@Check
	public void checkUniqueIds(Module p) {

		TreeMap<String, EObject> set = new TreeMap<String, EObject>();
		List<VariableRef> names = new BasicEList<VariableRef>();
		names.addAll((Collection<? extends VariableRef>) Utils.getConstants(p));
		names.addAll((Collection<? extends VariableRef>) Utils.getMacros(p));
		names.addAll((Collection<? extends VariableRef>) Utils.getVariables(p));
		names.addAll((Collection<? extends VariableRef>) Utils.getInputs(p));
		names.add((Variable) Utils.getOutput(p));
		for (VariableRef vr : names) {
			checkAndAddToMap(set, vr.getName(), vr);
		}
		List<NamedFormula> namedforms = new BasicEList<NamedFormula>();
		namedforms.addAll((List<? extends NamedFormula>) Utils.getProperties(p));
		namedforms.addAll((List<? extends NamedFormula>) Utils.getRequirements(p));

		for (NamedFormula nf : namedforms) {
			checkAndAddToMap(set, nf.getName(), nf);
		}
		for (TypeDef t : Utils.getTypes(p)) {
			checkAndAddToMap(set, t.getName(), t);
		}

		for (UnitDef u : Utils.getUnits(p)) {
			checkAndAddToMap(set, u.getName(), u);
		}

	}

	@Check
	public void checkEnumerationSymbolsAreUnique(Module p) {
		TreeMap<String, EObject> set = new TreeMap<String, EObject>();
		if (Utils.getTypes(p) == null) {
			return;
		}
		for (TypeDef t : Utils.getTypes(p)) {
			if (t.getType() instanceof EnumerationType) {
				EnumerationType et = (EnumerationType) t.getType();
				for (Enumerator e : et.getEnumerators()) {
					checkAndAddToMap(set, e.getName(), e);
				}
			}
		}
	}

	@Check
	public void checkConstant(Constant c) {
		if (!TypeChecker.isExprLiteral(c.getExpr())) {
			error("Constant " + c.getName()
					+ " must be assigned a value that statically computes to a literal.", c.getExpr());
		}
	}
	
	@Check
	public void checkIntegerSubRangesAreConstant(IntegerSubRangeType isr) {
		if(!(TypeChecker.isExprLiteral(isr.getLow()) && TypeChecker.isExprLiteral(isr.getHigh()))) {
			error("Upper and lower bounds must be assigned a value that statically computes to a literal.", isr);
		}
	}
	
	@Check
	public void checkArrayLengthsAreConstant(ArrayType at) {
		if(!(TypeChecker.isExprLiteral(at.getLength()))) {
			error("Array length must must be assigned a value that statically computes to a literal",at.getLength());
		}
		if(IntegerConstantSimplification.simplify(at.getLength()).compareTo(BigInteger.ZERO)<=0) {
			error("Array length must be greater zero.",at.getLength());
		}
	}

	@Check
	public void checkInitial(Initial i) {
		expectBoolean(i.getExpr());
	}
	

	/* All type checking validations go below here */
	@Check
	public void typeCheckConstant(Constant c) {
		Type decltype = c.getType();
		Type exprtype = tc.getType(c.getExpr());
		if (!tc.typeAssignable(decltype, exprtype, c)) {
			error("Expected type " + SpecDSLErrorPrinter.toString(decltype)
					+ ", but found type "
					+ SpecDSLErrorPrinter.toString(exprtype), c.getExpr());
		}

		NormUnit declunit = uc.normalize(c.getUnit());
		NormUnit exprunit = uc.doSwitch(c.getExpr());
		if (!uc.equals(declunit, exprunit, c)) {
			error("Expected unit " + SpecDSLErrorPrinter.toString(declunit)
					+ ", but found " + SpecDSLErrorPrinter.toString(exprunit),
					c.getExpr());
		}

	}

	@Check
	public void typeCheckMacro(Macro m) {
		Type decltype = m.getType();
		Type exprtype = tc.getType(m.getExpr());
		if (!tc.typeAssignable(decltype, exprtype, m)) {
			error("Expected type " + SpecDSLErrorPrinter.toString(decltype)
					+ ", but found type "
					+ SpecDSLErrorPrinter.toString(exprtype), m.getExpr());
		}

		NormUnit declunit = uc.normalize(m.getUnit());
		NormUnit exprunit = uc.doSwitch(m.getExpr());
		if (!uc.equals(declunit, exprunit, m)) {
			error("Expected unit " + SpecDSLErrorPrinter.toString(declunit)
					+ ", but found " + SpecDSLErrorPrinter.toString(exprunit),
					m.getExpr());
		}

	}

	@Check
	public void typeCheckBefore(Before b) {
		expectBoolean(b.getExpr());
		uc.doSwitch(b.getExpr());
	}

	@Check
	public void typeCheckAfter(After a) {
		expectBoolean(a.getExpr());
		uc.doSwitch(a.getExpr());
		if (a.getUntilExpr() != null) {
			expectBoolean(a.getUntilExpr());
			uc.doSwitch(a.getUntilExpr());
		}
	}

	@Check
	public void typeCheckBetween(Between b) {
		expectBoolean(b.getStart());
		expectBoolean(b.getEnd());
		uc.doSwitch(b.getStart());
		uc.doSwitch(b.getEnd());
	}

	@Check
	public void typeCheckWhile(While w) {
		expectBoolean(w.getExpr());
		uc.doSwitch(w.getExpr());
	}

	@Check
	public void typeCheckUnaryFormula(UnaryFormula uf) {
		expectBoolean(uf.getExpr());
		uc.doSwitch(uf.getExpr());
	}

	@Check
	public void typeCheckBinaryFormula(BinaryFormula bf) {
		expectBoolean(bf.getLeft());
		expectBoolean(bf.getRight());
		uc.doSwitch(bf.getLeft());
		uc.doSwitch(bf.getRight());
	}

	public void expectBoolean(Expr e) {
		Type type = tc.getType(e);
		if (!TypeChecker.isError(type)) {
			if (!TypeChecker.isTypeLogical(type)) {
				error("Expression must be a boolean value, this expression is of type "
						+ SpecDSLErrorPrinter.toString(type), e);
				return;
			}
		}
	}
	
	@Check
	public void cyclicTypeDependency(Module p) {
		// Initialize adjacency map and node to object map.
		if (Utils.getTypes(p) == null) {
			return;
		}
		Map<TypeDef, List<TypeDef>> adj = new HashMap<TypeDef, List<TypeDef>>();
		Map<TypeDef, TypeDef> id = new HashMap<TypeDef, TypeDef>();
		// Build adjacency map and node to object map.
		for (TypeDef t : Utils.getTypes(p)) {
			List<TypeDef> ts = new LinkedList<TypeDef>();
			for (NamedType n : Utils.getAllContentsOfType(t, NamedType.class)) {
				ts.add(n.getId());
			}
			adj.put(t, ts);
			id.put(t, t);
		}

		// For every node, check for cycles.
		for (Entry<TypeDef, List<TypeDef>> entry : adj.entrySet()) {
			List<TypeDef> visited = new LinkedList<TypeDef>();
			visited.add(entry.getKey());
			Utils.detectCycle(entry.getKey(), adj, id, visited, this,
					"Circular type definition.");
		}
	}

	@Check
	public void cyclicProcedureDependency(Procedure p) {
		// XXX: This procedure requires an implementation which will ensure
		// that the call graph is acyclic. 

	}
	
	@Check
	public void uniqueVariableUseInProcedureSignature(Procedure p) {
		Set<String> vars = new HashSet<String>();
		for( Variable v : Utils.getInputs(p)) {
			if(vars.contains(v.getName())) {
				error("Duplicate use of variable "+v.getName()+" in procedure signature.",p);
			}
			vars.add(v.getName());
		}
		if(vars.contains(Utils.getOutput(p).getName())) {
			error("Duplicate use of variable "+Utils.getOutput(p).getName()+" in procedure signature.",p);
		}
	}
	
	
	@Check
	public void nonLinearityCheck(BinaryExpr bexp) {
		String emsg = "Non-linearity requirement violated.";
		BinaryOp op = bexp.getOp();

		if (!(op instanceof Multiply) && !(op instanceof Divide)) {
			return;
		}
		// First we check the RHS because in the case of divide it is the
		// only side we need check.

		boolean rnonconst = false;
		EObject expr2 = bexp.getRight();
		List<IdExpr> ridexprs = Utils.getAllContentsOfType(expr2, IdExpr.class);
		List<FnCallExpr> rfncalls = Utils.getAllContentsOfType(expr2,
				FnCallExpr.class);

		if (rfncalls.size() > 0) {
			rnonconst = true;
		}
		for (IdExpr idexpr : ridexprs) {
			if (rnonconst) {
				break;
			}
			VariableRef id = idexpr.getId();
			if (id instanceof Variable || id instanceof Macro) {
				rnonconst = true;
			}
		}

		boolean isDivide = op instanceof Divide;
		// If the RHS contains a variable subexpression and the binary
		// expression
		// is a divide operation then flag the binary expression as being
		// non-linear.
		if (isDivide && rnonconst) {
			error(emsg, bexp);
			return;
		}
		// If the preceding conditional did not apply then the binary expression
		// is not a divide operation or rnonconst is false. If binary expression
		// is a divide operation then we know rnonconst is false and this
		// expression
		// must be linear. Otherwise, if rnonconst is true, then this expression
		// must be linear.
		if (isDivide || !rnonconst) {
			return;
		}

		// At this point, the RHS has a variable and the operation is multiply.
		// So we must check that the LHS does not contain a variable.

		boolean lnonconst = false;
		EObject expr1 = bexp.getLeft();
		List<IdExpr> lidexprs = Utils.getAllContentsOfType(expr1, IdExpr.class);
		List<FnCallExpr> lfncalls = Utils.getAllContentsOfType(expr1,
				FnCallExpr.class);

		if (lfncalls.size() > 0) {
			lnonconst = true;
		}
		for (IdExpr idexpr : lidexprs) {
			if (lnonconst) {
				break;
			}
			VariableRef id = idexpr.getId();
			if (id instanceof Variable || id instanceof Macro) {
				lnonconst = true;
			}
		}

		if (lnonconst) {
			error("Non-linearity requirement violated.", bexp);
		}

	}

	@SuppressWarnings("unchecked")
	@Check
	public void warnOnUnusedDefinition(Module p) {
		if(!(p instanceof Procedure)) {
			return;
		}
		UnusedComparator<EObject, IdExpr> compare = new UnusedComparator<EObject, IdExpr>() {
			@Override
			public boolean same(EObject o, IdExpr i) {
				return o == i.getId();
			}
		};
		// Warn on non-use of interface variables.
		Utils.findUnusedAndWarn(this, (List<EObject>) (List<?>) Utils
				.getAllContentsOfType(p, Variable.class), Utils
				.getAllContentsOfType(p, IdExpr.class), compare,
				"Unused variable.");
		// Warn on non-use of constants.
		Utils.findUnusedAndWarn(this, (List<EObject>) (List<?>) Utils
				.getAllContentsOfType(p, Constant.class), Utils
				.getAllContentsOfType(p, IdExpr.class), compare,
				"Unused constant.");
		// Warn on non-use of Macros.
		Utils.findUnusedAndWarn(this, (List<EObject>) (List<?>) Utils
				.getAllContentsOfType(p, Macro.class), Utils
				.getAllContentsOfType(p, IdExpr.class), compare,
				"Unused macro.");
		
		//Warn on non-use of types.
		Utils.findUnusedAndWarn(this,
				Utils.getAllContentsOfType(p, TypeDef.class),
				Utils.getAllContentsOfType(p, NamedType.class),
				new UnusedComparator<TypeDef, NamedType>() {
					@Override
					public boolean same(TypeDef v, NamedType i) {
						return v == i.getId();
					}
				}, "Unused type.");
		
		// Warn on non-use of units 
		Utils.findUnusedAndWarn(this,
						Utils.getAllContentsOfType(p, UnitDef.class),
						Utils.getAllContentsOfType(p, NamedUnit.class),
						new UnusedComparator<UnitDef, NamedUnit>() {
							@Override
							public boolean same(UnitDef v, NamedUnit i) {
								return v == i.getId();
							}
						}, "Unused unit.");
	}

	@Check
	public void cyclicConstantDependency(Module p) {
		// If there are no constants then there can be no cycles.
		if (Utils.getConstants(p) == null) {
			return;
		}
		// Initialize adjacency and node to object maps.
		Map<Constant, List<VariableRef>> adj = new HashMap<Constant, List<VariableRef>>();
		Map<VariableRef, Constant> v2c = new HashMap<VariableRef, Constant>();
		for (Constant c : Utils.getConstants(p)) {

			List<VariableRef> cs = new LinkedList<VariableRef>();
			for (IdExpr i : Utils.getAllContentsOfType(c, IdExpr.class)) {
				cs.add(i.getId());
			}
			adj.put(c, cs);
			v2c.put(c, c);
		}
		// For each node, check for a cycle beginning at that node.
		for (Entry<Constant, List<VariableRef>> entry : adj.entrySet()) {
			List<Constant> visited = new LinkedList<Constant>();
			visited.add(entry.getKey());
			Utils.detectCycle(entry.getKey(), adj, v2c, visited, this,
					"Circular constant definition.");
		}
	}

	@Check
	public void cyclicMacroDependency(Module p) {
		// If there are no macros then there can be no macro cycles.
		if (Utils.getMacros(p) == null) {
			return;
		}
		// Initialize adjacency and node to object map.
		Map<Macro, List<VariableRef>> adj = new HashMap<Macro, List<VariableRef>>();
		Map<VariableRef, Macro> v2m = new HashMap<VariableRef, Macro>();
		// Build adjacency and node to object map.
		for (Macro m : Utils.getMacros(p)) {
			List<VariableRef> ms = new LinkedList<VariableRef>();
			for (IdExpr i : Utils.getAllContentsOfType(m, IdExpr.class)) {
				ms.add(i.getId());
			}
			adj.put(m, ms);
			v2m.put(m, m);
		}
		// For every node, check for cycles.
		for (Entry<Macro, List<VariableRef>> entry : adj.entrySet()) {
			List<Macro> visited = new LinkedList<Macro>();
			visited.add(entry.getKey());
			Utils.detectCycle(entry.getKey(), adj, v2m, visited, this,
					"Circular macro definition.");
		}
	}

	@Check
	public void cyclicUnitDependency(Module p) {
		// Initialize adjacency map and node to object map.
		if (Utils.getUnits(p) == null) {
			return;
		}
		Map<UnitDef, List<UnitDef>> adj = new HashMap<UnitDef, List<UnitDef>>();
		Map<UnitDef, UnitDef> id = new HashMap<UnitDef, UnitDef>();
		// Build adjacency map and node to object map.
		for (UnitDef t : Utils.getUnits(p)) {
			List<UnitDef> ts = new LinkedList<UnitDef>();
			for (NamedUnit n : Utils.getAllContentsOfType(t, NamedUnit.class)) {
				ts.add(n.getId());
			}
			adj.put(t, ts);
			id.put(t, t);
		}

		// For every node, check for cycles.
		for (Entry<UnitDef, List<UnitDef>> entry : adj.entrySet()) {
			List<UnitDef> visited = new LinkedList<UnitDef>();
			visited.add(entry.getKey());
			Utils.detectCycle(entry.getKey(), adj, id, visited, this,
					"Circular unit definition.");
		}
	}

	@Check
	public void cyclicNamedPropertyDependency(Module p) {
		/* Get all properties that are transitions. */
		List<NamedFormula> props = new LinkedList<NamedFormula>();
		for (NamedFormula nf : Utils.getAllContentsOfType(p, NamedFormula.class)) {
			props.add(nf);
		}

		Map<EObject, List<EObject>> adj = new HashMap<EObject, List<EObject>>();
		Map<EObject, EObject> id = new HashMap<EObject, EObject>();
		// Initialize adjacency and node to object map.
		for (NamedFormula nf : props) {
			List<EObject> proprefs = new LinkedList<EObject>();
			for (IdExpr i : Utils.getAllContentsOfType(nf,IdExpr.class)) {

				if (!(i.getId() instanceof NamedFormula))
					continue;
				NamedFormula pp = (NamedFormula) i.getId();

				proprefs.add(pp);
			}
			adj.put(p, proprefs);
			id.put(p, p);
		}
		// For each node, check for a cycle beginning at that node.
		for (Entry<EObject, List<EObject>> entry : adj.entrySet()) {
			List<EObject> visited = new LinkedList<EObject>();
			visited.add(entry.getKey());
			Utils.detectCycle(entry.getKey(), adj, id, visited, this,
					"Circular property definition.");
		}
	}

	@Check
	public void uninitializedConstantUse(Module p) {
		List<IdExpr> idexprs = Utils.getAllContentsOfType(p, IdExpr.class);
		for (IdExpr i : idexprs) {
			if (i.getId() instanceof Constant
					&& ((Constant) i.getId()).getExpr() == null) {
				error("Use of unitialized constant.", i);
			}
		}
	}

	
	@Check
	public void validDomains(QuantificationExpr qp) {
		Domain dom = qp.getDomain();
		if(dom instanceof DomainExpr) {
			DomainExpr de = (DomainExpr)dom;
			Type type = TypeChecker.resolveNamedType(tc.getType(de.getDomain()));
			if(!(type instanceof ArrayType)) {
				error("Domain must be an array.",dom);
			}
		} else {
			DomainType dt = (DomainType)dom;
			Type type = dt.getDomain();
			if(!TypeChecker.isTypeFinite(type)) {
				error("Domain must be of a type that is finite.",dom);
			}
		}
	}
	
	@Check
	public void exponentiationIsConstant(BinaryExpr be) {
		if(be.getOp() instanceof Exponentiation) {
			if(TypeChecker.isExprLiteral(be.getLeft()) && TypeChecker.isExprLiteral(be.getRight())) {
				
			} else {
				error("Exponentiation only permitted over constant expressions.",be);
			}
		}
	}
	
	public void error(String message, EObject e) {
		error(message, e, null, 0);
	}

	public void warning(String message, EObject e) {
		warning(message, e, null, 0);
	}
}
