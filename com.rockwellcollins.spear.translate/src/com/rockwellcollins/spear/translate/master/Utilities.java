package com.rockwellcollins.spear.translate.master;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.spear.File;

public class Utilities {

	public static File getRoot(EObject o) {
		EObject root = EcoreUtil2.getRootContainer(o);
		if (root instanceof File) {
			File file = (File) root;
			return file;
		} else {
			throw new RuntimeException("Root of object: " + o + " should be a File construct.");
		}
	}
	
	public static String getName(EObject o) {
		String name = SimpleAttributeResolver.NAME_RESOLVER.apply(o);
		if(name == null) {
			throw new RuntimeException("Name not found for object " + o);
		} else {
			return name;
		}
	}
}
