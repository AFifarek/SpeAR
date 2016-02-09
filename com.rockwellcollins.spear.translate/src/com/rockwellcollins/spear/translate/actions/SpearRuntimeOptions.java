package com.rockwellcollins.spear.translate.actions;

import com.rockwellcollins.spear.ui.preferences.PreferencesUtil;

public class SpearRuntimeOptions {

	public static boolean createDebugFiles = true;
	public static int consistencyDepth = 10;
	
	public static void setRuntimeOptions() {
		SpearRuntimeOptions.consistencyDepth = PreferencesUtil.getConsistencyDepthOption();
		SpearRuntimeOptions.createDebugFiles = PreferencesUtil.getSpearDeubgOption();
	}
}
