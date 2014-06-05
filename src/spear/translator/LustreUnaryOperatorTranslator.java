package spear.translator;

import spear.language.Not;
import spear.language.UnaryMinus;
import spear.language.util.LanguageSwitch;

/**
 * Convert specification unary operators to jkind lustre AST unary operators.
 */
public class LustreUnaryOperatorTranslator extends
		LanguageSwitch<jkind.lustre.UnaryOp> {
	@Override
	public jkind.lustre.UnaryOp caseUnaryMinus(UnaryMinus o) {
		return jkind.lustre.UnaryOp.NEGATIVE;
	}

	@Override
	public jkind.lustre.UnaryOp caseNot(Not o) {
		return jkind.lustre.UnaryOp.NOT;
	}
}
