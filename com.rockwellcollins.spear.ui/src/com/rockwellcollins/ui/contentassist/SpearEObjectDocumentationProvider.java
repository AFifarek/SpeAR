package com.rockwellcollins.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;

public class SpearEObjectDocumentationProvider extends MultiLineCommentDocumentationProvider {

	@Override
	public String getDocumentation(EObject o) {
		String val = super.getDocumentation(o);
		if (val == null) {
			return null;
		}
		
		return val.replaceAll("\r?\n", "<br>").replaceAll("\t", "&nbsp&nbsp&nbsp&nbsp");
	}
}
