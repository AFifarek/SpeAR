package com.rockwellcollins.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;

import com.rockwellcollins.spear.EnglishConstraint;
import com.rockwellcollins.spear.FormalConstraint;

public class SpearEObjectDocumentationProvider extends MultiLineCommentDocumentationProvider {
	@Override
	public String getDocumentation(EObject o) {
		String val;
		if (o instanceof FormalConstraint) {
			FormalConstraint fc = (FormalConstraint) o;
			if (fc.getDescriptor() != null) {
				val = fc.getDescriptor();
			} else {
				val = super.getDocumentation(fc);
			}
		} else if (o instanceof EnglishConstraint) {
			EnglishConstraint ec = (EnglishConstraint) o;
			val = ec.getText();
		} else {
			val = super.getDocumentation(o);
		}

		if (val == null) {
			return null;
		}
		return val.replaceAll("\r?\n", "<br>").replaceAll("\t", "&nbsp&nbsp&nbsp&nbsp");
	}
}
