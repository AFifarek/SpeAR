package com.rockwellcollins.scoping;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.RecordExpr;
import com.rockwellcollins.spear.RecordType;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.util.SpearSwitch;

public class CompositeTypeLookup extends SpearSwitch<RecordType> {

	public static RecordType getRecordType(Expr e) {
		return new CompositeTypeLookup().doSwitch(e);
	}
	
	@Override
	public RecordType caseVariable(Variable v) {
		return doSwitch(v.getType());
	}
	
	@Override
	public RecordType caseIdExpr(IdExpr ide) {
		return doSwitch(ide.getId());
	}
	
	@Override
	public RecordType caseRecordExpr(RecordExpr re) {
		return doSwitch(re.getType());
	}
	
	@Override
	public RecordType caseUserType(UserType ut) {
		return doSwitch(ut.getDef());
	}
	
	@Override
	public RecordType caseRecordType(RecordType rt) {
		return rt;
	}
	
	//TODO: this needs to be finished.
}
