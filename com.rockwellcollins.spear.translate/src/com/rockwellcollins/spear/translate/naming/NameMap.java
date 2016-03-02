package com.rockwellcollins.spear.translate.naming;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.translate.master.SFile;
import com.rockwellcollins.spear.translate.master.Utilities;

public class NameMap {

	public Map<File,FileMap> map = new LinkedHashMap<>();
	public Map<File,SFile> mapping = new LinkedHashMap<>();
	
	public void addFile(File f, SFile sfile) {
		mapping.put(f, sfile);
		map.put(f, new FileMap(f));
	}
	
	/* these three methods are used for getting unique names*/
	public String getDefinitionsName(EObject o) {
		File root = Utilities.getRoot(o);
		FileMap fm = map.get(root);
		String renamed = fm.getDefinitionsName(o);
		map.put(root,fm);
		return renamed;
	}
	
	public String getShadowName(Variable v) {
		File root = Utilities.getRoot(v);
		FileMap fm = map.get(root);
		String renamed = fm.getShadowName(v);
		map.put(root, fm);
		return renamed;
	}
	
	public String getName(EObject o) {
		File root = Utilities.getRoot(o);
		FileMap fm = map.get(root);
		String renamed = fm.getName(o);
		map.put(root, fm);
		return renamed;
	}
	
	public String getFileBasedName(EObject o) {
		File root = Utilities.getRoot(o);
		FileMap fm = map.get(root);
		String renamed = fm.getFileBasedName(o);
		map.put(root, fm);
		return renamed;
	}
	
	/* this method is used for looking up names */
	public String lookup(EObject o) {
		File root = Utilities.getRoot(o);
		FileMap fm = map.get(root);
		return fm.lookup(o);
	}
}
