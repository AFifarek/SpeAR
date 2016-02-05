package com.rockwellcollins.spear.translate.lustre;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.Ast;
import jkind.lustre.Constant;
import jkind.lustre.EnumType;
import jkind.lustre.Expr;
import jkind.lustre.Type;
import jkind.lustre.TypeDef;
import jkind.lustre.VarDecl;

public class TranslateDecl extends SpearSwitch<Ast> {

	public static Ast translate(EObject o, Map<String,String> mapping) {
		return new TranslateDecl(mapping).doSwitch(o);
	}
	
	private Map<String,String> mapping;
	
	private TranslateDecl(Map<String,String> mapping) {
		this.mapping=mapping;
	}
	
	@Override
	public Ast caseConstant(com.rockwellcollins.spear.Constant c) {
		String newName = mapping.get(c.getName());
		Type type = TranslateType.translate(c.getType(), mapping);
		Expr expr = TranslateExpr.translate(c.getExpr(), mapping);
		return new Constant(newName,type,expr);
	}
	
	@Override
	public Ast caseNamedTypeDef(com.rockwellcollins.spear.NamedTypeDef ntd) {
		String newName = mapping.get(ntd.getName());
		Type type = TranslateType.translate(ntd.getType(), mapping);
		return new TypeDef(newName,type);
	}
	
	@Override
	public Ast caseRecordTypeDef(com.rockwellcollins.spear.RecordTypeDef rtd) {
		String newName = mapping.get(rtd.getName());
		Map<String,Type> fields = new LinkedHashMap<>();
		for(FieldType ft : rtd.getFields()) {
			String field = ft.getName();
			Type type = TranslateType.translate(ft.getType(), mapping);
			fields.put(field,type);
		}
		return new TypeDef(newName,new jkind.lustre.RecordType(newName,fields));		
	}
	
	@Override
	public Ast caseArrayTypeDef(com.rockwellcollins.spear.ArrayTypeDef atd) {
		String newName = mapping.get(atd.getName());
		Type base = TranslateType.translate(atd.getBase(), mapping);
		int size = atd.getSize();
		return new TypeDef(newName,new jkind.lustre.ArrayType(base,size));
	}
	
	@Override
	public Ast caseEnumTypeDef(com.rockwellcollins.spear.EnumTypeDef etd) {
		String newName = mapping.get(etd.getName());
		List<String> values = new ArrayList<>();
		for(EnumValue ev : etd.getValues()) {
			values.add(ev.getName());
		}
		return new TypeDef(newName,new EnumType(newName,values));
	}
	
	@Override
	public Ast caseVariable(com.rockwellcollins.spear.Variable v) {
		String newName = mapping.get(v.getName());
		Type type = TranslateType.translate(v.getType(), mapping);
		return new VarDecl(newName, type);
	}
	
	@Override
	public Ast defaultCase(EObject o) {
		throw new RuntimeException("Unexpected object " + o + " provided.");
	}	
}
