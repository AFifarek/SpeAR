package com.rockwellcollins.spear.translate.master;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

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
	
}
