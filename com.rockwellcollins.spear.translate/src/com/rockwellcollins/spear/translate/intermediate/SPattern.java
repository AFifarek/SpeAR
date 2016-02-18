package com.rockwellcollins.spear.translate.intermediate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jkind.lustre.Node;
import jkind.lustre.builders.NodeBuilder;

public class SPattern extends SAst {

	public static List<SPattern> convert(Collection<Node> list, SProgram context) {
		List<SPattern> converted = new ArrayList<>();
		for(Node n : list) {
			converted.add(new SPattern(n,context));
		}
		return converted;
	}
	
	public static List<Node> toLustre(Collection<SPattern> list, SProgram context) {
		List<Node> lustre = new ArrayList<>();
		for(SPattern spattern : list) {
			lustre.add(spattern.toLustre());
		}
		return lustre;
	}
	
	public String name;
	private Node node;

	public SPattern(Node n, SProgram context) {
		this.name = context.scope.getUniqueNameAndRegister(n.id);
		NodeBuilder builder = new NodeBuilder(n);
		builder.setId(name);
		node = builder.build();
	}
	
	public Node toLustre() {
		return node;
	}
	
	@Override
	public String toString() {
		return toLustre().toString();
	}
}
