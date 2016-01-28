package com.rockwellcollins.spear.units;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.rockwellcollins.spear.AfterUntilExpr;
import com.rockwellcollins.spear.ArrayAccessExpr;
import com.rockwellcollins.spear.ArrayExpr;
import com.rockwellcollins.spear.ArrayType;
import com.rockwellcollins.spear.ArrayUpdateExpr;
import com.rockwellcollins.spear.BaseUnit;
import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.BinaryUnitExpr;
import com.rockwellcollins.spear.BoolLiteral;
import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.DerivedUnit;
import com.rockwellcollins.spear.EnumType;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.IfThenElseExpr;
import com.rockwellcollins.spear.IntLiteral;
import com.rockwellcollins.spear.MIdExpr;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.NamedType;
import com.rockwellcollins.spear.NamedUnitExpr;
import com.rockwellcollins.spear.PatternCall;
import com.rockwellcollins.spear.PreviousExpr;
import com.rockwellcollins.spear.RealLiteral;
import com.rockwellcollins.spear.RecordAccessExpr;
import com.rockwellcollins.spear.RecordExpr;
import com.rockwellcollins.spear.RecordFieldExpr;
import com.rockwellcollins.spear.RecordType;
import com.rockwellcollins.spear.RecordTypeField;
import com.rockwellcollins.spear.RecordUpdateExpr;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.SpecificationCall;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.WhileExpr;
import com.rockwellcollins.spear.util.SpearSwitch;

public class UnitChecker extends SpearSwitch<SpearUnit> {

	final private ValidationMessageAcceptor messageAcceptor;

	public UnitChecker(ValidationMessageAcceptor messageAcceptor) {
		this.messageAcceptor = messageAcceptor;
	}

	private static final SpearUnit ERROR = new Error();
	private static final SpearUnit SCALAR = new Scalar();

	/***************************************************************************************************/
	// Checks
	/***************************************************************************************************/
	public void checkNamedType(NamedType nt) {
		doSwitch(nt);
	}

	public void checkConstant(Constant c) {
		SpearUnit declared = doSwitch(c.getType());
		SpearUnit expressed = doSwitch(c.getExpr());

		if (declared == ERROR || expressed == ERROR) {
			return;
		}

		if (!declared.equals(expressed)) {
			error("Expected unit " + declared + ", " + "but received " + expressed, c.getExpr());
		}
	}

	public void checkMacro(Macro m) {
		SpearUnit declared = doSwitch(m.getType());
		SpearUnit expressed = doSwitch(m.getExpr());

		if (declared == ERROR || expressed == ERROR) {
			return;
		}

		if (!declared.equals(expressed)) {
			error("Expected unit " + declared + ", " + "but received " + expressed, m);
		}
	}

	public void checkFormalConstraint(FormalConstraint fc) {
		doSwitch(fc.getExpr());
	}

	/***************************************************************************************************/
	// Declarations
	/***************************************************************************************************/
	@Override
	public SpearUnit caseConstant(Constant c) {
		return doSwitch(c.getType());
	}

	@Override
	public SpearUnit caseMacro(Macro m) {
		return doSwitch(m.getType());
	}

	@Override
	public SpearUnit caseVariable(Variable v) {
		return doSwitch(v.getType());
	}

	/***************************************************************************************************/
	// UnitDefs
	/***************************************************************************************************/
	@Override
	public SpearUnit caseBaseUnit(BaseUnit base) {
		Map<String, Integer> map = new HashMap<>();
		map.put(base.getName(), 1);
		return new ComputedUnit(map);
	}

	@Override
	public SpearUnit caseDerivedUnit(DerivedUnit derived) {
		return doSwitch(derived.getUnit());
	}

	/***************************************************************************************************/
	// UnitExprs
	/***************************************************************************************************/
	@Override
	public SpearUnit caseBinaryUnitExpr(BinaryUnitExpr bue) {
		SpearUnit left = doSwitch(bue.getLeft());
		SpearUnit right = doSwitch(bue.getRight());

		if (left == ERROR || right == ERROR) {
			return ERROR;
		}

		switch (bue.getOp()) {
		case "*":
			if (left == SCALAR && right == SCALAR) {
				return SCALAR;
			}

			if (left instanceof ComputedUnit && right instanceof ComputedUnit) {
				ComputedUnit leftUnit = (ComputedUnit) left;
				ComputedUnit rightUnit = (ComputedUnit) right;
				return leftUnit.multiply(rightUnit);
			}
			break;

		case "/":
			if (left == SCALAR && right == SCALAR) {
				return SCALAR;
			}

			if (left instanceof ComputedUnit && right instanceof ComputedUnit) {
				ComputedUnit leftUnit = (ComputedUnit) left;
				ComputedUnit rightUnit = (ComputedUnit) right;
				return leftUnit.divide(rightUnit);
			}
			break;
		}

		error("Units " + left + ", " + right + " do not agree.", bue);
		return ERROR;
	}

