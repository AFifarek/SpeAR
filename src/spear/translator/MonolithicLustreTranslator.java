package spear.translator;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import jkind.lustre.Node;


import spear.language.CallRef;
import spear.language.Constant;
import spear.language.Expr;
import spear.language.FnCallExpr;
import spear.language.IdExpr;
import spear.language.NamedFormula;
import spear.language.LanguageFactory;
import spear.language.NamedType;
import spear.language.Procedure;
import spear.language.Type;
import spear.language.TypeDef;
import spear.language.Utils;
import spear.language.Variable;
import spear.language.util.LanguageSwitch;


/* Translates a SPEAR specification into a monolithic Lustre Program. If there
 * are multiple nodes that require translation, they must be translated in 
 * topological order. Enforcing this translation order is not the concern of 
 * this class. This class is concerned with translating one definition/relation
 * SPEAR specification file.
 */

public class MonolithicLustreTranslator extends LanguageSwitch<jkind.lustre.Ast> implements Translator {
	
	
	private static final LanguageFactory factory = LanguageFactory.eINSTANCE;
	private static final LustreTypeTranslator transtype = new LustreTypeTranslator();
	private LustreExpressionTranslator transexpr;
	private static String requirements = NameGenerator.getVariableName("requirements", "Historical conjunction of all requirements.");
	private LinkedList<Node> nodes;
	private HashMap<String,jkind.lustre.TypeDef> types;
	private HashMap<String,jkind.lustre.Constant> constants;
	private HashMap<Procedure,LinkedList<jkind.lustre.VarDecl>> hiddenargs;
	
	public MonolithicLustreTranslator() {
		nodes = new LinkedList<Node>();
		types = new HashMap<String,jkind.lustre.TypeDef>();
		constants = new HashMap<String,jkind.lustre.Constant>();
		hiddenargs = new HashMap<Procedure,LinkedList<jkind.lustre.VarDecl>>();
		this.transexpr = new LustreExpressionTranslator();
	}
	
	private void translate(Procedure p) {
		if(hiddenargs.containsKey(p)) {
			return;
		}
		/* Collect the constants, enumeration types, and namedtypes from this procedure package. */
		for (IdExpr ie : Utils.getAllContentsOfType(p,IdExpr.class)) {
			if(ie.getId() instanceof Constant) {
				constants.put(Utils.getFQN(ie.getId()),(jkind.lustre.Constant) doSwitch(ie.getId()));
			}
		}
	
		for (NamedType nt : Utils.getAllContentsOfType(p, NamedType.class)) {
			types.put(Utils.getFQN(nt.getId()),(jkind.lustre.TypeDef)doSwitch(nt.getId()));
		}
		
		nodes.add(makeNode(p));
	}

	@Override
	public jkind.lustre.Ast caseConstant(Constant c) {
		return new jkind.lustre.Constant(Utils.getFQN(c),transtype.doSwitch(c.getType()),transexpr.doSwitch(c.getExpr()));
	}
	
	@Override
	public jkind.lustre.Ast caseTypeDef(TypeDef td) {
		return new jkind.lustre.TypeDef(Utils.getFQN(td), transtype.doSwitch(td.getType()));
	}

