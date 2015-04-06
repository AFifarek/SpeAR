package spear.ui.preferences;

import jkind.api.JKindApi;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import spear.ui.internal.LanguageActivator;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */
public class SpeARPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public SpeARPreferencePage() {
		super(GRID);
		setPreferenceStore(LanguageActivator.getInstance().getPreferenceStore());
	}

	private static final String[][] SOLVERS = {
			{ PreferenceConstants.SOLVER_YICES, PreferenceConstants.SOLVER_YICES },
			{ PreferenceConstants.SOLVER_Z3, PreferenceConstants.SOLVER_Z3 },
			{ PreferenceConstants.SOLVER_CVC4, PreferenceConstants.SOLVER_CVC4 },
			{ PreferenceConstants.SOLVER_YICES2, PreferenceConstants.SOLVER_YICES2 },
			{ PreferenceConstants.SOLVER_MATHSAT, PreferenceConstants.SOLVER_MATHSAT },
			{ PreferenceConstants.SOLVER_SMTINTERPOL, PreferenceConstants.SOLVER_SMTINTERPOL } };
	private ComboFieldEditor solverFieldEditor;

	private BooleanFieldEditor bmcFieldEditor;
	private BooleanFieldEditor kInductionFieldEditor;
	private BooleanFieldEditor invGenFieldEditor;
	private NonNegativeIntegerFieldEditor pdrMaxFieldEditor;
	private BooleanFieldEditor intervalGenFieldEditor;
	private NonNegativeIntegerFieldEditor depthFieldEditor;
	private NonNegativeIntegerFieldEditor timeoutFieldEditor;

	@Override
	public void createFieldEditors() {
		solverFieldEditor = new ComboFieldEditor(PreferenceConstants.PREF_SOLVER, "SMT Solver",
				SOLVERS, getFieldEditorParent());
		addField(solverFieldEditor);

		bmcFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_BOUNDED_MODEL_CHECKING,
				"Use bounded model checking", getFieldEditorParent());
		addField(bmcFieldEditor);

		kInductionFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_K_INDUCTION,
				"Use k-induction", getFieldEditorParent());
		addField(kInductionFieldEditor);

		invGenFieldEditor = new BooleanFieldEditor(PreferenceConstants.PREF_INVARIANT_GENERATION,
				"Use invariant generation", getFieldEditorParent());
		addField(invGenFieldEditor);

		pdrMaxFieldEditor = new NonNegativeIntegerFieldEditor(PreferenceConstants.PREF_PDR_MAX,
				"Maximum number of PDR instances (0 to disable)", getFieldEditorParent());
		addField(pdrMaxFieldEditor);

		intervalGenFieldEditor = new BooleanFieldEditor(
				PreferenceConstants.PREF_INTERVAL_GENERALIZATION,
				"Generalize counterexamples using interval analysis", getFieldEditorParent());
		addField(intervalGenFieldEditor);

		depthFieldEditor = new NonNegativeIntegerFieldEditor(PreferenceConstants.PREF_DEPTH,
				"Maximum depth for k-induction", getFieldEditorParent());
		addField(depthFieldEditor);

		timeoutFieldEditor = new NonNegativeIntegerFieldEditor(PreferenceConstants.PREF_TIMEOUT,
				"Timeout in seconds", getFieldEditorParent());
		addField(timeoutFieldEditor);

		Button checkAvailableButton = new Button(getFieldEditorParent(), SWT.PUSH);
		checkAvailableButton.setText("Check if available");
		checkAvailableButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				checkAvailable();
			}
		});
	}

	private void checkAvailable() {
		try {
			JKindApi api = PreferencesUtil.getJKindApi();
			api.checkAvailable();
			MessageDialog.openInformation(getShell(), "JKind available",
					"JKind available");
		} catch (Exception e) {
			MessageDialog.openError(getShell(), "Error running JKind",
					"Error running JKind: " + e.getMessage());
		}
	}

	private class NonNegativeIntegerFieldEditor extends IntegerFieldEditor {
		public NonNegativeIntegerFieldEditor(String name, String labelText, Composite parent) {
			super(name, labelText, parent);
			setValidRange(0, Integer.MAX_VALUE);
			setErrorMessage("Field must be a non-negative integer");
		}
	}

	@Override
	public void init(IWorkbench workbench) {
	}
}