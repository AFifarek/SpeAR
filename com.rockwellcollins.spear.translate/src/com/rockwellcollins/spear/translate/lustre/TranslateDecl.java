package com.rockwellcollins.spear.translate.lustre;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.translate.intermediate.SNode;
import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.Ast;
import jkind.lustre.Constant;
import jkind.lustre.EnumType;
import jkind.lustre.Expr;
import jkind.lustre.Type;
import jkind.lustre.TypeDef;
import jkind.lustre.VarDecl;

public class TranslateDecl extends SpearSwitch<Ast> {

	public static Ast translate(EObject o, SNode context) {
		return new TranslateDecl(context).doSwitch(o);
	}
	
	private SNode context;
	
	private TranslateDecl(SNode context) {
		this.context=context;
	}
	
	@Override
	public Ast caseConstant(com.rockwellcollins.spear.Constant c) {
		String newName = context.scope.lookup(c.getName());
		Type type = TranslateType.translate(c.getType(), context);
		Expr expr = TranslateExpr.translate(c.getExpr(), context);
		return new Constant(newName,type,expr);
	}
	
	@Override
	public Ast caseNamedTypeDef(com.rockwellcollins.spear.NamedTypeDef ntd) {
		String newName = context.scope.lookup(ntd.getName());
		Type type = TranslateType.translate(ntd.getType(), context);
		return new TypeDef(newName,type);
	}
	
	@Override
	public Ast caseRecordTypeDef(com.rockwellcollins.spear.RecordTypeDef rtd) {
		String newName = context.scope.lookup(rtd.getName());
		Map<String,Type> fields = new LinkedHashMap<>();
		for(FieldType ft : rtd.getFields()) {
			String field = ft.getName();
			Type type = TranslateType.translate(ft.getType(), context);
			fields.put(field,type);
		}
		return new TypeDef(newName,new jkind.lustre.RecordType(newName,fields));		
	}
	
	@Override
	public Ast caseArrayTypeDef(com.rockwellcollins.spear.ArrayTypeDef atd) {
		String newName = context.scope.lookup(atd.getName());
		Type base = TranslateType.translate(atd.getBase(), context);
		int size = atd.getSize();
		return new TypeDef(newName,new jkind.lustre.ArrayType(base,size));
	}
	
	@Override
	public Ast caseEnumTypeDef(com.rockwellcollins.spear.EnumTypeDef etd) {
		String newName = context.scope.lookup(etd.getName());
		List<String> values = new ArrayList<>();
		for(EnumValue ev : etd.getValues()) {
			values.add(context.scope.lookup(ev.getName()));
		}
		return new TypeDef(newName,new EnumType(newName,values));
	}
	
	@Override
	public Ast caseVariable(com.rockwellcollins.spear.Variable v) {
		String newName = context.scope.lookup(v.getName());
		Type type = TranslateType.translate(v.getType(), context);
		return new VarDecl(newName, type);
	}
	
	@Override
	public Ast defaultCase(EObject o) {
		throw new RuntimeException("Unexpected object " + o + " provided.");
	}	
}
