package com.rockwellcollins.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.UserType;
import com.rockwellcollins.spear.utilities.CycleUtilities;
import com.rockwellcollins.validation.AbstractSpearJavaValidator;

import jkind.util.CycleFinder;

public class TypesAcyclicValidator extends AbstractSpearJavaValidator {

	@Check
	public void checkTypeDefAcyclic(Specification spec) {
		Map<String, Set<String>> dependencies = getDependencies(spec);
		List<String> cycle = CycleFinder.findCycle(dependencies);
		if(cycle != null) {
			error(spec, cycle);
		}
	}

	protected Map<String, Set<String>> getDependencies(Specification spec) {
		Map<String, Set<String>> dependencies = new HashMap<>();
		for(TypeDef def : spec.getTypedefs()) {
			Set<String> set = new HashSet<>();
			for (UserType dep : EcoreUtil2.getAllContentsOfType(def, UserType.class)) {
				set.add(dep.getDef().getName());
			}
			dependencies.put(def.getName(), set);
		}
		return dependencies;
	}
	
	protected void error(Specification spec, List<String> cycle) {
		String message = "Cycle in types " + CycleUtilities.getCycleErrorMessage(cycle);
		Map<String, TypeDef> table = getTypeDefTable(spec);
		boolean first = true;
		for(String node : cycle) {
			if (first) {
				first = false;
			} else {
				error(message, table.get(node), SpearPackage.Literals.TYPE_DEF__NAME);
			}
		}
	}
	
	private Map<String, TypeDef> getTypeDefTable(Specification spec) {
		Map<String, TypeDef> table = new HashMap<>();
		for(TypeDef def : spec.getTypedefs()) {
			table.put(def.getName(), def);
		}
		return table;
	}
	
	@Override
	public void register(EValidatorRegistrar registrar) {
		// this is intentionally empty to prevent the composed check from registering itself.
	}
}
