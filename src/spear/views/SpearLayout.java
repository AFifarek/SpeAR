package spear.views;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.EcoreUtil2;

import jkind.results.layout.Layout;
import spear.language.DerReqSection;
import spear.language.InputSection;
import spear.language.NamedFormula;
import spear.language.OutputSection;
import spear.language.Procedure;
import spear.language.ReqSection;
import spear.language.StateSection;
import spear.language.Variable;

public class SpearLayout implements Layout {
	private final Map<String, String> map;
	
	private static final String INPUTS = "Inputs";
	private static final String OUTPUTS = "Outputs";
	private static final String STATE = "State";
	private static final String DERIVED_REQUIREMENTS = "DerivedRequirements";
	private static final String REQUIREMENTS = "Requirements";
	private static final String[] CATEGORIES = { INPUTS, OUTPUTS, STATE, REQUIREMENTS, DERIVED_REQUIREMENTS};

	public SpearLayout(Procedure p) {
		if (p == null) {
			throw new IllegalArgumentException("Unable to create layout for null procedure");
		}
		
		this.map = new HashMap<>();
		
		
		for(InputSection inputs : EcoreUtil2.getAllContentsOfType(p, InputSection.class)) {
			for (Variable v : EcoreUtil2.getAllContentsOfType(inputs, Variable.class)) {
				map.put(v.getName(), INPUTS);
			}
		}

		for(OutputSection outputs : EcoreUtil2.getAllContentsOfType(p, OutputSection.class)) {
			for (Variable v : EcoreUtil2.getAllContentsOfType(outputs, Variable.class)) {
				map.put(v.getName(), OUTPUTS);
			}
		}

		for(StateSection locals : EcoreUtil2.getAllContentsOfType(p, StateSection.class)) {
			for (Variable v : EcoreUtil2.getAllContentsOfType(locals, Variable.class)) {
				map.put(v.getName(), STATE);
			}
		}
		
		for(DerReqSection requirements : EcoreUtil2.getAllContentsOfType(p, DerReqSection.class)) {
			for (NamedFormula req : EcoreUtil2.getAllContentsOfType(requirements, NamedFormula.class)) {
				map.put(req.getName(), DERIVED_REQUIREMENTS);
			}
		}

		for(ReqSection properties : EcoreUtil2.getAllContentsOfType(p, ReqSection.class)) {
			for (NamedFormula prop : EcoreUtil2.getAllContentsOfType(properties, NamedFormula.class)) {
				map.put(prop.getName(), REQUIREMENTS);
			}
		}
	}

	@Override
	public List<String> getCategories() {
		return Arrays.asList(CATEGORIES);
	}

	@Override
	public String getCategory(String signal) {
		String prefix = signal.split("\\.|\\[")[0];
		return map.get(prefix);
	}
}