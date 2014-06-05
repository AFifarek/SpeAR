package spear.ui;

import java.io.FileOutputStream;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
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
import com.google.inject.Inject;

public class ActionTranslate implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	
	@Inject
	public IResourceValidator validator;
	
	public ActionTranslate() {
	}

	
	public boolean hasErrors(Resource res)
	{
    List<Issue> issues = validator.validate(res, CheckMode.ALL,CancelIndicator.NullImpl);
    for (Issue issue : issues) 
    {
      if (issue.getSeverity() == Severity.ERROR) return true;
    }
    return false;
	}
	
	public void run(IAction action) {
	  
	  
		IEditorPart editor = window.getActivePage().getActiveEditor();
		
		if (!(editor instanceof XtextEditor)) {
			MessageDialog.openError(window.getShell(), "Error",
					"This command is only valid for spear files");
		}

		XtextEditor xtextEditor = (XtextEditor) editor;
		IXtextDocument document = xtextEditor.getDocument();
		
		document.readOnly(new IUnitOfWork<Void, XtextResource>() {
			public java.lang.Void exec(XtextResource state) throws Exception {
				if(!(state.getContents().get(0) instanceof Procedure)) {
					MessageDialog.openError(window.getShell(), "Error",
							"Translation can only be done on procedures.");
					return null;
				}
				Procedure file = (Procedure) state.getContents().get(0);
				if(hasErrors(file.eResource()))
				{
				  MessageDialog.openError(window.getShell(), "Error",
		          "Translation can only be done on well-formed specifications.");
				  return null;
				}
				String string = Operations.translate(file);
				URI uri = file.eResource().getURI();
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IFile ofile = root.getFile(new Path(uri.appendFileExtension("lus").toPlatformString(true)));
				FileOutputStream fout = new FileOutputStream(ofile.getLocation().toOSString());
				fout.write(string.getBytes());
				ofile.refreshLocal(IResource.DEPTH_INFINITE, null);
				fout.close();
				return null;	
			}
		});
	}

	public void selectionChanged(IAction action, ISelection selection) {
	}

	public void dispose() {
	}

	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}