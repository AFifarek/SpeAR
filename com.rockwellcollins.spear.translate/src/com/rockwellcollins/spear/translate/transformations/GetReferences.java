package com.rockwellcollins.spear.translate.transformations;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.util.SpearSwitch;

public class GetReferences extends SpearSwitch<Void> {

	public static Map<EObject,EObject> getReferences(Specification s) {
		GetReferences getRefs = new GetReferences(s);
		getRefs.doSwitch(s);
		return getRefs.referenced;
	}

	private GetReferences(Specification s) {
		this.root=s;
	}
	
	public Specification root;
	public Map<EObject,EObject> referenced = new HashMap<>();

	@Override
	public Void defaultCase(EObject e) {
		for(EObject sub : e.eContents()) {
			this.doSwitch(sub);
		}
		
		for(EObject ref : e.eCrossReferences()) {
			if(!EcoreUtil2.isAncestor(root, ref)) {
				EObject referencedRoot = EcoreUtil2.getRootContainer(ref);
				referenced.put(ref,referencedRoot);
			}
			this.doSwitch(ref);
		}
		return null;
	}
}
