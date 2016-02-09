package com.rockwellcollins.spear.translate.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import jkind.api.ui.counterexample.CounterexampleTreeViewer;
import jkind.results.Counterexample;
import jkind.results.layout.Layout;

/**
 * JKindCounterexampleView is a view.
 */
public class SpearCounterexampleView extends ViewPart {
	public static final String ID = "com.rockwellcollins.spear.translate.views.SpearCounterexampleView";

	private CounterexampleTreeViewer tree;

	@Override
	public void createPartControl(Composite parent) {
		tree = new CounterexampleTreeViewer(parent);
	}

	@Override
	public void setFocus() {
		tree.setFocus();
	}

	public void setInput(Counterexample cex, Layout layout) {
		tree.setInput(cex, layout);
	}
}