	@Override
	public SpearUnit caseNamedUnitExpr(NamedUnitExpr nue) {
		return doSwitch(nue.getUnit());
	}

	/***************************************************************************************************/
	// TypeDefs
	/***************************************************************************************************/
	@Override
	public SpearUnit caseNamedType(NamedType nt) {
		if (nt.getUnit() == null) {
			return SCALAR;
		} else {
			return doSwitch(nt.getUnit());
		}
	}

	@Override
	public SpearUnit caseRecordType(RecordType rt) {
		Map<String,SpearUnit> fields = new HashMap<>();
		for(RecordTypeField rtf : rt.getFields()) {
			fields.put(rtf.getName(), doSwitch(rtf.getType()));
		}
		return new RecordUnit(rt.getName(),fields);
	}
	
	@Override
	public ArrayUnit caseArrayType(ArrayType at) {
		return new ArrayUnit(at.getName(),doSwitch(at.getBase()),at.getSize());
	}

	@Override
	public SpearUnit caseEnumType(EnumType enumtype) {
		return new EnumUnit(enumtype.getName());
	}

	/***************************************************************************************************/
	// Types
	/***************************************************************************************************/
	@Override
	public SpearUnit caseUserType(UserType ut) {
		return doSwitch(ut.getDef());
	}
	
	@Override
	public SpearUnit caseType(Type t) {
		return SCALAR;
	}

	/***************************************************************************************************/
	// Expressions
	/***************************************************************************************************/

	@Override
	public SpearUnit caseBinaryExpr(BinaryExpr be) {
		SpearUnit left = doSwitch(be.getLeft());
		SpearUnit right = doSwitch(be.getRight());

		if (left == ERROR || right == ERROR) {
			return ERROR;
		}

		if (left == SCALAR && right == SCALAR) {
			return SCALAR;
		}

		switch (be.getOp()) {
		case "+":
		case "-":
			if (left.equals(right)) {
				return left;
			}
			break;

		case "*":
		case "/":
			if (left instanceof ComputedUnit) {
				ComputedUnit leftUnit = (ComputedUnit) left;
				if (right instanceof ComputedUnit) {
					ComputedUnit rightUnit = (ComputedUnit) right;
					if (be.getOp().equals("*")) {
						return leftUnit.multiply(rightUnit);
					} else {
						return leftUnit.divide(rightUnit);
					}
				}

				if (right == SCALAR) {
					return leftUnit;
				}
			}

			if (left == SCALAR) {
				if (right instanceof ComputedUnit) {
					ComputedUnit rightUnit = (ComputedUnit) right;
					return rightUnit;
				}
			}
			break;

		case "==":
		case "equal to":
		case "<>":
		case "not equal to":
		case ">":
		case "greater than":
		case ">=":
		case "greater than or equal to":
		case "<":
		case "less than":
		case "<=":
		case "less than or equal to":
			if (left.equals(right)) {
				return SCALAR;
			}
			break;

		case "or":
		case "xor":
		case "and":
		case "implies":
		case "=>":
		case "triggers":
		case "T":
		case "since":
		case "S":
			if (left == SCALAR && right == SCALAR) {
				return SCALAR;
			}
			break;
		}

		error("Operator '" + be.getOp() + "' not defined on units " + left + ", " + right, be);
		return ERROR;
	}

	@Override
	public SpearUnit caseUnaryExpr(UnaryExpr ue) {
		SpearUnit unit = doSwitch(ue.getExpr());

		if (unit == ERROR) {
			return ERROR;
		}

		switch (ue.getOp()) {

		case "-":
			return unit;

		case "not":
		case "once":
		case "O":
		case "historically":
		case "H":
		case "initially":
		//the following ops are syntactic sugar
		case "never":
		case "before":
			if (unit == SCALAR) {
				return SCALAR;
			}
			break;
		}

		error("Operator '" + ue.getOp() + "' not defined on unit " + unit, ue);
		return ERROR;
	}

	@Override
	public SpearUnit caseRecordAccessExpr(RecordAccessExpr rae) {
		SpearUnit record = doSwitch(rae.getRecord());
		if(record == ERROR) {
			return ERROR;
		}
		
		if (record instanceof RecordUnit) {
			RecordUnit recordUnit = (RecordUnit) record;
			return recordUnit.fields.get(rae.getField().getName());
		}
		
		error("Expected record unit but found " + record,rae.getRecord());
		return ERROR;
	}
	
