package com.rockwellcollins.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.IdExpr;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.utilities.CycleUtilities;

import jkind.util.CycleFinder;

public class ConstantsAcyclicValidator extends AbstractSpearJavaValidator {

	@Check
	public void checkConstantsAcyclic(Specification spec) {
		Map<String, Set<String>> dependencies = getDependencies(spec);
		List<String> cycle = CycleFinder.findCycle(dependencies);
		if(cycle != null) {
			error(spec, cycle);
		}
	}
	
	protected Map<String, Set<String>> getDependencies(Specification spec) {
		Map<String, Set<String>> dependencies = new HashMap<>();
		for(Constant c : spec.getConstants()) {
			Set<String> set = new HashSet<>();
			for (IdExpr ide : EcoreUtil2.getAllContentsOfType(c, IdExpr.class)) {
				if(ide.getId() instanceof Constant) {
					Constant c2 = (Constant) ide.getId();
					set.add(c2.getName());
				}
			}
			dependencies.put(c.getName(), set);
		}
		return dependencies;
	}
	
	protected void error(Specification spec, List<String> cycle) {
		String message = "Cycle in constant definitions " + CycleUtilities.getCycleErrorMessage(cycle);
		Map<String, Constant> table = getConstantTable(spec);
		boolean first = true;
		for(String node : cycle) {
			if (first) {
				first = false;
			} else {
				error(message, table.get(node), SpearPackage.Literals.CONSTANT__EXPR);
			}
		}
	}
	
	private Map<String, Constant> getConstantTable(Specification spec) {
		Map<String, Constant> table = new HashMap<>();
		for(Constant c : spec.getConstants()) {
			table.put(c.getName(), c);
		}
		return table;
	}
	
	@Override
	public void register(EValidatorRegistrar registrar) {
		// this is intentionally empty to prevent the composed check from registering itself.
	}
}
