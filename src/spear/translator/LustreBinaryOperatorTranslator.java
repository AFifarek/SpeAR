package spear.translator;

import jkind.lustre.BinaryOp;
import spear.language.And;
import spear.language.Divide;
import spear.language.EqualTo;
import spear.language.GreaterThan;
import spear.language.GreaterThanEqual;
import spear.language.Implies;
import spear.language.LessThan;
import spear.language.LessThanEqual;
import spear.language.Minus;
import spear.language.Modulus;
import spear.language.Multiply;
import spear.language.NotEqual;
import spear.language.Or;
import spear.language.Plus;
import spear.language.Xor;
import spear.language.util.LanguageSwitch;

/*
 * Map binary operators to jkind binary operators.
 */
public class LustreBinaryOperatorTranslator extends
		LanguageSwitch<jkind.lustre.BinaryOp> {
	@Override
	public BinaryOp caseModulus(Modulus object) {
		return jkind.lustre.BinaryOp.MODULUS;
	}

	@Override
	public jkind.lustre.BinaryOp caseMultiply(Multiply m) {
		return jkind.lustre.BinaryOp.MULTIPLY;
	}

	@Override
	public jkind.lustre.BinaryOp caseDivide(Divide m) {
		return jkind.lustre.BinaryOp.DIVIDE;
	}

	@Override
	public jkind.lustre.BinaryOp casePlus(Plus m) {
		return jkind.lustre.BinaryOp.PLUS;
	}

	@Override
	public jkind.lustre.BinaryOp caseMinus(Minus m) {
		return jkind.lustre.BinaryOp.MINUS;
	}

	@Override
	public jkind.lustre.BinaryOp caseEqualTo(EqualTo m) {
		return jkind.lustre.BinaryOp.EQUAL;
	}

	@Override
	public jkind.lustre.BinaryOp caseNotEqual(NotEqual m) {
		return jkind.lustre.BinaryOp.NOTEQUAL;
	}

	@Override
	public jkind.lustre.BinaryOp caseGreaterThan(GreaterThan m) {
		return jkind.lustre.BinaryOp.GREATER;
	}

	@Override
	public jkind.lustre.BinaryOp caseLessThan(LessThan m) {
		return jkind.lustre.BinaryOp.LESS;
	}

	@Override
	public jkind.lustre.BinaryOp caseGreaterThanEqual(GreaterThanEqual m) {
		return jkind.lustre.BinaryOp.GREATEREQUAL;
	}

	@Override
	public jkind.lustre.BinaryOp caseLessThanEqual(LessThanEqual m) {
		return jkind.lustre.BinaryOp.LESSEQUAL;
	}

	@Override
	public jkind.lustre.BinaryOp caseAnd(And m) {
		return jkind.lustre.BinaryOp.AND;
	}

	@Override
	public jkind.lustre.BinaryOp caseOr(Or m) {
		return jkind.lustre.BinaryOp.OR;
	}

	@Override
	public jkind.lustre.BinaryOp caseXor(Xor m) {
		return jkind.lustre.BinaryOp.XOR;
	}

	@Override
	public jkind.lustre.BinaryOp caseImplies(Implies m) {
		return jkind.lustre.BinaryOp.IMPLIES;
	}

}
