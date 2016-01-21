package com.rockwellcollins.spear.translate.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;
import com.rockwellcollins.SpearInjectorUtil;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.transformations.NormalizeOperators;
import com.rockwellcollins.spear.translate.transformations.RemoveSugar;
import com.rockwellcollins.ui.internal.SpearActivator;

public class Spear2Lustre implements IWorkbenchWindowActionDelegate {

	private IWorkbenchWindow window;

	@Override
	public void run(IAction action) {
		SpearInjectorUtil.setInjector(SpearActivator.getInstance().getInjector(SpearActivator.COM_ROCKWELLCOLLINS_SPEAR));
		
		IEditorPart editor = window.getActivePage().getActiveEditor();
		if (!(editor instanceof XtextEditor)) {
			MessageDialog.openError(window.getShell(), "Error", "Only SpeAR files can be analyzed.");
			return;
		}
		
		XtextEditor xte = (XtextEditor) editor;
		IXtextDocument doc = xte.getDocument();

		doc.readOnly(new IUnitOfWork<Void, XtextResource>() {

			@Override
			public java.lang.Void exec(XtextResource state) throws Exception {
				Specification specification = (Specification) state.getContents().get(0);
				if(hasErrors(specification.eResource())) {
					MessageDialog.openError(window.getShell(), "Error", "Specification has errors.");
					return null;
				}

				Integer pass = 0;
				Specification workingCopy = EcoreUtil2.copy(specification);

				//apply operator normalization
				workingCopy = NormalizeOperators.transform(workingCopy);
				printSpearFile(getOutputURI(state.getURI(), pass.toString()), workingCopy);
				pass++;
				
				//apply remove sugar
				workingCopy = RemoveSugar.transform(workingCopy);
				printSpearFile(getOutputURI(state.getURI(), pass.toString()), workingCopy);
				pass++;
				
				//refresh the workspace
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				root.refreshLocal(IResource.DEPTH_INFINITE, null);
				return null;
			}	
		});		
		
	}

	protected boolean hasErrors(Resource res) {
		Injector injector = SpearActivator.getInstance().getInjector(SpearActivator.COM_ROCKWELLCOLLINS_SPEAR);
		IResourceValidator resourceValidator = injector.getInstance(IResourceValidator.class);

		for (Issue issue : resourceValidator.validate(res, CheckMode.ALL, CancelIndicator.NullImpl)) {
			if (issue.getSeverity() == Severity.ERROR) {
				return true;
			}
		}
		return false;
	}

	private void printSpearFile(URI uri, Specification s) throws Exception {
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
		if(pass != null) {
			uri = uri.appendSegment(filename.substring(0, i) + "." + pass + ".spear");	
		} else {
			uri = uri.appendSegment(filename.substring(0, i) + ".final.limp");
		}
		return uri;
	}
	
	@Override
	public void selectionChanged(IAction arg0, ISelection arg1) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void init(IWorkbenchWindow arg0) {
		this.window=arg0;
	}

}
