package com.rockwellcollins.spear.translate.actions;

import com.rockwellcollins.spear.ui.preferences.PreferencesUtil;

public class SpearRuntimeOptions {

	//TODO: Remove or provide a way to create the Debug Files since we moved to the SpearDocument feature.
	public static boolean createDebugFiles = false;
	public static int consistencyDepth = 10;
	protected static boolean printFinalLustre = false;
	
	public static void setRuntimeOptions() {
		SpearRuntimeOptions.consistencyDepth = PreferencesUtil.getConsistencyDepthOption();
		SpearRuntimeOptions.createDebugFiles = PreferencesUtil.getSpearDebugOption();
		SpearRuntimeOptions.printFinalLustre = PreferencesUtil.getFinalLustreFileOption();
	}
}
