package com.rockwellcollins.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
 * on how to customize the content assistant.
 */
public class SpearProposalProvider extends com.rockwellcollins.ui.contentassist.AbstractSpearProposalProvider {
	
	@Override
	public void completeTypeDef_Unit(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.completeTypeDef_Unit(model, assignment, context, acceptor);
		
	}
	
}
