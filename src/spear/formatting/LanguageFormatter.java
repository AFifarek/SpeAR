
package spear.formatting;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

import spear.services.LanguageGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an
 * example
 */
public class LanguageFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {

		LanguageGrammarAccess f = (LanguageGrammarAccess) getGrammarAccess();

		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(f.getML_COMMENTRule());

		for (Keyword semicolon : f.findKeywords(";")) {
			c.setNoSpace().before(semicolon);
		}

		c.setAutoLinewrap(1000);

		// set a newline after each constant, property, type, and variable
		c.setLinewrap().after(f.getConstantRule());
		c.setLinewrap().after(f.getTypeDefRule());
		c.setLinewrap().after(f.getVariableRule());

		// do not add spaces between enumeration type values in declarations
		c.setNoSpace().before(
				f.getEnumerationTypeAccess().getCommaKeyword_2_0());

		// do not add spaces after the # enumeration expressions
		c.setNoSpace().after(f.getEnumeratorRule());

		// do not add spaces after the Unary Op and the sub expression
		c.setNoSpace().after(f.getUnaryOpAccess().getHyphenMinusKeyword_0_1());

		// do not add spaces in RecordTypes
		c.setNoSpace().after(
				f.getRecordTypeAccess().getLeftCurlyBracketKeyword_0());
		c.setNoSpace().before(
				f.getRecordTypeAccess().getRightCurlyBracketKeyword_3());
		c.setNoSpace().before(f.getRecordTypeAccess().getCommaKeyword_2_0());


		// do not add spaces before and after the = in recordFieldExprs, and
		// recordFields
		c.setNoSpace().before(
				f.getRecordFieldExprAccess().getEqualsSignKeyword_1());
		c.setNoSpace().after(
				f.getRecordFieldExprAccess().getEqualsSignKeyword_1());


	}
}
