package com.rockwellcollins.spear.translate.master;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

/**
 * This class manages the various aspects of the SpeAR to Lustre translation.
 * @author lgwagner
 *
 */
public class Naming {

	//this needs to be reimplemented.
	private BidiMap<String,String> map = new DualHashBidiMap<>();
	
	public Naming() {
		map = new DualHashBidiMap<>();
	}
	
	public Naming(Naming existing) {
		map = new DualHashBidiMap<>();
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
		map.put(renamed, original);
	}
	
	public String getSpecificationBasedName(String specificationName, String original) {
		String proposed = specificationName + "_" + original;
		String renamed = getUniqueName(proposed);
		register(original,renamed);
		return renamed;
	}
	
	public String getName(String original) {
		String renamed = getUniqueName(original);
		register(original,renamed);
		return renamed;
	}
	
	public String lookup(String original) {
		return map.inverseBidiMap().get(original);
	}
}
