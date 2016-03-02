package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rockwellcollins.spear.NormalizedCall;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.NameMap;

import jkind.lustre.VarDecl;

public class SCall {
	
	public static Map<NormalizedCall,SCall> build(List<NormalizedCall> calls, NameMap map) {
		Map<NormalizedCall,SCall> built = new HashMap<>();
		for(NormalizedCall call : calls) {
			SCall called = SCall.build(call, map);
			built.put(call,called);
		}
		return built;
	}
	
	private static SCall build(NormalizedCall call, NameMap map) {
		return new SCall(call,map);
	}

	public SSpecification caller;
	public SSpecification called;
	private Integer hashcode;

	/*
	 * This needs to keep track of
	 * 1. the caller (SSpecification)
	 * 2. the called (SSpecification)
	 */
	public SCall(NormalizedCall nc, NameMap map) {
		this.caller = (SSpecification) map.mapping.get(Utilities.getRoot(nc));
		this.called = (SSpecification) map.mapping.get(nc.getSpec());
		this.hashcode = nc.hashCode();
	}
	
	public List<VarDecl> getShadowVariablesForCall(NameMap map) {
		List<SVariable> shadowed = new ArrayList<>();
		shadowed.addAll(called.outputs);
		shadowed.addAll(called.state);
		
		List<VarDecl> shadow = new ArrayList<>();
		for(SVariable svar : shadowed) {
			String name = caller.name + "_call" + hashcode + "_" + called.name + "_" + svar.shadowName;
			shadow.add(new VarDecl(name,TranslateType.translate(svar.type, map)));
		}
		shadow.addAll(called.getShadowedVariables());
		return shadow;
	}
}
