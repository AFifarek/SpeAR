package com.rockwellcollins.spear.naming;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import com.rockwellcollins.spear.EnumValue;

public class SpearQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	public QualifiedName qualifiedName(EnumValue ev) {
		return QualifiedName.create(ev.getName());
	}
}
