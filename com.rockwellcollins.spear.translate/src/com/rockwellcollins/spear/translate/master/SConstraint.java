package com.rockwellcollins.spear.translate.master;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.translate.naming.NameMap;
import com.rockwellcollins.spear.util.SpearSwitch;

import jkind.lustre.Equation;
import jkind.lustre.VarDecl;

public abstract class SConstraint {

	public static List<SConstraint> build(List<Constraint> list, NameMap map) {
		List<SConstraint> built = new ArrayList<>();
		for(Constraint c : list) {
			built.add(SConstraint.build(c, map));
		}
		return built;
	}
	
	public static List<VarDecl> toVarDecl(List<SConstraint> list, NameMap map) {
		List<VarDecl> decls = new ArrayList<>();
		for(SConstraint c : list) {
			decls.add(c.toVarDecl(map));
		}
		return decls;
	}

	public static List<Equation> toEquation(List<SConstraint> list, NameMap map) {
		List<Equation> equations = new ArrayList<>();
		for(SConstraint c : list) {
			equations.add(c.toEquation(map));
		}
		return equations;
	}
	
	public static SConstraint build(Constraint c, NameMap map) {
		SConstraintBuilder builder = new SConstraintBuilder(map);
		return builder.doSwitch(c);
	}
	
	public String name;
	public abstract jkind.lustre.VarDecl toVarDecl(NameMap map);
	public abstract jkind.lustre.Equation toEquation(NameMap map);
	
	private static class SConstraintBuilder extends SpearSwitch<SConstraint> {
		
		private NameMap map;
		
		private SConstraintBuilder(NameMap map) {
			this.map=map;
		}
		
		@Override
		public SConstraint caseFormalConstraint(FormalConstraint fc) {
			return SFormalConstraint.build(fc, map);
		}
		
		@Override
		public SConstraint defaultCase(EObject o) {
			throw new RuntimeException("Expected a File object, received: " + o.toString());
		}
	}
}
