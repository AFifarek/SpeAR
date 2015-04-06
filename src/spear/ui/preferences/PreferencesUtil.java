package spear.ui.preferences;

import jkind.SolverOption;
import jkind.api.JKindApi;

import org.eclipse.jface.preference.IPreferenceStore;

import spear.ui.internal.LanguageActivator;

public class PreferencesUtil {
	public static JKindApi getJKindApi() {
		IPreferenceStore prefs = LanguageActivator.getInstance().getPreferenceStore();
		JKindApi api = new JKindApi();
		
		api.setInductiveCounterexamples();

		String solverString = prefs.getString(PreferenceConstants.PREF_SOLVER)
				.toUpperCase().replaceAll(" ", "");
		SolverOption solver = SolverOption.valueOf(solverString);
		api.setSolver(solver);

		if (!prefs.getBoolean(PreferenceConstants.PREF_BOUNDED_MODEL_CHECKING)) {
			api.disableBoundedModelChecking();
		}
		if (!prefs.getBoolean(PreferenceConstants.PREF_K_INDUCTION)) {
			api.disableKInduction();
		}
		if (!prefs.getBoolean(PreferenceConstants.PREF_INVARIANT_GENERATION)) {
			api.disableInvariantGeneration();
		}
		api.setPdrMax(prefs.getInt(PreferenceConstants.PREF_PDR_MAX));
		if (prefs.getBoolean(PreferenceConstants.PREF_INTERVAL_GENERALIZATION)) {
			api.setIntervalGeneralization();
		}

		api.setN(prefs.getInt(PreferenceConstants.PREF_DEPTH));
		api.setTimeout(prefs.getInt(PreferenceConstants.PREF_TIMEOUT));
		return api;
	}
}
