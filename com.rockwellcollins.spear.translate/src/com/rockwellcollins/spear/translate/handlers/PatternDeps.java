package com.rockwellcollins.spear.translate.handlers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.handlers.PatternDeps.Status;
import com.rockwellcollins.spear.util.SpearSwitch;
import com.rockwellcollins.spear.utilities.Utilities;

public class PatternDeps extends SpearSwitch<Status> {

	public enum Status { DONE }

	private Set<EObject> elements = new HashSet<>();
	private List<EObject> copied = new ArrayList<>();
	
	public PatternDeps(Pattern p) {
		File root = com.rockwellcollins.spear.utilities.Utilities.getRoot(p);
		elements.add(root);
		this.doSwitch(p);
		copied = new ArrayList<>(EcoreUtil2.copyAll(elements));
	}
	
	public List<TypeDef> getTypeDefs() {
		List<TypeDef> typedefs = new ArrayList<>();
		for(EObject o : copied) {
			if (o instanceof TypeDef) {
				typedefs.add((TypeDef) o);
			}
		}
		return typedefs;
	}
	
	public List<Constant> getConstants() {
		List<Constant> constants = new ArrayList<>();
		for(EObject o : copied) {
			if (o instanceof Constant) {
				constants.add((Constant) o);
			}
		}
		return constants;
	}
	
	public List<Pattern> getPatterns() {
		List<Pattern> patterns = new ArrayList<>();
		for(EObject o : copied) {
			if (o instanceof Pattern) {
				patterns.add((Pattern) o);
			}
		}
		return patterns;
	}
	
	@Override
	public Status caseTypeDef(TypeDef td) {
		elements.add(td);
		this.defaultCase(td);
		return Status.DONE;
	}
	
	@Override
	public Status caseConstant(Constant c) {
		elements.add(c);
		this.defaultCase(c);
		return Status.DONE;
	}
	
	@Override
	public Status casePattern(Pattern p) {
		elements.add(p);
		this.defaultCase(p);
		return Status.DONE;
	}
	
	@Override
	public Status defaultCase(EObject e) {
		for(EObject sub : e.eContents()) {
			this.doSwitch(sub);
		}
		
		for(EObject ref : e.eCrossReferences()) {
			File root = Utilities.getRoot(ref);
			elements.add(root);
			this.doSwitch(ref);	
		}
		return Status.DONE;
	}
}
