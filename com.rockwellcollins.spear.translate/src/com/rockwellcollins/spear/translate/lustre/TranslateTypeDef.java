package com.rockwellcollins.spear.translate.lustre;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.ArrayType;
import com.rockwellcollins.spear.EnumType;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.NamedType;
import com.rockwellcollins.spear.RecordType;
import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.Type;
import jkind.lustre.TypeDef;

/*
 * Complex types are all handled here. They should only be referenced by IDs in the actual specification.
 */
public class TranslateTypeDef extends SpearSwitch<TypeDef> {
	
	public static TypeDef translate(EObject o) {
		return new TranslateTypeDef().doSwitch(o);
	}

	@Override
	public TypeDef caseNamedType(NamedType nt) {
		return new jkind.lustre.TypeDef(nt.getName(),TranslateType.translate(nt.getType()));
	}
	
	@Override
	public TypeDef caseRecordType(RecordType rt) {
		Map<String,Type> fields = new LinkedHashMap<>();
		for(FieldType rtf : rt.getFields()) {
			fields.put(rtf.getName(), TranslateType.translate(rtf.getType()));
		}
		jkind.lustre.RecordType record = new jkind.lustre.RecordType(rt.getName(),fields); 
		return new jkind.lustre.TypeDef(rt.getName(),record);
	}
	
	@Override
	public TypeDef caseArrayType(ArrayType at) {
		jkind.lustre.ArrayType array = new jkind.lustre.ArrayType(TranslateType.translate(at.getBase()),at.getSize());
		return new jkind.lustre.TypeDef(at.getName(),array);
	}
	
	@Override
	public TypeDef caseEnumType(EnumType et) {
		List<String> values = new ArrayList<>();
		for(EnumValue ev : et.getValues()) {
			values.add(ev.getName());
		}
		jkind.lustre.EnumType enumType = new jkind.lustre.EnumType(et.getName(),values);
		return new jkind.lustre.TypeDef(et.getName(),enumType);
	}
	
	@Override
	public TypeDef defaultCase(EObject o) {
		throw new RuntimeException("Expected a typedef, but received " + o);
	}
}
