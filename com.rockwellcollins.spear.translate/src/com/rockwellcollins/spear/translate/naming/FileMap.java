package com.rockwellcollins.spear.translate.naming;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.translate.master.Utilities;

public class FileMap {
	private File file;
	private DualHashBidiMap<String,String> filemap = new DualHashBidiMap<>();
	
	public FileMap(File file) {
		this.file=file;
	}
	
	private String getUniqueName(String proposed) {
		Integer unique = 0;
		String renamed = proposed;
		while(filemap.containsKey(renamed)) {
			renamed = proposed + "_" + unique;
			unique++;
		}
		return renamed;
	}
	
	private void register(String original, String renamed) {
		filemap.put(renamed, original);
	}
	
	public String getName(EObject o) {
		String original = Utilities.getName(o);
		String renamed = getUniqueName(original);
		register(original,renamed);
		return renamed;
	}
	
	public String getFileBasedName(EObject o) {
		String original = Utilities.getName(o);
		String proposed = file.getName() + "_" + original;
		String renamed = getUniqueName(proposed);
		register(original,renamed);
		return renamed;
	}
	
	public String getDefinitionsName(EObject o) {
		String original = Utilities.getName(o);
		String proposed = file.getName() + "_" + original + "_definition";
		String renamed = getUniqueName(proposed);
		register(original,renamed);
		return renamed;
	}
	
	private String lookup(String key) {
		return this.filemap.inverseBidiMap().get(key);
	}
	
	public String lookup(EObject o) {
		String name = Utilities.getName(o);
		return lookup(name);
	}
}
