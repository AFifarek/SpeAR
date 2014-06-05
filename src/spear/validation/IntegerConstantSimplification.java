//TODO: Spear should support general expression simplification of integer constant
// simplification would be one part of.
package spear.validation;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;

import spear.language.BinaryExpr;
import spear.language.Constant;
import spear.language.Divide;
import spear.language.Exponentiation;
import spear.language.IdExpr;
import spear.language.IntExpr;
import spear.language.Minus;
import spear.language.Modulus;
import spear.language.Multiply;
import spear.language.Plus;
import spear.language.UnaryExpr;
import spear.language.UnaryMinus;
import spear.language.util.LanguageSwitch;

public class IntegerConstantSimplification extends LanguageSwitch<BigInteger> {

	private static IntegerConstantSimplification COMPUTE = new IntegerConstantSimplification();
	
	public static BigInteger simplify(EObject o) {
		return COMPUTE.doSwitch(o);
	}

	//http://www.coderanch.com/t/374311/java/java/BigInteger-exponents
    private BigInteger pow(BigInteger mantissa, BigInteger exponent) {  
        if(exponent.equals(BigInteger.ONE)) return mantissa;  
        if(exponent.testBit(0)) {  
            return mantissa.multiply(pow(mantissa,exponent.subtract(BigInteger.ONE)));  
        }  
        BigInteger tmp = pow(mantissa,exponent.shiftRight(1));  
        return tmp.multiply(tmp);  
    } 
	@Override
	public BigInteger caseBinaryExpr(BinaryExpr be) {
		BigInteger lv = doSwitch(be.getLeft());
		BigInteger rv = doSwitch(be.getRight());
		if(be.getOp() instanceof Multiply) {
			return lv.multiply(rv);
		} else if (be.getOp() instanceof Divide) {
			return lv.divide(rv);
		} else if (be.getOp() instanceof Plus) {
			return lv.add(rv);
		} else if (be.getOp() instanceof Minus) {
			return lv.subtract(rv);
		} else if (be.getOp() instanceof Modulus) {
			return lv.mod(rv);
		} else if (be.getOp() instanceof Exponentiation) {
			return pow(lv,rv);
		} else {
			return null;
		}
	}

	@Override
	public BigInteger caseIntExpr(IntExpr ie) {
		return BigInteger.valueOf(((IntExpr)ie).getValue());
	}

	@Override
	public BigInteger caseIdExpr(IdExpr id) {
		return doSwitch(id.getId());
	}

	@Override
	public BigInteger caseConstant(Constant c) {
		return doSwitch(c.getExpr());
	}

	@Override
	public BigInteger caseUnaryExpr(UnaryExpr ue) {
		BigInteger val = doSwitch(ue.getExpr());
		if (ue.getOp() instanceof UnaryMinus & val != null) {
			return val.negate();
		} else {
			/* TODO: Some kind of indication should be given that we just encountered a
			 * unary operator that is not handled.
			 */
			return null;
		}
	}

}
