package com.rockwellcollins.spear.naming;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import com.rockwellcollins.spear.EnumValue;
import com.rockwellcollins.spear.TypeDef;

public class SpearDeclarativeQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	protected QualifiedName qualifiedName(EnumValue e) {
		return QualifiedName.create(e.getName());
	}
	
	protected QualifiedName qualifiedName(TypeDef t) {
		return QualifiedName.create(t.getName());
	}
	
}
