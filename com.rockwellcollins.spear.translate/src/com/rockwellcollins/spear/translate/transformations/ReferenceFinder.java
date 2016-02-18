package com.rockwellcollins.spear.translate.transformations;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ReferenceFinder extends SpearSwitch<Void> {

	public static ReferenceFinder get(Specification s) {
		ReferenceFinder refs = new ReferenceFinder(s);
		refs.defaultCase(s);
		return refs;
	}
	
	public static Map<EObject,EObject> getReferences(Specification s) {
		ReferenceFinder getRefs = new ReferenceFinder(s);
		getRefs.defaultCase(s);
		return getRefs.referenced;
	}

	private ReferenceFinder(Specification s) {
		this.root=s;
	}
	
	public Specification root;
	public Map<EObject,EObject> referenced = new HashMap<>();
	
	public Collection<TypeDef> typedefs = new HashSet<>();
	public Collection<Constant> constants = new HashSet<>();
	
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
	public Void defaultCase(EObject e) {
		for(EObject sub : e.eContents()) {
			this.defaultCase(sub);
		}
		
		for(EObject ref : e.eCrossReferences()) {
			if(!EcoreUtil2.isAncestor(root, ref)) {
				EObject referencedRoot = EcoreUtil2.getRootContainer(ref);
				referenced.put(ref,referencedRoot);
				this.doSwitch(ref);
			}
			this.defaultCase(ref);
		}
		return null;
	}
}
