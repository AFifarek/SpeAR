package com.rockwellcollins.spear.translate.experimental;

import java.util.HashMap;
import java.util.Map;

/**
 * This class manages the various aspects of the SpeAR to Lustre translation.
 * @author lgwagner
 *
 */
public class Naming {

	private Map<String,String> map;
	
	public Naming() {
		map = new HashMap<>();
	}
	
	public Naming(Naming existing) {
		map = new HashMap<>();
		map.putAll(existing.map);
	}
	
	private String getUniqueName(String original) {
		Integer unique = 0;
		String renamed = original;
		while(map.containsKey(renamed)) {
			renamed = original + unique;
			unique++;
		}
		return renamed;
	}
	
	private void register(String original, String renamed) {
		map.put(original, renamed);
	}
	
	public String getUniqueNameAndRegister(String original) {
		String renamed = getUniqueName(original);
		register(original,renamed);
		return renamed;
	}
	
	public String lookup(String original) {
		return map.get(original);
	}
}
