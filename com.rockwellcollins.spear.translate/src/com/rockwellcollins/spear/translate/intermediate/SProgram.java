package com.rockwellcollins.spear.translate.intermediate;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.translate.lustre.PLTL;

import jkind.lustre.Node;
import jkind.lustre.Program;
import jkind.lustre.builders.ProgramBuilder;

public class SProgram {

	public Set<SPattern> patterns = new HashSet<>();
	public Set<STypeDef> typedefs = new HashSet<>();
	public Set<SConstant> constants = new HashSet<>();
	public Set<SNode> calledNodes = new HashSet<>();
	public SNode main;

	public SProgram(Specification s) {
		main = new SNode(s);
	}
	
	public static Naming getInitialNaming() {
		Naming scope = new Naming();
		for(Node n : PLTL.getPLTL()) {
			scope.getUniqueLocalNameAndRegister(n.id);
		}
		return scope;
	}

	public Program getLogicalEntailment() {
		ProgramBuilder program = new ProgramBuilder();
		
		//get the PLTL stuff
		program.addNodes(PLTL.getPLTL());
		
		/*
		 * 1. add the PLTL patterns
		 * 2. add the typedefs
		 * 3. add the constants
		 */
		program.addTypes(main.getRecursiveLustreTypeDefs());
		program.addConstants(main.getRecursiveLustreConstants());

		/*
		 * At some point we'll have to add user patterns
		 * 1. They'll have to be uniquely named
		 * 2. We'll have to grab them recursively
		 */
		//TODO: add support for user patterns
		
		Set<Node> calledNodes = new HashSet<>();
		for(SNode called : main.calls.values()) {
			calledNodes.add(called.getLogicalEntailment().build());
			calledNodes.addAll(called.getCalledNodes());
		}
		program.addNodes(calledNodes);
		Node mainNode = main.getLogicalEntailment().build();
		program.setMain(mainNode.id);
		program.addNode(mainNode);
		return program.build();
	}
	
	@Override
	public String toString() {
		return StringUtils.join(typedefs, "\n\n") + StringUtils.join(constants, "\n\n")
				+ StringUtils.join(calledNodes, "\n\n") + main.toString();
	}
}
