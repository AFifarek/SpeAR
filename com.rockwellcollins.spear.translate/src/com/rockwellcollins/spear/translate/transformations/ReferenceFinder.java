package com.rockwellcollins.spear.translate.transformations;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ReferenceFinder extends SpearSwitch<Void> {

	public static ReferenceFinder get(Specification s) {
		ReferenceFinder refs = new ReferenceFinder(s);
		refs.defaultCase(s);
		return refs;
	}

	private ReferenceFinder(Specification s) {
		this.root=s;
	}
	
	public Specification root;
	
	public Collection<TypeDef> typedefs = new HashSet<>();
	public Collection<Constant> constants = new HashSet<>();
	public Collection<Pattern> patterns = new HashSet<>();
	
	@Override
	public Void caseTypeDef(TypeDef td) {
		typedefs.add(td);
		return null;
	}
	
	@Override
	public Void caseConstant(Constant c) {
		constants.add(c);
		return null;
	}
	
	@Override
	public Void casePattern(Pattern p) {
		patterns.add(p);
		return null;
	}
	
	@Override
	public Void defaultCase(EObject e) {
		for(EObject sub : e.eContents()) {
			this.doSwitch(sub);
			this.defaultCase(sub);
		}
		
		for(EObject ref : e.eCrossReferences()) {
			this.doSwitch(ref);
			this.defaultCase(ref);
		}
		return null;
	}
}
