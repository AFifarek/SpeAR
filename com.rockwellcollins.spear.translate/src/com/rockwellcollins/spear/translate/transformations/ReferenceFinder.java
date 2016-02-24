package com.rockwellcollins.spear.translate.transformations;

import java.util.HashMap;
import java.util.Map;

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
	
	public Map<TypeDef,Specification> typedefs = new HashMap<>();
	public Map<Constant,Specification> constants = new HashMap<>();
	public Map<Pattern,Specification> patterns = new HashMap<>();
	
	@Override
	public Void caseTypeDef(TypeDef td) {
		typedefs.put(td,root);
		return null;
	}
	
	@Override
	public Void caseConstant(Constant c) {
		constants.put(c,root);
		return null;
	}
	
	@Override
	public Void casePattern(Pattern p) {
		patterns.put(p,root);
		return null;
	}
	
	@Override
	public Void caseSpecification(Specification s) {
		Specification previous = this.root;
		this.root = s;
		this.defaultCase(s);
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
