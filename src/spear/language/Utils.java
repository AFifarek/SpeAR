/*
 * Miscellaneous utility functions.
 */
package spear.language;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;

import spear.validation.LanguageJavaValidator;
import spear.validation.UnusedComparator;

public class Utils {

	private static DefaultDeclarativeQualifiedNameProvider nameprovider = new DefaultDeclarativeQualifiedNameProvider();
	

	/**
	 * Determine if a graph contains a cycles.
	 * @param node The vertex to begin with.
	 * @param adj The adjacency matrix mapping vertices to other objects.
	 * @param r2d Maps non-D class instances to a D-class instance.
	 * @param visited A list of vertices already visited.
	 * @param validator The validator class, needed to output messages.
	 * @param emsg The message to output if a cycle is encountered.
	 */
	public static <D extends EObject, R extends EObject> void detectCycle(
			D node, Map<D, List<R>> adj, Map<R, D> r2d, List<D> visited,
			LanguageJavaValidator validator, String emsg) {

		for (R r : adj.get(node)) {
			if (!r2d.containsKey(r)) {
				continue;
			}
			if (visited.contains(r2d.get(r))) {
				for (D d : visited) {
					validator.error(emsg, d);
				}
				return;
			}
			List<D> visitedp = new LinkedList<D>();
			for (D d : visited) {
				visitedp.add(d);
			}
			visitedp.add(r2d.get(r));
			detectCycle(r2d.get(r), adj, r2d, visitedp, validator, emsg);
		}
		return;
	}
	
	/**
	 * Use definitions and uses to determine if some definition is unused.
	 * @param validator The validator will be used to print warning messages.
	 * @param d The list of definitions.
	 * @param u The list of uses.
	 * @param compare An object that can test whether some use is a use of a definition.
	 * @param emsg The message to print should an unused definition found.
	 */
	public static <D extends EObject, U extends EObject> void findUnusedAndWarn(
			LanguageJavaValidator validator, List<D> d,
			List<U> u, UnusedComparator<D, U> compare, String emsg) {
		if (d == null) {
			return;
		}
		Iterator<D> iterO = d.iterator();
		List<D> unused = new BasicEList<D>();
		while (iterO.hasNext() && u != null) {
			D o = iterO.next();
			boolean found = false;
			Iterator<U> iterI = u.iterator();
			while (iterI.hasNext()) {
				U i = iterI.next();
				if (compare.same(o, i)) {
					found = true;
					break;
				}
			}
			if (!found) {
				unused.add(o);
			}
		}
		for (D e : unused) {
			validator.warning(emsg, (EObject) e);
		}
	}

	/**
	 * EcoreUtil2's getAllContentsOfType function will return a proper subset. That is
	 * it will never include the parent object. This function will include the parent
	 * object if it is of the appropriate class.
	 * @param o
	 * @param clazz
	 * @return
	 */
	public static <T extends EObject> List<T> getAllContentsOfType(EObject o,
			Class<T> clazz) {
		List<T> retval = EcoreUtil2.getAllContentsOfType(o, clazz);
		if (clazz.isInstance(o)) {
			retval.add((T) o);
		}
		return retval;
	}

	
	public static List<TypeDef> getTypes(Module p) {
		return Utils.getAllContentsOfType(p,TypeDef.class);		
	}
	
	public static List<Constant> getConstants(Module p) {
		return Utils.getAllContentsOfType(p,Constant.class);		
	}
	
	public static List<Function> getFunctions(Module p) {
		return Utils.getAllContentsOfType(p,Function.class);		
	}
	
	public static List<Variable> getVariables(Module p) {
		return (List<Variable>)getSection(p,StateSection.class);	
	}
	
	public static List<Variable> getInputs(Module p) {
		return (List<Variable>)getSection(p,InputSection.class);		
	}
	
	public static Variable getOutput(Module p) {
		List<Variable> v = (List<Variable>) Utils.getSection(p,OutputSection.class);
		if(v.size()!=1) {
			return null;
		}
		return v.get(0);	
	}
	
	public static <S extends Section> List<? extends SectionElement> getSection(Module p,Class<S> clazz) {
		List<SectionElement> els = new BasicEList<SectionElement>();
		for(Section s: p.getSections()) {
			if(!(clazz.isInstance(s))) {
				continue;
			}
			if(s.getElements().size()>0) {
				els.addAll(s.getElements());
			}
		}
		return els;
	}
	
	public static List<Expr> getAssumptions(Module p) {
		return (List<Expr>)getSection(p,AssSection.class);
	}
	
	public static List<NamedFormula> getRequirements(Module p) {
		return (List<NamedFormula>)getSection(p,DerReqSection.class);
	}
	
	public static List<NamedFormula> getProperties(Module p) {
		return (List<NamedFormula>)getSection(p,ReqSection.class);
	}
	
	public static List<Macro> getMacros(Module p) {
		return Utils.getAllContentsOfType(p,Macro.class);		
	}
	
	public static List<UnitDef> getUnits(Module p) {
		return Utils.getAllContentsOfType(p,UnitDef.class);		
	}

	public static Procedure getContainingProcedure(EObject o) {
		Procedure p = EcoreUtil2.getContainerOfType(o, Procedure.class);
		return p;
	}
	
	public static String getFQN(EObject obj) {
		return nameprovider.getFullyQualifiedName(obj).toString().replace('.','_');
	}
	
	public static QuantificationExpr getBinder(QuantifiedVariable qr) {
		QuantificationExpr qp = EcoreUtil2.getContainerOfType(qr, QuantificationExpr.class);
		if(qp==null) { 
			return null; 
		}
		if(qp.getVariable()==qr) {
			return qp;	
		}
		return null;
	}
}
