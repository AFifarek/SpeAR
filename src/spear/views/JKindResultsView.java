package spear.views;

import jkind.api.results.JKindResult;
import jkind.api.ui.results.AnalysisResultTable;
import jkind.results.layout.Layout;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class JKindResultsView extends ViewPart {
	public static final String ID = "spear.views.JKindResultsView";

	private AnalysisResultTable table;
	private JKindMenuListener menuListener;
	
	public JKindResultsView() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		table = new AnalysisResultTable(parent);
		menuListener = new JKindMenuListener(this.getViewSite().getWorkbenchWindow(), table);
		MenuManager manager = new MenuManager();
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(menuListener);
		table.getControl().setMenu(manager.createContextMenu(table.getViewer().getTable()));
	}

	public void setLayout(Layout layout) {
		menuListener.setLayout(layout);
	}
	
	public void setInput(JKindResult result) {
		table.setInput(result);
	}
	
	@Override
	public void setFocus() {
		table.getControl().setFocus();
	}
}
