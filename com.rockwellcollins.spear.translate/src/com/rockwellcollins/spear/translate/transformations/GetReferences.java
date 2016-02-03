package com.rockwellcollins.spear.translate.transformations;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.util.SpearSwitch;

public class GetReferences extends SpearSwitch<Void> {

	public static Set<EObject> getReferences(Specification s) {
		GetReferences getRefs = new GetReferences(s);
		getRefs.doSwitch(s);
		return getRefs.referenced;
	}

	private GetReferences(Specification s) {
		this.root=s;
	}
	
	public Specification root;
	public Set<EObject> referenced = new HashSet<>();

	@Override
	public Void defaultCase(EObject e) {
		for(EObject sub : e.eContents()) {
			this.doSwitch(sub);
		}
		
		for(EObject ref : e.eCrossReferences()) {
			if(!EcoreUtil2.isAncestor(root, ref)) {
				referenced.add(ref);
			}
			this.doSwitch(ref);
		}
		return null;
	}
}
