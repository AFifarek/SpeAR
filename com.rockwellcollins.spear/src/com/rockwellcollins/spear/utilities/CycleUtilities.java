package com.rockwellcollins.spear.utilities;

import java.util.List;

public class CycleUtilities {

	public static String getCycleErrorMessage(List<String> cycle) {
		StringBuilder text = new StringBuilder();
		boolean first = true;
		for (String node : cycle) {
			if (first) {
				first = false;
			} else {
				text.append(" -> ");
			}
			text.append(node);
		}
		return text.toString();
	}
}
