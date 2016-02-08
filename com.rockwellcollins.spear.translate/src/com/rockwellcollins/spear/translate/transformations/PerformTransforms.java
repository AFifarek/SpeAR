package com.rockwellcollins.spear.translate.transformations;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.XtextResource;

import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.actions.SpearRuntimeOptions;

public class PerformTransforms {

	public static Specification apply(Specification s, XtextResource state) throws Exception {
		Integer pass = 0;
		
		s = RemoveLustreKeywords.transform(s);
		printSpearFile(getOutputURI(state.getURI(), pass.toString()), s);
		pass++;
		
		s = NormalizeOperators.transform(s);
		printSpearFile(getOutputURI(state.getURI(), pass.toString()), s);
		pass++;
		
		s = RemoveSugar.transform(s);
		printSpearFile(getOutputURI(state.getURI(), pass.toString()), s);
		pass++;
		
		return s;
	}
	
	private static void printSpearFile(URI uri, Specification s) throws Exception {
		if (SpearRuntimeOptions.createDebugFiles) {
			Resource res = new ResourceSetImpl().createResource(uri);
			res.getContents().add(s);
			res.save(null);
		}
	}

	private static URI getOutputURI(URI uri, String pass) {
		String filename = uri.lastSegment();
		uri = uri.trimSegments(1);
		int i = filename.lastIndexOf(".");
		if (pass != null) {
			uri = uri.appendSegment(filename.substring(0, i) + "." + pass + ".spear");
		} else {
			uri = uri.appendSegment(filename.substring(0, i) + ".final.limp");
		}
		return uri;
	}
}
