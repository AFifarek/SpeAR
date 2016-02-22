package com.rockwellcollins.spear.translate.lustre;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import jkind.lustre.Node;

public class TestPLTL {

	public static void main(String[] args) {
		Set<Node> nodes = PLTL.getPLTL();
		System.out.println(StringUtils.join(nodes.toString(), "\n\n"));
		
		System.exit(-1);
	}
}
