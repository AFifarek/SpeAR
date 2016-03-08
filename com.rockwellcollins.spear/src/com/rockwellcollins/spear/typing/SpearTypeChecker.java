package com.rockwellcollins.spear.typing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.rockwellcollins.spear.AfterUntilExpr;
import com.rockwellcollins.spear.ArrayAccessExpr;
import com.rockwellcollins.spear.ArrayExpr;
import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.ArrayUpdateExpr;
import com.rockwellcollins.spear.BinaryExpr;
import com.rockwellcollins.spear.BoolLiteral;
import com.rockwellcollins.spear.BoolType;
import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FieldExpr;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.FieldlessRecordExpr;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.IfThenElseExpr;
import com.rockwellcollins.spear.IntLiteral;
import com.rockwellcollins.spear.IntType;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.MultipleIdExpr;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.PatternCall;
import com.rockwellcollins.spear.PreviousExpr;
import com.rockwellcollins.spear.RealLiteral;
import com.rockwellcollins.spear.RealType;
import com.rockwellcollins.spear.RecordAccessExpr;
import com.rockwellcollins.spear.RecordExpr;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.RecordUpdateExpr;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.SpecificationCall;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.UnaryExpr;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.WhileExpr;
import com.rockwellcollins.spear.util.SpearSwitch;

public class SpearTypeChecker extends SpearSwitch<SpearType> {

	public static SpearType typeCheck(EObject o) {
		SpearTypeChecker typecheck = new SpearTypeChecker();
		return typecheck.doSwitch(o);
	}

	final private ValidationMessageAcceptor messageAcceptor;

	public SpearTypeChecker() {
		this.messageAcceptor = null;
	}

	public SpearTypeChecker(ValidationMessageAcceptor messageAcceptor) {
		this.messageAcceptor = messageAcceptor;
	}

	public static final SpearType ERROR = SpearBuiltinType.ERROR;
	public static final SpearType BOOL = SpearBuiltinType.BOOL;
	public static final SpearType INT = SpearBuiltinType.INT;
	public static final SpearType REAL = SpearBuiltinType.REAL;

	/***************************************************************************************************/
	// Checks
	/***************************************************************************************************/
	public SpearType checkNamedType(NamedTypeDef nt) {
		return doSwitch(nt);
	}

	public boolean checkConstant(Constant c) {
		return expectAssignableType(doSwitch(c.getType()), c.getExpr());
	}

	public boolean checkMacro(Macro m) {
		return expectAssignableType(doSwitch(m.getType()), m.getExpr());
	}

	public boolean checkFormalConstraint(FormalConstraint fc) {
		return expectAssignableType(BOOL, fc.getExpr());
	}

	/***************************************************************************************************/
	// TYPES
	/***************************************************************************************************/

	@Override
	public SpearType caseNamedTypeDef(NamedTypeDef nt) {
		return doSwitch(nt.getType());
	}

	@Override
	public SpearType caseRecordTypeDef(RecordTypeDef rt) {
		if (rt.getName() == null) {
			return ERROR;
		}

		Map<String, SpearType> fields = new LinkedHashMap<>();
		for (FieldType rtf : rt.getFields()) {
			fields.put(rtf.getName(), doSwitch(rtf.getType()));
		}
		return new SpearRecordType(rt.getName(), fields);
	}

	@Override
	public SpearType caseArrayTypeDef(ArrayTypeDef at) {
		if (at.getName() == null) {
			return ERROR;
		}

		return new SpearArrayType(at.getName(), doSwitch(at.getBase()), at.getSize());
	}

	@Override
	public SpearType caseEnumTypeDef(EnumTypeDef et) {
		if (et.getName() == null) {
			return ERROR;
		}

		List<String> values = new ArrayList<>();
		for (EnumValue ev : et.getValues()) {
			values.add(ev.getName());
		}
		return new SpearEnumType(et.getName(), values);
	}

	public final Deque<TypeDef> stack = new ArrayDeque<>();

	@Override
	public SpearType caseUserType(UserType ut) {
		if (stack.contains(ut.getDef())) {
			return ERROR;
		}

		stack.push(ut.getDef());
		SpearType type = doSwitch(ut.getDef());
		stack.pop();
		return type;
	}

	@Override
	public SpearType caseBoolType(BoolType bt) {
		return BOOL;
	}

