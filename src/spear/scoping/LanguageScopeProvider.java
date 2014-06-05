package spear.scoping;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import spear.language.IdExpr;
import spear.language.QuantificationExpr;

public class LanguageScopeProvider extends AbstractDeclarativeScopeProvider {
	
	@Override
	public IScope getScope(EObject context, EReference reference){
		IScope scope = super.getScope(context,reference);
		if(context instanceof IdExpr) {
	   			QuantificationExpr qr = EcoreUtil2.getContainerOfType(context, QuantificationExpr.class);
		   		while(qr!=null) {
		   			List<QuantificationExpr> es = new LinkedList<>();
		   			es.add(qr);
		   			scope = Scopes.scopeFor(es,scope);
	   				qr = EcoreUtil2.getContainerOfType(qr.eContainer(), QuantificationExpr.class);
		   		}
		}
		return scope;
	}
	   	
}
