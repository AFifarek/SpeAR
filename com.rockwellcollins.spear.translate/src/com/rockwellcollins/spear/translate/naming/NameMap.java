package com.rockwellcollins.spear.translate.naming;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.translate.master.Utilities;

public class NameMap {

	public Map<File,FileMap> map;
	
	private FileMap getFileMap(File file) {
		if(map.containsKey(file)) {
			return map.get(file);
		} else {
			return new FileMap(file);
		}
	}
	
	private void insertFileMap(File file, FileMap filemap) {
		map.put(file, filemap);
	}
	
	public NameMap() {
		map = new HashMap<>();
	}
	
	public NameMap(NameMap nameMap) {
		map = new HashMap<>(nameMap.map);
	}
	
	/* these three methods are used for getting unique names*/
	public String getDefinitionsName(EObject o) {
		File root = Utilities.getRoot(o);
		FileMap fm = getFileMap(root);
		String renamed = fm.getDefinitionsName(o);
		insertFileMap(root,fm);
		return renamed;
	}
	
	public String getName(EObject o) {
		File root = Utilities.getRoot(o);
		FileMap fm = getFileMap(root);
		String renamed = fm.getName(o);
		insertFileMap(root,fm);
		return renamed;
	}
	
	public String getFileBasedName(EObject o) {
		File root = Utilities.getRoot(o);
		FileMap fm = getFileMap(root);
		String renamed = fm.getFileBasedName(o);
		insertFileMap(root,fm);
		return renamed;
	}
	
	/* this method is used for looking up names */
	public String lookup(EObject o) {
		File root = Utilities.getRoot(o);
		FileMap fm = map.get(root);
		return fm.lookup(o);
	}

}
