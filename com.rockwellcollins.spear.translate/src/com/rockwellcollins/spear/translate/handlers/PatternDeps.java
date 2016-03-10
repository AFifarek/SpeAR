package com.rockwellcollins.spear.translate.handlers;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.handlers.PatternDeps.Status;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.Utilities;

public class PatternDeps extends SpearSwitch<Status> {

	public enum Status { DONE }

	public Set<File> files = new HashSet<>();
	public Set<TypeDef> typedefs = new HashSet<>();
	public Set<Constant> constants = new HashSet<>();
	public Set<Pattern> patterns = new HashSet<>();
	
	public PatternDeps(Pattern p) {
		this.doSwitch(p);
	}
	
	@Override
	public Status caseTypeDef(TypeDef td) {
		typedefs.add(td);
		files.add(Utilities.getRoot(td));
		this.defaultCase(td);
		return Status.DONE;
	}
	
	@Override
	public Status caseConstant(Constant c) {
		constants.add(c);
		files.add(Utilities.getRoot(c));
		this.defaultCase(c);
		return Status.DONE;
	}
	
	@Override
	public Status casePattern(Pattern p) {
		patterns.add(p);
		files.add(Utilities.getRoot(p));
		this.defaultCase(p);
		return Status.DONE;
	}
	
	@Override
	public Status defaultCase(EObject e) {
		for(EObject sub : e.eContents()) {
			this.doSwitch(sub);
		}
		
		for(EObject ref : e.eCrossReferences()) {
			this.doSwitch(ref);	
		}
		return Status.DONE;
	}
}
