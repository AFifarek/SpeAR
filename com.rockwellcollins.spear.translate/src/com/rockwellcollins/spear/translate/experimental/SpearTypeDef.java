package com.rockwellcollins.spear.translate.experimental;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.TypeDef;

public class SpearTypeDef extends SpearAst {

	public TypeDef typedef;
	public EObject root;
	
	public SpearTypeDef(TypeDef td, EObject root) {
		this.typedef = td;
		this.root=root;
	}
}
