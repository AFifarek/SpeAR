package com.rockwellcollins.spear.translate.lustre;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.translate.experimental.TranslationManager;
import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.Ast;
import jkind.lustre.Constant;
import jkind.lustre.EnumType;
import jkind.lustre.Expr;
import jkind.lustre.Type;
import jkind.lustre.TypeDef;
import jkind.lustre.VarDecl;

public class TranslateDecl extends SpearSwitch<Ast> {

	public static Ast translate(EObject o, TranslationManager naming) {
		return new TranslateDecl(naming).doSwitch(o);
	}
	
	private TranslationManager naming;
	
	private TranslateDecl(TranslationManager naming) {
		this.naming=naming;
	}
	
	@Override
	public Ast caseConstant(com.rockwellcollins.spear.Constant c) {
		String newName = naming.lookup(c.getName());
		Type type = TranslateType.translate(c.getType(), naming);
		Expr expr = TranslateExpr.translate(c.getExpr(), naming);
		return new Constant(newName,type,expr);
	}
	
	@Override
	public Ast caseNamedTypeDef(com.rockwellcollins.spear.NamedTypeDef ntd) {
		String newName = naming.lookup(ntd.getName());
		Type type = TranslateType.translate(ntd.getType(), naming);
		return new TypeDef(newName,type);
	}
	
	@Override
	public Ast caseRecordTypeDef(com.rockwellcollins.spear.RecordTypeDef rtd) {
		String newName = naming.lookup(rtd.getName());
		Map<String,Type> fields = new LinkedHashMap<>();
		for(FieldType ft : rtd.getFields()) {
			String field = ft.getName();
			Type type = TranslateType.translate(ft.getType(), naming);
			fields.put(field,type);
		}
		return new TypeDef(newName,new jkind.lustre.RecordType(newName,fields));		
	}
	
	@Override
	public Ast caseArrayTypeDef(com.rockwellcollins.spear.ArrayTypeDef atd) {
		String newName = naming.lookup(atd.getName());
		Type base = TranslateType.translate(atd.getBase(), naming);
		int size = atd.getSize();
		return new TypeDef(newName,new jkind.lustre.ArrayType(base,size));
	}
	
	@Override
	public Ast caseEnumTypeDef(com.rockwellcollins.spear.EnumTypeDef etd) {
		String newName = naming.lookup(etd.getName());
		List<String> values = new ArrayList<>();
		for(EnumValue ev : etd.getValues()) {
			values.add(naming.lookup(ev.getName()));
		}
		return new TypeDef(newName,new EnumType(newName,values));
	}
	
	@Override
	public Ast caseVariable(com.rockwellcollins.spear.Variable v) {
		String newName = naming.lookup(v.getName());
		Type type = TranslateType.translate(v.getType(), naming);
		return new VarDecl(newName, type);
	}
	
	@Override
	public Ast defaultCase(EObject o) {
		throw new RuntimeException("Unexpected object " + o + " provided.");
	}	
}