	@Override
	public SpearUnit caseRecordUpdateExpr(RecordUpdateExpr rue) {
		SpearUnit record = doSwitch(rue.getRecord());
		SpearUnit value = doSwitch(rue.getValue());
		
		if(record == ERROR || value == ERROR) {
			return ERROR;
		}
		
		if (record instanceof RecordUnit) {
			RecordUnit recordUnit = (RecordUnit) record;
			SpearUnit fieldUnit = recordUnit.fields.get(rue.getField().getName());
			if(!fieldUnit.equals(value)) {
				error("RecordField expected unit " + fieldUnit + ", but received " + value, rue);
				return ERROR;
			} else {
				return record;
			}
		} else {
			error("Expected record unit but found " + record, rue.getRecord());
			return ERROR;
		}
	}
	
	@Override
	public SpearUnit caseRecordExpr(RecordExpr re) {
		Map<String,SpearUnit> fields = new HashMap<>();
		for(RecordFieldExpr rfe : re.getFieldExprs()) {
			fields.put(rfe.getName(), doSwitch(rfe.getExpr()));
		}
		
		return new RecordUnit(re.getType().getName(),fields);
	}
	
	@Override
	public SpearUnit caseArrayAccessExpr(ArrayAccessExpr aae) {
		SpearUnit array = doSwitch(aae.getArray());
		
		if(array == ERROR) {
			return ERROR;
		}
		
		if (array instanceof ArrayUnit) {
			ArrayUnit arrayUnit = (ArrayUnit) array;
			return arrayUnit.base;
		}
		
		error("Expected array of units but " + array + " was provided instead", aae.getArray(), null);
		return ERROR;
	}
	
	@Override
	public SpearUnit caseArrayUpdateExpr(ArrayUpdateExpr aue) {
		SpearUnit array = doSwitch(aue.getAccess().getArray());
		SpearUnit value = doSwitch(aue.getValue());
		
		if(array == ERROR || value == ERROR) {
			return ERROR;
		}
		
		if (array instanceof ArrayUnit) {
			ArrayUnit arrayUnit = (ArrayUnit) array;
			if(!arrayUnit.base.equals(value)) {
				error("Array update unit is " + value + ", but array expects " + arrayUnit.base, aue, SpearPackage.Literals.ARRAY_UPDATE_EXPR__VALUE);
				return ERROR;
			} else {
				return array;
			}
		}
		error("Expected array, but received " + array, aue, null);
		return ERROR;
	}
	
	@Override
	public SpearUnit caseArrayExpr(ArrayExpr array) {
		SpearUnit expected = doSwitch(array.getType());
		if(expected == ERROR) {
			return ERROR;
		}
		
		if (expected instanceof ArrayUnit) {
			ArrayUnit arrayUnit = (ArrayUnit) expected;
			boolean error = false;
			for(int i=0; i<array.getExprs().size(); i++) {
				SpearUnit current = doSwitch(array.getExprs().get(i));
				if(!arrayUnit.base.equals(current)) {
					error("Expected unit " + arrayUnit.base + ", but received " + current, array, SpearPackage.Literals.ARRAY_EXPR__EXPRS, i);
					error=true;
				}
			}
			if(error) {
				return ERROR;
			} else {
				return arrayUnit;				
			}
		}
		
		error("Expected an array of units but received " + expected, array);
		return ERROR;
	}
	
	@Override
	public SpearUnit caseIdExpr(IdExpr ide) {
		return doSwitch(ide.getId());
	}

	@Override
	public SpearUnit caseMIdExpr(MIdExpr mide) {
		List<SpearUnit> units = new ArrayList<>();
		for (IdRef idr : mide.getIds()) {
			units.add(doSwitch(idr));
		}
		return compressTuple(new TupleUnit(units));
	}

	@Override
	public SpearUnit casePreviousExpr(PreviousExpr prev) {
		SpearUnit init = doSwitch(prev.getInit());
		SpearUnit var = doSwitch(prev.getVar());

		if (init == ERROR || var == ERROR) {
			return ERROR;
		}

		if (init.equals(var)) {
			return var;
		}

		error("Previous has variable unit of " + var + ", but initial expression has unit of " + init, prev);
		return ERROR;
	}

	@Override
	public SpearUnit caseIfThenElseExpr(IfThenElseExpr ite) {
		SpearUnit testUnit = doSwitch(ite.getCond());
		SpearUnit thenUnit = doSwitch(ite.getThen());
		
		if(ite.getElse() == null) {
			return thenUnit;
		}
		
		SpearUnit elseUnit = doSwitch(ite.getElse());
		
		if(thenUnit == ERROR || elseUnit == ERROR) {
			return ERROR;
		}
		
		if(testUnit != SCALAR) {
			error("Condition of If-Then-Else must be scalar.",ite,SpearPackage.Literals.IF_THEN_ELSE_EXPR__COND);
		}
		
		if(thenUnit.equals(elseUnit)) {
			return thenUnit;
		}
		
		error("Then branch of If-Then-Else has units " + thenUnit + ", but else branch has units " + elseUnit, ite, null);
		return ERROR;
	}
	
