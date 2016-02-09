package com.rockwellcollins.scoping;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.FieldExpr;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.RecordAccessExpr;
import com.rockwellcollins.spear.RecordExpr;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.RecordUpdateExpr;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.util.SpearSwitch;

public class CompositeTypeLookup extends SpearSwitch<RecordTypeDef> {

	public static RecordTypeDef getRecordType(Expr e) {
		return new CompositeTypeLookup().doSwitch(e);
	}
	
	@Override
	public RecordTypeDef caseVariable(Variable v) {
		return doSwitch(v.getType());
	}
	
	@Override
	public RecordTypeDef caseIdExpr(IdExpr ide) {
		return doSwitch(ide.getId());
	}
	
	@Override
	public RecordTypeDef caseRecordUpdateExpr(RecordUpdateExpr rue) {
		return doSwitch(rue.getRecord());
	}
	
	@Override
	public RecordTypeDef caseRecordAccessExpr(RecordAccessExpr rae) {
		return doSwitch(rae.getField());
	}
	
	@Override
	public RecordTypeDef caseRecordExpr(RecordExpr re) {
		return doSwitch(re.getType());
	}
	
	@Override
	public RecordTypeDef caseFieldExpr(FieldExpr fe) {
		return doSwitch(fe.getField());
	}
	
	@Override
	public RecordTypeDef caseUserType(UserType ut) {
		return doSwitch(ut.getDef());
	}
	
	@Override
	public RecordTypeDef caseRecordTypeDef(RecordTypeDef rt) {
		return rt;
	}
	
	//TODO: this needs to be finished.
}
