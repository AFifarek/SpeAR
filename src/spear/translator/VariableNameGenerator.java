package spear.translator;

import java.util.HashMap;
import java.util.Map;

public class VariableNameGenerator {
	private static int count = 0;
	private static Map<String, String> names = new HashMap<String, String>();

	public static String getVariableName(String str, String dsc) {
		String name = "_gen_" + str + "_" + Integer.toString(count++);
		names.put(name, dsc);
		return name;
	}

	public static String getVariableName(String dsc) {
		String name = "_gen_" + Integer.toString(count++);
		names.put(name, dsc);
		return name;
	}

	public static Map<String, String> getNames() {
		return names;
	}
}
