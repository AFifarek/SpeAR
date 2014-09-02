package spear.translator;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jkind.lustre.Type;

import spear.language.ArrayType;
import spear.language.BooleanType;
import spear.language.EnumerationType;
import spear.language.Enumerator;
import spear.language.IntegerSubRangeType;
import spear.language.IntegerType;
import spear.language.NamedType;
import spear.language.RealType;
import spear.language.RecordField;
import spear.language.RecordType;
import spear.language.Utils;
import spear.language.util.LanguageSwitch;
import spear.validation.IntegerConstantSimplification;

/**
 * Convert specification types to jkind lustre AST types.
 */
public class LustreTypeTranslator extends
		LanguageSwitch<jkind.lustre.Type> {
	
	
	@Override
	public Type caseArrayType(ArrayType a) {
		int len = IntegerConstantSimplification.simplify(a.getLength()).intValue();
		return new jkind.lustre.ArrayType(doSwitch(a.getType()), len);
	}

	public LustreTypeTranslator() {
	}

	@Override
	public jkind.lustre.Type caseIntegerType(IntegerType i) {
		return jkind.lustre.NamedType.INT;
	}

	@Override
	public jkind.lustre.Type caseBooleanType(BooleanType b) {
		return jkind.lustre.NamedType.BOOL;
	}

	@Override
	public jkind.lustre.Type caseRealType(RealType r) {
		return jkind.lustre.NamedType.REAL;
	}

	@Override
	public jkind.lustre.Type caseNamedType(NamedType nt) {
		return new jkind.lustre.NamedType(Utils.getFQN(nt.getId()));
	}
	

	
	@Override
	public jkind.lustre.Type caseEnumerationType(EnumerationType object) {
		List<String> names = new LinkedList<String>();
		String type = NameGenerator.getVariableName("Enumeration type");
		for (Enumerator e : object.getEnumerators()) {
			names.add(Utils.getFQN(e));
		}
		return new jkind.lustre.EnumType(type,names);
	}
	
	@Override
	public jkind.lustre.Type caseRecordType(RecordType object) {
		Map<String,jkind.lustre.Type> map = new HashMap<String,jkind.lustre.Type>();
		String type = NameGenerator.getVariableName("Record type");
		for (RecordField rf : object.getFields()) {
			map.put(rf.getName(),doSwitch(rf.getType()));
		}
		return new jkind.lustre.RecordType(type,map);
	}

	@Override
	public Type caseIntegerSubRangeType(IntegerSubRangeType object) {
		BigInteger low = IntegerConstantSimplification.simplify(object.getLow());
		BigInteger high = IntegerConstantSimplification.simplify(object.getHigh());
		return new jkind.lustre.SubrangeIntType(low,high);
	}

}
