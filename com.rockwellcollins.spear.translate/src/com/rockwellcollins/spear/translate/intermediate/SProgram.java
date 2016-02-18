package com.rockwellcollins.spear.translate.intermediate;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.experimental.Naming;
import com.rockwellcollins.spear.translate.transformations.ReferenceFinder;

public class SProgram extends SAst {

	protected Naming scope;

	public Set<STypeDef> typedefs = new HashSet<>();
	public Set<SConstant> constants = new HashSet<>();
	public Set<SNode> calledNodes = new HashSet<>();
	public SNode main;

	public SProgram(Specification s) {
		scope = new Naming();
		
		//get the referenced elements, still global
		ReferenceFinder finder = ReferenceFinder.get(s);
		typedefs.addAll(STypeDef.convertList(finder.typedefs, this));
		constants.addAll(SConstant.convertList(finder.constants, this));
		main = new SNode(s, this);
	}

	@Override
	public String toString() {
		return StringUtils.join(typedefs, "\n\n") + StringUtils.join(constants, "\n\n")
				+ StringUtils.join(calledNodes, "\n\n") + main.toString();
	}
}