	@Override
	public SpearUnit caseAfterUntilExpr(AfterUntilExpr afe) {
		SpearUnit afterUnit = doSwitch(afe.getAfter());
		if(afterUnit != SCALAR) {
			error("After expressions must have scalar units.",afe.getAfter(),null);
		}
		
		if(afe.getUntil() != null) {
			SpearUnit untilUnit = doSwitch(afe.getUntil());
			if(untilUnit != SCALAR) {
				error("Until expressions must have scalar units.",afe.getUntil(),null);
			}
		}
		return SCALAR;
	}
	
	@Override
	public SpearUnit caseWhileExpr(WhileExpr wh) {
		SpearUnit cond = doSwitch(wh.getCond());
		SpearUnit then = doSwitch(wh.getThen());
		
		if(cond != SCALAR) {
			error("While expressions must have scalar units.", wh.getCond(), null);
			return ERROR;
		}
		
		if(then != SCALAR) {
			error("Then expression smust have scalar units.", wh.getThen(), null);
			return ERROR;
		}
		
		return SCALAR;
	}
	
	@Override
	public SpearUnit caseSpecificationCall(SpecificationCall sc) {
		List<SpearUnit> input_units = new ArrayList<>();
		for (Variable v : sc.getSpec().getInputs()) {
			input_units.add(doSwitch(v));
		}
		TupleUnit inputs = new TupleUnit(input_units);

		List<SpearUnit> arg_units = new ArrayList<>();
		for (Expr e : sc.getArgs()) {
			arg_units.add(doSwitch(e));
		}
		TupleUnit args = new TupleUnit(arg_units);

		if (inputs.units.size() != args.units.size()) {
			error("Specification call arguments units " + args + " do not match specifications units " + inputs, sc,
					SpearPackage.Literals.SPECIFICATION_CALL__ARGS);
		} else {
			for (int i = 0; i < input_units.size(); i++) {
				if (!inputs.units.get(i).equals(args.units.get(i))) {
					error("Specification " + sc.getSpec().getName() + " requires units " + inputs.units.get(i)
							+ ", but is provided " + args.units.get(i) + " for argument " + i + ".", sc,
							SpearPackage.Literals.SPECIFICATION_CALL__ARGS, i);
				}
			}
		}

		List<SpearUnit> output_units = new ArrayList<>();
		for (Variable v : sc.getSpec().getOutputs()) {
			output_units.add(doSwitch(v));
		}
		return compressTuple(new TupleUnit(output_units));
	}
	
	@Override
	public SpearUnit casePatternCall(PatternCall pc) {
		return ERROR;
	}

	@Override
	public SpearUnit caseRealLiteral(RealLiteral rle) {
		if (rle.getUnit() != null) {
			return doSwitch(rle.getUnit());
		} else {
			return SCALAR;
		}
	}

	@Override
	public SpearUnit caseIntLiteral(IntLiteral ile) {
		if (ile.getUnit() != null) {
			return doSwitch(ile.getUnit());
		} else {
			return SCALAR;
		}
	}
	
	@Override
	public SpearUnit caseBoolLiteral(BoolLiteral ble) {
		return SCALAR;
	}

	@Override
	public SpearUnit caseEnumValue(EnumValue ev) {
		return doSwitch(ev.eContainer());
	}
	
	// TODO: remove this.
	@Override
	public SpearUnit caseExpr(Expr e) {
		warning("Unit Checker not implemented for " + e, e);
		return SCALAR;
	}

	/***************************************************************************************************/
	// Error Functions
	/***************************************************************************************************/
	private void error(String message, EObject e, EStructuralFeature feature) {
		messageAcceptor.acceptError(message, e, feature, 0, null);
	}

	private void error(String message, EObject e, EStructuralFeature feature, int index) {
		messageAcceptor.acceptError(message, e, feature, index, null);
	}

	private void error(String message, EObject e) {
		messageAcceptor.acceptError(message, e, null, 0, null);
	}

	private void warning(String message, EObject e) {
		messageAcceptor.acceptWarning(message, e, null, 0, null);
	}

	private SpearUnit compressTuple(TupleUnit tupleUnit) {
		if (tupleUnit.units.size() == 1) {
			return tupleUnit.units.get(0);
		} else {
			return tupleUnit;
		}
	}
}
