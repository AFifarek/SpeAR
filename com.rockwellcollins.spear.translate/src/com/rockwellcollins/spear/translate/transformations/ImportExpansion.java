package com.rockwellcollins.spear.translate.transformations;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.Macro;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.UnitDef;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.util.SpearSwitch;

public class ImportExpansion extends SpearSwitch<EObject> {

	public static Specification transform(Specification s) {
		return (Specification) new ImportExpansion().doSwitch(s);
	}
	
	private Set<UnitDef> units = new HashSet<>();
	private Set<TypeDef> typedefs = new HashSet<>();
	private Set<Constant> constants = new HashSet<>();
	private Set<Pattern> patterns = new HashSet<>();
	private Set<Variable> inputs = new HashSet<>();
	private Set<Variable> outputs = new HashSet<>();
	private Set<Variable> state = new HashSet<>();
	private Set<Macro> macros = new HashSet<>();
	private Set<Constraint> assumptions = new HashSet<>();
	private Set<Constraint> requirements = new HashSet<>();
	private Set<Constraint> behaviors = new HashSet<>();
	
	private Element element;
	
	private enum Element {
			UNITS, TYPEDEFS, CONSTANTS, 
			PATTERNS, INPUTS, OUTPUTS, 
			STATE, MACROS, ASSUMPTIONS, 
			REQUIREMENTS, BEHAVIORS
	}
	
	@Override
	public EObject caseSpecification(Specification s) {
		element = Element.UNITS;
		for(UnitDef ud : s.getUnits()) {
			this.doSwitch(ud);
		}
		
		element = Element.TYPEDEFS;
		for(TypeDef td : s.getTypedefs()) {
			this.doSwitch(td);
		}
		
		element = Element.CONSTANTS;
		for(Constant c : s.getConstants()) {
			this.doSwitch(c);
		}
		
		element = Element.PATTERNS;
		for(Pattern p : s.getPatterns()) {
			this.doSwitch(p);
		}
		
		element = Element.INPUTS;
		for(Variable v : s.getInputs()) {
			this.doSwitch(v);
		}
		
		element = Element.OUTPUTS;
		for(Variable v : s.getOutputs()) {
			this.doSwitch(v);
		}
		
		element = Element.STATE;
		for(Variable v : s.getState()) {
			this.doSwitch(v);
		}
		
		element = Element.MACROS;
		for(Macro m : s.getMacros()) {
			this.doSwitch(m);
		}
		
		element = Element.ASSUMPTIONS;
		for(Constraint c : s.getAssumptions()) {
			this.doSwitch(c);
		}
		
		element = Element.REQUIREMENTS;
		for(Constraint c : s.getRequirements()) {
			this.doSwitch(c);
		}
		
		element = Element.BEHAVIORS;
		for(Constraint c : s.getBehaviors()) {
			this.doSwitch(c);
		}
		
		s.getImports().clear();
		
		s.getUnits().clear();
		s.getUnits().addAll(EcoreUtil2.copyAll(units));
		
		s.getTypedefs().clear();
		s.getTypedefs().addAll(EcoreUtil2.copyAll(typedefs));
		
		s.getConstants().clear();
		s.getConstants().addAll(EcoreUtil2.copyAll(constants));
		
		s.getPatterns().clear();
		s.getPatterns().addAll(EcoreUtil2.copyAll(patterns));
		
		s.getInputs().clear();
		s.getInputs().addAll(EcoreUtil2.copyAll(inputs));
		
		s.getOutputs().clear();
		s.getOutputs().addAll(EcoreUtil2.copyAll(outputs));
		
		s.getState().clear();
		s.getState().addAll(EcoreUtil2.copyAll(state));
		
		s.getMacros().clear();
		s.getMacros().addAll(EcoreUtil2.copyAll(macros));
		
		s.getAssumptions().clear();
		s.getAssumptions().addAll(EcoreUtil2.copyAll(assumptions));
		
		s.getRequirements().clear();
		s.getRequirements().addAll(EcoreUtil2.copyAll(requirements));
		
		s.getBehaviors().clear();
		s.getBehaviors().addAll(EcoreUtil2.copyAll(behaviors));
		
		return s;
	}
	
	@Override
	public EObject caseUnitDef(UnitDef ud) {
		units.add(ud);
		this.defaultCase(ud);
		return ud;
	}
	
	@Override
	public EObject caseTypeDef(TypeDef td) {
		typedefs.add(td);
		this.defaultCase(td);
		return td;
	}
	
	@Override
	public EObject caseConstant(Constant c) {
		constants.add(c);
		this.defaultCase(c);
		return c;
	}
	
	@Override
	public EObject caseVariable(Variable v) {
		switch (element) {
			case INPUTS:
				inputs.add(v);
				break;
				
			case OUTPUTS:
				outputs.add(v);
				break;
				
			case STATE:
				state.add(v);
				break;
				
			default:
				throw new RuntimeException("Element field was set incorrectly.");
		}
		
		this.defaultCase(v);
		return v;
	}
	
	@Override
	public EObject caseMacro(Macro m) {
		macros.add(m);
		this.defaultCase(m);
		return m;
	}
	
	@Override
	public EObject caseConstraint(Constraint c) {
		switch(element) {
			case ASSUMPTIONS:
				assumptions.add(c);
				break;
				
			case REQUIREMENTS:
				requirements.add(c);
				break;
				
			case BEHAVIORS:
				behaviors.add(c);
				break;
				
			default:
				throw new RuntimeException("Element field was set incorrectly.");
		}
		this.defaultCase(c);
		return c;
	}
	
	@Override
	public EObject defaultCase(EObject e) {
		for(EObject sub : e.eContents()) {
			this.doSwitch(sub);
		}
		
		for(EObject ref : e.eCrossReferences()) {
			this.doSwitch(ref);
		}
		return e;
	}

}