	private Node makeNode(Procedure procedure) {
		
		LinkedList<jkind.lustre.VarDecl> inputs = new LinkedList<jkind.lustre.VarDecl>();
		LinkedList<jkind.lustre.VarDecl> locals = new LinkedList<jkind.lustre.VarDecl>();
		LinkedList<jkind.lustre.Equation> equations = new LinkedList<jkind.lustre.Equation>();
		HashMap<FnCallExpr,jkind.lustre.VarDecl> procreturnvalvar = new HashMap<FnCallExpr,jkind.lustre.VarDecl>();
		/* 
		 * This list will collect all of the implicit requirements generated
		 * by procedure invocations. Specifically, it will collect the boolean
		 * variables that must be true for the procedure return value to be 
		 * valid.
		 */
		LinkedList<String> constraints = new LinkedList<String>();

		/* Generate a variable to for each procedure invocation to store the return value. */
		for(FnCallExpr e : Utils.getAllContentsOfType(procedure, FnCallExpr.class)) {
			CallRef cr = e.getId();
			if(!(cr instanceof Procedure)) continue;
			Procedure p = (Procedure)cr;
			Variable output = Utils.getOutput(p);
			if(output==null) continue;
			jkind.lustre.Type t = transtype.doSwitch(output.getType());
			String freshname = NameGenerator.getVariableName("Storage for return value of "+e.getId().getName());
			jkind.lustre.VarDecl vd = new jkind.lustre.VarDecl(freshname,t);
			procreturnvalvar.put(e,vd);
		}
		/* All procedure invocations will be replaced by variables. These variables
		 * will store the return value of the original procedure.
		 */
		transexpr.setFnCallExprMap(procreturnvalvar);
		
		/* All inputs, outputs, and state variables will become inputs in the translated node.
		 * How we order these in the node signature is important because we must layout parameters
		 * similarly on node invocations. The argument sequence will go as follows: inputs, outputs, state, hidden.
		 */
		
		/* Put all input variables in the order they appear in the procedure signature. */
		for(Variable va : Utils.getInputs(procedure)) {
			inputs.add(new jkind.lustre.VarDecl(va.getName(),transtype.doSwitch(va.getType())));
		}
		/* Add the output variable to the inputs. */
		Variable output = Utils.getOutput(procedure);
		if (output != null  ) {
			inputs.add(new jkind.lustre.VarDecl(output.getName(),transtype.doSwitch(output.getType())));
		}
		
		/* Add state variables and lift those fresh variables to the calling procedure signature. */
		LinkedList<jkind.lustre.VarDecl> hiddens = new LinkedList<jkind.lustre.VarDecl>();
		for(Variable va : Utils.getVariables(procedure)) {
			jkind.lustre.VarDecl vd = new jkind.lustre.VarDecl(va.getName(),transtype.doSwitch(va.getType()));
			inputs.add(vd);
			hiddens.add(vd);
		}
		
		/* Add fresh variables for function call values. */
		hiddens.addAll(procreturnvalvar.values());
		inputs.addAll(procreturnvalvar.values());
		
		
		/* 
		 * Lift all procedure invocations into their own equation.
		 */
		for(FnCallExpr e : Utils.getAllContentsOfType(procedure, FnCallExpr.class)) {
			//TODO: The information for this generated variable should also have file and line information.
			//Line information can be retrieved via NodeModelUtils.getNode(e).getStartLine().
			//I am not entirely sure how to get the file name of the input DSL file. 
			String freshname = NameGenerator.getVariableName("Ensure relation holds for invocation "+e.getId().getName());
			jkind.lustre.VarDecl vd = new jkind.lustre.VarDecl(freshname, jkind.lustre.NamedType.BOOL);
			locals.add(vd);
			constraints.add(vd.id);
			LinkedList<jkind.lustre.Expr> args = new LinkedList<jkind.lustre.Expr>();
			for(Expr exp : e.getArgs()) {
				args.add(transexpr.doSwitch(exp));
			}
			args.add(new jkind.lustre.IdExpr(procreturnvalvar.get(e).id));
			for(jkind.lustre.VarDecl vdp : hiddenargs.get(e.getId())) {
				String newnameforinput = NameGenerator.getVariableName("New name for hidden argument "+vdp.id+" from a function call of "+procedure.getName());
				jkind.lustre.VarDecl vdpn = new jkind.lustre.VarDecl(newnameforinput, vdp.type);
				inputs.add(vdpn);
				hiddens.add(vdpn);
				args.add(new jkind.lustre.IdExpr(vdpn.id));
			}
			jkind.lustre.NodeCallExpr nc = new jkind.lustre.NodeCallExpr(Utils.getFQN(e.getId()), args);
			jkind.lustre.Equation eq = new jkind.lustre.Equation(new jkind.lustre.IdExpr(vd.id), nc);
			equations.add(eq);
		}
		/*
		 * At this point we have calculated all hidden arguments. Map the list
		 * of these hidden arguments to the procedure so other calling nodes
		 * may be aware of them. 
		 */
		hiddenargs.put(procedure,hiddens);
		
		
		/*
		 * Convert all requirements to equations.
		 */
		for (NamedFormula nf : Utils.getRequirements(procedure)) {
			jkind.lustre.IdExpr id = new jkind.lustre.IdExpr(getFormulaName(nf));
			constraints.add(id.id);
			jkind.lustre.Equation eq = new jkind.lustre.Equation(id,transexpr.doSwitch(nf));
			equations.add(eq);
			locals.add(new jkind.lustre.VarDecl(getFormulaName(nf),
					jkind.lustre.NamedType.BOOL));
		}
		
		/*
		 * Convert all properties to equations and collect all of their names.
		 */
		List<String> propnames = new LinkedList<String>();
		for (NamedFormula nf : Utils.getProperties(procedure)) {
			jkind.lustre.IdExpr id = new jkind.lustre.IdExpr(getFormulaName(nf));
			jkind.lustre.IdExpr ctx = new jkind.lustre.IdExpr(requirements);
			jkind.lustre.Equation eq = new jkind.lustre.Equation(id,
					new jkind.lustre.BinaryExpr(ctx,jkind.lustre.BinaryOp.IMPLIES, transexpr.doSwitch(nf)));
			equations.add(eq);
			locals.add(new jkind.lustre.VarDecl(getFormulaName(nf),
					jkind.lustre.NamedType.BOOL));
			propnames.add(getFormulaName(nf));
		}
		
		/*
		 * Build the context equation.
		 */
		Iterator<String> it = constraints.iterator();
		if (it.hasNext()) {
			jkind.lustre.Expr ctx = null;
			ctx = new jkind.lustre.IdExpr(it.next());
			while (it.hasNext()) {
				jkind.lustre.Expr id = new jkind.lustre.IdExpr(it.next());
				ctx = new jkind.lustre.BinaryExpr(ctx,jkind.lustre.BinaryOp.AND, id);
			}
			equations.add(
					new jkind.lustre.Equation(
							new jkind.lustre.IdExpr(requirements)
							, new jkind.lustre.NodeCallExpr("H",ctx)));
		} else {
			jkind.lustre.Expr ctx = new jkind.lustre.BoolExpr(true);
			equations.add(new jkind.lustre.Equation(new jkind.lustre.IdExpr(
					requirements), ctx));
		}

		// TODO: Any operations permitted over integers are permitted over
		// sub-ranges and enumerated types. Currently, jkind will cast such 
		// operations up to integers. Therefore, we should generate properties
		// for all sub-range and enumerate types ensure their values are valid.
		

		// XXX: Because getName will return a qualified name we must replace the
		// '.''s in the name with something else. We opt to replace them with
		// '_'. There may be other issues related to the fully elaborated names.
		LinkedList<jkind.lustre.VarDecl> outputs = new LinkedList<jkind.lustre.VarDecl>();
		Variable v = factory.createVariable();
		v.setName(requirements);
		v.setType(factory.createBooleanType());
		outputs.add(new jkind.lustre.VarDecl(v.getName(), transtype.doSwitch(v.getType())));
		return new jkind.lustre.Node(Utils.getFQN(procedure), inputs,outputs, locals,
				equations, propnames, new LinkedList<jkind.lustre.Expr>());
	}
	
	private String getFormulaName(NamedFormula f) {
        return f.getName();
	}

	@Override
	public void action(Procedure p) {
		translate(p);
	}
	

	
	@Override
	public String toString() {
		jkind.lustre.visitors.PrettyPrintVisitor ppv = new jkind.lustre.visitors.PrettyPrintVisitor();
		(new jkind.lustre.Program(new LinkedList<>(types.values()),new LinkedList<>(constants.values()),nodes)).accept(ppv);
		return ppv.toString();
	}
		
}
