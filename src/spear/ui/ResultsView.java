package spear.ui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import jkind.api.results.JKindResult;
import jkind.api.results.PropertyResult;
import jkind.api.ui.AnalysisResultTable;
import jkind.results.Counterexample;
import jkind.results.InvalidProperty;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ResultsView extends ViewPart {
	public static final String ID = "spear.specifications.resultsView";
	private AnalysisResultTable table;

	public ResultsView() {
		super();
	}

	@Override
	public void createPartControl(final Composite parent) {
		table = new AnalysisResultTable(parent);
		table.getViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection sel = (IStructuredSelection) event.getSelection();
					if (!sel.isEmpty()) {
						click(parent, (PropertyResult) sel.getFirstElement());
					}
				}
			}
		});
	}

	public static void click(Composite parent, PropertyResult pr) {
		if (pr.getStatus() == jkind.api.results.Status.INVALID) {
			InvalidProperty ip = (InvalidProperty) pr.getProperty();
			Counterexample cex = ip.getCounterexample();

			try {
				File file = File.createTempFile("cex", ".xls");
				cex.toExcel(file);
				openFile(file);
			} catch (Throwable t) {
				MessageDialog.openError(parent.getShell(), "Error opening Excel file",
						t.getMessage());
			}
		}
	}

	public static void openFile(File file) throws IOException {
		if (System.getProperty("os.name").startsWith("Windows")) {
			/*
			 * Desktop.open is slow initially on Windows, so we call explorer
			 * directly instead
			 */
			new ProcessBuilder("explorer", file.toString()).start();
		} else {
			Desktop.getDesktop().open(file);
		}
	}

	@Override
	public void setFocus() {
		table.getControl().setFocus();
	}

	public void setInput(JKindResult result) {
		table.setInput(result);
	}
}
