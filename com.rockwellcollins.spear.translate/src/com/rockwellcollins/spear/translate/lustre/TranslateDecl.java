package com.rockwellcollins.spear.translate.lustre;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.rockwellcollins.spear.ArrayTypeDef;
import com.rockwellcollins.spear.EnumTypeDef;
import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.NamedTypeDef;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.ArrayType;
import jkind.lustre.Ast;
import jkind.lustre.Constant;
import jkind.lustre.EnumType;
import jkind.lustre.Type;
import jkind.lustre.TypeDef;
import jkind.lustre.VarDecl;

public class TranslateDecl extends SpearSwitch<Ast> {

	public static TypeDef translate(com.rockwellcollins.spear.TypeDef td, String name) {
		if (td instanceof NamedTypeDef) {
			NamedTypeDef namedTypeDef = (NamedTypeDef) td;
			return TranslateDecl.translate(namedTypeDef,name);
		} else if(td instanceof RecordTypeDef) {
			RecordTypeDef recordTypeDef = (RecordTypeDef) td;
			return TranslateDecl.translate(recordTypeDef,name);
		} else if(td instanceof ArrayTypeDef) {
			ArrayTypeDef arrayTypeDef = (ArrayTypeDef) td;
			return TranslateDecl.translate(arrayTypeDef,name);
		} else if(td instanceof EnumTypeDef) {
			EnumTypeDef enumTypeDef = (EnumTypeDef) td;
			return TranslateDecl.translate(enumTypeDef,name);
		}
		throw new RuntimeException("This should never happen, ever. EVER. EVER!!!!!!!!!!");
	}
	
	private static TypeDef translate(com.rockwellcollins.spear.NamedTypeDef nt, String name) {
		return new TypeDef(name,TranslateType.translate(nt.getType()));
	}
	
	public static TypeDef translate(com.rockwellcollins.spear.NamedTypeDef nt) {
		return translate(nt,nt.getName());
	}
	
	public static TypeDef translate(com.rockwellcollins.spear.RecordTypeDef recordType, String name) {
		Map<String,Type> fields = new LinkedHashMap<>();
		for(FieldType ft : recordType.getFields()) {
			fields.put(ft.getName(), TranslateType.translate(ft.getType()));
		}
		return new TypeDef(name,new jkind.lustre.RecordType(name,fields));		
	}
	
	public static TypeDef translate(com.rockwellcollins.spear.RecordTypeDef recordType) {
		return translate(recordType, recordType.getName());
	}
	
	public static TypeDef translate(com.rockwellcollins.spear.ArrayTypeDef arrayType, String name) {
		return new jkind.lustre.TypeDef(name,new ArrayType(TranslateType.translate(arrayType.getBase()),arrayType.getSize()));
	}
	
	public static TypeDef translate(com.rockwellcollins.spear.ArrayTypeDef arrayType) {
		return translate(arrayType, arrayType.getName());
	}
	
	public static TypeDef translate(com.rockwellcollins.spear.EnumTypeDef enumType, String name) {
		List<String> values = new ArrayList<>();
		for(EnumValue ev : enumType.getValues()) {
			values.add(ev.getName());
		}
		return new jkind.lustre.TypeDef(name,new EnumType(name,values));		
	}
	
	public static Constant translate(com.rockwellcollins.spear.Constant c, String name) {
		return new Constant(name,TranslateType.translate(c.getType()),TranslateExpr.translate(c.getExpr()));		
	}
	
	public static Constant translate(com.rockwellcollins.spear.Constant c) {
		return translate(c,c.getName());
	}

	public static VarDecl translate(com.rockwellcollins.spear.Variable v, String name) {
		return new VarDecl(name,TranslateType.translate(v.getType()));
	}
	
	public static VarDecl translate(com.rockwellcollins.spear.Variable v) {
		return translate(v,v.getName());
	}
}
