package spear.ui;

import java.util.List;

import jkind.results.layout.Layout;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import spear.language.Procedure;
import spear.views.JKindResultsView;
import spear.views.SpearLayout;

import com.google.inject.Inject;

public class ActionReason implements
		IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;

	@Inject
	public IResourceValidator validator;

	public ActionReason() {
	}

	public boolean hasErrors(Resource res) {
		List<Issue> issues = validator.validate(res, CheckMode.ALL,
				CancelIndicator.NullImpl);
		for (Issue issue : issues) {
			if (issue.getSeverity() == Severity.ERROR) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void run(IAction action) {
		IEditorPart editor = window.getActivePage().getActiveEditor();
		if (!(editor instanceof XtextEditor)) {
			MessageDialog.openError(window.getShell(), "Error",
					"This command is only valid for spear files");
			return;
		}

		XtextEditor xtextEditor = (XtextEditor) editor;
		IXtextDocument document = xtextEditor.getDocument();

		document.readOnly(new IUnitOfWork<Void, XtextResource>() {
			@Override
			public java.lang.Void exec(XtextResource state) throws Exception {

				if(!(state.getContents().get(0) instanceof Procedure)) {
					MessageDialog.openError(window.getShell(), "Error",
							"Reasoning can only be done on procedures.");
					return null;
				}
				Procedure file = (Procedure) state.getContents().get(0);
				if (hasErrors(file.eResource())) {
					MessageDialog.openError(window.getShell(), "Error",
							"Reasoning can only be done on well-formed specifications.");
					return null;
				}
				
				Layout spearLayout = new SpearLayout(file);
				//page showview has to be set before setting the layout, else NPE
				JKindResultsView page = (JKindResultsView) window.getActivePage().showView(JKindResultsView.ID);
				page.setLayout(spearLayout);
				Operations.reason(file, page);
				return null;
			}
		});
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}