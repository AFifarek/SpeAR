package com.rockwellcollins.spear.translate.experimental;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.SpecificationCall;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.lustre.HelperNodes;
import com.rockwellcollins.spear.translate.lustre.TranslateDecl;
import com.rockwellcollins.spear.translate.transformations.GetReferences;

import jkind.lustre.Node;
import jkind.lustre.Program;
import jkind.lustre.builders.NodeBuilder;
import jkind.lustre.builders.ProgramBuilder;

public class SpearProgram extends SpearAst {

	public static Program translateLogicalEntailment(Specification s) {
		SpearProgram spearProgram = new SpearProgram(s);
		return spearProgram.logicalCheck();
	}
	
	public static Program translateConsistencyCheck(Specification s) {
		SpearProgram spearProgram = new SpearProgram(s);
		return spearProgram.consistencyCheck();
	}
	/*
	 * Each of these maps has the object of interest (in the keyset) and the
	 * object it was derived from.
	 * 
	 * For example if a typedef td was from specification s then the map entry
	 * would be td -> s
	 * 
	 * This will be useful for making unique Lustre names later.
	 */
	public List<SpearTypeDef> typedefs = new ArrayList<>();
	public List<SpearConstant> constants = new ArrayList<>();
	public List<SpearNode> called_specifications = new ArrayList<>();
	public SpearNode main;
	
	private Manager naming;

	public SpearProgram(Specification s) {
		naming = new Manager();
		Map<EObject, EObject> references = GetReferences.getReferences(s);
		for (TypeDef typedef : s.getTypedefs()) {
			typedefs.add(new SpearTypeDef(typedef,s));
		}

		for (Constant constant : s.getConstants()) {
			constants.add(new SpearConstant(constant,s));
		}

		for (EObject o : references.keySet()) {
			if (o instanceof TypeDef) {
				TypeDef typedef = (TypeDef) o;
				typedefs.add(new SpearTypeDef(typedef, references.get(o)));
			}

			if (o instanceof Constant) {
				Constant constant = (Constant) o;
				constants.add(new SpearConstant(constant, references.get(0)));
			}
		}

		for (SpecificationCall call : EcoreUtil2.getAllContentsOfType(s, SpecificationCall.class)) {
			called_specifications.add(new SpearNode(call.getSpec()));
		}
		main = new SpearNode(s);
	}
	
	private List<Node> addHelperNodes() {
		List<Node> nodes = new ArrayList<>();
		for(Node n : HelperNodes.getPLTL()) {
			NodeBuilder node = new NodeBuilder(n);
			String renamed = naming.getUniqueNameAndRegister(n.id);
			node.setId(renamed);
			nodes.add(node.build());
		}
		return nodes;
	}
	
	private String prependSpecName(SpearTypeDef spearTypeDef) {
		if (spearTypeDef.root instanceof Specification) {
			Specification s = (Specification) spearTypeDef.root;
			return s.getName() + "_" + spearTypeDef.typedef.getName();
		}
		
		if (spearTypeDef.root instanceof Definitions) {
			Definitions definitions = (Definitions) spearTypeDef.root;
			return definitions.getName() + "_" + spearTypeDef.typedef.getName();
		}
		
		throw new RuntimeException("Root object should be a specification or definitions file.");
	}
	
	private List<jkind.lustre.TypeDef> processTypeDefs() {
		List<jkind.lustre.TypeDef> typedefs = new ArrayList<>();
		for(SpearTypeDef spearTypeDef : this.typedefs) {
			String proposed = prependSpecName(spearTypeDef);
			String renamed = naming.getUniqueNameAndRegister(proposed);
			typedefs.add((jkind.lustre.TypeDef) TranslateDecl.translate(spearTypeDef.typedef, naming));
		}
		return typedefs;
	}
	
	private String prependSpecName(SpearConstant spearConstant) {
		if (spearConstant.root instanceof Specification) {
			Specification s = (Specification) spearConstant.root;
			return s.getName() + "_" + spearConstant.constant.getName();
		}
		
		if (spearConstant.root instanceof Definitions) {
			Definitions definitions = (Definitions) spearConstant.root;
			return definitions.getName() + "_" + spearConstant.constant.getName();
		}
		
		throw new RuntimeException("Root object should be a specification or definitions file.");
	}
	
	private List<jkind.lustre.Constant> processConstants() {
		List<jkind.lustre.Constant> constants = new ArrayList<>();
		for(SpearConstant spearConstant : this.constants) {
			String proposed = prependSpecName(spearConstant);
			String renamed = naming.getUniqueNameAndRegister(proposed);
			constants.add((jkind.lustre.Constant) TranslateDecl.translate(spearConstant.constant, naming));
		}
		return constants;
	}

	public Program logicalCheck() {
		ProgramBuilder program = new ProgramBuilder();
		naming = new Manager();
		program.addNodes(addHelperNodes());
		program.addTypes(processTypeDefs());
		program.addConstants(processConstants());
		//program.addNodes(processCalledSpecs());
		Node mainNode = main.getBaseLustre(naming);
		program.addNode(main.addLogicalProperties(mainNode));
		return program.build();
	}
	
	public Program consistencyCheck() {
		ProgramBuilder program = new ProgramBuilder();
		naming = new Manager();
		program.addNodes(addHelperNodes());
		program.addTypes(processTypeDefs());
		program.addConstants(processConstants());
		//program.addNodes(processCalledSpecs());
		Node mainNode = main.getBaseLustre(naming);
		program.addNode(main.addConsistencyProperties(mainNode));
		return program.build();
	}
}
