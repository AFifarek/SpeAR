package com.rockwellcollins.spear.translate.experimental;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;

public class SpearConstant extends SpearAst {

	public Constant constant;
	public EObject root;
	
	public SpearConstant(Constant c, EObject root) {
		this.constant=c;
		this.root=root;
	}
}
