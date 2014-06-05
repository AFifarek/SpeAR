package spear.validation;

import org.eclipse.emf.ecore.EObject;

import spear.language.BinaryExpr;
import spear.language.Constant;
import spear.language.Divide;
import spear.language.IdExpr;
import spear.language.Minus;
import spear.language.Multiply;
import spear.language.Plus;
import spear.language.RealExpr;
import spear.language.UnaryExpr;
import spear.language.UnaryMinus;
import spear.language.util.LanguageSwitch;

public class RealConstantFolder extends LanguageSwitch<Double> {

	private static RealConstantFolder COMPUTE = new RealConstantFolder();
	
	public static Double compute(EObject o) {
		return COMPUTE.doSwitch(o);
	}

	@Override
	public Double caseBinaryExpr(BinaryExpr be) {
		Double lv = doSwitch(be.getLeft());
		Double rv = doSwitch(be.getRight());
		if (lv == null || rv == null) {
			return null;
		}
		if (be.getOp() instanceof Multiply) {
			return lv * rv;
		} else if (be.getOp() instanceof Plus) {
			return lv + rv;
		} else if (be.getOp() instanceof Minus) {
			return lv - rv;
		} else if (be.getOp() instanceof Divide) {
			return lv / rv;
		} else {
			/* TODO: Some kind of indication should be given that we just encountered a
			 * binary operator that is not handled.
			 */
			return null;
		}
	}

	@Override
	public Double caseRealExpr(RealExpr ie) {
		return new Double(ie.getValue());
	}

	@Override
	public Double caseIdExpr(IdExpr id) {
		return doSwitch(id.getId());
	}

	@Override
	public Double caseConstant(Constant c) {
		return doSwitch(c.getExpr());
	}

	@Override
	public Double caseUnaryExpr(UnaryExpr ue) {
		Double val = doSwitch(ue.getExpr());
		if (ue.getOp() instanceof UnaryMinus && val!=null) {
			return -1 * val;
		} else {
			/* TODO: Some kind of indication should be given that we just encountered a
			 * unary operator that is not handled.
			 */
			return null;
		}
	}

}
