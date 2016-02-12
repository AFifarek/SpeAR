package com.rockwellcollins.spear.translate.experimental;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.SpecificationCall;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.translate.transformations.GetReferences;

public class SpearProgram extends SpearAst {

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

	public SpearProgram(Specification s) {
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
}
