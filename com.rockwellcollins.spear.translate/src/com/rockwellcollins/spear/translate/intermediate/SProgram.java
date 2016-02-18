package com.rockwellcollins.spear.translate.intermediate;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.lustre.PLTL;
import com.rockwellcollins.spear.translate.transformations.ReferenceFinder;

import jkind.lustre.Node;
import jkind.lustre.Program;
import jkind.lustre.builders.ProgramBuilder;

public class SProgram extends SContextElement {

	public Set<SPattern> patterns = new HashSet<>();
	public Set<STypeDef> typedefs = new HashSet<>();
	public Set<SConstant> constants = new HashSet<>();
	public Set<SNode> calledNodes = new HashSet<>();
	public SNode main;

	public SProgram(Specification s) {
		scope = new Naming();
		patterns.addAll(SPattern.convert(PLTL.getPLTL(), this));
		
		//get the referenced elements, still global
		ReferenceFinder finder = ReferenceFinder.get(s);
		typedefs.addAll(STypeDef.convertList(finder.typedefs, this));
		constants.addAll(SConstant.convertList(finder.constants, this));
		main = new SNode(s, this);
	}

	public Program getLogicalEntailment() {
		ProgramBuilder program = new ProgramBuilder();
		
		/*
		 * 1. add the patterns
		 * 2. add the typedefs
		 * 3. add the constants
		 */
		program.addNodes(SPattern.toLustre(patterns, this));
		program.addTypes(STypeDef.toLustre(typedefs, this));
		program.addConstants(SConstant.toLustre(constants, this));

		Node mainNode = main.getLogicalEntailment().build();
		program.setMain(mainNode.id);
		return program.build();
	}
	
	@Override
	public String toString() {
		return StringUtils.join(typedefs, "\n\n") + StringUtils.join(constants, "\n\n")
				+ StringUtils.join(calledNodes, "\n\n") + main.toString();
	}
}
