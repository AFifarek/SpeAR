package spear.translator;

import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.visitors.ExprMapVisitor;

public class QuantifiedVariableReplacementVisitor extends ExprMapVisitor {
	
	private String quantifiedvariable;
	private jkind.lustre.Expr replacementexpr;
	
	QuantifiedVariableReplacementVisitor(String quantifiedvariable, jkind.lustre.Expr replacementexpr) {
		this.quantifiedvariable = quantifiedvariable;
		this.replacementexpr = replacementexpr;
	}
	
	@Override
	public Expr visit(IdExpr e) {
		if(e.id.equals(this.quantifiedvariable)) {
			return this.replacementexpr;
		}
		else {
			return super.visit(e);
		}	
	}

	
}
