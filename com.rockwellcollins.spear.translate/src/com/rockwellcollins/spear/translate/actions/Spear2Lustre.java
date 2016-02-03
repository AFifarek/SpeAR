package com.rockwellcollins.spear.translate.actions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
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
import com.rockwellcollins.spear.translate.lustre.CheckForUnsupported;
import com.rockwellcollins.spear.translate.lustre.TranslateSpecification;
import com.rockwellcollins.spear.translate.transformations.GetReferences;
import com.rockwellcollins.spear.translate.transformations.NormalizeOperators;
import com.rockwellcollins.spear.translate.transformations.RemoveLustreKeywords;
import com.rockwellcollins.spear.translate.transformations.RemoveSugar;
import com.rockwellcollins.spear.translate.views.JKindResultsView;
import com.rockwellcollins.ui.internal.SpearActivator;

import jkind.api.JKindApi;
import jkind.api.results.JKindResult;
import jkind.lustre.Program;
import jkind.results.layout.Layout;
import jkind.results.layout.NodeLayout;

public class Spear2Lustre implements IWorkbenchWindowActionDelegate {

	private IWorkbenchWindow window;

	@Override
	public void run(IAction action) {
		SpearInjectorUtil
				.setInjector(SpearActivator.getInstance().getInjector(SpearActivator.COM_ROCKWELLCOLLINS_SPEAR));

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
				
				if (hasErrors(specification.eResource())) {
					MessageDialog.openError(window.getShell(), "Error", "Specification contains errors.");
					return null;
				}
				
				if (CheckForUnsupported.check(specification)) {
					MessageDialog.openError(window.getShell(), "Unsupported Specification elements.",
							"Specification contains at least one unsupported element.");
					return null;
				}

				Integer pass = 0;
				Specification workingCopy = EcoreUtil2.copy(specification);

				// apply operator normalization
				workingCopy = RemoveLustreKeywords.transform(workingCopy);
				printSpearFile(getOutputURI(state.getURI(), pass.toString()), workingCopy);
				pass++;

				// apply operator normalization
				workingCopy = NormalizeOperators.transform(workingCopy);
				printSpearFile(getOutputURI(state.getURI(), pass.toString()), workingCopy);
				pass++;

				// apply remove sugar
				workingCopy = RemoveSugar.transform(workingCopy);
				printSpearFile(getOutputURI(state.getURI(), pass.toString()), workingCopy);
				pass++;

				Set<EObject> references = GetReferences.getReferences(workingCopy);
				
				// translate to Lustre
				Program p = TranslateSpecification.translate(workingCopy, references);
				URI lustreURI = createURI(state.getURI(), "", "lus");

				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IResource finalResource = root.getFile(new Path(lustreURI.toPlatformString(true)));
				printResource(finalResource, p.toString());

				// refresh the workspace
				root.refreshLocal(IResource.DEPTH_INFINITE, null);

				JKindApi api = getJKindApi();
				JKindResult result = new JKindResult("result", p.getMainNode().properties);
				IProgressMonitor monitor = new NullProgressMonitor();
				showView(result, new NodeLayout(p));

				try {
					api.execute(p, result, monitor);
				} catch (Exception e) {
					System.out.println(result.getText());
					throw e;
				}

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
		if (pass != null) {
			uri = uri.appendSegment(filename.substring(0, i) + "." + pass + ".spear");
		} else {
			uri = uri.appendSegment(filename.substring(0, i) + ".final.limp");
		}
		return uri;
	}

	private static URI createURI(URI baseURI, String suffix, String extension) {
		String filename = baseURI.lastSegment();
		baseURI = baseURI.trimSegments(1);
		int i = filename.lastIndexOf(".");
		baseURI = baseURI.appendSegment((filename.substring(0, i) + suffix + "." + extension));
		return baseURI;
	}

	private void printResource(IResource res, String contents) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(res.getRawLocation().toFile()))) {
			bw.write(contents);
		}
	}

	private JKindApi getJKindApi() {
		JKindApi api = new JKindApi();
		return api;
	}

	private void showView(final JKindResult result, final Layout layout) {
		window.getShell().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				try {
					JKindResultsView page = (JKindResultsView) window.getActivePage().showView(JKindResultsView.ID);
					page.setInput(result, layout);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void selectionChanged(IAction arg0, ISelection arg1) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void init(IWorkbenchWindow arg0) {
		this.window = arg0;
	}

}