	@Override
	public SpearType caseRealType(RealType rt) {
		return REAL;
	}

	@Override
	public SpearType caseIntType(IntType it) {
		return INT;
	}

	/***************************************************************************************************/
	// DECLARATIONS
	/***************************************************************************************************/
	@Override
	public SpearType caseVariable(Variable v) {
		return doSwitch(v.getType());
	}

	@Override
	public SpearType caseConstant(Constant c) {
		return doSwitch(c.getType());
	}

	@Override
	public SpearType caseMacro(Macro m) {
		return doSwitch(m.getType());
	}

	/***************************************************************************************************/
	// EXPRESSIONS
	/***************************************************************************************************/

	@Override
	public SpearType caseBinaryExpr(BinaryExpr be) {
		SpearType left = doSwitch(be.getLeft());
		SpearType right = doSwitch(be.getRight());

		if (left == ERROR || right == ERROR) {
			return ERROR;
		}

		switch (be.getOp()) {
		case "+":
		case "-":
		case "*":
		case "/":
			if (left == REAL && right == REAL) {
				return REAL;
			}

			if (left == INT && right == INT) {
				return INT;
			}
			break;

		case "mod":
			if (left == INT && right == INT) {
				return INT;
			}
			break;

		case "==":
		case "equal to":
		case "<>":
		case "not equal to":
			if (left.equals(right)) {
				return BOOL;
			}
			break;

		case ">":
		case "greater than":
		case "<":
		case "less than":
		case ">=":
		case "greater than or equal to":
		case "<=":
		case "less than or equal to":
			if (left == REAL && right == REAL) {
				return BOOL;
			}

			if (left == INT && right == INT) {
				return BOOL;
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
			if (left == BOOL && right == BOOL) {
				return BOOL;
			}
			break;
		}

		error("Operator '" + be.getOp() + "' not defined on types " + left + ", " + right, be);
		return ERROR;
	}

	@Override
	public SpearType caseUnaryExpr(UnaryExpr ue) {
		SpearType type = doSwitch(ue.getExpr());
		if (type == ERROR) {
			return ERROR;
		}

		switch (ue.getOp()) {
		case "-":
			if (type == INT) {
				return INT;
			}

			if (type == REAL) {
				return REAL;
			}
			break;

		case "not":
		case "once":
		case "O":
		case "historically":
		case "H":
		case "initially":
			// the following ops are syntactic sugar
		case "never":
		case "before":
			if (type == BOOL) {
				return BOOL;
			}
			break;
		}

		error("Operator '" + ue.getOp() + "' not defined on type " + type, ue);
		return ERROR;
	}

	@Override
	public SpearType caseRecordAccessExpr(RecordAccessExpr rae) {
		SpearType type = doSwitch(rae.getRecord());
		if (type == ERROR) {
			return ERROR;
		}

		if (type instanceof SpearRecordType) {
			SpearRecordType recordType = (SpearRecordType) type;
			return recordType.fields.get(rae.getField().getName());
		} else {
			error("Expected record type, but found " + type, rae.getRecord());
			return ERROR;
		}
	}

	@Override
	public SpearType caseRecordUpdateExpr(RecordUpdateExpr rue) {
		SpearType type = doSwitch(rue.getRecord());

		if (type == ERROR) {
			return ERROR;
		}

		if (type instanceof SpearRecordType) {
			SpearRecordType recordType = (SpearRecordType) type;
			SpearType fieldType = recordType.fields.get(rue.getField().getName());
			expectAssignableType(fieldType, rue.getValue());
			return recordType;
		} else {
			error("Expected record type, but found " + type, rue.getRecord());
			return ERROR;
		}
	}

	@Override
	public SpearType caseRecordExpr(RecordExpr re) {
		Map<String, Expr> fields = new LinkedHashMap<>();
		for (FieldExpr fe : re.getFieldExprs()) {
			fields.put(fe.getField().getName(), fe.getExpr());
		}

		SpearType result = doSwitch(re.getType());
		if (!(result instanceof SpearRecordType)) {
			return ERROR;
		}
		SpearRecordType expectedRecord = (SpearRecordType) result;

		for (Entry<String, SpearType> entry : expectedRecord.fields.entrySet()) {
			String expectedField = entry.getKey();
			SpearType expectedType = entry.getValue();

			if (!fields.containsKey(expectedField)) {
				error("Missing field " + expectedField, re, SpearPackage.Literals.RECORD_EXPR__TYPE);
			} else {
				Expr actualExpr = fields.get(expectedField);
				expectAssignableType(expectedType, actualExpr);
			}
		}

		return result;
	}

	@Override
	public SpearType caseFieldlessRecordExpr(FieldlessRecordExpr re) {
		Map<String, Expr> fields = new LinkedHashMap<>();
		if (re.getExprs().size() == re.getType().getFields().size()) {
			for (int i = 0; i < re.getExprs().size(); i++) {
				Expr actual = re.getExprs().get(i);
				fields.put(re.getType().getFields().get(i).getName(), actual);
			}
		} else {
			error("Record shorthand was " + re.getExprs().size() + " elements, expected "
					+ re.getType().getFields().size(), re, null);
			return ERROR;
		}

		SpearType result = this.doSwitch(re.getType());
		SpearRecordType expectedRecord = (SpearRecordType) result;
		for (Entry<String, SpearType> entry : expectedRecord.fields.entrySet()) {
			String expectedField = entry.getKey();
			SpearType expectedType = entry.getValue();

			if (!fields.containsKey(expectedField)) {
				error("Missing field " + expectedField, re, SpearPackage.Literals.RECORD_EXPR__TYPE);
			} else {
				Expr actualExpr = fields.get(expectedField);
				expectAssignableType(expectedType, actualExpr);
			}
		}
		return result;
	}

	@Override
	public SpearType caseArrayAccessExpr(ArrayAccessExpr aae) {
		SpearType type = doSwitch(aae.getArray());
		if (type == ERROR) {
			return ERROR;
		}

		SpearType indexType = doSwitch(aae.getIndex());
		if (indexType != INT) {
			error("Expected type int, but found " + indexType, aae.getIndex());
		}

		if (type instanceof SpearArrayType) {
			SpearArrayType arrayType = (SpearArrayType) type;
			return arrayType.base;
		} else {
			error("Expected array type, but found " + type, aae.getArray());
			return ERROR;
		}
	}

	@Override
	public SpearType caseArrayUpdateExpr(ArrayUpdateExpr aue) {
		SpearType type = doSwitch(aue.getAccess().getArray());
		if (type == ERROR) {
			return ERROR;
		}

		SpearType index = doSwitch(aue.getAccess().getIndex());
		if (index != INT) {
			error("Expected type int, but found " + index, aue.getAccess().getIndex());
		}

		if (type instanceof SpearArrayType) {
			SpearArrayType arrayType = (SpearArrayType) type;
			expectAssignableType(arrayType.base, aue.getValue());
			return arrayType;
		} else {
			error("Expected array type, but found " + type, aue.getAccess().getArray());
			return ERROR;
		}
	}

	@Override
	public SpearType caseArrayExpr(ArrayExpr ae) {
		SpearType type = doSwitch(ae.getType());

		if (type == ERROR) {
			return ERROR;
		}

		if (type instanceof SpearArrayType) {
			SpearArrayType arrayType = (SpearArrayType) type;

			if (arrayType.size != ae.getExprs().size()) {
				error("Array expected " + arrayType.size + " elements, but received " + ae.getExprs().size()
						+ " instead.", ae);
				return ERROR;
			}

			for (Expr e : ae.getExprs()) {
				expectAssignableType(arrayType.base, e);
			}
			return arrayType;
		} else {
			error("Expected array type, but found " + type, ae);
			return ERROR;
		}
	}

	@Override
	public SpearType caseIntLiteral(IntLiteral ile) {
		return INT;
	}

	@Override
	public SpearType caseBoolLiteral(BoolLiteral ble) {
		return BOOL;
	}

	@Override
	public SpearType caseRealLiteral(RealLiteral rle) {
		return REAL;
	}

	@Override
	public SpearType caseIdExpr(IdExpr ide) {
		return doSwitch(ide.getId());
	}

	@Override
	public SpearType casePreviousExpr(PreviousExpr prev) {
		SpearType var = doSwitch(prev.getVar());

		if (var == ERROR) {
			return ERROR;
		}

		if (prev.getInit() != null) {
			SpearType init = doSwitch(prev.getInit());
			if (init == ERROR) {
				return ERROR;
			}

			if (!var.equals(init)) {
				error("Previous must be supplied expressions of the same type.", prev.getInit());
				return ERROR;
			}
		}

		return var;
	}

	@Override
	public SpearType caseIfThenElseExpr(IfThenElseExpr ite) {
		expectAssignableType(BOOL, ite.getCond());
		SpearType thenType = doSwitch(ite.getThen());

		if (ite.getElse() == null) {
			if (thenType != BOOL) {
				error("Then branch must be of type boolean when else branch is unspecified.", ite.getThen());
				return ERROR;
			}
			return thenType;
		}

		SpearType elseType = doSwitch(ite.getElse());

		if (thenType == ERROR || elseType == ERROR) {
			return ERROR;
		}

		if (!thenType.equals(elseType)) {
			error("Branches have inconsistent types " + thenType + ", " + elseType, ite);
			return ERROR;
		} else {
			return thenType;
		}
	}

	@Override
	public SpearType caseAfterUntilExpr(AfterUntilExpr afe) {
		expectAssignableType(BOOL, afe.getAfter());
		if (afe.getUntil() != null) {
			if (!expectAssignableType(BOOL, afe.getUntil())) {
				return ERROR;
			}
		}
		return BOOL;
	}

	@Override
	public SpearType caseWhileExpr(WhileExpr wh) {
		if (!expectAssignableType(BOOL, wh.getCond())) {
			return ERROR;
		}

		if (!expectAssignableType(BOOL, wh.getThen())) {
			return ERROR;
		}
		return BOOL;
	}

	@Override
	public SpearType caseEnumValue(EnumValue ev) {
		return doSwitch(ev.eContainer());
	}

	@Override
	public SpearType casePatternCall(PatternCall pce) {
		// TODO: This needs to be updated when Patterns are implemented.
		return ERROR;
	}

	@Override
	public SpearType caseSpecificationCall(SpecificationCall sc) {
		//check the args match the spec's inputs
		List<SpearType> argslist = new ArrayList<>();
		for(Expr e : sc.getArgs()) {
			argslist.add(this.doSwitch(e));
		}
		SpearTupleType argsType = new SpearTupleType(argslist);
		
		List<SpearType> inputslist = new ArrayList<>();
		for(Variable v : sc.getSpec().getInputs()) {
			inputslist.add(this.doSwitch(v));
		}
		SpearTupleType inputType = new SpearTupleType(inputslist);
		
		if(!argsType.equals(inputType)) {
			error("Provided args of type " + argsType + ", but " + sc.getSpec().getName() + " expected type " + inputType + ".",sc,SpearPackage.Literals.SPECIFICATION_CALL__ARGS);
			return ERROR;
		}
		
		List<SpearType> outputslist = new ArrayList<>();
		for(Variable v : sc.getSpec().getOutputs()) {
			outputslist.add(this.doSwitch(v));
		}
		return new SpearTupleType(outputslist);
	}

	@Override
	public SpearType caseMultipleIdExpr(MultipleIdExpr mide) {
		List<SpearType> typelist = new ArrayList<>();
		for (IdRef idr : mide.getIds()) {
			typelist.add(this.doSwitch(idr));
		}
		return new SpearTupleType(typelist);
	}

	/***************************************************************************************************/
	// HELPER FUNCTIONS
	/***************************************************************************************************/
	private boolean expectAssignableType(SpearType expected, EObject actual) {
		return expectAssignableType(expected, doSwitch(actual), actual);
	}

	private boolean expectAssignableType(SpearType expected, SpearType actual, EObject source) {
		if (!isAssignable(expected, actual)) {
			error("Expected type " + expected.toString() + ", but found type " + actual, source);
			return false;
		} else {
			return true;
		}
	}

	private boolean isAssignable(SpearType expected, SpearType actual) {
		if (expected == ERROR || actual == ERROR || expected == null || actual == null) {
			return true;
		}

		return expected.equals(actual);
	}

	private void error(String message, EObject e, EStructuralFeature feature) {
		if (messageAcceptor != null) {
			messageAcceptor.acceptError(message, e, feature, 0, null);
		}
	}

	private void error(String message, EObject e) {
		if (messageAcceptor != null) {
			messageAcceptor.acceptError(message, e, null, 0, null);
		}
	}
}
