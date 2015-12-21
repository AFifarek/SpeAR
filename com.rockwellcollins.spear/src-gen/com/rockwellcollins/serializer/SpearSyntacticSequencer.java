package com.rockwellcollins.serializer;

import com.google.inject.Inject;
import com.rockwellcollins.services.SpearGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class SpearSyntacticSequencer extends AbstractSyntacticSequencer {

	protected SpearGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AtomicExpr_LeftParenthesisKeyword_9_0_a;
	protected AbstractElementAlias match_AtomicExpr_LeftParenthesisKeyword_9_0_p;
	protected AbstractElementAlias match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_a;
	protected AbstractElementAlias match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_p;
	protected AbstractElementAlias match_Definitions_ConstantsKeyword_4_0_q;
	protected AbstractElementAlias match_Definitions_TypesKeyword_3_0_q;
	protected AbstractElementAlias match_Definitions_UnitsKeyword_2_0_q;
	protected AbstractElementAlias match_Specification_AssumptionsKeyword_12_0_q;
	protected AbstractElementAlias match_Specification_ConstantsKeyword_5_0_q;
	protected AbstractElementAlias match_Specification_ImportsKeyword_2_0_q;
	protected AbstractElementAlias match_Specification_MacrosKeyword_11_0_q;
	protected AbstractElementAlias match_Specification_RequirementsKeyword_15_0_q;
	protected AbstractElementAlias match_Specification_StateKeyword_10_0_q;
	protected AbstractElementAlias match_Specification_TypesKeyword_4_0_q;
	protected AbstractElementAlias match_Specification_UnitsKeyword_3_0_q;
	protected AbstractElementAlias match_Variable_ColonKeyword_1_0_or_IsAKeyword_1_1;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SpearGrammarAccess) access;
		match_AtomicExpr_LeftParenthesisKeyword_9_0_a = new TokenAlias(true, true, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_9_0());
		match_AtomicExpr_LeftParenthesisKeyword_9_0_p = new TokenAlias(true, false, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_9_0());
		match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_a = new TokenAlias(true, true, grammarAccess.getAtomicUnitExprAccess().getLeftParenthesisKeyword_1_0());
		match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_p = new TokenAlias(true, false, grammarAccess.getAtomicUnitExprAccess().getLeftParenthesisKeyword_1_0());
		match_Definitions_ConstantsKeyword_4_0_q = new TokenAlias(false, true, grammarAccess.getDefinitionsAccess().getConstantsKeyword_4_0());
		match_Definitions_TypesKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getDefinitionsAccess().getTypesKeyword_3_0());
		match_Definitions_UnitsKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getDefinitionsAccess().getUnitsKeyword_2_0());
		match_Specification_AssumptionsKeyword_12_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getAssumptionsKeyword_12_0());
		match_Specification_ConstantsKeyword_5_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getConstantsKeyword_5_0());
		match_Specification_ImportsKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getImportsKeyword_2_0());
		match_Specification_MacrosKeyword_11_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getMacrosKeyword_11_0());
		match_Specification_RequirementsKeyword_15_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getRequirementsKeyword_15_0());
		match_Specification_StateKeyword_10_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getStateKeyword_10_0());
		match_Specification_TypesKeyword_4_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getTypesKeyword_4_0());
		match_Specification_UnitsKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getSpecificationAccess().getUnitsKeyword_3_0());
		match_Variable_ColonKeyword_1_0_or_IsAKeyword_1_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getVariableAccess().getColonKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getVariableAccess().getIsAKeyword_1_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AtomicExpr_LeftParenthesisKeyword_9_0_a.equals(syntax))
				emit_AtomicExpr_LeftParenthesisKeyword_9_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AtomicExpr_LeftParenthesisKeyword_9_0_p.equals(syntax))
				emit_AtomicExpr_LeftParenthesisKeyword_9_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_a.equals(syntax))
				emit_AtomicUnitExpr_LeftParenthesisKeyword_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AtomicUnitExpr_LeftParenthesisKeyword_1_0_p.equals(syntax))
				emit_AtomicUnitExpr_LeftParenthesisKeyword_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Definitions_ConstantsKeyword_4_0_q.equals(syntax))
				emit_Definitions_ConstantsKeyword_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Definitions_TypesKeyword_3_0_q.equals(syntax))
				emit_Definitions_TypesKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Definitions_UnitsKeyword_2_0_q.equals(syntax))
				emit_Definitions_UnitsKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Specification_AssumptionsKeyword_12_0_q.equals(syntax))
				emit_Specification_AssumptionsKeyword_12_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Specification_ConstantsKeyword_5_0_q.equals(syntax))
				emit_Specification_ConstantsKeyword_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Specification_ImportsKeyword_2_0_q.equals(syntax))
				emit_Specification_ImportsKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Specification_MacrosKeyword_11_0_q.equals(syntax))
				emit_Specification_MacrosKeyword_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Specification_RequirementsKeyword_15_0_q.equals(syntax))
				emit_Specification_RequirementsKeyword_15_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Specification_StateKeyword_10_0_q.equals(syntax))
				emit_Specification_StateKeyword_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Specification_TypesKeyword_4_0_q.equals(syntax))
				emit_Specification_TypesKeyword_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Specification_UnitsKeyword_3_0_q.equals(syntax))
				emit_Specification_UnitsKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Variable_ColonKeyword_1_0_or_IsAKeyword_1_1.equals(syntax))
				emit_Variable_ColonKeyword_1_0_or_IsAKeyword_1_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_AtomicExpr_LeftParenthesisKeyword_9_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_AtomicExpr_LeftParenthesisKeyword_9_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_AtomicUnitExpr_LeftParenthesisKeyword_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_AtomicUnitExpr_LeftParenthesisKeyword_1_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'Constants:'?
	 */
	protected void emit_Definitions_ConstantsKeyword_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'Types:'?
	 */
	protected void emit_Definitions_TypesKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'Units:'?
	 */
	protected void emit_Definitions_UnitsKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'Assumptions:'?
	 */
	protected void emit_Specification_AssumptionsKeyword_12_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'Constants:'?
	 */
	protected void emit_Specification_ConstantsKeyword_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'Imports:'?
	 */
	protected void emit_Specification_ImportsKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'Macros:'?
	 */
	protected void emit_Specification_MacrosKeyword_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'Requirements:'?
	 */
	protected void emit_Specification_RequirementsKeyword_15_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'State:'?
	 */
	protected void emit_Specification_StateKeyword_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'Types:'?
	 */
	protected void emit_Specification_TypesKeyword_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'Units:'?
	 */
	protected void emit_Specification_UnitsKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ':' | 'is a'
	 */
	protected void emit_Variable_ColonKeyword_1_0_or_IsAKeyword_1_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
