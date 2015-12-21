package com.rockwellcollins.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.rockwellcollins.services.SpearGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalSpearParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Specification'", "'Imports:'", "'Units:'", "'Types:'", "'Constants:'", "'Inputs:'", "'Outputs:'", "'State:'", "'Macros:'", "'Assumptions:'", "'DerivedRequirements:'", "'Requirements:'", "'import'", "'Definitions'", "'Patterns'", "'Pattern'", "','", "'Lustre:'", "'English:'", "':'", "'*'", "'/'", "'('", "')'", "'='", "'record'", "'{'", "'}'", "'['", "']'", "'enum'", "'int'", "'bool'", "'real'", "'is a'", "'=>'", "'implies'", "'or'", "'xor'", "'and'", "'T'", "'triggers'", "'S'", "'since'", "'<'", "'<='", "'>'", "'>='", "'=='", "'<>'", "'+'", "'-'", "'not'", "'O'", "'once'", "'H'", "'historically'", "'.'", "':='", "'|'", "'prev'", "'if'", "'then'", "'else'", "'new'", "'pattern'", "'spec'", "'TRUE'", "'true'", "'FALSE'", "'false'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalSpearParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSpearParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSpearParser.tokenNames; }
    public String getGrammarFileName() { return "../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g"; }



     	private SpearGrammarAccess grammarAccess;
     	
        public InternalSpearParser(TokenStream input, SpearGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	}
       	
       	@Override
       	protected SpearGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleFile"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:67:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:68:2: (iv_ruleFile= ruleFile EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:69:2: iv_ruleFile= ruleFile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFileRule()); 
            }
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile75);
            iv_ruleFile=ruleFile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFile; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFile"


    // $ANTLR start "ruleFile"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:76:1: ruleFile returns [EObject current=null] : (this_Specification_0= ruleSpecification | this_Definitions_1= ruleDefinitions | this_Patterns_2= rulePatterns ) ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject this_Specification_0 = null;

        EObject this_Definitions_1 = null;

        EObject this_Patterns_2 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:79:28: ( (this_Specification_0= ruleSpecification | this_Definitions_1= ruleDefinitions | this_Patterns_2= rulePatterns ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:80:1: (this_Specification_0= ruleSpecification | this_Definitions_1= ruleDefinitions | this_Patterns_2= rulePatterns )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:80:1: (this_Specification_0= ruleSpecification | this_Definitions_1= ruleDefinitions | this_Patterns_2= rulePatterns )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 24:
                {
                alt1=2;
                }
                break;
            case 25:
                {
                alt1=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:81:5: this_Specification_0= ruleSpecification
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFileAccess().getSpecificationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSpecification_in_ruleFile132);
                    this_Specification_0=ruleSpecification();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Specification_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:91:5: this_Definitions_1= ruleDefinitions
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFileAccess().getDefinitionsParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDefinitions_in_ruleFile159);
                    this_Definitions_1=ruleDefinitions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Definitions_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:101:5: this_Patterns_2= rulePatterns
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFileAccess().getPatternsParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_rulePatterns_in_ruleFile186);
                    this_Patterns_2=rulePatterns();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Patterns_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleSpecification"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:117:1: entryRuleSpecification returns [EObject current=null] : iv_ruleSpecification= ruleSpecification EOF ;
    public final EObject entryRuleSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecification = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:118:2: (iv_ruleSpecification= ruleSpecification EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:119:2: iv_ruleSpecification= ruleSpecification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpecificationRule()); 
            }
            pushFollow(FOLLOW_ruleSpecification_in_entryRuleSpecification221);
            iv_ruleSpecification=ruleSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpecification; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpecification231); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecification"


    // $ANTLR start "ruleSpecification"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:126:1: ruleSpecification returns [EObject current=null] : (otherlv_0= 'Specification' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? otherlv_10= 'Inputs:' ( (lv_inputs_11_0= ruleVariable ) )* otherlv_12= 'Outputs:' ( (lv_outputs_13_0= ruleVariable ) )* (otherlv_14= 'State:' ( (lv_state_15_0= ruleVariable ) )* )? (otherlv_16= 'Macros:' ( (lv_macros_17_0= ruleMacro ) )* )? (otherlv_18= 'Assumptions:' ( (lv_assumptions_19_0= ruleConstraint ) )* )? otherlv_20= 'DerivedRequirements:' ( (lv_requirements_21_0= ruleConstraint ) )* (otherlv_22= 'Requirements:' ( (lv_behaviors_23_0= ruleConstraint ) )* )? ) ;
    public final EObject ruleSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        EObject lv_imports_3_0 = null;

        EObject lv_units_5_0 = null;

        EObject lv_typedefs_7_0 = null;

        EObject lv_constants_9_0 = null;

        EObject lv_inputs_11_0 = null;

        EObject lv_outputs_13_0 = null;

        EObject lv_state_15_0 = null;

        EObject lv_macros_17_0 = null;

        EObject lv_assumptions_19_0 = null;

        EObject lv_requirements_21_0 = null;

        EObject lv_behaviors_23_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:129:28: ( (otherlv_0= 'Specification' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? otherlv_10= 'Inputs:' ( (lv_inputs_11_0= ruleVariable ) )* otherlv_12= 'Outputs:' ( (lv_outputs_13_0= ruleVariable ) )* (otherlv_14= 'State:' ( (lv_state_15_0= ruleVariable ) )* )? (otherlv_16= 'Macros:' ( (lv_macros_17_0= ruleMacro ) )* )? (otherlv_18= 'Assumptions:' ( (lv_assumptions_19_0= ruleConstraint ) )* )? otherlv_20= 'DerivedRequirements:' ( (lv_requirements_21_0= ruleConstraint ) )* (otherlv_22= 'Requirements:' ( (lv_behaviors_23_0= ruleConstraint ) )* )? ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:130:1: (otherlv_0= 'Specification' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? otherlv_10= 'Inputs:' ( (lv_inputs_11_0= ruleVariable ) )* otherlv_12= 'Outputs:' ( (lv_outputs_13_0= ruleVariable ) )* (otherlv_14= 'State:' ( (lv_state_15_0= ruleVariable ) )* )? (otherlv_16= 'Macros:' ( (lv_macros_17_0= ruleMacro ) )* )? (otherlv_18= 'Assumptions:' ( (lv_assumptions_19_0= ruleConstraint ) )* )? otherlv_20= 'DerivedRequirements:' ( (lv_requirements_21_0= ruleConstraint ) )* (otherlv_22= 'Requirements:' ( (lv_behaviors_23_0= ruleConstraint ) )* )? )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:130:1: (otherlv_0= 'Specification' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? otherlv_10= 'Inputs:' ( (lv_inputs_11_0= ruleVariable ) )* otherlv_12= 'Outputs:' ( (lv_outputs_13_0= ruleVariable ) )* (otherlv_14= 'State:' ( (lv_state_15_0= ruleVariable ) )* )? (otherlv_16= 'Macros:' ( (lv_macros_17_0= ruleMacro ) )* )? (otherlv_18= 'Assumptions:' ( (lv_assumptions_19_0= ruleConstraint ) )* )? otherlv_20= 'DerivedRequirements:' ( (lv_requirements_21_0= ruleConstraint ) )* (otherlv_22= 'Requirements:' ( (lv_behaviors_23_0= ruleConstraint ) )* )? )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:130:3: otherlv_0= 'Specification' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? otherlv_10= 'Inputs:' ( (lv_inputs_11_0= ruleVariable ) )* otherlv_12= 'Outputs:' ( (lv_outputs_13_0= ruleVariable ) )* (otherlv_14= 'State:' ( (lv_state_15_0= ruleVariable ) )* )? (otherlv_16= 'Macros:' ( (lv_macros_17_0= ruleMacro ) )* )? (otherlv_18= 'Assumptions:' ( (lv_assumptions_19_0= ruleConstraint ) )* )? otherlv_20= 'DerivedRequirements:' ( (lv_requirements_21_0= ruleConstraint ) )* (otherlv_22= 'Requirements:' ( (lv_behaviors_23_0= ruleConstraint ) )* )?
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleSpecification268); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSpecificationAccess().getSpecificationKeyword_0());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:134:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:135:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:135:1: (lv_name_1_0= RULE_ID )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:136:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpecification285); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getSpecificationAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getSpecificationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:152:2: (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:152:4: otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )*
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleSpecification303); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSpecificationAccess().getImportsKeyword_2_0());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:156:1: ( (lv_imports_3_0= ruleImport ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==23) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:157:1: (lv_imports_3_0= ruleImport )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:157:1: (lv_imports_3_0= ruleImport )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:158:3: lv_imports_3_0= ruleImport
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getImportsImportParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleImport_in_ruleSpecification324);
                    	    lv_imports_3_0=ruleImport();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"imports",
                    	              		lv_imports_3_0, 
                    	              		"Import");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:174:5: (otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:174:7: otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )*
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleSpecification340); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getSpecificationAccess().getUnitsKeyword_3_0());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:178:1: ( (lv_units_5_0= ruleUnitDef ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:179:1: (lv_units_5_0= ruleUnitDef )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:179:1: (lv_units_5_0= ruleUnitDef )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:180:3: lv_units_5_0= ruleUnitDef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getUnitsUnitDefParserRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleUnitDef_in_ruleSpecification361);
                    	    lv_units_5_0=ruleUnitDef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"units",
                    	              		lv_units_5_0, 
                    	              		"UnitDef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:196:5: (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:196:7: otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )*
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleSpecification377); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getSpecificationAccess().getTypesKeyword_4_0());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:200:1: ( (lv_typedefs_7_0= ruleTypeDef ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==RULE_ID) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:201:1: (lv_typedefs_7_0= ruleTypeDef )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:201:1: (lv_typedefs_7_0= ruleTypeDef )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:202:3: lv_typedefs_7_0= ruleTypeDef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getTypedefsTypeDefParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTypeDef_in_ruleSpecification398);
                    	    lv_typedefs_7_0=ruleTypeDef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typedefs",
                    	              		lv_typedefs_7_0, 
                    	              		"TypeDef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:218:5: (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:218:7: otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )*
                    {
                    otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleSpecification414); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getSpecificationAccess().getConstantsKeyword_5_0());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:222:1: ( (lv_constants_9_0= ruleConstant ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_ID) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:223:1: (lv_constants_9_0= ruleConstant )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:223:1: (lv_constants_9_0= ruleConstant )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:224:3: lv_constants_9_0= ruleConstant
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getConstantsConstantParserRuleCall_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleConstant_in_ruleSpecification435);
                    	    lv_constants_9_0=ruleConstant();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"constants",
                    	              		lv_constants_9_0, 
                    	              		"Constant");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,16,FOLLOW_16_in_ruleSpecification450); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getSpecificationAccess().getInputsKeyword_6());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:244:1: ( (lv_inputs_11_0= ruleVariable ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:245:1: (lv_inputs_11_0= ruleVariable )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:245:1: (lv_inputs_11_0= ruleVariable )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:246:3: lv_inputs_11_0= ruleVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getInputsVariableParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariable_in_ruleSpecification471);
            	    lv_inputs_11_0=ruleVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"inputs",
            	              		lv_inputs_11_0, 
            	              		"Variable");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleSpecification484); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getSpecificationAccess().getOutputsKeyword_8());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:266:1: ( (lv_outputs_13_0= ruleVariable ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:267:1: (lv_outputs_13_0= ruleVariable )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:267:1: (lv_outputs_13_0= ruleVariable )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:268:3: lv_outputs_13_0= ruleVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getOutputsVariableParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariable_in_ruleSpecification505);
            	    lv_outputs_13_0=ruleVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"outputs",
            	              		lv_outputs_13_0, 
            	              		"Variable");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:284:3: (otherlv_14= 'State:' ( (lv_state_15_0= ruleVariable ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==18) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:284:5: otherlv_14= 'State:' ( (lv_state_15_0= ruleVariable ) )*
                    {
                    otherlv_14=(Token)match(input,18,FOLLOW_18_in_ruleSpecification519); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getSpecificationAccess().getStateKeyword_10_0());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:288:1: ( (lv_state_15_0= ruleVariable ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:289:1: (lv_state_15_0= ruleVariable )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:289:1: (lv_state_15_0= ruleVariable )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:290:3: lv_state_15_0= ruleVariable
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getStateVariableParserRuleCall_10_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleVariable_in_ruleSpecification540);
                    	    lv_state_15_0=ruleVariable();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"state",
                    	              		lv_state_15_0, 
                    	              		"Variable");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:306:5: (otherlv_16= 'Macros:' ( (lv_macros_17_0= ruleMacro ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==19) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:306:7: otherlv_16= 'Macros:' ( (lv_macros_17_0= ruleMacro ) )*
                    {
                    otherlv_16=(Token)match(input,19,FOLLOW_19_in_ruleSpecification556); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getSpecificationAccess().getMacrosKeyword_11_0());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:310:1: ( (lv_macros_17_0= ruleMacro ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_ID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:311:1: (lv_macros_17_0= ruleMacro )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:311:1: (lv_macros_17_0= ruleMacro )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:312:3: lv_macros_17_0= ruleMacro
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getMacrosMacroParserRuleCall_11_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMacro_in_ruleSpecification577);
                    	    lv_macros_17_0=ruleMacro();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"macros",
                    	              		lv_macros_17_0, 
                    	              		"Macro");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:328:5: (otherlv_18= 'Assumptions:' ( (lv_assumptions_19_0= ruleConstraint ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==20) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:328:7: otherlv_18= 'Assumptions:' ( (lv_assumptions_19_0= ruleConstraint ) )*
                    {
                    otherlv_18=(Token)match(input,20,FOLLOW_20_in_ruleSpecification593); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getSpecificationAccess().getAssumptionsKeyword_12_0());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:332:1: ( (lv_assumptions_19_0= ruleConstraint ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_ID) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:333:1: (lv_assumptions_19_0= ruleConstraint )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:333:1: (lv_assumptions_19_0= ruleConstraint )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:334:3: lv_assumptions_19_0= ruleConstraint
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getAssumptionsConstraintParserRuleCall_12_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleConstraint_in_ruleSpecification614);
                    	    lv_assumptions_19_0=ruleConstraint();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"assumptions",
                    	              		lv_assumptions_19_0, 
                    	              		"Constraint");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_20=(Token)match(input,21,FOLLOW_21_in_ruleSpecification629); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_20, grammarAccess.getSpecificationAccess().getDerivedRequirementsKeyword_13());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:354:1: ( (lv_requirements_21_0= ruleConstraint ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:355:1: (lv_requirements_21_0= ruleConstraint )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:355:1: (lv_requirements_21_0= ruleConstraint )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:356:3: lv_requirements_21_0= ruleConstraint
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getRequirementsConstraintParserRuleCall_14_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleConstraint_in_ruleSpecification650);
            	    lv_requirements_21_0=ruleConstraint();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"requirements",
            	              		lv_requirements_21_0, 
            	              		"Constraint");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:372:3: (otherlv_22= 'Requirements:' ( (lv_behaviors_23_0= ruleConstraint ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==22) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:372:5: otherlv_22= 'Requirements:' ( (lv_behaviors_23_0= ruleConstraint ) )*
                    {
                    otherlv_22=(Token)match(input,22,FOLLOW_22_in_ruleSpecification664); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getSpecificationAccess().getRequirementsKeyword_15_0());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:376:1: ( (lv_behaviors_23_0= ruleConstraint ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:377:1: (lv_behaviors_23_0= ruleConstraint )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:377:1: (lv_behaviors_23_0= ruleConstraint )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:378:3: lv_behaviors_23_0= ruleConstraint
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getBehaviorsConstraintParserRuleCall_15_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleConstraint_in_ruleSpecification685);
                    	    lv_behaviors_23_0=ruleConstraint();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"behaviors",
                    	              		lv_behaviors_23_0, 
                    	              		"Constraint");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecification"


    // $ANTLR start "entryRuleImport"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:402:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:403:2: (iv_ruleImport= ruleImport EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:404:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport724);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport734); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:411:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:414:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:415:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:415:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:415:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleImport771); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:419:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:420:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:420:1: (lv_importURI_1_0= RULE_STRING )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:421:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport788); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getImportRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"importURI",
                      		lv_importURI_1_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleDefinitions"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:445:1: entryRuleDefinitions returns [EObject current=null] : iv_ruleDefinitions= ruleDefinitions EOF ;
    public final EObject entryRuleDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinitions = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:446:2: (iv_ruleDefinitions= ruleDefinitions EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:447:2: iv_ruleDefinitions= ruleDefinitions EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefinitionsRule()); 
            }
            pushFollow(FOLLOW_ruleDefinitions_in_entryRuleDefinitions829);
            iv_ruleDefinitions=ruleDefinitions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefinitions; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinitions839); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinitions"


    // $ANTLR start "ruleDefinitions"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:454:1: ruleDefinitions returns [EObject current=null] : (otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Units:' ( (lv_unitdefs_3_0= ruleUnitDef ) )* )? (otherlv_4= 'Types:' ( (lv_typedefs_5_0= ruleTypeDef ) )* )? (otherlv_6= 'Constants:' ( (lv_constants_7_0= ruleConstant ) )* )? ) ;
    public final EObject ruleDefinitions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_unitdefs_3_0 = null;

        EObject lv_typedefs_5_0 = null;

        EObject lv_constants_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:457:28: ( (otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Units:' ( (lv_unitdefs_3_0= ruleUnitDef ) )* )? (otherlv_4= 'Types:' ( (lv_typedefs_5_0= ruleTypeDef ) )* )? (otherlv_6= 'Constants:' ( (lv_constants_7_0= ruleConstant ) )* )? ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:458:1: (otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Units:' ( (lv_unitdefs_3_0= ruleUnitDef ) )* )? (otherlv_4= 'Types:' ( (lv_typedefs_5_0= ruleTypeDef ) )* )? (otherlv_6= 'Constants:' ( (lv_constants_7_0= ruleConstant ) )* )? )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:458:1: (otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Units:' ( (lv_unitdefs_3_0= ruleUnitDef ) )* )? (otherlv_4= 'Types:' ( (lv_typedefs_5_0= ruleTypeDef ) )* )? (otherlv_6= 'Constants:' ( (lv_constants_7_0= ruleConstant ) )* )? )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:458:3: otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Units:' ( (lv_unitdefs_3_0= ruleUnitDef ) )* )? (otherlv_4= 'Types:' ( (lv_typedefs_5_0= ruleTypeDef ) )* )? (otherlv_6= 'Constants:' ( (lv_constants_7_0= ruleConstant ) )* )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleDefinitions876); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDefinitionsAccess().getDefinitionsKeyword_0());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:462:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:463:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:463:1: (lv_name_1_0= RULE_ID )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:464:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinitions893); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getDefinitionsAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDefinitionsRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:480:2: (otherlv_2= 'Units:' ( (lv_unitdefs_3_0= ruleUnitDef ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==13) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:480:4: otherlv_2= 'Units:' ( (lv_unitdefs_3_0= ruleUnitDef ) )*
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleDefinitions911); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDefinitionsAccess().getUnitsKeyword_2_0());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:484:1: ( (lv_unitdefs_3_0= ruleUnitDef ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==RULE_ID) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:485:1: (lv_unitdefs_3_0= ruleUnitDef )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:485:1: (lv_unitdefs_3_0= ruleUnitDef )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:486:3: lv_unitdefs_3_0= ruleUnitDef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDefinitionsAccess().getUnitdefsUnitDefParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleUnitDef_in_ruleDefinitions932);
                    	    lv_unitdefs_3_0=ruleUnitDef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDefinitionsRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"unitdefs",
                    	              		lv_unitdefs_3_0, 
                    	              		"UnitDef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:502:5: (otherlv_4= 'Types:' ( (lv_typedefs_5_0= ruleTypeDef ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==14) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:502:7: otherlv_4= 'Types:' ( (lv_typedefs_5_0= ruleTypeDef ) )*
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleDefinitions948); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDefinitionsAccess().getTypesKeyword_3_0());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:506:1: ( (lv_typedefs_5_0= ruleTypeDef ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==RULE_ID) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:507:1: (lv_typedefs_5_0= ruleTypeDef )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:507:1: (lv_typedefs_5_0= ruleTypeDef )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:508:3: lv_typedefs_5_0= ruleTypeDef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDefinitionsAccess().getTypedefsTypeDefParserRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTypeDef_in_ruleDefinitions969);
                    	    lv_typedefs_5_0=ruleTypeDef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDefinitionsRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typedefs",
                    	              		lv_typedefs_5_0, 
                    	              		"TypeDef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:524:5: (otherlv_6= 'Constants:' ( (lv_constants_7_0= ruleConstant ) )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==15) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:524:7: otherlv_6= 'Constants:' ( (lv_constants_7_0= ruleConstant ) )*
                    {
                    otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleDefinitions985); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDefinitionsAccess().getConstantsKeyword_4_0());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:528:1: ( (lv_constants_7_0= ruleConstant ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==RULE_ID) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:529:1: (lv_constants_7_0= ruleConstant )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:529:1: (lv_constants_7_0= ruleConstant )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:530:3: lv_constants_7_0= ruleConstant
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDefinitionsAccess().getConstantsConstantParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleConstant_in_ruleDefinitions1006);
                    	    lv_constants_7_0=ruleConstant();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDefinitionsRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"constants",
                    	              		lv_constants_7_0, 
                    	              		"Constant");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefinitions"


    // $ANTLR start "entryRulePatterns"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:554:1: entryRulePatterns returns [EObject current=null] : iv_rulePatterns= rulePatterns EOF ;
    public final EObject entryRulePatterns() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatterns = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:555:2: (iv_rulePatterns= rulePatterns EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:556:2: iv_rulePatterns= rulePatterns EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternsRule()); 
            }
            pushFollow(FOLLOW_rulePatterns_in_entryRulePatterns1045);
            iv_rulePatterns=rulePatterns();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePatterns; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePatterns1055); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatterns"


    // $ANTLR start "rulePatterns"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:563:1: rulePatterns returns [EObject current=null] : (otherlv_0= 'Patterns' ( (lv_name_1_0= RULE_ID ) ) ( (lv_patterns_2_0= rulePattern ) )* ) ;
    public final EObject rulePatterns() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_patterns_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:566:28: ( (otherlv_0= 'Patterns' ( (lv_name_1_0= RULE_ID ) ) ( (lv_patterns_2_0= rulePattern ) )* ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:567:1: (otherlv_0= 'Patterns' ( (lv_name_1_0= RULE_ID ) ) ( (lv_patterns_2_0= rulePattern ) )* )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:567:1: (otherlv_0= 'Patterns' ( (lv_name_1_0= RULE_ID ) ) ( (lv_patterns_2_0= rulePattern ) )* )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:567:3: otherlv_0= 'Patterns' ( (lv_name_1_0= RULE_ID ) ) ( (lv_patterns_2_0= rulePattern ) )*
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_rulePatterns1092); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPatternsAccess().getPatternsKeyword_0());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:571:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:572:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:572:1: (lv_name_1_0= RULE_ID )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:573:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePatterns1109); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getPatternsAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPatternsRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:589:2: ( (lv_patterns_2_0= rulePattern ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==26) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:590:1: (lv_patterns_2_0= rulePattern )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:590:1: (lv_patterns_2_0= rulePattern )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:591:3: lv_patterns_2_0= rulePattern
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPatternsAccess().getPatternsPatternParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePattern_in_rulePatterns1135);
            	    lv_patterns_2_0=rulePattern();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPatternsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"patterns",
            	              		lv_patterns_2_0, 
            	              		"Pattern");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatterns"


    // $ANTLR start "entryRulePattern"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:615:1: entryRulePattern returns [EObject current=null] : iv_rulePattern= rulePattern EOF ;
    public final EObject entryRulePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePattern = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:616:2: (iv_rulePattern= rulePattern EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:617:2: iv_rulePattern= rulePattern EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternRule()); 
            }
            pushFollow(FOLLOW_rulePattern_in_entryRulePattern1172);
            iv_rulePattern=rulePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePattern; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePattern1182); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePattern"


    // $ANTLR start "rulePattern"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:624:1: rulePattern returns [EObject current=null] : (otherlv_0= 'Pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'Inputs:' ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* otherlv_6= 'Outputs:' ( (lv_outputs_7_0= ruleVariable ) ) (otherlv_8= ',' ( (lv_outputs_9_0= ruleVariable ) ) )* otherlv_10= 'Lustre:' ( (lv_node_11_0= RULE_STRING ) ) otherlv_12= 'English:' ( (lv_english_13_0= RULE_STRING ) ) ) ;
    public final EObject rulePattern() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_node_11_0=null;
        Token otherlv_12=null;
        Token lv_english_13_0=null;
        EObject lv_inputs_3_0 = null;

        EObject lv_inputs_5_0 = null;

        EObject lv_outputs_7_0 = null;

        EObject lv_outputs_9_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:627:28: ( (otherlv_0= 'Pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'Inputs:' ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* otherlv_6= 'Outputs:' ( (lv_outputs_7_0= ruleVariable ) ) (otherlv_8= ',' ( (lv_outputs_9_0= ruleVariable ) ) )* otherlv_10= 'Lustre:' ( (lv_node_11_0= RULE_STRING ) ) otherlv_12= 'English:' ( (lv_english_13_0= RULE_STRING ) ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:628:1: (otherlv_0= 'Pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'Inputs:' ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* otherlv_6= 'Outputs:' ( (lv_outputs_7_0= ruleVariable ) ) (otherlv_8= ',' ( (lv_outputs_9_0= ruleVariable ) ) )* otherlv_10= 'Lustre:' ( (lv_node_11_0= RULE_STRING ) ) otherlv_12= 'English:' ( (lv_english_13_0= RULE_STRING ) ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:628:1: (otherlv_0= 'Pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'Inputs:' ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* otherlv_6= 'Outputs:' ( (lv_outputs_7_0= ruleVariable ) ) (otherlv_8= ',' ( (lv_outputs_9_0= ruleVariable ) ) )* otherlv_10= 'Lustre:' ( (lv_node_11_0= RULE_STRING ) ) otherlv_12= 'English:' ( (lv_english_13_0= RULE_STRING ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:628:3: otherlv_0= 'Pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'Inputs:' ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* otherlv_6= 'Outputs:' ( (lv_outputs_7_0= ruleVariable ) ) (otherlv_8= ',' ( (lv_outputs_9_0= ruleVariable ) ) )* otherlv_10= 'Lustre:' ( (lv_node_11_0= RULE_STRING ) ) otherlv_12= 'English:' ( (lv_english_13_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_rulePattern1219); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPatternAccess().getPatternKeyword_0());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:632:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:633:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:633:1: (lv_name_1_0= RULE_ID )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:634:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePattern1236); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getPatternAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPatternRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_rulePattern1253); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getPatternAccess().getInputsKeyword_2());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:654:1: ( (lv_inputs_3_0= ruleVariable ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:655:1: (lv_inputs_3_0= ruleVariable )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:655:1: (lv_inputs_3_0= ruleVariable )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:656:3: lv_inputs_3_0= ruleVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPatternAccess().getInputsVariableParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVariable_in_rulePattern1274);
            lv_inputs_3_0=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPatternRule());
              	        }
                     		add(
                     			current, 
                     			"inputs",
                      		lv_inputs_3_0, 
                      		"Variable");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:672:2: (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==27) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:672:4: otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) )
            	    {
            	    otherlv_4=(Token)match(input,27,FOLLOW_27_in_rulePattern1287); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getPatternAccess().getCommaKeyword_4_0());
            	          
            	    }
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:676:1: ( (lv_inputs_5_0= ruleVariable ) )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:677:1: (lv_inputs_5_0= ruleVariable )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:677:1: (lv_inputs_5_0= ruleVariable )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:678:3: lv_inputs_5_0= ruleVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPatternAccess().getInputsVariableParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariable_in_rulePattern1308);
            	    lv_inputs_5_0=ruleVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPatternRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"inputs",
            	              		lv_inputs_5_0, 
            	              		"Variable");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_rulePattern1322); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getPatternAccess().getOutputsKeyword_5());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:698:1: ( (lv_outputs_7_0= ruleVariable ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:699:1: (lv_outputs_7_0= ruleVariable )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:699:1: (lv_outputs_7_0= ruleVariable )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:700:3: lv_outputs_7_0= ruleVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPatternAccess().getOutputsVariableParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVariable_in_rulePattern1343);
            lv_outputs_7_0=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPatternRule());
              	        }
                     		add(
                     			current, 
                     			"outputs",
                      		lv_outputs_7_0, 
                      		"Variable");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:716:2: (otherlv_8= ',' ( (lv_outputs_9_0= ruleVariable ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==27) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:716:4: otherlv_8= ',' ( (lv_outputs_9_0= ruleVariable ) )
            	    {
            	    otherlv_8=(Token)match(input,27,FOLLOW_27_in_rulePattern1356); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_8, grammarAccess.getPatternAccess().getCommaKeyword_7_0());
            	          
            	    }
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:720:1: ( (lv_outputs_9_0= ruleVariable ) )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:721:1: (lv_outputs_9_0= ruleVariable )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:721:1: (lv_outputs_9_0= ruleVariable )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:722:3: lv_outputs_9_0= ruleVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPatternAccess().getOutputsVariableParserRuleCall_7_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariable_in_rulePattern1377);
            	    lv_outputs_9_0=ruleVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPatternRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"outputs",
            	              		lv_outputs_9_0, 
            	              		"Variable");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            otherlv_10=(Token)match(input,28,FOLLOW_28_in_rulePattern1391); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getPatternAccess().getLustreKeyword_8());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:742:1: ( (lv_node_11_0= RULE_STRING ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:743:1: (lv_node_11_0= RULE_STRING )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:743:1: (lv_node_11_0= RULE_STRING )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:744:3: lv_node_11_0= RULE_STRING
            {
            lv_node_11_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePattern1408); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_node_11_0, grammarAccess.getPatternAccess().getNodeSTRINGTerminalRuleCall_9_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPatternRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"node",
                      		lv_node_11_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_12=(Token)match(input,29,FOLLOW_29_in_rulePattern1425); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getPatternAccess().getEnglishKeyword_10());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:764:1: ( (lv_english_13_0= RULE_STRING ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:765:1: (lv_english_13_0= RULE_STRING )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:765:1: (lv_english_13_0= RULE_STRING )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:766:3: lv_english_13_0= RULE_STRING
            {
            lv_english_13_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePattern1442); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_english_13_0, grammarAccess.getPatternAccess().getEnglishSTRINGTerminalRuleCall_11_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPatternRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"english",
                      		lv_english_13_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePattern"


    // $ANTLR start "entryRuleUnitDef"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:790:1: entryRuleUnitDef returns [EObject current=null] : iv_ruleUnitDef= ruleUnitDef EOF ;
    public final EObject entryRuleUnitDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitDef = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:791:2: (iv_ruleUnitDef= ruleUnitDef EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:792:2: iv_ruleUnitDef= ruleUnitDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitDefRule()); 
            }
            pushFollow(FOLLOW_ruleUnitDef_in_entryRuleUnitDef1483);
            iv_ruleUnitDef=ruleUnitDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnitDef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitDef1493); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnitDef"


    // $ANTLR start "ruleUnitDef"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:799:1: ruleUnitDef returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= ':' ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? ) ) ;
    public final EObject ruleUnitDef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_description_2_0=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token lv_description_7_0=null;
        EObject lv_unit_6_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:802:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= ':' ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:803:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= ':' ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:803:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= ':' ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==30) ) {
                    alt32=2;
                }
                else if ( (LA32_1==EOF||(LA32_1>=RULE_ID && LA32_1<=RULE_STRING)||(LA32_1>=14 && LA32_1<=16)) ) {
                    alt32=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:803:2: ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:803:2: ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:803:3: () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )?
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:803:3: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:804:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnitDefAccess().getBaseUnitAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:809:2: ( (lv_name_1_0= RULE_ID ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:810:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:810:1: (lv_name_1_0= RULE_ID )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:811:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnitDef1545); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_0, grammarAccess.getUnitDefAccess().getNameIDTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getUnitDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"ID");
                      	    
                    }

                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:827:2: ( (lv_description_2_0= RULE_STRING ) )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==RULE_STRING) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:828:1: (lv_description_2_0= RULE_STRING )
                            {
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:828:1: (lv_description_2_0= RULE_STRING )
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:829:3: lv_description_2_0= RULE_STRING
                            {
                            lv_description_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleUnitDef1567); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_description_2_0, grammarAccess.getUnitDefAccess().getDescriptionSTRINGTerminalRuleCall_0_2_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnitDefRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"description",
                                      		lv_description_2_0, 
                                      		"STRING");
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:846:6: ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= ':' ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:846:6: ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= ':' ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:846:7: () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= ':' ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )?
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:846:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:847:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnitDefAccess().getDerivedUnitAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:852:2: ( (lv_name_4_0= RULE_ID ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:853:1: (lv_name_4_0= RULE_ID )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:853:1: (lv_name_4_0= RULE_ID )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:854:3: lv_name_4_0= RULE_ID
                    {
                    lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnitDef1607); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_4_0, grammarAccess.getUnitDefAccess().getNameIDTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getUnitDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"ID");
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,30,FOLLOW_30_in_ruleUnitDef1624); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getUnitDefAccess().getColonKeyword_1_2());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:874:1: ( (lv_unit_6_0= ruleUnitExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:875:1: (lv_unit_6_0= ruleUnitExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:875:1: (lv_unit_6_0= ruleUnitExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:876:3: lv_unit_6_0= ruleUnitExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnitDefAccess().getUnitUnitExprParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnitExpr_in_ruleUnitDef1645);
                    lv_unit_6_0=ruleUnitExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnitDefRule());
                      	        }
                             		set(
                             			current, 
                             			"unit",
                              		lv_unit_6_0, 
                              		"UnitExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:892:2: ( (lv_description_7_0= RULE_STRING ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==RULE_STRING) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:893:1: (lv_description_7_0= RULE_STRING )
                            {
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:893:1: (lv_description_7_0= RULE_STRING )
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:894:3: lv_description_7_0= RULE_STRING
                            {
                            lv_description_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleUnitDef1662); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_description_7_0, grammarAccess.getUnitDefAccess().getDescriptionSTRINGTerminalRuleCall_1_4_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnitDefRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"description",
                                      		lv_description_7_0, 
                                      		"STRING");
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnitDef"


    // $ANTLR start "entryRuleUnitExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:918:1: entryRuleUnitExpr returns [EObject current=null] : iv_ruleUnitExpr= ruleUnitExpr EOF ;
    public final EObject entryRuleUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:919:2: (iv_ruleUnitExpr= ruleUnitExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:920:2: iv_ruleUnitExpr= ruleUnitExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitExprRule()); 
            }
            pushFollow(FOLLOW_ruleUnitExpr_in_entryRuleUnitExpr1705);
            iv_ruleUnitExpr=ruleUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnitExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpr1715); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnitExpr"


    // $ANTLR start "ruleUnitExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:927:1: ruleUnitExpr returns [EObject current=null] : this_ProductUnitExpr_0= ruleProductUnitExpr ;
    public final EObject ruleUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject this_ProductUnitExpr_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:930:28: (this_ProductUnitExpr_0= ruleProductUnitExpr )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:932:5: this_ProductUnitExpr_0= ruleProductUnitExpr
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnitExprAccess().getProductUnitExprParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleProductUnitExpr_in_ruleUnitExpr1761);
            this_ProductUnitExpr_0=ruleProductUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ProductUnitExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnitExpr"


    // $ANTLR start "entryRuleProductUnitExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:948:1: entryRuleProductUnitExpr returns [EObject current=null] : iv_ruleProductUnitExpr= ruleProductUnitExpr EOF ;
    public final EObject entryRuleProductUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProductUnitExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:949:2: (iv_ruleProductUnitExpr= ruleProductUnitExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:950:2: iv_ruleProductUnitExpr= ruleProductUnitExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProductUnitExprRule()); 
            }
            pushFollow(FOLLOW_ruleProductUnitExpr_in_entryRuleProductUnitExpr1795);
            iv_ruleProductUnitExpr=ruleProductUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProductUnitExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProductUnitExpr1805); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProductUnitExpr"


    // $ANTLR start "ruleProductUnitExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:957:1: ruleProductUnitExpr returns [EObject current=null] : (this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )? ) ;
    public final EObject ruleProductUnitExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_DivisionUnitExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:960:28: ( (this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )? ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:961:1: (this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )? )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:961:1: (this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )? )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:962:5: this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getProductUnitExprAccess().getDivisionUnitExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleDivisionUnitExpr_in_ruleProductUnitExpr1852);
            this_DivisionUnitExpr_0=ruleDivisionUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_DivisionUnitExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:970:1: ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==31) && (synpred1_InternalSpear())) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:970:2: ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:970:2: ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:970:3: ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:977:6: ( () ( (lv_op_2_0= '*' ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:977:7: () ( (lv_op_2_0= '*' ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:977:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:978:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getProductUnitExprAccess().getBinaryUnitExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:983:2: ( (lv_op_2_0= '*' ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:984:1: (lv_op_2_0= '*' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:984:1: (lv_op_2_0= '*' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:985:3: lv_op_2_0= '*'
                    {
                    lv_op_2_0=(Token)match(input,31,FOLLOW_31_in_ruleProductUnitExpr1903); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_2_0, grammarAccess.getProductUnitExprAccess().getOpAsteriskKeyword_1_0_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getProductUnitExprRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_2_0, "*");
                      	    
                    }

                    }


                    }


                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:998:4: ( (lv_right_3_0= ruleProductUnitExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:999:1: (lv_right_3_0= ruleProductUnitExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:999:1: (lv_right_3_0= ruleProductUnitExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1000:3: lv_right_3_0= ruleProductUnitExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getProductUnitExprAccess().getRightProductUnitExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleProductUnitExpr_in_ruleProductUnitExpr1939);
                    lv_right_3_0=ruleProductUnitExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getProductUnitExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"ProductUnitExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProductUnitExpr"


    // $ANTLR start "entryRuleDivisionUnitExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1024:1: entryRuleDivisionUnitExpr returns [EObject current=null] : iv_ruleDivisionUnitExpr= ruleDivisionUnitExpr EOF ;
    public final EObject entryRuleDivisionUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivisionUnitExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1025:2: (iv_ruleDivisionUnitExpr= ruleDivisionUnitExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1026:2: iv_ruleDivisionUnitExpr= ruleDivisionUnitExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDivisionUnitExprRule()); 
            }
            pushFollow(FOLLOW_ruleDivisionUnitExpr_in_entryRuleDivisionUnitExpr1977);
            iv_ruleDivisionUnitExpr=ruleDivisionUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDivisionUnitExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDivisionUnitExpr1987); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDivisionUnitExpr"


    // $ANTLR start "ruleDivisionUnitExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1033:1: ruleDivisionUnitExpr returns [EObject current=null] : (this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )? ) ;
    public final EObject ruleDivisionUnitExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_AtomicUnitExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1036:28: ( (this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )? ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1037:1: (this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )? )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1037:1: (this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )? )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1038:5: this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getDivisionUnitExprAccess().getAtomicUnitExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAtomicUnitExpr_in_ruleDivisionUnitExpr2034);
            this_AtomicUnitExpr_0=ruleAtomicUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AtomicUnitExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1046:1: ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==32) && (synpred2_InternalSpear())) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1046:2: ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1046:2: ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1046:3: ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1053:6: ( () ( (lv_op_2_0= '/' ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1053:7: () ( (lv_op_2_0= '/' ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1053:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1054:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getDivisionUnitExprAccess().getBinaryUnitExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1059:2: ( (lv_op_2_0= '/' ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1060:1: (lv_op_2_0= '/' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1060:1: (lv_op_2_0= '/' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1061:3: lv_op_2_0= '/'
                    {
                    lv_op_2_0=(Token)match(input,32,FOLLOW_32_in_ruleDivisionUnitExpr2085); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_2_0, grammarAccess.getDivisionUnitExprAccess().getOpSolidusKeyword_1_0_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDivisionUnitExprRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_2_0, "/");
                      	    
                    }

                    }


                    }


                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1074:4: ( (lv_right_3_0= ruleAtomicUnitExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1075:1: (lv_right_3_0= ruleAtomicUnitExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1075:1: (lv_right_3_0= ruleAtomicUnitExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1076:3: lv_right_3_0= ruleAtomicUnitExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDivisionUnitExprAccess().getRightAtomicUnitExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAtomicUnitExpr_in_ruleDivisionUnitExpr2121);
                    lv_right_3_0=ruleAtomicUnitExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDivisionUnitExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"AtomicUnitExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDivisionUnitExpr"


    // $ANTLR start "entryRuleAtomicUnitExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1100:1: entryRuleAtomicUnitExpr returns [EObject current=null] : iv_ruleAtomicUnitExpr= ruleAtomicUnitExpr EOF ;
    public final EObject entryRuleAtomicUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicUnitExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1101:2: (iv_ruleAtomicUnitExpr= ruleAtomicUnitExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1102:2: iv_ruleAtomicUnitExpr= ruleAtomicUnitExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicUnitExprRule()); 
            }
            pushFollow(FOLLOW_ruleAtomicUnitExpr_in_entryRuleAtomicUnitExpr2159);
            iv_ruleAtomicUnitExpr=ruleAtomicUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicUnitExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomicUnitExpr2169); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicUnitExpr"


    // $ANTLR start "ruleAtomicUnitExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1109:1: ruleAtomicUnitExpr returns [EObject current=null] : ( ( () ( (otherlv_1= RULE_ID ) ) ) | (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' ) ) ;
    public final EObject ruleAtomicUnitExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_UnitExpr_3 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1112:28: ( ( ( () ( (otherlv_1= RULE_ID ) ) ) | (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1113:1: ( ( () ( (otherlv_1= RULE_ID ) ) ) | (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1113:1: ( ( () ( (otherlv_1= RULE_ID ) ) ) | (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            else if ( (LA35_0==33) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1113:2: ( () ( (otherlv_1= RULE_ID ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1113:2: ( () ( (otherlv_1= RULE_ID ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1113:3: () ( (otherlv_1= RULE_ID ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1113:3: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1114:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicUnitExprAccess().getNamedUnitExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1119:2: ( (otherlv_1= RULE_ID ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1120:1: (otherlv_1= RULE_ID )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1120:1: (otherlv_1= RULE_ID )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1121:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicUnitExprRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicUnitExpr2224); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getAtomicUnitExprAccess().getUnitUnitDefCrossReference_0_1_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1133:6: (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1133:6: (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1133:8: otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleAtomicUnitExpr2244); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAtomicUnitExprAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicUnitExprAccess().getUnitExprParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnitExpr_in_ruleAtomicUnitExpr2266);
                    this_UnitExpr_3=ruleUnitExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnitExpr_3; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_4=(Token)match(input,34,FOLLOW_34_in_ruleAtomicUnitExpr2277); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getAtomicUnitExprAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicUnitExpr"


    // $ANTLR start "entryRuleTypeDef"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1158:1: entryRuleTypeDef returns [EObject current=null] : iv_ruleTypeDef= ruleTypeDef EOF ;
    public final EObject entryRuleTypeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDef = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1159:2: (iv_ruleTypeDef= ruleTypeDef EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1160:2: iv_ruleTypeDef= ruleTypeDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDefRule()); 
            }
            pushFollow(FOLLOW_ruleTypeDef_in_entryRuleTypeDef2314);
            iv_ruleTypeDef=ruleTypeDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeDef2324); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeDef"


    // $ANTLR start "ruleTypeDef"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1167:1: ruleTypeDef returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '=' otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleRecordTypeField ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleRecordTypeField ) ) )* otherlv_13= '}' ) | ( () ( (lv_name_15_0= RULE_ID ) ) otherlv_16= '=' ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']' ) | ( () ( (lv_name_22_0= RULE_ID ) ) otherlv_23= '=' otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}' ) ) ;
    public final EObject ruleTypeDef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token lv_name_15_0=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token lv_size_19_0=null;
        Token otherlv_20=null;
        Token lv_name_22_0=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        EObject lv_type_3_0 = null;

        EObject lv_fields_10_0 = null;

        EObject lv_fields_12_0 = null;

        EObject lv_base_17_0 = null;

        EObject lv_values_26_0 = null;

        EObject lv_values_28_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1170:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '=' otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleRecordTypeField ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleRecordTypeField ) ) )* otherlv_13= '}' ) | ( () ( (lv_name_15_0= RULE_ID ) ) otherlv_16= '=' ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']' ) | ( () ( (lv_name_22_0= RULE_ID ) ) otherlv_23= '=' otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}' ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1171:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '=' otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleRecordTypeField ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleRecordTypeField ) ) )* otherlv_13= '}' ) | ( () ( (lv_name_15_0= RULE_ID ) ) otherlv_16= '=' ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']' ) | ( () ( (lv_name_22_0= RULE_ID ) ) otherlv_23= '=' otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}' ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1171:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '=' otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleRecordTypeField ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleRecordTypeField ) ) )* otherlv_13= '}' ) | ( () ( (lv_name_15_0= RULE_ID ) ) otherlv_16= '=' ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']' ) | ( () ( (lv_name_22_0= RULE_ID ) ) otherlv_23= '=' otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}' ) )
            int alt39=4;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1171:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1171:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1171:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )?
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1171:3: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1172:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeDefAccess().getNamedTypeAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1177:2: ( (lv_name_1_0= RULE_ID ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1178:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1178:1: (lv_name_1_0= RULE_ID )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1179:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeDef2376); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_0, grammarAccess.getTypeDefAccess().getNameIDTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"ID");
                      	    
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleTypeDef2393); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTypeDefAccess().getEqualsSignKeyword_0_2());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1199:1: ( (lv_type_3_0= ruleType ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1200:1: (lv_type_3_0= ruleType )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1200:1: (lv_type_3_0= ruleType )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1201:3: lv_type_3_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeDefAccess().getTypeTypeParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleTypeDef2414);
                    lv_type_3_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_3_0, 
                              		"Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1217:2: ( (otherlv_4= RULE_ID ) )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==RULE_ID) ) {
                        int LA36_1 = input.LA(2);

                        if ( (LA36_1==EOF||LA36_1==RULE_ID||(LA36_1>=15 && LA36_1<=16)) ) {
                            alt36=1;
                        }
                    }
                    switch (alt36) {
                        case 1 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1218:1: (otherlv_4= RULE_ID )
                            {
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1218:1: (otherlv_4= RULE_ID )
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1219:3: otherlv_4= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getTypeDefRule());
                              	        }
                                      
                            }
                            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeDef2434); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_4, grammarAccess.getTypeDefAccess().getUnitUnitDefCrossReference_0_4_0()); 
                              	
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1231:6: ( () ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '=' otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleRecordTypeField ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleRecordTypeField ) ) )* otherlv_13= '}' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1231:6: ( () ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '=' otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleRecordTypeField ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleRecordTypeField ) ) )* otherlv_13= '}' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1231:7: () ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '=' otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleRecordTypeField ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleRecordTypeField ) ) )* otherlv_13= '}'
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1231:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1232:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeDefAccess().getRecordTypeAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1237:2: ( (lv_name_6_0= RULE_ID ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1238:1: (lv_name_6_0= RULE_ID )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1238:1: (lv_name_6_0= RULE_ID )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1239:3: lv_name_6_0= RULE_ID
                    {
                    lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeDef2469); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_6_0, grammarAccess.getTypeDefAccess().getNameIDTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_6_0, 
                              		"ID");
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,35,FOLLOW_35_in_ruleTypeDef2486); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getTypeDefAccess().getEqualsSignKeyword_1_2());
                          
                    }
                    otherlv_8=(Token)match(input,36,FOLLOW_36_in_ruleTypeDef2498); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getTypeDefAccess().getRecordKeyword_1_3());
                          
                    }
                    otherlv_9=(Token)match(input,37,FOLLOW_37_in_ruleTypeDef2510); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getTypeDefAccess().getLeftCurlyBracketKeyword_1_4());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1267:1: ( (lv_fields_10_0= ruleRecordTypeField ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1268:1: (lv_fields_10_0= ruleRecordTypeField )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1268:1: (lv_fields_10_0= ruleRecordTypeField )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1269:3: lv_fields_10_0= ruleRecordTypeField
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeDefAccess().getFieldsRecordTypeFieldParserRuleCall_1_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRecordTypeField_in_ruleTypeDef2531);
                    lv_fields_10_0=ruleRecordTypeField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                      	        }
                             		add(
                             			current, 
                             			"fields",
                              		lv_fields_10_0, 
                              		"RecordTypeField");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1285:2: (otherlv_11= ',' ( (lv_fields_12_0= ruleRecordTypeField ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==27) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1285:4: otherlv_11= ',' ( (lv_fields_12_0= ruleRecordTypeField ) )
                    	    {
                    	    otherlv_11=(Token)match(input,27,FOLLOW_27_in_ruleTypeDef2544); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getTypeDefAccess().getCommaKeyword_1_6_0());
                    	          
                    	    }
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1289:1: ( (lv_fields_12_0= ruleRecordTypeField ) )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1290:1: (lv_fields_12_0= ruleRecordTypeField )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1290:1: (lv_fields_12_0= ruleRecordTypeField )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1291:3: lv_fields_12_0= ruleRecordTypeField
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeDefAccess().getFieldsRecordTypeFieldParserRuleCall_1_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleRecordTypeField_in_ruleTypeDef2565);
                    	    lv_fields_12_0=ruleRecordTypeField();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"fields",
                    	              		lv_fields_12_0, 
                    	              		"RecordTypeField");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,38,FOLLOW_38_in_ruleTypeDef2579); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getTypeDefAccess().getRightCurlyBracketKeyword_1_7());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1312:6: ( () ( (lv_name_15_0= RULE_ID ) ) otherlv_16= '=' ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1312:6: ( () ( (lv_name_15_0= RULE_ID ) ) otherlv_16= '=' ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1312:7: () ( (lv_name_15_0= RULE_ID ) ) otherlv_16= '=' ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']'
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1312:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1313:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeDefAccess().getArrayTypeAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1318:2: ( (lv_name_15_0= RULE_ID ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1319:1: (lv_name_15_0= RULE_ID )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1319:1: (lv_name_15_0= RULE_ID )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1320:3: lv_name_15_0= RULE_ID
                    {
                    lv_name_15_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeDef2613); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_15_0, grammarAccess.getTypeDefAccess().getNameIDTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_15_0, 
                              		"ID");
                      	    
                    }

                    }


                    }

                    otherlv_16=(Token)match(input,35,FOLLOW_35_in_ruleTypeDef2630); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getTypeDefAccess().getEqualsSignKeyword_2_2());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1340:1: ( (lv_base_17_0= ruleType ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1341:1: (lv_base_17_0= ruleType )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1341:1: (lv_base_17_0= ruleType )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1342:3: lv_base_17_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeDefAccess().getBaseTypeParserRuleCall_2_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleTypeDef2651);
                    lv_base_17_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                      	        }
                             		set(
                             			current, 
                             			"base",
                              		lv_base_17_0, 
                              		"Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_18=(Token)match(input,39,FOLLOW_39_in_ruleTypeDef2663); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getTypeDefAccess().getLeftSquareBracketKeyword_2_4());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1362:1: ( (lv_size_19_0= RULE_INT ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1363:1: (lv_size_19_0= RULE_INT )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1363:1: (lv_size_19_0= RULE_INT )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1364:3: lv_size_19_0= RULE_INT
                    {
                    lv_size_19_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTypeDef2680); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_size_19_0, grammarAccess.getTypeDefAccess().getSizeINTTerminalRuleCall_2_5_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"size",
                              		lv_size_19_0, 
                              		"INT");
                      	    
                    }

                    }


                    }

                    otherlv_20=(Token)match(input,40,FOLLOW_40_in_ruleTypeDef2697); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getTypeDefAccess().getRightSquareBracketKeyword_2_6());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1385:6: ( () ( (lv_name_22_0= RULE_ID ) ) otherlv_23= '=' otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1385:6: ( () ( (lv_name_22_0= RULE_ID ) ) otherlv_23= '=' otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1385:7: () ( (lv_name_22_0= RULE_ID ) ) otherlv_23= '=' otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}'
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1385:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1386:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeDefAccess().getEnumTypeAction_3_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1391:2: ( (lv_name_22_0= RULE_ID ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1392:1: (lv_name_22_0= RULE_ID )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1392:1: (lv_name_22_0= RULE_ID )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1393:3: lv_name_22_0= RULE_ID
                    {
                    lv_name_22_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeDef2731); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_22_0, grammarAccess.getTypeDefAccess().getNameIDTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_22_0, 
                              		"ID");
                      	    
                    }

                    }


                    }

                    otherlv_23=(Token)match(input,35,FOLLOW_35_in_ruleTypeDef2748); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_23, grammarAccess.getTypeDefAccess().getEqualsSignKeyword_3_2());
                          
                    }
                    otherlv_24=(Token)match(input,41,FOLLOW_41_in_ruleTypeDef2760); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getTypeDefAccess().getEnumKeyword_3_3());
                          
                    }
                    otherlv_25=(Token)match(input,37,FOLLOW_37_in_ruleTypeDef2772); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getTypeDefAccess().getLeftCurlyBracketKeyword_3_4());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1421:1: ( (lv_values_26_0= ruleEnumValue ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1422:1: (lv_values_26_0= ruleEnumValue )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1422:1: (lv_values_26_0= ruleEnumValue )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1423:3: lv_values_26_0= ruleEnumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeDefAccess().getValuesEnumValueParserRuleCall_3_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEnumValue_in_ruleTypeDef2793);
                    lv_values_26_0=ruleEnumValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                      	        }
                             		add(
                             			current, 
                             			"values",
                              		lv_values_26_0, 
                              		"EnumValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1439:2: (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==27) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1439:4: otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) )
                    	    {
                    	    otherlv_27=(Token)match(input,27,FOLLOW_27_in_ruleTypeDef2806); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_27, grammarAccess.getTypeDefAccess().getCommaKeyword_3_6_0());
                    	          
                    	    }
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1443:1: ( (lv_values_28_0= ruleEnumValue ) )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1444:1: (lv_values_28_0= ruleEnumValue )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1444:1: (lv_values_28_0= ruleEnumValue )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1445:3: lv_values_28_0= ruleEnumValue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeDefAccess().getValuesEnumValueParserRuleCall_3_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleEnumValue_in_ruleTypeDef2827);
                    	    lv_values_28_0=ruleEnumValue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"values",
                    	              		lv_values_28_0, 
                    	              		"EnumValue");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);

                    otherlv_29=(Token)match(input,38,FOLLOW_38_in_ruleTypeDef2841); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_29, grammarAccess.getTypeDefAccess().getRightCurlyBracketKeyword_3_7());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeDef"


    // $ANTLR start "entryRuleRecordTypeField"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1473:1: entryRuleRecordTypeField returns [EObject current=null] : iv_ruleRecordTypeField= ruleRecordTypeField EOF ;
    public final EObject entryRuleRecordTypeField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTypeField = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1474:2: (iv_ruleRecordTypeField= ruleRecordTypeField EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1475:2: iv_ruleRecordTypeField= ruleRecordTypeField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecordTypeFieldRule()); 
            }
            pushFollow(FOLLOW_ruleRecordTypeField_in_entryRuleRecordTypeField2878);
            iv_ruleRecordTypeField=ruleRecordTypeField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRecordTypeField; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordTypeField2888); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecordTypeField"


    // $ANTLR start "ruleRecordTypeField"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1482:1: ruleRecordTypeField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleRecordTypeField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1485:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1486:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1486:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1486:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1486:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1487:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1487:1: (lv_name_0_0= RULE_ID )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1488:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRecordTypeField2930); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getRecordTypeFieldAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRecordTypeFieldRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleRecordTypeField2947); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRecordTypeFieldAccess().getColonKeyword_1());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1508:1: ( (lv_type_2_0= ruleType ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1509:1: (lv_type_2_0= ruleType )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1509:1: (lv_type_2_0= ruleType )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1510:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRecordTypeFieldAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleRecordTypeField2968);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRecordTypeFieldRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecordTypeField"


    // $ANTLR start "entryRuleEnumValue"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1534:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1535:2: (iv_ruleEnumValue= ruleEnumValue EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1536:2: iv_ruleEnumValue= ruleEnumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumValueRule()); 
            }
            pushFollow(FOLLOW_ruleEnumValue_in_entryRuleEnumValue3004);
            iv_ruleEnumValue=ruleEnumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumValue3014); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumValue"


    // $ANTLR start "ruleEnumValue"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1543:1: ruleEnumValue returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1546:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1547:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1547:1: ( (lv_name_0_0= RULE_ID ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1548:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1548:1: (lv_name_0_0= RULE_ID )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1549:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumValue3055); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getEnumValueAccess().getNameIDTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEnumValueRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumValue"


    // $ANTLR start "entryRuleType"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1573:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1574:2: (iv_ruleType= ruleType EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1575:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType3095);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType3105); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1582:1: ruleType returns [EObject current=null] : ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'bool' ) | ( () otherlv_5= 'real' ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1585:28: ( ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'bool' ) | ( () otherlv_5= 'real' ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1586:1: ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'bool' ) | ( () otherlv_5= 'real' ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1586:1: ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'bool' ) | ( () otherlv_5= 'real' ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            int alt40=4;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt40=1;
                }
                break;
            case 43:
                {
                alt40=2;
                }
                break;
            case 44:
                {
                alt40=3;
                }
                break;
            case RULE_ID:
                {
                alt40=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1586:2: ( () otherlv_1= 'int' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1586:2: ( () otherlv_1= 'int' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1586:3: () otherlv_1= 'int'
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1586:3: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1587:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getIntTypeAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleType3152); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeAccess().getIntKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1597:6: ( () otherlv_3= 'bool' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1597:6: ( () otherlv_3= 'bool' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1597:7: () otherlv_3= 'bool'
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1597:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1598:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getBoolTypeAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,43,FOLLOW_43_in_ruleType3181); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTypeAccess().getBoolKeyword_1_1());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1608:6: ( () otherlv_5= 'real' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1608:6: ( () otherlv_5= 'real' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1608:7: () otherlv_5= 'real'
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1608:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1609:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getRealTypeAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_5=(Token)match(input,44,FOLLOW_44_in_ruleType3210); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getTypeAccess().getRealKeyword_2_1());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1619:6: ( () ( (otherlv_7= RULE_ID ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1619:6: ( () ( (otherlv_7= RULE_ID ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1619:7: () ( (otherlv_7= RULE_ID ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1619:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1620:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getUserTypeAction_3_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1625:2: ( (otherlv_7= RULE_ID ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1626:1: (otherlv_7= RULE_ID )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1626:1: (otherlv_7= RULE_ID )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1627:3: otherlv_7= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeRule());
                      	        }
                              
                    }
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType3247); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_7, grammarAccess.getTypeAccess().getDefTypeDefCrossReference_3_1_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleConstant"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1646:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1647:2: (iv_ruleConstant= ruleConstant EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1648:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant3284);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant3294); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1655:1: ruleConstant returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1658:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1659:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1659:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1659:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1659:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1660:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1660:1: (lv_name_0_0= RULE_ID )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1661:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConstant3336); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getConstantAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getConstantRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleConstant3353); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getConstantAccess().getColonKeyword_1());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1681:1: ( (lv_type_2_0= ruleType ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1682:1: (lv_type_2_0= ruleType )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1682:1: (lv_type_2_0= ruleType )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1683:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstantAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleConstant3374);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConstantRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleConstant3386); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getConstantAccess().getEqualsSignKeyword_3());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1703:1: ( (lv_expr_4_0= ruleExpr ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1704:1: (lv_expr_4_0= ruleExpr )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1704:1: (lv_expr_4_0= ruleExpr )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1705:3: lv_expr_4_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstantAccess().getExprExprParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpr_in_ruleConstant3407);
            lv_expr_4_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConstantRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_4_0, 
                      		"Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleVariable"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1729:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1730:2: (iv_ruleVariable= ruleVariable EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1731:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableRule()); 
            }
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable3443);
            iv_ruleVariable=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable3453); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1738:1: ruleVariable returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' | otherlv_2= 'is a' ) ( (lv_type_3_0= ruleType ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1741:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' | otherlv_2= 'is a' ) ( (lv_type_3_0= ruleType ) ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1742:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' | otherlv_2= 'is a' ) ( (lv_type_3_0= ruleType ) ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1742:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' | otherlv_2= 'is a' ) ( (lv_type_3_0= ruleType ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1742:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' | otherlv_2= 'is a' ) ( (lv_type_3_0= ruleType ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1742:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1743:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1743:1: (lv_name_0_0= RULE_ID )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1744:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariable3495); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVariableRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1760:2: (otherlv_1= ':' | otherlv_2= 'is a' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==30) ) {
                alt41=1;
            }
            else if ( (LA41_0==45) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1760:4: otherlv_1= ':'
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleVariable3513); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getColonKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1765:7: otherlv_2= 'is a'
                    {
                    otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleVariable3531); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getVariableAccess().getIsAKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1769:2: ( (lv_type_3_0= ruleType ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1770:1: (lv_type_3_0= ruleType )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1770:1: (lv_type_3_0= ruleType )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1771:3: lv_type_3_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleVariable3553);
            lv_type_3_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_3_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleMacro"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1795:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1796:2: (iv_ruleMacro= ruleMacro EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1797:2: iv_ruleMacro= ruleMacro EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroRule()); 
            }
            pushFollow(FOLLOW_ruleMacro_in_entryRuleMacro3589);
            iv_ruleMacro=ruleMacro();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacro; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacro3599); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMacro"


    // $ANTLR start "ruleMacro"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1804:1: ruleMacro returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1807:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1808:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1808:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1808:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1808:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1809:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1809:1: (lv_name_0_0= RULE_ID )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1810:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMacro3641); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getMacroAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMacroRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleMacro3658); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMacroAccess().getColonKeyword_1());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1830:1: ( (lv_type_2_0= ruleType ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1831:1: (lv_type_2_0= ruleType )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1831:1: (lv_type_2_0= ruleType )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1832:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleMacro3679);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMacroRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleMacro3691); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMacroAccess().getEqualsSignKeyword_3());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1852:1: ( (lv_expr_4_0= ruleExpr ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1853:1: (lv_expr_4_0= ruleExpr )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1853:1: (lv_expr_4_0= ruleExpr )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1854:3: lv_expr_4_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getExprExprParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpr_in_ruleMacro3712);
            lv_expr_4_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMacroRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_4_0, 
                      		"Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMacro"


    // $ANTLR start "entryRuleConstraint"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1878:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1879:2: (iv_ruleConstraint= ruleConstraint EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1880:2: iv_ruleConstraint= ruleConstraint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstraintRule()); 
            }
            pushFollow(FOLLOW_ruleConstraint_in_entryRuleConstraint3748);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstraint; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraint3758); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1887:1: ruleConstraint returns [EObject current=null] : (this_FormalConstraint_0= ruleFormalConstraint | this_EnglishConstraint_1= ruleEnglishConstraint ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        EObject this_FormalConstraint_0 = null;

        EObject this_EnglishConstraint_1 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1890:28: ( (this_FormalConstraint_0= ruleFormalConstraint | this_EnglishConstraint_1= ruleEnglishConstraint ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1891:1: (this_FormalConstraint_0= ruleFormalConstraint | this_EnglishConstraint_1= ruleEnglishConstraint )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1891:1: (this_FormalConstraint_0= ruleFormalConstraint | this_EnglishConstraint_1= ruleEnglishConstraint )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==35) ) {
                    int LA42_2 = input.LA(3);

                    if ( (LA42_2==RULE_STRING) ) {
                        alt42=2;
                    }
                    else if ( (LA42_2==RULE_ID||LA42_2==RULE_INT||LA42_2==33||(LA42_2>=62 && LA42_2<=67)||(LA42_2>=70 && LA42_2<=72)||(LA42_2>=75 && LA42_2<=81)) ) {
                        alt42=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1892:5: this_FormalConstraint_0= ruleFormalConstraint
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstraintAccess().getFormalConstraintParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFormalConstraint_in_ruleConstraint3805);
                    this_FormalConstraint_0=ruleFormalConstraint();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FormalConstraint_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1902:5: this_EnglishConstraint_1= ruleEnglishConstraint
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstraintAccess().getEnglishConstraintParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEnglishConstraint_in_ruleConstraint3832);
                    this_EnglishConstraint_1=ruleEnglishConstraint();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EnglishConstraint_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleFormalConstraint"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1918:1: entryRuleFormalConstraint returns [EObject current=null] : iv_ruleFormalConstraint= ruleFormalConstraint EOF ;
    public final EObject entryRuleFormalConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormalConstraint = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1919:2: (iv_ruleFormalConstraint= ruleFormalConstraint EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1920:2: iv_ruleFormalConstraint= ruleFormalConstraint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFormalConstraintRule()); 
            }
            pushFollow(FOLLOW_ruleFormalConstraint_in_entryRuleFormalConstraint3867);
            iv_ruleFormalConstraint=ruleFormalConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFormalConstraint; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFormalConstraint3877); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFormalConstraint"


    // $ANTLR start "ruleFormalConstraint"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1927:1: ruleFormalConstraint returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) ) ;
    public final EObject ruleFormalConstraint() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1930:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1931:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1931:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1931:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1931:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1932:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1932:1: (lv_name_0_0= RULE_ID )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1933:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFormalConstraint3919); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getFormalConstraintAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFormalConstraintRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleFormalConstraint3936); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFormalConstraintAccess().getEqualsSignKeyword_1());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1953:1: ( (lv_expr_2_0= ruleExpr ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1954:1: (lv_expr_2_0= ruleExpr )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1954:1: (lv_expr_2_0= ruleExpr )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1955:3: lv_expr_2_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFormalConstraintAccess().getExprExprParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpr_in_ruleFormalConstraint3957);
            lv_expr_2_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFormalConstraintRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_2_0, 
                      		"Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFormalConstraint"


    // $ANTLR start "entryRuleEnglishConstraint"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1979:1: entryRuleEnglishConstraint returns [EObject current=null] : iv_ruleEnglishConstraint= ruleEnglishConstraint EOF ;
    public final EObject entryRuleEnglishConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnglishConstraint = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1980:2: (iv_ruleEnglishConstraint= ruleEnglishConstraint EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1981:2: iv_ruleEnglishConstraint= ruleEnglishConstraint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnglishConstraintRule()); 
            }
            pushFollow(FOLLOW_ruleEnglishConstraint_in_entryRuleEnglishConstraint3993);
            iv_ruleEnglishConstraint=ruleEnglishConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnglishConstraint; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnglishConstraint4003); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnglishConstraint"


    // $ANTLR start "ruleEnglishConstraint"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1988:1: ruleEnglishConstraint returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_text_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleEnglishConstraint() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_text_2_0=null;

         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1991:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_text_2_0= RULE_STRING ) ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1992:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_text_2_0= RULE_STRING ) ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1992:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_text_2_0= RULE_STRING ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1992:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_text_2_0= RULE_STRING ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1992:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1993:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1993:1: (lv_name_0_0= RULE_ID )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1994:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnglishConstraint4045); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getEnglishConstraintAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEnglishConstraintRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleEnglishConstraint4062); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEnglishConstraintAccess().getEqualsSignKeyword_1());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2014:1: ( (lv_text_2_0= RULE_STRING ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2015:1: (lv_text_2_0= RULE_STRING )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2015:1: (lv_text_2_0= RULE_STRING )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2016:3: lv_text_2_0= RULE_STRING
            {
            lv_text_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEnglishConstraint4079); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_text_2_0, grammarAccess.getEnglishConstraintAccess().getTextSTRINGTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEnglishConstraintRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"text",
                      		lv_text_2_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnglishConstraint"


    // $ANTLR start "entryRuleExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2040:1: entryRuleExpr returns [EObject current=null] : iv_ruleExpr= ruleExpr EOF ;
    public final EObject entryRuleExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2041:2: (iv_ruleExpr= ruleExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2042:2: iv_ruleExpr= ruleExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExprRule()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_entryRuleExpr4120);
            iv_ruleExpr=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpr4130); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpr"


    // $ANTLR start "ruleExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2049:1: ruleExpr returns [EObject current=null] : this_ImpliesExpr_0= ruleImpliesExpr ;
    public final EObject ruleExpr() throws RecognitionException {
        EObject current = null;

        EObject this_ImpliesExpr_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2052:28: (this_ImpliesExpr_0= ruleImpliesExpr )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2054:5: this_ImpliesExpr_0= ruleImpliesExpr
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExprAccess().getImpliesExprParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleImpliesExpr_in_ruleExpr4176);
            this_ImpliesExpr_0=ruleImpliesExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ImpliesExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpr"


    // $ANTLR start "entryRuleImpliesExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2070:1: entryRuleImpliesExpr returns [EObject current=null] : iv_ruleImpliesExpr= ruleImpliesExpr EOF ;
    public final EObject entryRuleImpliesExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImpliesExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2071:2: (iv_ruleImpliesExpr= ruleImpliesExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2072:2: iv_ruleImpliesExpr= ruleImpliesExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImpliesExprRule()); 
            }
            pushFollow(FOLLOW_ruleImpliesExpr_in_entryRuleImpliesExpr4210);
            iv_ruleImpliesExpr=ruleImpliesExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImpliesExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImpliesExpr4220); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImpliesExpr"


    // $ANTLR start "ruleImpliesExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2079:1: ruleImpliesExpr returns [EObject current=null] : (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) ;
    public final EObject ruleImpliesExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_OrExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2082:28: ( (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2083:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2083:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2084:5: this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getImpliesExprAccess().getOrExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleOrExpr_in_ruleImpliesExpr4267);
            this_OrExpr_0=ruleOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_OrExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2092:1: ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==46) ) {
                int LA44_1 = input.LA(2);

                if ( (synpred3_InternalSpear()) ) {
                    alt44=1;
                }
            }
            else if ( (LA44_0==47) ) {
                int LA44_2 = input.LA(2);

                if ( (synpred3_InternalSpear()) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2092:2: ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2092:2: ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2092:3: ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2105:6: ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2105:7: () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2105:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2106:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getImpliesExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2111:2: ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2112:1: ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2112:1: ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2113:1: (lv_op_2_1= '=>' | lv_op_2_2= 'implies' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2113:1: (lv_op_2_1= '=>' | lv_op_2_2= 'implies' )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==46) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==47) ) {
                        alt43=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 43, 0, input);

                        throw nvae;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2114:3: lv_op_2_1= '=>'
                            {
                            lv_op_2_1=(Token)match(input,46,FOLLOW_46_in_ruleImpliesExpr4339); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getImpliesExprAccess().getOpEqualsSignGreaterThanSignKeyword_1_0_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getImpliesExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2126:8: lv_op_2_2= 'implies'
                            {
                            lv_op_2_2=(Token)match(input,47,FOLLOW_47_in_ruleImpliesExpr4368); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getImpliesExprAccess().getOpImpliesKeyword_1_0_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getImpliesExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2141:4: ( (lv_right_3_0= ruleImpliesExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2142:1: (lv_right_3_0= ruleImpliesExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2142:1: (lv_right_3_0= ruleImpliesExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2143:3: lv_right_3_0= ruleImpliesExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImpliesExprAccess().getRightImpliesExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleImpliesExpr_in_ruleImpliesExpr4407);
                    lv_right_3_0=ruleImpliesExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getImpliesExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"ImpliesExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImpliesExpr"


    // $ANTLR start "entryRuleOrExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2167:1: entryRuleOrExpr returns [EObject current=null] : iv_ruleOrExpr= ruleOrExpr EOF ;
    public final EObject entryRuleOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2168:2: (iv_ruleOrExpr= ruleOrExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2169:2: iv_ruleOrExpr= ruleOrExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExprRule()); 
            }
            pushFollow(FOLLOW_ruleOrExpr_in_entryRuleOrExpr4445);
            iv_ruleOrExpr=ruleOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrExpr4455); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpr"


    // $ANTLR start "ruleOrExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2176:1: ruleOrExpr returns [EObject current=null] : (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) ;
    public final EObject ruleOrExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AndExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2179:28: ( (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2180:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2180:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2181:5: this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrExprAccess().getAndExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAndExpr_in_ruleOrExpr4502);
            this_AndExpr_0=ruleAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2189:1: ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==48) ) {
                int LA46_1 = input.LA(2);

                if ( (synpred4_InternalSpear()) ) {
                    alt46=1;
                }
            }
            else if ( (LA46_0==49) ) {
                int LA46_2 = input.LA(2);

                if ( (synpred4_InternalSpear()) ) {
                    alt46=1;
                }
            }
            switch (alt46) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2189:2: ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2189:2: ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2189:3: ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2202:6: ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2202:7: () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2202:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2203:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getOrExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2208:2: ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2209:1: ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2209:1: ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2210:1: (lv_op_2_1= 'or' | lv_op_2_2= 'xor' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2210:1: (lv_op_2_1= 'or' | lv_op_2_2= 'xor' )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==48) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==49) ) {
                        alt45=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;
                    }
                    switch (alt45) {
                        case 1 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2211:3: lv_op_2_1= 'or'
                            {
                            lv_op_2_1=(Token)match(input,48,FOLLOW_48_in_ruleOrExpr4574); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getOrExprAccess().getOpOrKeyword_1_0_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getOrExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2223:8: lv_op_2_2= 'xor'
                            {
                            lv_op_2_2=(Token)match(input,49,FOLLOW_49_in_ruleOrExpr4603); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getOrExprAccess().getOpXorKeyword_1_0_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getOrExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2238:4: ( (lv_right_3_0= ruleImpliesExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2239:1: (lv_right_3_0= ruleImpliesExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2239:1: (lv_right_3_0= ruleImpliesExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2240:3: lv_right_3_0= ruleImpliesExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOrExprAccess().getRightImpliesExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleImpliesExpr_in_ruleOrExpr4642);
                    lv_right_3_0=ruleImpliesExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOrExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"ImpliesExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpr"


    // $ANTLR start "entryRuleAndExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2264:1: entryRuleAndExpr returns [EObject current=null] : iv_ruleAndExpr= ruleAndExpr EOF ;
    public final EObject entryRuleAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2265:2: (iv_ruleAndExpr= ruleAndExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2266:2: iv_ruleAndExpr= ruleAndExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExprRule()); 
            }
            pushFollow(FOLLOW_ruleAndExpr_in_entryRuleAndExpr4680);
            iv_ruleAndExpr=ruleAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpr4690); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpr"


    // $ANTLR start "ruleAndExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2273:1: ruleAndExpr returns [EObject current=null] : (this_TriggersExpr_0= ruleTriggersExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )? ) ;
    public final EObject ruleAndExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_TriggersExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2276:28: ( (this_TriggersExpr_0= ruleTriggersExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )? ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2277:1: (this_TriggersExpr_0= ruleTriggersExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )? )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2277:1: (this_TriggersExpr_0= ruleTriggersExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )? )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2278:5: this_TriggersExpr_0= ruleTriggersExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndExprAccess().getTriggersExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleTriggersExpr_in_ruleAndExpr4737);
            this_TriggersExpr_0=ruleTriggersExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TriggersExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2286:1: ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==50) ) {
                int LA47_1 = input.LA(2);

                if ( (synpred5_InternalSpear()) ) {
                    alt47=1;
                }
            }
            switch (alt47) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2286:2: ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2286:2: ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2286:3: ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2293:6: ( () ( (lv_op_2_0= 'and' ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2293:7: () ( (lv_op_2_0= 'and' ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2293:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2294:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getAndExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2299:2: ( (lv_op_2_0= 'and' ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2300:1: (lv_op_2_0= 'and' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2300:1: (lv_op_2_0= 'and' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2301:3: lv_op_2_0= 'and'
                    {
                    lv_op_2_0=(Token)match(input,50,FOLLOW_50_in_ruleAndExpr4788); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_2_0, grammarAccess.getAndExprAccess().getOpAndKeyword_1_0_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAndExprRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_2_0, "and");
                      	    
                    }

                    }


                    }


                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2314:4: ( (lv_right_3_0= ruleAndExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2315:1: (lv_right_3_0= ruleAndExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2315:1: (lv_right_3_0= ruleAndExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2316:3: lv_right_3_0= ruleAndExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAndExprAccess().getRightAndExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAndExpr_in_ruleAndExpr4824);
                    lv_right_3_0=ruleAndExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAndExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"AndExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpr"


    // $ANTLR start "entryRuleTriggersExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2340:1: entryRuleTriggersExpr returns [EObject current=null] : iv_ruleTriggersExpr= ruleTriggersExpr EOF ;
    public final EObject entryRuleTriggersExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggersExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2341:2: (iv_ruleTriggersExpr= ruleTriggersExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2342:2: iv_ruleTriggersExpr= ruleTriggersExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTriggersExprRule()); 
            }
            pushFollow(FOLLOW_ruleTriggersExpr_in_entryRuleTriggersExpr4862);
            iv_ruleTriggersExpr=ruleTriggersExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTriggersExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggersExpr4872); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTriggersExpr"


    // $ANTLR start "ruleTriggersExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2349:1: ruleTriggersExpr returns [EObject current=null] : (this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )? ) ;
    public final EObject ruleTriggersExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_SinceExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2352:28: ( (this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )? ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2353:1: (this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )? )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2353:1: (this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )? )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2354:5: this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTriggersExprAccess().getSinceExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleSinceExpr_in_ruleTriggersExpr4919);
            this_SinceExpr_0=ruleSinceExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_SinceExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2362:1: ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==51) ) {
                int LA49_1 = input.LA(2);

                if ( (synpred6_InternalSpear()) ) {
                    alt49=1;
                }
            }
            else if ( (LA49_0==52) ) {
                int LA49_2 = input.LA(2);

                if ( (synpred6_InternalSpear()) ) {
                    alt49=1;
                }
            }
            switch (alt49) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2362:2: ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2362:2: ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2362:3: ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2375:6: ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2375:7: () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2375:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2376:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getTriggersExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2381:2: ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2382:1: ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2382:1: ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2383:1: (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2383:1: (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==51) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==52) ) {
                        alt48=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                        throw nvae;
                    }
                    switch (alt48) {
                        case 1 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2384:3: lv_op_2_1= 'T'
                            {
                            lv_op_2_1=(Token)match(input,51,FOLLOW_51_in_ruleTriggersExpr4991); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getTriggersExprAccess().getOpTKeyword_1_0_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getTriggersExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2396:8: lv_op_2_2= 'triggers'
                            {
                            lv_op_2_2=(Token)match(input,52,FOLLOW_52_in_ruleTriggersExpr5020); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getTriggersExprAccess().getOpTriggersKeyword_1_0_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getTriggersExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2411:4: ( (lv_right_3_0= ruleTriggersExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2412:1: (lv_right_3_0= ruleTriggersExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2412:1: (lv_right_3_0= ruleTriggersExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2413:3: lv_right_3_0= ruleTriggersExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTriggersExprAccess().getRightTriggersExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTriggersExpr_in_ruleTriggersExpr5059);
                    lv_right_3_0=ruleTriggersExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTriggersExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"TriggersExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTriggersExpr"


    // $ANTLR start "entryRuleSinceExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2437:1: entryRuleSinceExpr returns [EObject current=null] : iv_ruleSinceExpr= ruleSinceExpr EOF ;
    public final EObject entryRuleSinceExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSinceExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2438:2: (iv_ruleSinceExpr= ruleSinceExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2439:2: iv_ruleSinceExpr= ruleSinceExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSinceExprRule()); 
            }
            pushFollow(FOLLOW_ruleSinceExpr_in_entryRuleSinceExpr5097);
            iv_ruleSinceExpr=ruleSinceExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSinceExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSinceExpr5107); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSinceExpr"


    // $ANTLR start "ruleSinceExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2446:1: ruleSinceExpr returns [EObject current=null] : (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )? ) ;
    public final EObject ruleSinceExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_RelationalExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2449:28: ( (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )? ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2450:1: (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )? )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2450:1: (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )? )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2451:5: this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSinceExprAccess().getRelationalExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleRelationalExpr_in_ruleSinceExpr5154);
            this_RelationalExpr_0=ruleRelationalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_RelationalExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2459:1: ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==53) ) {
                int LA51_1 = input.LA(2);

                if ( (synpred7_InternalSpear()) ) {
                    alt51=1;
                }
            }
            else if ( (LA51_0==54) ) {
                int LA51_2 = input.LA(2);

                if ( (synpred7_InternalSpear()) ) {
                    alt51=1;
                }
            }
            switch (alt51) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2459:2: ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2459:2: ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2459:3: ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2472:6: ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2472:7: () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2472:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2473:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getSinceExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2478:2: ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2479:1: ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2479:1: ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2480:1: (lv_op_2_1= 'S' | lv_op_2_2= 'since' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2480:1: (lv_op_2_1= 'S' | lv_op_2_2= 'since' )
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==53) ) {
                        alt50=1;
                    }
                    else if ( (LA50_0==54) ) {
                        alt50=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 50, 0, input);

                        throw nvae;
                    }
                    switch (alt50) {
                        case 1 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2481:3: lv_op_2_1= 'S'
                            {
                            lv_op_2_1=(Token)match(input,53,FOLLOW_53_in_ruleSinceExpr5226); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getSinceExprAccess().getOpSKeyword_1_0_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSinceExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2493:8: lv_op_2_2= 'since'
                            {
                            lv_op_2_2=(Token)match(input,54,FOLLOW_54_in_ruleSinceExpr5255); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getSinceExprAccess().getOpSinceKeyword_1_0_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSinceExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2508:4: ( (lv_right_3_0= ruleSinceExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2509:1: (lv_right_3_0= ruleSinceExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2509:1: (lv_right_3_0= ruleSinceExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2510:3: lv_right_3_0= ruleSinceExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSinceExprAccess().getRightSinceExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSinceExpr_in_ruleSinceExpr5294);
                    lv_right_3_0=ruleSinceExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSinceExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"SinceExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSinceExpr"


    // $ANTLR start "entryRuleRelationalExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2534:1: entryRuleRelationalExpr returns [EObject current=null] : iv_ruleRelationalExpr= ruleRelationalExpr EOF ;
    public final EObject entryRuleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2535:2: (iv_ruleRelationalExpr= ruleRelationalExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2536:2: iv_ruleRelationalExpr= ruleRelationalExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExprRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpr_in_entryRuleRelationalExpr5332);
            iv_ruleRelationalExpr=ruleRelationalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpr5342); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpr"


    // $ANTLR start "ruleRelationalExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2543:1: ruleRelationalExpr returns [EObject current=null] : (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )? ) ;
    public final EObject ruleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject this_PlusExpr_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2546:28: ( (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )? ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2547:1: (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )? )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2547:1: (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )? )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2548:5: this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRelationalExprAccess().getPlusExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePlusExpr_in_ruleRelationalExpr5389);
            this_PlusExpr_0=rulePlusExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PlusExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2556:1: ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )?
            int alt52=2;
            switch ( input.LA(1) ) {
                case 55:
                    {
                    int LA52_1 = input.LA(2);

                    if ( (synpred8_InternalSpear()) ) {
                        alt52=1;
                    }
                    }
                    break;
                case 56:
                    {
                    int LA52_2 = input.LA(2);

                    if ( (synpred8_InternalSpear()) ) {
                        alt52=1;
                    }
                    }
                    break;
                case 57:
                    {
                    int LA52_3 = input.LA(2);

                    if ( (synpred8_InternalSpear()) ) {
                        alt52=1;
                    }
                    }
                    break;
                case 58:
                    {
                    int LA52_4 = input.LA(2);

                    if ( (synpred8_InternalSpear()) ) {
                        alt52=1;
                    }
                    }
                    break;
                case 59:
                    {
                    int LA52_5 = input.LA(2);

                    if ( (synpred8_InternalSpear()) ) {
                        alt52=1;
                    }
                    }
                    break;
                case 60:
                    {
                    int LA52_6 = input.LA(2);

                    if ( (synpred8_InternalSpear()) ) {
                        alt52=1;
                    }
                    }
                    break;
            }

            switch (alt52) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2556:2: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2556:2: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2556:3: ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2561:6: ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2561:7: () ( (lv_op_2_0= ruleRelationalOp ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2561:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2562:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2567:2: ( (lv_op_2_0= ruleRelationalOp ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2568:1: (lv_op_2_0= ruleRelationalOp )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2568:1: (lv_op_2_0= ruleRelationalOp )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2569:3: lv_op_2_0= ruleRelationalOp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExprAccess().getOpRelationalOpParserRuleCall_1_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalOp_in_ruleRelationalExpr5438);
                    lv_op_2_0=ruleRelationalOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRelationalExprRule());
                      	        }
                             		set(
                             			current, 
                             			"op",
                              		lv_op_2_0, 
                              		"RelationalOp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2585:4: ( (lv_right_3_0= ruleRelationalExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2586:1: (lv_right_3_0= ruleRelationalExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2586:1: (lv_right_3_0= ruleRelationalExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2587:3: lv_right_3_0= ruleRelationalExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExprAccess().getRightRelationalExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpr_in_ruleRelationalExpr5461);
                    lv_right_3_0=ruleRelationalExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRelationalExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"RelationalExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpr"


    // $ANTLR start "entryRuleRelationalOp"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2611:1: entryRuleRelationalOp returns [String current=null] : iv_ruleRelationalOp= ruleRelationalOp EOF ;
    public final String entryRuleRelationalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOp = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2612:2: (iv_ruleRelationalOp= ruleRelationalOp EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2613:2: iv_ruleRelationalOp= ruleRelationalOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOpRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalOp_in_entryRuleRelationalOp5500);
            iv_ruleRelationalOp=ruleRelationalOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOp.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOp5511); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalOp"


    // $ANTLR start "ruleRelationalOp"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2620:1: ruleRelationalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '<' | kw= '<=' | kw= '>' | kw= '>=' | kw= '==' | kw= '<>' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2623:28: ( (kw= '<' | kw= '<=' | kw= '>' | kw= '>=' | kw= '==' | kw= '<>' ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2624:1: (kw= '<' | kw= '<=' | kw= '>' | kw= '>=' | kw= '==' | kw= '<>' )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2624:1: (kw= '<' | kw= '<=' | kw= '>' | kw= '>=' | kw= '==' | kw= '<>' )
            int alt53=6;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt53=1;
                }
                break;
            case 56:
                {
                alt53=2;
                }
                break;
            case 57:
                {
                alt53=3;
                }
                break;
            case 58:
                {
                alt53=4;
                }
                break;
            case 59:
                {
                alt53=5;
                }
                break;
            case 60:
                {
                alt53=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2625:2: kw= '<'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleRelationalOp5549); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2632:2: kw= '<='
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleRelationalOp5568); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2639:2: kw= '>'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleRelationalOp5587); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2646:2: kw= '>='
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleRelationalOp5606); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2653:2: kw= '=='
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleRelationalOp5625); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualsSignEqualsSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2660:2: kw= '<>'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleRelationalOp5644); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignGreaterThanSignKeyword_5()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalOp"


    // $ANTLR start "entryRulePlusExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2673:1: entryRulePlusExpr returns [EObject current=null] : iv_rulePlusExpr= rulePlusExpr EOF ;
    public final EObject entryRulePlusExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2674:2: (iv_rulePlusExpr= rulePlusExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2675:2: iv_rulePlusExpr= rulePlusExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlusExprRule()); 
            }
            pushFollow(FOLLOW_rulePlusExpr_in_entryRulePlusExpr5684);
            iv_rulePlusExpr=rulePlusExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlusExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePlusExpr5694); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlusExpr"


    // $ANTLR start "rulePlusExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2682:1: rulePlusExpr returns [EObject current=null] : (this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? ) ;
    public final EObject rulePlusExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_MultiplyExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2685:28: ( (this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2686:1: (this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2686:1: (this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2687:5: this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPlusExprAccess().getMultiplyExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplyExpr_in_rulePlusExpr5741);
            this_MultiplyExpr_0=ruleMultiplyExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MultiplyExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2695:1: ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==61) ) {
                int LA55_1 = input.LA(2);

                if ( (synpred9_InternalSpear()) ) {
                    alt55=1;
                }
            }
            else if ( (LA55_0==62) ) {
                int LA55_2 = input.LA(2);

                if ( (synpred9_InternalSpear()) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2695:2: ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2695:2: ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2695:3: ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2708:6: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2708:7: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2708:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2709:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getPlusExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2714:2: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2715:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2715:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2716:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2716:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==61) ) {
                        alt54=1;
                    }
                    else if ( (LA54_0==62) ) {
                        alt54=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 54, 0, input);

                        throw nvae;
                    }
                    switch (alt54) {
                        case 1 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2717:3: lv_op_2_1= '+'
                            {
                            lv_op_2_1=(Token)match(input,61,FOLLOW_61_in_rulePlusExpr5813); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getPlusExprAccess().getOpPlusSignKeyword_1_0_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPlusExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2729:8: lv_op_2_2= '-'
                            {
                            lv_op_2_2=(Token)match(input,62,FOLLOW_62_in_rulePlusExpr5842); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getPlusExprAccess().getOpHyphenMinusKeyword_1_0_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPlusExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2744:4: ( (lv_right_3_0= rulePlusExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2745:1: (lv_right_3_0= rulePlusExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2745:1: (lv_right_3_0= rulePlusExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2746:3: lv_right_3_0= rulePlusExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPlusExprAccess().getRightPlusExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePlusExpr_in_rulePlusExpr5881);
                    lv_right_3_0=rulePlusExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPlusExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"PlusExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlusExpr"


    // $ANTLR start "entryRuleMultiplyExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2770:1: entryRuleMultiplyExpr returns [EObject current=null] : iv_ruleMultiplyExpr= ruleMultiplyExpr EOF ;
    public final EObject entryRuleMultiplyExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2771:2: (iv_ruleMultiplyExpr= ruleMultiplyExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2772:2: iv_ruleMultiplyExpr= ruleMultiplyExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplyExprRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplyExpr_in_entryRuleMultiplyExpr5919);
            iv_ruleMultiplyExpr=ruleMultiplyExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplyExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplyExpr5929); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplyExpr"


    // $ANTLR start "ruleMultiplyExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2779:1: ruleMultiplyExpr returns [EObject current=null] : (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '*' | '/' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )? ) ;
    public final EObject ruleMultiplyExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_PrefixExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2782:28: ( (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '*' | '/' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )? ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2783:1: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '*' | '/' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )? )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2783:1: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '*' | '/' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )? )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2784:5: this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '*' | '/' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplyExprAccess().getPrefixExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePrefixExpr_in_ruleMultiplyExpr5976);
            this_PrefixExpr_0=rulePrefixExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PrefixExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2792:1: ( ( ( ( () ( ( ( '*' | '/' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==31) ) {
                int LA57_1 = input.LA(2);

                if ( (synpred10_InternalSpear()) ) {
                    alt57=1;
                }
            }
            else if ( (LA57_0==32) ) {
                int LA57_2 = input.LA(2);

                if ( (synpred10_InternalSpear()) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2792:2: ( ( ( () ( ( ( '*' | '/' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2792:2: ( ( ( () ( ( ( '*' | '/' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2792:3: ( ( () ( ( ( '*' | '/' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2805:6: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2805:7: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2805:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2806:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getMultiplyExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2811:2: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2812:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2812:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2813:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2813:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==31) ) {
                        alt56=1;
                    }
                    else if ( (LA56_0==32) ) {
                        alt56=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 56, 0, input);

                        throw nvae;
                    }
                    switch (alt56) {
                        case 1 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2814:3: lv_op_2_1= '*'
                            {
                            lv_op_2_1=(Token)match(input,31,FOLLOW_31_in_ruleMultiplyExpr6048); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getMultiplyExprAccess().getOpAsteriskKeyword_1_0_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getMultiplyExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2826:8: lv_op_2_2= '/'
                            {
                            lv_op_2_2=(Token)match(input,32,FOLLOW_32_in_ruleMultiplyExpr6077); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getMultiplyExprAccess().getOpSolidusKeyword_1_0_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getMultiplyExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2841:4: ( (lv_right_3_0= ruleMultiplyExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2842:1: (lv_right_3_0= ruleMultiplyExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2842:1: (lv_right_3_0= ruleMultiplyExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2843:3: lv_right_3_0= ruleMultiplyExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplyExprAccess().getRightMultiplyExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplyExpr_in_ruleMultiplyExpr6116);
                    lv_right_3_0=ruleMultiplyExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMultiplyExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"MultiplyExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplyExpr"


    // $ANTLR start "entryRulePrefixExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2867:1: entryRulePrefixExpr returns [EObject current=null] : iv_rulePrefixExpr= rulePrefixExpr EOF ;
    public final EObject entryRulePrefixExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2868:2: (iv_rulePrefixExpr= rulePrefixExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2869:2: iv_rulePrefixExpr= rulePrefixExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixExprRule()); 
            }
            pushFollow(FOLLOW_rulePrefixExpr_in_entryRulePrefixExpr6154);
            iv_rulePrefixExpr=rulePrefixExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrefixExpr6164); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixExpr"


    // $ANTLR start "rulePrefixExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2876:1: rulePrefixExpr returns [EObject current=null] : ( ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' | lv_op_1_3= 'O' | lv_op_1_4= 'once' | lv_op_1_5= 'H' | lv_op_1_6= 'historically' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | this_AccessExpr_3= ruleAccessExpr ) ;
    public final EObject rulePrefixExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        Token lv_op_1_4=null;
        Token lv_op_1_5=null;
        Token lv_op_1_6=null;
        EObject lv_expr_2_0 = null;

        EObject this_AccessExpr_3 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2879:28: ( ( ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' | lv_op_1_3= 'O' | lv_op_1_4= 'once' | lv_op_1_5= 'H' | lv_op_1_6= 'historically' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | this_AccessExpr_3= ruleAccessExpr ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2880:1: ( ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' | lv_op_1_3= 'O' | lv_op_1_4= 'once' | lv_op_1_5= 'H' | lv_op_1_6= 'historically' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | this_AccessExpr_3= ruleAccessExpr )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2880:1: ( ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' | lv_op_1_3= 'O' | lv_op_1_4= 'once' | lv_op_1_5= 'H' | lv_op_1_6= 'historically' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | this_AccessExpr_3= ruleAccessExpr )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=62 && LA59_0<=67)) ) {
                alt59=1;
            }
            else if ( (LA59_0==RULE_ID||LA59_0==RULE_INT||LA59_0==33||(LA59_0>=70 && LA59_0<=72)||(LA59_0>=75 && LA59_0<=81)) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2880:2: ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' | lv_op_1_3= 'O' | lv_op_1_4= 'once' | lv_op_1_5= 'H' | lv_op_1_6= 'historically' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2880:2: ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' | lv_op_1_3= 'O' | lv_op_1_4= 'once' | lv_op_1_5= 'H' | lv_op_1_6= 'historically' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2880:3: () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' | lv_op_1_3= 'O' | lv_op_1_4= 'once' | lv_op_1_5= 'H' | lv_op_1_6= 'historically' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2880:3: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2881:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixExprAccess().getUnaryExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2886:2: ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' | lv_op_1_3= 'O' | lv_op_1_4= 'once' | lv_op_1_5= 'H' | lv_op_1_6= 'historically' ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2887:1: ( (lv_op_1_1= '-' | lv_op_1_2= 'not' | lv_op_1_3= 'O' | lv_op_1_4= 'once' | lv_op_1_5= 'H' | lv_op_1_6= 'historically' ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2887:1: ( (lv_op_1_1= '-' | lv_op_1_2= 'not' | lv_op_1_3= 'O' | lv_op_1_4= 'once' | lv_op_1_5= 'H' | lv_op_1_6= 'historically' ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2888:1: (lv_op_1_1= '-' | lv_op_1_2= 'not' | lv_op_1_3= 'O' | lv_op_1_4= 'once' | lv_op_1_5= 'H' | lv_op_1_6= 'historically' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2888:1: (lv_op_1_1= '-' | lv_op_1_2= 'not' | lv_op_1_3= 'O' | lv_op_1_4= 'once' | lv_op_1_5= 'H' | lv_op_1_6= 'historically' )
                    int alt58=6;
                    switch ( input.LA(1) ) {
                    case 62:
                        {
                        alt58=1;
                        }
                        break;
                    case 63:
                        {
                        alt58=2;
                        }
                        break;
                    case 64:
                        {
                        alt58=3;
                        }
                        break;
                    case 65:
                        {
                        alt58=4;
                        }
                        break;
                    case 66:
                        {
                        alt58=5;
                        }
                        break;
                    case 67:
                        {
                        alt58=6;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 58, 0, input);

                        throw nvae;
                    }

                    switch (alt58) {
                        case 1 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2889:3: lv_op_1_1= '-'
                            {
                            lv_op_1_1=(Token)match(input,62,FOLLOW_62_in_rulePrefixExpr6219); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_1, grammarAccess.getPrefixExprAccess().getOpHyphenMinusKeyword_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2901:8: lv_op_1_2= 'not'
                            {
                            lv_op_1_2=(Token)match(input,63,FOLLOW_63_in_rulePrefixExpr6248); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_2, grammarAccess.getPrefixExprAccess().getOpNotKeyword_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_2, null);
                              	    
                            }

                            }
                            break;
                        case 3 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2913:8: lv_op_1_3= 'O'
                            {
                            lv_op_1_3=(Token)match(input,64,FOLLOW_64_in_rulePrefixExpr6277); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_3, grammarAccess.getPrefixExprAccess().getOpOKeyword_0_1_0_2());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_3, null);
                              	    
                            }

                            }
                            break;
                        case 4 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2925:8: lv_op_1_4= 'once'
                            {
                            lv_op_1_4=(Token)match(input,65,FOLLOW_65_in_rulePrefixExpr6306); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_4, grammarAccess.getPrefixExprAccess().getOpOnceKeyword_0_1_0_3());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_4, null);
                              	    
                            }

                            }
                            break;
                        case 5 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2937:8: lv_op_1_5= 'H'
                            {
                            lv_op_1_5=(Token)match(input,66,FOLLOW_66_in_rulePrefixExpr6335); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_5, grammarAccess.getPrefixExprAccess().getOpHKeyword_0_1_0_4());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_5, null);
                              	    
                            }

                            }
                            break;
                        case 6 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2949:8: lv_op_1_6= 'historically'
                            {
                            lv_op_1_6=(Token)match(input,67,FOLLOW_67_in_rulePrefixExpr6364); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_6, grammarAccess.getPrefixExprAccess().getOpHistoricallyKeyword_0_1_0_5());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_6, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2964:2: ( (lv_expr_2_0= rulePrefixExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2965:1: (lv_expr_2_0= rulePrefixExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2965:1: (lv_expr_2_0= rulePrefixExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2966:3: lv_expr_2_0= rulePrefixExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixExprAccess().getExprPrefixExprParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrefixExpr_in_rulePrefixExpr6401);
                    lv_expr_2_0=rulePrefixExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixExprRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_2_0, 
                              		"PrefixExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2984:5: this_AccessExpr_3= ruleAccessExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixExprAccess().getAccessExprParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAccessExpr_in_rulePrefixExpr6430);
                    this_AccessExpr_3=ruleAccessExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AccessExpr_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefixExpr"


    // $ANTLR start "entryRuleAccessExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3000:1: entryRuleAccessExpr returns [EObject current=null] : iv_ruleAccessExpr= ruleAccessExpr EOF ;
    public final EObject entryRuleAccessExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccessExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3001:2: (iv_ruleAccessExpr= ruleAccessExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3002:2: iv_ruleAccessExpr= ruleAccessExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccessExprRule()); 
            }
            pushFollow(FOLLOW_ruleAccessExpr_in_entryRuleAccessExpr6465);
            iv_ruleAccessExpr=ruleAccessExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccessExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAccessExpr6475); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccessExpr"


    // $ANTLR start "ruleAccessExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3009:1: ruleAccessExpr returns [EObject current=null] : (this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )* ) ;
    public final EObject ruleAccessExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject this_AtomicExpr_0 = null;

        EObject lv_value_8_0 = null;

        EObject lv_index_12_0 = null;

        EObject lv_value_15_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3012:28: ( (this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )* ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3013:1: (this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )* )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3013:1: (this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )* )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3014:5: this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAccessExprAccess().getAtomicExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAtomicExpr_in_ruleAccessExpr6522);
            this_AtomicExpr_0=ruleAtomicExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AtomicExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3022:1: ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )*
            loop61:
            do {
                int alt61=4;
                switch ( input.LA(1) ) {
                case 68:
                    {
                    int LA61_2 = input.LA(2);

                    if ( (synpred11_InternalSpear()) ) {
                        alt61=1;
                    }


                    }
                    break;
                case 37:
                    {
                    int LA61_3 = input.LA(2);

                    if ( (synpred12_InternalSpear()) ) {
                        alt61=2;
                    }


                    }
                    break;
                case 39:
                    {
                    int LA61_4 = input.LA(2);

                    if ( (synpred13_InternalSpear()) ) {
                        alt61=3;
                    }


                    }
                    break;

                }

                switch (alt61) {
            	case 1 :
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3022:2: ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3022:2: ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3022:3: ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3022:3: ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3022:4: ( ( () '.' ) )=> ( () otherlv_2= '.' )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3024:5: ( () otherlv_2= '.' )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3024:6: () otherlv_2= '.'
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3024:6: ()
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3025:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAccessExprAccess().getRecordAccessExprRecordAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,68,FOLLOW_68_in_ruleAccessExpr6558); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAccessExprAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3034:3: ( (otherlv_3= RULE_ID ) )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3035:1: (otherlv_3= RULE_ID )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3035:1: (otherlv_3= RULE_ID )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3036:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getAccessExprRule());
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAccessExpr6580); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_3, grammarAccess.getAccessExprAccess().getFieldRecordFieldExprCrossReference_1_0_1_0()); 
            	      	
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3048:6: ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3048:6: ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3048:7: ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}'
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3048:7: ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3048:8: ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3056:5: ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3056:6: () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':='
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3056:6: ()
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3057:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAccessExprAccess().getRecordUpdateExprRecordAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_5=(Token)match(input,37,FOLLOW_37_in_ruleAccessExpr6638); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getAccessExprAccess().getLeftCurlyBracketKeyword_1_1_0_0_1());
            	          
            	    }
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3066:1: ( (otherlv_6= RULE_ID ) )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3067:1: (otherlv_6= RULE_ID )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3067:1: (otherlv_6= RULE_ID )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3068:3: otherlv_6= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getAccessExprRule());
            	      	        }
            	              
            	    }
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAccessExpr6658); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_6, grammarAccess.getAccessExprAccess().getFieldRecordFieldExprCrossReference_1_1_0_0_2_0()); 
            	      	
            	    }

            	    }


            	    }

            	    otherlv_7=(Token)match(input,69,FOLLOW_69_in_ruleAccessExpr6670); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getAccessExprAccess().getColonEqualsSignKeyword_1_1_0_0_3());
            	          
            	    }

            	    }


            	    }

            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3083:3: ( (lv_value_8_0= ruleExpr ) )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3084:1: (lv_value_8_0= ruleExpr )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3084:1: (lv_value_8_0= ruleExpr )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3085:3: lv_value_8_0= ruleExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAccessExprAccess().getValueExprParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpr_in_ruleAccessExpr6693);
            	    lv_value_8_0=ruleExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAccessExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"value",
            	              		lv_value_8_0, 
            	              		"Expr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_9=(Token)match(input,38,FOLLOW_38_in_ruleAccessExpr6705); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_9, grammarAccess.getAccessExprAccess().getRightCurlyBracketKeyword_1_1_2());
            	          
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3106:6: ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3106:6: ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3106:7: ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']'
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3106:7: ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3106:8: ( ( () '[' ) )=> ( () otherlv_11= '[' )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3108:5: ( () otherlv_11= '[' )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3108:6: () otherlv_11= '['
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3108:6: ()
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3109:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAccessExprAccess().getArrayAccessExprArrayAction_1_2_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_11=(Token)match(input,39,FOLLOW_39_in_ruleAccessExpr6748); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_11, grammarAccess.getAccessExprAccess().getLeftSquareBracketKeyword_1_2_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3118:3: ( (lv_index_12_0= ruleExpr ) )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3119:1: (lv_index_12_0= ruleExpr )
            	    {
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3119:1: (lv_index_12_0= ruleExpr )
            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3120:3: lv_index_12_0= ruleExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAccessExprAccess().getIndexExprParserRuleCall_1_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpr_in_ruleAccessExpr6771);
            	    lv_index_12_0=ruleExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAccessExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"index",
            	              		lv_index_12_0, 
            	              		"Expr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3136:2: ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )?
            	    int alt60=2;
            	    int LA60_0 = input.LA(1);

            	    if ( (LA60_0==69) && (synpred14_InternalSpear())) {
            	        alt60=1;
            	    }
            	    switch (alt60) {
            	        case 1 :
            	            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3136:3: ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) )
            	            {
            	            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3136:3: ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) )
            	            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3136:4: ( ( () ':=' ) )=> ( () otherlv_14= ':=' )
            	            {
            	            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3138:5: ( () otherlv_14= ':=' )
            	            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3138:6: () otherlv_14= ':='
            	            {
            	            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3138:6: ()
            	            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3139:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getAccessExprAccess().getArrayUpdateExprAccessAction_1_2_2_0_0_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_14=(Token)match(input,69,FOLLOW_69_in_ruleAccessExpr6807); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getAccessExprAccess().getColonEqualsSignKeyword_1_2_2_0_0_1());
            	                  
            	            }

            	            }


            	            }

            	            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3148:3: ( (lv_value_15_0= ruleExpr ) )
            	            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3149:1: (lv_value_15_0= ruleExpr )
            	            {
            	            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3149:1: (lv_value_15_0= ruleExpr )
            	            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3150:3: lv_value_15_0= ruleExpr
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getAccessExprAccess().getValueExprParserRuleCall_1_2_2_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleExpr_in_ruleAccessExpr6830);
            	            lv_value_15_0=ruleExpr();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getAccessExprRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"value",
            	                      		lv_value_15_0, 
            	                      		"Expr");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    otherlv_16=(Token)match(input,40,FOLLOW_40_in_ruleAccessExpr6844); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_16, grammarAccess.getAccessExprAccess().getRightSquareBracketKeyword_1_2_3());
            	          
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAccessExpr"


    // $ANTLR start "entryRuleAtomicExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3178:1: entryRuleAtomicExpr returns [EObject current=null] : iv_ruleAtomicExpr= ruleAtomicExpr EOF ;
    public final EObject entryRuleAtomicExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3179:2: (iv_ruleAtomicExpr= ruleAtomicExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3180:2: iv_ruleAtomicExpr= ruleAtomicExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicExprRule()); 
            }
            pushFollow(FOLLOW_ruleAtomicExpr_in_entryRuleAtomicExpr6883);
            iv_ruleAtomicExpr=ruleAtomicExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomicExpr6893); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicExpr"


    // $ANTLR start "ruleAtomicExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3187:1: ruleAtomicExpr returns [EObject current=null] : (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'prev' otherlv_11= '(' ( (lv_var_12_0= ruleExpr ) ) otherlv_13= ',' ( (lv_init_14_0= ruleExpr ) ) otherlv_15= ')' ) | ( () otherlv_17= 'if' ( (lv_cond_18_0= ruleExpr ) ) otherlv_19= 'then' ( (lv_then_20_0= ruleExpr ) ) otherlv_21= 'else' ( (lv_else_22_0= ruleExpr ) ) ) | ( () otherlv_24= 'new' ( (otherlv_25= RULE_ID ) ) otherlv_26= '{' ( (lv_fieldExprs_27_0= ruleRecordFieldExpr ) ) (otherlv_28= ',' ( (lv_fieldExprs_29_0= ruleRecordFieldExpr ) ) )* otherlv_30= '}' ) | ( () otherlv_32= 'new' ( (otherlv_33= RULE_ID ) ) otherlv_34= '[' ( (lv_exprs_35_0= ruleExpr ) ) (otherlv_36= ',' ( (lv_exprs_37_0= ruleExpr ) ) )* otherlv_38= ']' ) | ( () otherlv_40= 'pattern' ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* otherlv_54= ')' ) | (otherlv_55= '(' this_Expr_56= ruleExpr otherlv_57= ')' ) ) ;
    public final EObject ruleAtomicExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        Token otherlv_40=null;
        Token otherlv_41=null;
        Token otherlv_42=null;
        Token otherlv_44=null;
        Token otherlv_46=null;
        Token otherlv_48=null;
        Token otherlv_49=null;
        Token otherlv_50=null;
        Token otherlv_52=null;
        Token otherlv_54=null;
        Token otherlv_55=null;
        Token otherlv_57=null;
        EObject this_LiteralExpr_0 = null;

        EObject lv_var_12_0 = null;

        EObject lv_init_14_0 = null;

        EObject lv_cond_18_0 = null;

        EObject lv_then_20_0 = null;

        EObject lv_else_22_0 = null;

        EObject lv_fieldExprs_27_0 = null;

        EObject lv_fieldExprs_29_0 = null;

        EObject lv_exprs_35_0 = null;

        EObject lv_exprs_37_0 = null;

        EObject lv_args_43_0 = null;

        EObject lv_args_45_0 = null;

        EObject lv_args_51_0 = null;

        EObject lv_args_53_0 = null;

        EObject this_Expr_56 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3190:28: ( (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'prev' otherlv_11= '(' ( (lv_var_12_0= ruleExpr ) ) otherlv_13= ',' ( (lv_init_14_0= ruleExpr ) ) otherlv_15= ')' ) | ( () otherlv_17= 'if' ( (lv_cond_18_0= ruleExpr ) ) otherlv_19= 'then' ( (lv_then_20_0= ruleExpr ) ) otherlv_21= 'else' ( (lv_else_22_0= ruleExpr ) ) ) | ( () otherlv_24= 'new' ( (otherlv_25= RULE_ID ) ) otherlv_26= '{' ( (lv_fieldExprs_27_0= ruleRecordFieldExpr ) ) (otherlv_28= ',' ( (lv_fieldExprs_29_0= ruleRecordFieldExpr ) ) )* otherlv_30= '}' ) | ( () otherlv_32= 'new' ( (otherlv_33= RULE_ID ) ) otherlv_34= '[' ( (lv_exprs_35_0= ruleExpr ) ) (otherlv_36= ',' ( (lv_exprs_37_0= ruleExpr ) ) )* otherlv_38= ']' ) | ( () otherlv_40= 'pattern' ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* otherlv_54= ')' ) | (otherlv_55= '(' this_Expr_56= ruleExpr otherlv_57= ')' ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3191:1: (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'prev' otherlv_11= '(' ( (lv_var_12_0= ruleExpr ) ) otherlv_13= ',' ( (lv_init_14_0= ruleExpr ) ) otherlv_15= ')' ) | ( () otherlv_17= 'if' ( (lv_cond_18_0= ruleExpr ) ) otherlv_19= 'then' ( (lv_then_20_0= ruleExpr ) ) otherlv_21= 'else' ( (lv_else_22_0= ruleExpr ) ) ) | ( () otherlv_24= 'new' ( (otherlv_25= RULE_ID ) ) otherlv_26= '{' ( (lv_fieldExprs_27_0= ruleRecordFieldExpr ) ) (otherlv_28= ',' ( (lv_fieldExprs_29_0= ruleRecordFieldExpr ) ) )* otherlv_30= '}' ) | ( () otherlv_32= 'new' ( (otherlv_33= RULE_ID ) ) otherlv_34= '[' ( (lv_exprs_35_0= ruleExpr ) ) (otherlv_36= ',' ( (lv_exprs_37_0= ruleExpr ) ) )* otherlv_38= ']' ) | ( () otherlv_40= 'pattern' ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* otherlv_54= ')' ) | (otherlv_55= '(' this_Expr_56= ruleExpr otherlv_57= ')' ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3191:1: (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'prev' otherlv_11= '(' ( (lv_var_12_0= ruleExpr ) ) otherlv_13= ',' ( (lv_init_14_0= ruleExpr ) ) otherlv_15= ')' ) | ( () otherlv_17= 'if' ( (lv_cond_18_0= ruleExpr ) ) otherlv_19= 'then' ( (lv_then_20_0= ruleExpr ) ) otherlv_21= 'else' ( (lv_else_22_0= ruleExpr ) ) ) | ( () otherlv_24= 'new' ( (otherlv_25= RULE_ID ) ) otherlv_26= '{' ( (lv_fieldExprs_27_0= ruleRecordFieldExpr ) ) (otherlv_28= ',' ( (lv_fieldExprs_29_0= ruleRecordFieldExpr ) ) )* otherlv_30= '}' ) | ( () otherlv_32= 'new' ( (otherlv_33= RULE_ID ) ) otherlv_34= '[' ( (lv_exprs_35_0= ruleExpr ) ) (otherlv_36= ',' ( (lv_exprs_37_0= ruleExpr ) ) )* otherlv_38= ']' ) | ( () otherlv_40= 'pattern' ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* otherlv_54= ')' ) | (otherlv_55= '(' this_Expr_56= ruleExpr otherlv_57= ')' ) )
            int alt67=10;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3192:5: this_LiteralExpr_0= ruleLiteralExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicExprAccess().getLiteralExprParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLiteralExpr_in_ruleAtomicExpr6940);
                    this_LiteralExpr_0=ruleLiteralExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LiteralExpr_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3201:6: ( () ( (otherlv_2= RULE_ID ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3201:6: ( () ( (otherlv_2= RULE_ID ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3201:7: () ( (otherlv_2= RULE_ID ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3201:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3202:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getIdExprAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3207:2: ( (otherlv_2= RULE_ID ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3208:1: (otherlv_2= RULE_ID )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3208:1: (otherlv_2= RULE_ID )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3209:3: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExpr6975); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_2, grammarAccess.getAtomicExprAccess().getIdIdRefCrossReference_1_1_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3221:6: ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3221:6: ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3221:7: () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|'
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3221:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3222:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getMIdExprAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_4=(Token)match(input,70,FOLLOW_70_in_ruleAtomicExpr7004); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getAtomicExprAccess().getVerticalLineKeyword_2_1());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3231:1: ( (otherlv_5= RULE_ID ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3232:1: (otherlv_5= RULE_ID )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3232:1: (otherlv_5= RULE_ID )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3233:3: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExpr7024); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_5, grammarAccess.getAtomicExprAccess().getIdsIdRefCrossReference_2_2_0()); 
                      	
                    }

                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3244:2: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==27) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3244:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleAtomicExpr7037); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_6, grammarAccess.getAtomicExprAccess().getCommaKeyword_2_3_0());
                    	          
                    	    }
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3248:1: ( (otherlv_7= RULE_ID ) )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3249:1: (otherlv_7= RULE_ID )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3249:1: (otherlv_7= RULE_ID )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3250:3: otherlv_7= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExpr7057); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_7, grammarAccess.getAtomicExprAccess().getIdsIdRefCrossReference_2_3_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,70,FOLLOW_70_in_ruleAtomicExpr7071); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getAtomicExprAccess().getVerticalLineKeyword_2_4());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3266:6: ( () otherlv_10= 'prev' otherlv_11= '(' ( (lv_var_12_0= ruleExpr ) ) otherlv_13= ',' ( (lv_init_14_0= ruleExpr ) ) otherlv_15= ')' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3266:6: ( () otherlv_10= 'prev' otherlv_11= '(' ( (lv_var_12_0= ruleExpr ) ) otherlv_13= ',' ( (lv_init_14_0= ruleExpr ) ) otherlv_15= ')' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3266:7: () otherlv_10= 'prev' otherlv_11= '(' ( (lv_var_12_0= ruleExpr ) ) otherlv_13= ',' ( (lv_init_14_0= ruleExpr ) ) otherlv_15= ')'
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3266:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3267:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getPreviousExprAction_3_0(),
                                  current);
                          
                    }

                    }

                    otherlv_10=(Token)match(input,71,FOLLOW_71_in_ruleAtomicExpr7100); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getAtomicExprAccess().getPrevKeyword_3_1());
                          
                    }
                    otherlv_11=(Token)match(input,33,FOLLOW_33_in_ruleAtomicExpr7112); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_3_2());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3280:1: ( (lv_var_12_0= ruleExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3281:1: (lv_var_12_0= ruleExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3281:1: (lv_var_12_0= ruleExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3282:3: lv_var_12_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getVarExprParserRuleCall_3_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleAtomicExpr7133);
                    lv_var_12_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"var",
                              		lv_var_12_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_13=(Token)match(input,27,FOLLOW_27_in_ruleAtomicExpr7145); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getAtomicExprAccess().getCommaKeyword_3_4());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3302:1: ( (lv_init_14_0= ruleExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3303:1: (lv_init_14_0= ruleExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3303:1: (lv_init_14_0= ruleExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3304:3: lv_init_14_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getInitExprParserRuleCall_3_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleAtomicExpr7166);
                    lv_init_14_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"init",
                              		lv_init_14_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_15=(Token)match(input,34,FOLLOW_34_in_ruleAtomicExpr7178); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_3_6());
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3325:6: ( () otherlv_17= 'if' ( (lv_cond_18_0= ruleExpr ) ) otherlv_19= 'then' ( (lv_then_20_0= ruleExpr ) ) otherlv_21= 'else' ( (lv_else_22_0= ruleExpr ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3325:6: ( () otherlv_17= 'if' ( (lv_cond_18_0= ruleExpr ) ) otherlv_19= 'then' ( (lv_then_20_0= ruleExpr ) ) otherlv_21= 'else' ( (lv_else_22_0= ruleExpr ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3325:7: () otherlv_17= 'if' ( (lv_cond_18_0= ruleExpr ) ) otherlv_19= 'then' ( (lv_then_20_0= ruleExpr ) ) otherlv_21= 'else' ( (lv_else_22_0= ruleExpr ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3325:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3326:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getIfThenElseExprAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_17=(Token)match(input,72,FOLLOW_72_in_ruleAtomicExpr7207); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getAtomicExprAccess().getIfKeyword_4_1());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3335:1: ( (lv_cond_18_0= ruleExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3336:1: (lv_cond_18_0= ruleExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3336:1: (lv_cond_18_0= ruleExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3337:3: lv_cond_18_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getCondExprParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleAtomicExpr7228);
                    lv_cond_18_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"cond",
                              		lv_cond_18_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_19=(Token)match(input,73,FOLLOW_73_in_ruleAtomicExpr7240); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getAtomicExprAccess().getThenKeyword_4_3());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3357:1: ( (lv_then_20_0= ruleExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3358:1: (lv_then_20_0= ruleExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3358:1: (lv_then_20_0= ruleExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3359:3: lv_then_20_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getThenExprParserRuleCall_4_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleAtomicExpr7261);
                    lv_then_20_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"then",
                              		lv_then_20_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_21=(Token)match(input,74,FOLLOW_74_in_ruleAtomicExpr7273); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getAtomicExprAccess().getElseKeyword_4_5());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3379:1: ( (lv_else_22_0= ruleExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3380:1: (lv_else_22_0= ruleExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3380:1: (lv_else_22_0= ruleExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3381:3: lv_else_22_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getElseExprParserRuleCall_4_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleAtomicExpr7294);
                    lv_else_22_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_22_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3398:6: ( () otherlv_24= 'new' ( (otherlv_25= RULE_ID ) ) otherlv_26= '{' ( (lv_fieldExprs_27_0= ruleRecordFieldExpr ) ) (otherlv_28= ',' ( (lv_fieldExprs_29_0= ruleRecordFieldExpr ) ) )* otherlv_30= '}' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3398:6: ( () otherlv_24= 'new' ( (otherlv_25= RULE_ID ) ) otherlv_26= '{' ( (lv_fieldExprs_27_0= ruleRecordFieldExpr ) ) (otherlv_28= ',' ( (lv_fieldExprs_29_0= ruleRecordFieldExpr ) ) )* otherlv_30= '}' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3398:7: () otherlv_24= 'new' ( (otherlv_25= RULE_ID ) ) otherlv_26= '{' ( (lv_fieldExprs_27_0= ruleRecordFieldExpr ) ) (otherlv_28= ',' ( (lv_fieldExprs_29_0= ruleRecordFieldExpr ) ) )* otherlv_30= '}'
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3398:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3399:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getRecordExprAction_5_0(),
                                  current);
                          
                    }

                    }

                    otherlv_24=(Token)match(input,75,FOLLOW_75_in_ruleAtomicExpr7323); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getAtomicExprAccess().getNewKeyword_5_1());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3408:1: ( (otherlv_25= RULE_ID ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3409:1: (otherlv_25= RULE_ID )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3409:1: (otherlv_25= RULE_ID )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3410:3: otherlv_25= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExpr7343); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_25, grammarAccess.getAtomicExprAccess().getTypeRecordTypeCrossReference_5_2_0()); 
                      	
                    }

                    }


                    }

                    otherlv_26=(Token)match(input,37,FOLLOW_37_in_ruleAtomicExpr7355); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_26, grammarAccess.getAtomicExprAccess().getLeftCurlyBracketKeyword_5_3());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3425:1: ( (lv_fieldExprs_27_0= ruleRecordFieldExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3426:1: (lv_fieldExprs_27_0= ruleRecordFieldExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3426:1: (lv_fieldExprs_27_0= ruleRecordFieldExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3427:3: lv_fieldExprs_27_0= ruleRecordFieldExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getFieldExprsRecordFieldExprParserRuleCall_5_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRecordFieldExpr_in_ruleAtomicExpr7376);
                    lv_fieldExprs_27_0=ruleRecordFieldExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		add(
                             			current, 
                             			"fieldExprs",
                              		lv_fieldExprs_27_0, 
                              		"RecordFieldExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3443:2: (otherlv_28= ',' ( (lv_fieldExprs_29_0= ruleRecordFieldExpr ) ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==27) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3443:4: otherlv_28= ',' ( (lv_fieldExprs_29_0= ruleRecordFieldExpr ) )
                    	    {
                    	    otherlv_28=(Token)match(input,27,FOLLOW_27_in_ruleAtomicExpr7389); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_28, grammarAccess.getAtomicExprAccess().getCommaKeyword_5_5_0());
                    	          
                    	    }
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3447:1: ( (lv_fieldExprs_29_0= ruleRecordFieldExpr ) )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3448:1: (lv_fieldExprs_29_0= ruleRecordFieldExpr )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3448:1: (lv_fieldExprs_29_0= ruleRecordFieldExpr )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3449:3: lv_fieldExprs_29_0= ruleRecordFieldExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getFieldExprsRecordFieldExprParserRuleCall_5_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleRecordFieldExpr_in_ruleAtomicExpr7410);
                    	    lv_fieldExprs_29_0=ruleRecordFieldExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"fieldExprs",
                    	              		lv_fieldExprs_29_0, 
                    	              		"RecordFieldExpr");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);

                    otherlv_30=(Token)match(input,38,FOLLOW_38_in_ruleAtomicExpr7424); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_30, grammarAccess.getAtomicExprAccess().getRightCurlyBracketKeyword_5_6());
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3470:6: ( () otherlv_32= 'new' ( (otherlv_33= RULE_ID ) ) otherlv_34= '[' ( (lv_exprs_35_0= ruleExpr ) ) (otherlv_36= ',' ( (lv_exprs_37_0= ruleExpr ) ) )* otherlv_38= ']' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3470:6: ( () otherlv_32= 'new' ( (otherlv_33= RULE_ID ) ) otherlv_34= '[' ( (lv_exprs_35_0= ruleExpr ) ) (otherlv_36= ',' ( (lv_exprs_37_0= ruleExpr ) ) )* otherlv_38= ']' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3470:7: () otherlv_32= 'new' ( (otherlv_33= RULE_ID ) ) otherlv_34= '[' ( (lv_exprs_35_0= ruleExpr ) ) (otherlv_36= ',' ( (lv_exprs_37_0= ruleExpr ) ) )* otherlv_38= ']'
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3470:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3471:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getArrayExprAction_6_0(),
                                  current);
                          
                    }

                    }

                    otherlv_32=(Token)match(input,75,FOLLOW_75_in_ruleAtomicExpr7453); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_32, grammarAccess.getAtomicExprAccess().getNewKeyword_6_1());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3480:1: ( (otherlv_33= RULE_ID ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3481:1: (otherlv_33= RULE_ID )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3481:1: (otherlv_33= RULE_ID )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3482:3: otherlv_33= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_33=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExpr7473); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_33, grammarAccess.getAtomicExprAccess().getTypeArrayTypeCrossReference_6_2_0()); 
                      	
                    }

                    }


                    }

                    otherlv_34=(Token)match(input,39,FOLLOW_39_in_ruleAtomicExpr7485); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_34, grammarAccess.getAtomicExprAccess().getLeftSquareBracketKeyword_6_3());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3497:1: ( (lv_exprs_35_0= ruleExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3498:1: (lv_exprs_35_0= ruleExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3498:1: (lv_exprs_35_0= ruleExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3499:3: lv_exprs_35_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getExprsExprParserRuleCall_6_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleAtomicExpr7506);
                    lv_exprs_35_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		add(
                             			current, 
                             			"exprs",
                              		lv_exprs_35_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3515:2: (otherlv_36= ',' ( (lv_exprs_37_0= ruleExpr ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==27) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3515:4: otherlv_36= ',' ( (lv_exprs_37_0= ruleExpr ) )
                    	    {
                    	    otherlv_36=(Token)match(input,27,FOLLOW_27_in_ruleAtomicExpr7519); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_36, grammarAccess.getAtomicExprAccess().getCommaKeyword_6_5_0());
                    	          
                    	    }
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3519:1: ( (lv_exprs_37_0= ruleExpr ) )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3520:1: (lv_exprs_37_0= ruleExpr )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3520:1: (lv_exprs_37_0= ruleExpr )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3521:3: lv_exprs_37_0= ruleExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getExprsExprParserRuleCall_6_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExpr_in_ruleAtomicExpr7540);
                    	    lv_exprs_37_0=ruleExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"exprs",
                    	              		lv_exprs_37_0, 
                    	              		"Expr");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop64;
                        }
                    } while (true);

                    otherlv_38=(Token)match(input,40,FOLLOW_40_in_ruleAtomicExpr7554); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_38, grammarAccess.getAtomicExprAccess().getRightSquareBracketKeyword_6_6());
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3542:6: ( () otherlv_40= 'pattern' ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* otherlv_46= ')' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3542:6: ( () otherlv_40= 'pattern' ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* otherlv_46= ')' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3542:7: () otherlv_40= 'pattern' ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* otherlv_46= ')'
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3542:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3543:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getPatternCallAction_7_0(),
                                  current);
                          
                    }

                    }

                    otherlv_40=(Token)match(input,76,FOLLOW_76_in_ruleAtomicExpr7583); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_40, grammarAccess.getAtomicExprAccess().getPatternKeyword_7_1());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3552:1: ( (otherlv_41= RULE_ID ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3553:1: (otherlv_41= RULE_ID )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3553:1: (otherlv_41= RULE_ID )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3554:3: otherlv_41= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_41=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExpr7603); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_41, grammarAccess.getAtomicExprAccess().getPatternPatternCrossReference_7_2_0()); 
                      	
                    }

                    }


                    }

                    otherlv_42=(Token)match(input,33,FOLLOW_33_in_ruleAtomicExpr7615); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_42, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_7_3());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3569:1: ( (lv_args_43_0= ruleExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3570:1: (lv_args_43_0= ruleExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3570:1: (lv_args_43_0= ruleExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3571:3: lv_args_43_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_7_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleAtomicExpr7636);
                    lv_args_43_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		add(
                             			current, 
                             			"args",
                              		lv_args_43_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3587:2: (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==27) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3587:4: otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) )
                    	    {
                    	    otherlv_44=(Token)match(input,27,FOLLOW_27_in_ruleAtomicExpr7649); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_44, grammarAccess.getAtomicExprAccess().getCommaKeyword_7_5_0());
                    	          
                    	    }
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3591:1: ( (lv_args_45_0= ruleExpr ) )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3592:1: (lv_args_45_0= ruleExpr )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3592:1: (lv_args_45_0= ruleExpr )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3593:3: lv_args_45_0= ruleExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_7_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExpr_in_ruleAtomicExpr7670);
                    	    lv_args_45_0=ruleExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"args",
                    	              		lv_args_45_0, 
                    	              		"Expr");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop65;
                        }
                    } while (true);

                    otherlv_46=(Token)match(input,34,FOLLOW_34_in_ruleAtomicExpr7684); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_46, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_7_6());
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3614:6: ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* otherlv_54= ')' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3614:6: ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* otherlv_54= ')' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3614:7: () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* otherlv_54= ')'
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3614:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3615:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getSpecificationCallAction_8_0(),
                                  current);
                          
                    }

                    }

                    otherlv_48=(Token)match(input,77,FOLLOW_77_in_ruleAtomicExpr7713); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_48, grammarAccess.getAtomicExprAccess().getSpecKeyword_8_1());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3624:1: ( (otherlv_49= RULE_ID ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3625:1: (otherlv_49= RULE_ID )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3625:1: (otherlv_49= RULE_ID )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3626:3: otherlv_49= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_49=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExpr7733); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_49, grammarAccess.getAtomicExprAccess().getSpecSpecificationCrossReference_8_2_0()); 
                      	
                    }

                    }


                    }

                    otherlv_50=(Token)match(input,33,FOLLOW_33_in_ruleAtomicExpr7745); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_50, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_8_3());
                          
                    }
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3641:1: ( (lv_args_51_0= ruleExpr ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3642:1: (lv_args_51_0= ruleExpr )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3642:1: (lv_args_51_0= ruleExpr )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3643:3: lv_args_51_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_8_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleAtomicExpr7766);
                    lv_args_51_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		add(
                             			current, 
                             			"args",
                              		lv_args_51_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3659:2: (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==27) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3659:4: otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) )
                    	    {
                    	    otherlv_52=(Token)match(input,27,FOLLOW_27_in_ruleAtomicExpr7779); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_52, grammarAccess.getAtomicExprAccess().getCommaKeyword_8_5_0());
                    	          
                    	    }
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3663:1: ( (lv_args_53_0= ruleExpr ) )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3664:1: (lv_args_53_0= ruleExpr )
                    	    {
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3664:1: (lv_args_53_0= ruleExpr )
                    	    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3665:3: lv_args_53_0= ruleExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_8_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExpr_in_ruleAtomicExpr7800);
                    	    lv_args_53_0=ruleExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"args",
                    	              		lv_args_53_0, 
                    	              		"Expr");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop66;
                        }
                    } while (true);

                    otherlv_54=(Token)match(input,34,FOLLOW_34_in_ruleAtomicExpr7814); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_54, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_8_6());
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3686:6: (otherlv_55= '(' this_Expr_56= ruleExpr otherlv_57= ')' )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3686:6: (otherlv_55= '(' this_Expr_56= ruleExpr otherlv_57= ')' )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3686:8: otherlv_55= '(' this_Expr_56= ruleExpr otherlv_57= ')'
                    {
                    otherlv_55=(Token)match(input,33,FOLLOW_33_in_ruleAtomicExpr7834); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_55, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_9_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicExprAccess().getExprParserRuleCall_9_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleAtomicExpr7856);
                    this_Expr_56=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Expr_56; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_57=(Token)match(input,34,FOLLOW_34_in_ruleAtomicExpr7867); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_57, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_9_2());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicExpr"


    // $ANTLR start "entryRuleLiteralExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3711:1: entryRuleLiteralExpr returns [EObject current=null] : iv_ruleLiteralExpr= ruleLiteralExpr EOF ;
    public final EObject entryRuleLiteralExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3712:2: (iv_ruleLiteralExpr= ruleLiteralExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3713:2: iv_ruleLiteralExpr= ruleLiteralExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralExprRule()); 
            }
            pushFollow(FOLLOW_ruleLiteralExpr_in_entryRuleLiteralExpr7904);
            iv_ruleLiteralExpr=ruleLiteralExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralExpr7914); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralExpr"


    // $ANTLR start "ruleLiteralExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3720:1: ruleLiteralExpr returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? ) | ( () ( (lv_value_4_0= ruleBOOL ) ) ) | ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? ) ) ;
    public final EObject ruleLiteralExpr() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_value_4_0 = null;

        AntlrDatatypeRuleToken lv_value_6_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3723:28: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? ) | ( () ( (lv_value_4_0= ruleBOOL ) ) ) | ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3724:1: ( ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? ) | ( () ( (lv_value_4_0= ruleBOOL ) ) ) | ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3724:1: ( ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? ) | ( () ( (lv_value_4_0= ruleBOOL ) ) ) | ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? ) )
            int alt70=3;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_INT) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==68) ) {
                    int LA70_3 = input.LA(3);

                    if ( (LA70_3==RULE_ID) ) {
                        alt70=1;
                    }
                    else if ( (LA70_3==RULE_INT) ) {
                        alt70=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA70_1==EOF||LA70_1==RULE_ID||LA70_1==16||(LA70_1>=20 && LA70_1<=22)||LA70_1==27||(LA70_1>=31 && LA70_1<=32)||LA70_1==34||(LA70_1>=37 && LA70_1<=40)||(LA70_1>=46 && LA70_1<=62)||LA70_1==69||(LA70_1>=73 && LA70_1<=74)) ) {
                    alt70=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA70_0>=78 && LA70_0<=81)) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3724:2: ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3724:2: ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3724:3: () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )?
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3724:3: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3725:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralExprAccess().getIntLiteralAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3730:2: ( (lv_value_1_0= RULE_INT ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3731:1: (lv_value_1_0= RULE_INT )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3731:1: (lv_value_1_0= RULE_INT )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3732:3: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLiteralExpr7966); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_1_0, grammarAccess.getLiteralExprAccess().getValueINTTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getLiteralExprRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_1_0, 
                              		"INT");
                      	    
                    }

                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3748:2: ( (otherlv_2= RULE_ID ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==RULE_ID) ) {
                        int LA68_1 = input.LA(2);

                        if ( (LA68_1==EOF||LA68_1==RULE_ID||LA68_1==16||(LA68_1>=20 && LA68_1<=22)||LA68_1==27||(LA68_1>=31 && LA68_1<=32)||LA68_1==34||(LA68_1>=37 && LA68_1<=40)||(LA68_1>=46 && LA68_1<=62)||(LA68_1>=68 && LA68_1<=69)||(LA68_1>=73 && LA68_1<=74)) ) {
                            alt68=1;
                        }
                    }
                    switch (alt68) {
                        case 1 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3749:1: (otherlv_2= RULE_ID )
                            {
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3749:1: (otherlv_2= RULE_ID )
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3750:3: otherlv_2= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getLiteralExprRule());
                              	        }
                                      
                            }
                            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLiteralExpr7991); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_2, grammarAccess.getLiteralExprAccess().getUnitUnitDefCrossReference_0_2_0()); 
                              	
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3762:6: ( () ( (lv_value_4_0= ruleBOOL ) ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3762:6: ( () ( (lv_value_4_0= ruleBOOL ) ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3762:7: () ( (lv_value_4_0= ruleBOOL ) )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3762:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3763:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralExprAccess().getBoolLiteralAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3768:2: ( (lv_value_4_0= ruleBOOL ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3769:1: (lv_value_4_0= ruleBOOL )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3769:1: (lv_value_4_0= ruleBOOL )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3770:3: lv_value_4_0= ruleBOOL
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLiteralExprAccess().getValueBOOLParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBOOL_in_ruleLiteralExpr8030);
                    lv_value_4_0=ruleBOOL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLiteralExprRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_4_0, 
                              		"BOOL");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3787:6: ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3787:6: ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3787:7: () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )?
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3787:7: ()
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3788:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralExprAccess().getRealLiteralAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3793:2: ( (lv_value_6_0= ruleREAL ) )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3794:1: (lv_value_6_0= ruleREAL )
                    {
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3794:1: (lv_value_6_0= ruleREAL )
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3795:3: lv_value_6_0= ruleREAL
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLiteralExprAccess().getValueREALParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleREAL_in_ruleLiteralExpr8068);
                    lv_value_6_0=ruleREAL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLiteralExprRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_6_0, 
                              		"REAL");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3811:2: ( (otherlv_7= RULE_ID ) )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==RULE_ID) ) {
                        int LA69_1 = input.LA(2);

                        if ( (LA69_1==EOF||LA69_1==RULE_ID||LA69_1==16||(LA69_1>=20 && LA69_1<=22)||LA69_1==27||(LA69_1>=31 && LA69_1<=32)||LA69_1==34||(LA69_1>=37 && LA69_1<=40)||(LA69_1>=46 && LA69_1<=62)||(LA69_1>=68 && LA69_1<=69)||(LA69_1>=73 && LA69_1<=74)) ) {
                            alt69=1;
                        }
                    }
                    switch (alt69) {
                        case 1 :
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3812:1: (otherlv_7= RULE_ID )
                            {
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3812:1: (otherlv_7= RULE_ID )
                            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3813:3: otherlv_7= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getLiteralExprRule());
                              	        }
                                      
                            }
                            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLiteralExpr8088); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_7, grammarAccess.getLiteralExprAccess().getUnitUnitDefCrossReference_2_2_0()); 
                              	
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralExpr"


    // $ANTLR start "entryRuleRecordFieldExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3834:1: entryRuleRecordFieldExpr returns [EObject current=null] : iv_ruleRecordFieldExpr= ruleRecordFieldExpr EOF ;
    public final EObject entryRuleRecordFieldExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordFieldExpr = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3835:2: (iv_ruleRecordFieldExpr= ruleRecordFieldExpr EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3836:2: iv_ruleRecordFieldExpr= ruleRecordFieldExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecordFieldExprRule()); 
            }
            pushFollow(FOLLOW_ruleRecordFieldExpr_in_entryRuleRecordFieldExpr8128);
            iv_ruleRecordFieldExpr=ruleRecordFieldExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRecordFieldExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordFieldExpr8138); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecordFieldExpr"


    // $ANTLR start "ruleRecordFieldExpr"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3843:1: ruleRecordFieldExpr returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) ) ;
    public final EObject ruleRecordFieldExpr() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3846:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3847:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3847:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3847:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3847:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3848:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3848:1: (lv_name_0_0= RULE_ID )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3849:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRecordFieldExpr8180); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getRecordFieldExprAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRecordFieldExprRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleRecordFieldExpr8197); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRecordFieldExprAccess().getEqualsSignKeyword_1());
                  
            }
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3869:1: ( (lv_expr_2_0= ruleExpr ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3870:1: (lv_expr_2_0= ruleExpr )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3870:1: (lv_expr_2_0= ruleExpr )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3871:3: lv_expr_2_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRecordFieldExprAccess().getExprExprParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpr_in_ruleRecordFieldExpr8218);
            lv_expr_2_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRecordFieldExprRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_2_0, 
                      		"Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecordFieldExpr"


    // $ANTLR start "entryRuleBOOL"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3895:1: entryRuleBOOL returns [String current=null] : iv_ruleBOOL= ruleBOOL EOF ;
    public final String entryRuleBOOL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBOOL = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3896:2: (iv_ruleBOOL= ruleBOOL EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3897:2: iv_ruleBOOL= ruleBOOL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBOOLRule()); 
            }
            pushFollow(FOLLOW_ruleBOOL_in_entryRuleBOOL8255);
            iv_ruleBOOL=ruleBOOL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBOOL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBOOL8266); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBOOL"


    // $ANTLR start "ruleBOOL"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3904:1: ruleBOOL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE | this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE ) ;
    public final AntlrDatatypeRuleToken ruleBOOL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_BOOLEAN_TRUE_0 = null;

        AntlrDatatypeRuleToken this_BOOLEAN_FALSE_1 = null;


         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3907:28: ( (this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE | this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3908:1: (this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE | this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3908:1: (this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE | this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=78 && LA71_0<=79)) ) {
                alt71=1;
            }
            else if ( ((LA71_0>=80 && LA71_0<=81)) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3909:5: this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBOOLAccess().getBOOLEAN_TRUEParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBOOLEAN_TRUE_in_ruleBOOL8313);
                    this_BOOLEAN_TRUE_0=ruleBOOLEAN_TRUE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BOOLEAN_TRUE_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3921:5: this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBOOLAccess().getBOOLEAN_FALSEParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBOOLEAN_FALSE_in_ruleBOOL8346);
                    this_BOOLEAN_FALSE_1=ruleBOOLEAN_FALSE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BOOLEAN_FALSE_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBOOL"


    // $ANTLR start "entryRuleBOOLEAN_TRUE"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3939:1: entryRuleBOOLEAN_TRUE returns [String current=null] : iv_ruleBOOLEAN_TRUE= ruleBOOLEAN_TRUE EOF ;
    public final String entryRuleBOOLEAN_TRUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBOOLEAN_TRUE = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3940:2: (iv_ruleBOOLEAN_TRUE= ruleBOOLEAN_TRUE EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3941:2: iv_ruleBOOLEAN_TRUE= ruleBOOLEAN_TRUE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBOOLEAN_TRUERule()); 
            }
            pushFollow(FOLLOW_ruleBOOLEAN_TRUE_in_entryRuleBOOLEAN_TRUE8392);
            iv_ruleBOOLEAN_TRUE=ruleBOOLEAN_TRUE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBOOLEAN_TRUE.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBOOLEAN_TRUE8403); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBOOLEAN_TRUE"


    // $ANTLR start "ruleBOOLEAN_TRUE"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3948:1: ruleBOOLEAN_TRUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'TRUE' | kw= 'true' ) ;
    public final AntlrDatatypeRuleToken ruleBOOLEAN_TRUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3951:28: ( (kw= 'TRUE' | kw= 'true' ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3952:1: (kw= 'TRUE' | kw= 'true' )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3952:1: (kw= 'TRUE' | kw= 'true' )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==78) ) {
                alt72=1;
            }
            else if ( (LA72_0==79) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3953:2: kw= 'TRUE'
                    {
                    kw=(Token)match(input,78,FOLLOW_78_in_ruleBOOLEAN_TRUE8441); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBOOLEAN_TRUEAccess().getTRUEKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3960:2: kw= 'true'
                    {
                    kw=(Token)match(input,79,FOLLOW_79_in_ruleBOOLEAN_TRUE8460); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBOOLEAN_TRUEAccess().getTrueKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBOOLEAN_TRUE"


    // $ANTLR start "entryRuleBOOLEAN_FALSE"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3973:1: entryRuleBOOLEAN_FALSE returns [String current=null] : iv_ruleBOOLEAN_FALSE= ruleBOOLEAN_FALSE EOF ;
    public final String entryRuleBOOLEAN_FALSE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBOOLEAN_FALSE = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3974:2: (iv_ruleBOOLEAN_FALSE= ruleBOOLEAN_FALSE EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3975:2: iv_ruleBOOLEAN_FALSE= ruleBOOLEAN_FALSE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBOOLEAN_FALSERule()); 
            }
            pushFollow(FOLLOW_ruleBOOLEAN_FALSE_in_entryRuleBOOLEAN_FALSE8501);
            iv_ruleBOOLEAN_FALSE=ruleBOOLEAN_FALSE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBOOLEAN_FALSE.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBOOLEAN_FALSE8512); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBOOLEAN_FALSE"


    // $ANTLR start "ruleBOOLEAN_FALSE"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3982:1: ruleBOOLEAN_FALSE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'FALSE' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBOOLEAN_FALSE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3985:28: ( (kw= 'FALSE' | kw= 'false' ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3986:1: (kw= 'FALSE' | kw= 'false' )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3986:1: (kw= 'FALSE' | kw= 'false' )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==80) ) {
                alt73=1;
            }
            else if ( (LA73_0==81) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3987:2: kw= 'FALSE'
                    {
                    kw=(Token)match(input,80,FOLLOW_80_in_ruleBOOLEAN_FALSE8550); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBOOLEAN_FALSEAccess().getFALSEKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3994:2: kw= 'false'
                    {
                    kw=(Token)match(input,81,FOLLOW_81_in_ruleBOOLEAN_FALSE8569); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBOOLEAN_FALSEAccess().getFalseKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBOOLEAN_FALSE"


    // $ANTLR start "entryRuleREAL"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:4007:1: entryRuleREAL returns [String current=null] : iv_ruleREAL= ruleREAL EOF ;
    public final String entryRuleREAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL = null;


        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:4008:2: (iv_ruleREAL= ruleREAL EOF )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:4009:2: iv_ruleREAL= ruleREAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getREALRule()); 
            }
            pushFollow(FOLLOW_ruleREAL_in_entryRuleREAL8610);
            iv_ruleREAL=ruleREAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleREAL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleREAL8621); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleREAL"


    // $ANTLR start "ruleREAL"
    // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:4016:1: ruleREAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleREAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:4019:28: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:4020:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:4020:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:4020:6: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL8661); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getREALAccess().getINTTerminalRuleCall_0()); 
                  
            }
            kw=(Token)match(input,68,FOLLOW_68_in_ruleREAL8679); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getREALAccess().getFullStopKeyword_1()); 
                  
            }
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL8694); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_2, grammarAccess.getREALAccess().getINTTerminalRuleCall_2()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleREAL"

    // $ANTLR start synpred1_InternalSpear
    public final void synpred1_InternalSpear_fragment() throws RecognitionException {   
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:970:3: ( ( () ( ( '*' ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:970:4: ( () ( ( '*' ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:970:4: ( () ( ( '*' ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:970:5: () ( ( '*' ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:970:5: ()
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:971:1: 
        {
        }

        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:971:2: ( ( '*' ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:972:1: ( '*' )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:972:1: ( '*' )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:973:2: '*'
        {
        match(input,31,FOLLOW_31_in_synpred1_InternalSpear1872); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalSpear

    // $ANTLR start synpred2_InternalSpear
    public final void synpred2_InternalSpear_fragment() throws RecognitionException {   
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1046:3: ( ( () ( ( '/' ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1046:4: ( () ( ( '/' ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1046:4: ( () ( ( '/' ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1046:5: () ( ( '/' ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1046:5: ()
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1047:1: 
        {
        }

        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1047:2: ( ( '/' ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1048:1: ( '/' )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1048:1: ( '/' )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:1049:2: '/'
        {
        match(input,32,FOLLOW_32_in_synpred2_InternalSpear2054); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalSpear

    // $ANTLR start synpred3_InternalSpear
    public final void synpred3_InternalSpear_fragment() throws RecognitionException {   
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2092:3: ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2092:4: ( () ( ( ( '=>' | 'implies' ) ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2092:4: ( () ( ( ( '=>' | 'implies' ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2092:5: () ( ( ( '=>' | 'implies' ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2092:5: ()
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2093:1: 
        {
        }

        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2093:2: ( ( ( '=>' | 'implies' ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2094:1: ( ( '=>' | 'implies' ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2094:1: ( ( '=>' | 'implies' ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2095:1: ( '=>' | 'implies' )
        {
        if ( (input.LA(1)>=46 && input.LA(1)<=47) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalSpear

    // $ANTLR start synpred4_InternalSpear
    public final void synpred4_InternalSpear_fragment() throws RecognitionException {   
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2189:3: ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2189:4: ( () ( ( ( 'or' | 'xor' ) ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2189:4: ( () ( ( ( 'or' | 'xor' ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2189:5: () ( ( ( 'or' | 'xor' ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2189:5: ()
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2190:1: 
        {
        }

        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2190:2: ( ( ( 'or' | 'xor' ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2191:1: ( ( 'or' | 'xor' ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2191:1: ( ( 'or' | 'xor' ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2192:1: ( 'or' | 'xor' )
        {
        if ( (input.LA(1)>=48 && input.LA(1)<=49) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalSpear

    // $ANTLR start synpred5_InternalSpear
    public final void synpred5_InternalSpear_fragment() throws RecognitionException {   
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2286:3: ( ( () ( ( 'and' ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2286:4: ( () ( ( 'and' ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2286:4: ( () ( ( 'and' ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2286:5: () ( ( 'and' ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2286:5: ()
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2287:1: 
        {
        }

        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2287:2: ( ( 'and' ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2288:1: ( 'and' )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2288:1: ( 'and' )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2289:2: 'and'
        {
        match(input,50,FOLLOW_50_in_synpred5_InternalSpear4757); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalSpear

    // $ANTLR start synpred6_InternalSpear
    public final void synpred6_InternalSpear_fragment() throws RecognitionException {   
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2362:3: ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2362:4: ( () ( ( ( 'T' | 'triggers' ) ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2362:4: ( () ( ( ( 'T' | 'triggers' ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2362:5: () ( ( ( 'T' | 'triggers' ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2362:5: ()
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2363:1: 
        {
        }

        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2363:2: ( ( ( 'T' | 'triggers' ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2364:1: ( ( 'T' | 'triggers' ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2364:1: ( ( 'T' | 'triggers' ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2365:1: ( 'T' | 'triggers' )
        {
        if ( (input.LA(1)>=51 && input.LA(1)<=52) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalSpear

    // $ANTLR start synpred7_InternalSpear
    public final void synpred7_InternalSpear_fragment() throws RecognitionException {   
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2459:3: ( ( () ( ( ( 'S' | 'since' ) ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2459:4: ( () ( ( ( 'S' | 'since' ) ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2459:4: ( () ( ( ( 'S' | 'since' ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2459:5: () ( ( ( 'S' | 'since' ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2459:5: ()
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2460:1: 
        {
        }

        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2460:2: ( ( ( 'S' | 'since' ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2461:1: ( ( 'S' | 'since' ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2461:1: ( ( 'S' | 'since' ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2462:1: ( 'S' | 'since' )
        {
        if ( (input.LA(1)>=53 && input.LA(1)<=54) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalSpear

    // $ANTLR start synpred8_InternalSpear
    public final void synpred8_InternalSpear_fragment() throws RecognitionException {   
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2556:3: ( ( () ( ( ruleRelationalOp ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2556:4: ( () ( ( ruleRelationalOp ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2556:4: ( () ( ( ruleRelationalOp ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2556:5: () ( ( ruleRelationalOp ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2556:5: ()
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2557:1: 
        {
        }

        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2557:2: ( ( ruleRelationalOp ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2558:1: ( ruleRelationalOp )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2558:1: ( ruleRelationalOp )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2559:1: ruleRelationalOp
        {
        pushFollow(FOLLOW_ruleRelationalOp_in_synpred8_InternalSpear5408);
        ruleRelationalOp();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalSpear

    // $ANTLR start synpred9_InternalSpear
    public final void synpred9_InternalSpear_fragment() throws RecognitionException {   
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2695:3: ( ( () ( ( ( '+' | '-' ) ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2695:4: ( () ( ( ( '+' | '-' ) ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2695:4: ( () ( ( ( '+' | '-' ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2695:5: () ( ( ( '+' | '-' ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2695:5: ()
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2696:1: 
        {
        }

        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2696:2: ( ( ( '+' | '-' ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2697:1: ( ( '+' | '-' ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2697:1: ( ( '+' | '-' ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2698:1: ( '+' | '-' )
        {
        if ( (input.LA(1)>=61 && input.LA(1)<=62) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalSpear

    // $ANTLR start synpred10_InternalSpear
    public final void synpred10_InternalSpear_fragment() throws RecognitionException {   
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2792:3: ( ( () ( ( ( '*' | '/' ) ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2792:4: ( () ( ( ( '*' | '/' ) ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2792:4: ( () ( ( ( '*' | '/' ) ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2792:5: () ( ( ( '*' | '/' ) ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2792:5: ()
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2793:1: 
        {
        }

        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2793:2: ( ( ( '*' | '/' ) ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2794:1: ( ( '*' | '/' ) )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2794:1: ( ( '*' | '/' ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:2795:1: ( '*' | '/' )
        {
        if ( (input.LA(1)>=31 && input.LA(1)<=32) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred10_InternalSpear

    // $ANTLR start synpred11_InternalSpear
    public final void synpred11_InternalSpear_fragment() throws RecognitionException {   
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3022:4: ( ( () '.' ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3022:5: ( () '.' )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3022:5: ( () '.' )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3022:6: () '.'
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3022:6: ()
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3023:1: 
        {
        }

        match(input,68,FOLLOW_68_in_synpred11_InternalSpear6539); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalSpear

    // $ANTLR start synpred12_InternalSpear
    public final void synpred12_InternalSpear_fragment() throws RecognitionException {   
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3048:8: ( ( () '{' ( ( RULE_ID ) ) ':=' ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3048:9: ( () '{' ( ( RULE_ID ) ) ':=' )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3048:9: ( () '{' ( ( RULE_ID ) ) ':=' )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3048:10: () '{' ( ( RULE_ID ) ) ':='
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3048:10: ()
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3049:1: 
        {
        }

        match(input,37,FOLLOW_37_in_synpred12_InternalSpear6604); if (state.failed) return ;
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3050:1: ( ( RULE_ID ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3051:1: ( RULE_ID )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3051:1: ( RULE_ID )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3052:2: RULE_ID
        {
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred12_InternalSpear6612); if (state.failed) return ;

        }


        }

        match(input,69,FOLLOW_69_in_synpred12_InternalSpear6619); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_InternalSpear

    // $ANTLR start synpred13_InternalSpear
    public final void synpred13_InternalSpear_fragment() throws RecognitionException {   
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3106:8: ( ( () '[' ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3106:9: ( () '[' )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3106:9: ( () '[' )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3106:10: () '['
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3106:10: ()
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3107:1: 
        {
        }

        match(input,39,FOLLOW_39_in_synpred13_InternalSpear6729); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalSpear

    // $ANTLR start synpred14_InternalSpear
    public final void synpred14_InternalSpear_fragment() throws RecognitionException {   
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3136:4: ( ( () ':=' ) )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3136:5: ( () ':=' )
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3136:5: ( () ':=' )
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3136:6: () ':='
        {
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3136:6: ()
        // ../com.rockwellcollins.spear/src-gen/com/rockwellcollins/parser/antlr/internal/InternalSpear.g:3137:1: 
        {
        }

        match(input,69,FOLLOW_69_in_synpred14_InternalSpear6788); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalSpear

    // Delegated rules

    public final boolean synpred2_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA39 dfa39 = new DFA39(this);
    protected DFA67 dfa67 = new DFA67(this);
    static final String DFA39_eotS =
        "\13\uffff";
    static final String DFA39_eofS =
        "\5\uffff\4\11\2\uffff";
    static final String DFA39_minS =
        "\1\4\1\43\1\4\2\uffff\4\4\2\uffff";
    static final String DFA39_maxS =
        "\1\4\1\43\1\54\2\uffff\4\47\2\uffff";
    static final String DFA39_acceptS =
        "\3\uffff\1\2\1\4\4\uffff\1\1\1\3";
    static final String DFA39_specialS =
        "\13\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\1",
            "\1\2",
            "\1\10\37\uffff\1\3\4\uffff\1\4\1\5\1\6\1\7",
            "",
            "",
            "\1\11\12\uffff\2\11\26\uffff\1\12",
            "\1\11\12\uffff\2\11\26\uffff\1\12",
            "\1\11\12\uffff\2\11\26\uffff\1\12",
            "\1\11\12\uffff\2\11\26\uffff\1\12",
            "",
            ""
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "1171:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '=' otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleRecordTypeField ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleRecordTypeField ) ) )* otherlv_13= '}' ) | ( () ( (lv_name_15_0= RULE_ID ) ) otherlv_16= '=' ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']' ) | ( () ( (lv_name_22_0= RULE_ID ) ) otherlv_23= '=' otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}' ) )";
        }
    }
    static final String DFA67_eotS =
        "\15\uffff";
    static final String DFA67_eofS =
        "\15\uffff";
    static final String DFA67_minS =
        "\1\4\5\uffff\1\4\3\uffff\1\45\2\uffff";
    static final String DFA67_maxS =
        "\1\121\5\uffff\1\4\3\uffff\1\47\2\uffff";
    static final String DFA67_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\12\1\uffff\1\6"+
        "\1\7";
    static final String DFA67_specialS =
        "\15\uffff}>";
    static final String[] DFA67_transitionS = {
            "\1\2\1\uffff\1\1\32\uffff\1\11\44\uffff\1\3\1\4\1\5\2\uffff"+
            "\1\6\1\7\1\10\4\1",
            "",
            "",
            "",
            "",
            "",
            "\1\12",
            "",
            "",
            "",
            "\1\13\1\uffff\1\14",
            "",
            ""
    };

    static final short[] DFA67_eot = DFA.unpackEncodedString(DFA67_eotS);
    static final short[] DFA67_eof = DFA.unpackEncodedString(DFA67_eofS);
    static final char[] DFA67_min = DFA.unpackEncodedStringToUnsignedChars(DFA67_minS);
    static final char[] DFA67_max = DFA.unpackEncodedStringToUnsignedChars(DFA67_maxS);
    static final short[] DFA67_accept = DFA.unpackEncodedString(DFA67_acceptS);
    static final short[] DFA67_special = DFA.unpackEncodedString(DFA67_specialS);
    static final short[][] DFA67_transition;

    static {
        int numStates = DFA67_transitionS.length;
        DFA67_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA67_transition[i] = DFA.unpackEncodedString(DFA67_transitionS[i]);
        }
    }

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = DFA67_eot;
            this.eof = DFA67_eof;
            this.min = DFA67_min;
            this.max = DFA67_max;
            this.accept = DFA67_accept;
            this.special = DFA67_special;
            this.transition = DFA67_transition;
        }
        public String getDescription() {
            return "3191:1: (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'prev' otherlv_11= '(' ( (lv_var_12_0= ruleExpr ) ) otherlv_13= ',' ( (lv_init_14_0= ruleExpr ) ) otherlv_15= ')' ) | ( () otherlv_17= 'if' ( (lv_cond_18_0= ruleExpr ) ) otherlv_19= 'then' ( (lv_then_20_0= ruleExpr ) ) otherlv_21= 'else' ( (lv_else_22_0= ruleExpr ) ) ) | ( () otherlv_24= 'new' ( (otherlv_25= RULE_ID ) ) otherlv_26= '{' ( (lv_fieldExprs_27_0= ruleRecordFieldExpr ) ) (otherlv_28= ',' ( (lv_fieldExprs_29_0= ruleRecordFieldExpr ) ) )* otherlv_30= '}' ) | ( () otherlv_32= 'new' ( (otherlv_33= RULE_ID ) ) otherlv_34= '[' ( (lv_exprs_35_0= ruleExpr ) ) (otherlv_36= ',' ( (lv_exprs_37_0= ruleExpr ) ) )* otherlv_38= ']' ) | ( () otherlv_40= 'pattern' ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* otherlv_54= ')' ) | (otherlv_55= '(' this_Expr_56= ruleExpr otherlv_57= ')' ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecification_in_ruleFile132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinitions_in_ruleFile159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePatterns_in_ruleFile186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecification_in_entryRuleSpecification221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpecification231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleSpecification268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpecification285 = new BitSet(new long[]{0x000000000001F000L});
    public static final BitSet FOLLOW_12_in_ruleSpecification303 = new BitSet(new long[]{0x000000000081E000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleSpecification324 = new BitSet(new long[]{0x000000000081E000L});
    public static final BitSet FOLLOW_13_in_ruleSpecification340 = new BitSet(new long[]{0x000000000001C010L});
    public static final BitSet FOLLOW_ruleUnitDef_in_ruleSpecification361 = new BitSet(new long[]{0x000000000001C010L});
    public static final BitSet FOLLOW_14_in_ruleSpecification377 = new BitSet(new long[]{0x0000000000018010L});
    public static final BitSet FOLLOW_ruleTypeDef_in_ruleSpecification398 = new BitSet(new long[]{0x0000000000018010L});
    public static final BitSet FOLLOW_15_in_ruleSpecification414 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleSpecification435 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_16_in_ruleSpecification450 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleSpecification471 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_17_in_ruleSpecification484 = new BitSet(new long[]{0x00000000003C0010L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleSpecification505 = new BitSet(new long[]{0x00000000003C0010L});
    public static final BitSet FOLLOW_18_in_ruleSpecification519 = new BitSet(new long[]{0x0000000000380010L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleSpecification540 = new BitSet(new long[]{0x0000000000380010L});
    public static final BitSet FOLLOW_19_in_ruleSpecification556 = new BitSet(new long[]{0x0000000000300010L});
    public static final BitSet FOLLOW_ruleMacro_in_ruleSpecification577 = new BitSet(new long[]{0x0000000000300010L});
    public static final BitSet FOLLOW_20_in_ruleSpecification593 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_ruleConstraint_in_ruleSpecification614 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_ruleSpecification629 = new BitSet(new long[]{0x0000000000400012L});
    public static final BitSet FOLLOW_ruleConstraint_in_ruleSpecification650 = new BitSet(new long[]{0x0000000000400012L});
    public static final BitSet FOLLOW_22_in_ruleSpecification664 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleConstraint_in_ruleSpecification685 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleImport771 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinitions_in_entryRuleDefinitions829 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinitions839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleDefinitions876 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinitions893 = new BitSet(new long[]{0x000000000000E002L});
    public static final BitSet FOLLOW_13_in_ruleDefinitions911 = new BitSet(new long[]{0x000000000000C012L});
    public static final BitSet FOLLOW_ruleUnitDef_in_ruleDefinitions932 = new BitSet(new long[]{0x000000000000C012L});
    public static final BitSet FOLLOW_14_in_ruleDefinitions948 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_ruleTypeDef_in_ruleDefinitions969 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_ruleDefinitions985 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleDefinitions1006 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rulePatterns_in_entryRulePatterns1045 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePatterns1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rulePatterns1092 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePatterns1109 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rulePattern_in_rulePatterns1135 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rulePattern_in_entryRulePattern1172 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePattern1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rulePattern1219 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePattern1236 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulePattern1253 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVariable_in_rulePattern1274 = new BitSet(new long[]{0x0000000008020000L});
    public static final BitSet FOLLOW_27_in_rulePattern1287 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVariable_in_rulePattern1308 = new BitSet(new long[]{0x0000000008020000L});
    public static final BitSet FOLLOW_17_in_rulePattern1322 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVariable_in_rulePattern1343 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_rulePattern1356 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVariable_in_rulePattern1377 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_rulePattern1391 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePattern1408 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rulePattern1425 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePattern1442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitDef_in_entryRuleUnitDef1483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitDef1493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnitDef1545 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleUnitDef1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnitDef1607 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleUnitDef1624 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_ruleUnitExpr_in_ruleUnitDef1645 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleUnitDef1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpr_in_entryRuleUnitExpr1705 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpr1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProductUnitExpr_in_ruleUnitExpr1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProductUnitExpr_in_entryRuleProductUnitExpr1795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProductUnitExpr1805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivisionUnitExpr_in_ruleProductUnitExpr1852 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleProductUnitExpr1903 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_ruleProductUnitExpr_in_ruleProductUnitExpr1939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivisionUnitExpr_in_entryRuleDivisionUnitExpr1977 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDivisionUnitExpr1987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicUnitExpr_in_ruleDivisionUnitExpr2034 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleDivisionUnitExpr2085 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_ruleAtomicUnitExpr_in_ruleDivisionUnitExpr2121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicUnitExpr_in_entryRuleAtomicUnitExpr2159 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomicUnitExpr2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicUnitExpr2224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleAtomicUnitExpr2244 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_ruleUnitExpr_in_ruleAtomicUnitExpr2266 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAtomicUnitExpr2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDef_in_entryRuleTypeDef2314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDef2324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeDef2376 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleTypeDef2393 = new BitSet(new long[]{0x00001C0000000010L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeDef2414 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeDef2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeDef2469 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleTypeDef2486 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleTypeDef2498 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleTypeDef2510 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRecordTypeField_in_ruleTypeDef2531 = new BitSet(new long[]{0x0000004008000000L});
    public static final BitSet FOLLOW_27_in_ruleTypeDef2544 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRecordTypeField_in_ruleTypeDef2565 = new BitSet(new long[]{0x0000004008000000L});
    public static final BitSet FOLLOW_38_in_ruleTypeDef2579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeDef2613 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleTypeDef2630 = new BitSet(new long[]{0x00001C0000000010L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeDef2651 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleTypeDef2663 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTypeDef2680 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleTypeDef2697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeDef2731 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleTypeDef2748 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleTypeDef2760 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleTypeDef2772 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumValue_in_ruleTypeDef2793 = new BitSet(new long[]{0x0000004008000000L});
    public static final BitSet FOLLOW_27_in_ruleTypeDef2806 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumValue_in_ruleTypeDef2827 = new BitSet(new long[]{0x0000004008000000L});
    public static final BitSet FOLLOW_38_in_ruleTypeDef2841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordTypeField_in_entryRuleRecordTypeField2878 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordTypeField2888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRecordTypeField2930 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleRecordTypeField2947 = new BitSet(new long[]{0x00001C0000000010L});
    public static final BitSet FOLLOW_ruleType_in_ruleRecordTypeField2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_entryRuleEnumValue3004 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumValue3014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumValue3055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType3095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType3105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleType3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleType3181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleType3210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType3247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant3284 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant3294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConstant3336 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleConstant3353 = new BitSet(new long[]{0x00001C0000000010L});
    public static final BitSet FOLLOW_ruleType_in_ruleConstant3374 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleConstant3386 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleConstant3407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable3443 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable3453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariable3495 = new BitSet(new long[]{0x0000200040000000L});
    public static final BitSet FOLLOW_30_in_ruleVariable3513 = new BitSet(new long[]{0x00001C0000000010L});
    public static final BitSet FOLLOW_45_in_ruleVariable3531 = new BitSet(new long[]{0x00001C0000000010L});
    public static final BitSet FOLLOW_ruleType_in_ruleVariable3553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_entryRuleMacro3589 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacro3599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMacro3641 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleMacro3658 = new BitSet(new long[]{0x00001C0000000010L});
    public static final BitSet FOLLOW_ruleType_in_ruleMacro3679 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleMacro3691 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleMacro3712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_entryRuleConstraint3748 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraint3758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormalConstraint_in_ruleConstraint3805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnglishConstraint_in_ruleConstraint3832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormalConstraint_in_entryRuleFormalConstraint3867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormalConstraint3877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFormalConstraint3919 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleFormalConstraint3936 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleFormalConstraint3957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnglishConstraint_in_entryRuleEnglishConstraint3993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnglishConstraint4003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnglishConstraint4045 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleEnglishConstraint4062 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEnglishConstraint4079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_entryRuleExpr4120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpr4130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImpliesExpr_in_ruleExpr4176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImpliesExpr_in_entryRuleImpliesExpr4210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImpliesExpr4220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpr_in_ruleImpliesExpr4267 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_46_in_ruleImpliesExpr4339 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_47_in_ruleImpliesExpr4368 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleImpliesExpr_in_ruleImpliesExpr4407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpr_in_entryRuleOrExpr4445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrExpr4455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpr_in_ruleOrExpr4502 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_48_in_ruleOrExpr4574 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_49_in_ruleOrExpr4603 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleImpliesExpr_in_ruleOrExpr4642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpr_in_entryRuleAndExpr4680 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpr4690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggersExpr_in_ruleAndExpr4737 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_ruleAndExpr4788 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleAndExpr_in_ruleAndExpr4824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggersExpr_in_entryRuleTriggersExpr4862 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggersExpr4872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSinceExpr_in_ruleTriggersExpr4919 = new BitSet(new long[]{0x0018000000000002L});
    public static final BitSet FOLLOW_51_in_ruleTriggersExpr4991 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_52_in_ruleTriggersExpr5020 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleTriggersExpr_in_ruleTriggersExpr5059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSinceExpr_in_entryRuleSinceExpr5097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSinceExpr5107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpr_in_ruleSinceExpr5154 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_53_in_ruleSinceExpr5226 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_54_in_ruleSinceExpr5255 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleSinceExpr_in_ruleSinceExpr5294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpr_in_entryRuleRelationalExpr5332 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpr5342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlusExpr_in_ruleRelationalExpr5389 = new BitSet(new long[]{0x1F80000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOp_in_ruleRelationalExpr5438 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleRelationalExpr_in_ruleRelationalExpr5461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOp_in_entryRuleRelationalOp5500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOp5511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleRelationalOp5549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleRelationalOp5568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleRelationalOp5587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleRelationalOp5606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleRelationalOp5625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleRelationalOp5644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlusExpr_in_entryRulePlusExpr5684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlusExpr5694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplyExpr_in_rulePlusExpr5741 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_61_in_rulePlusExpr5813 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_62_in_rulePlusExpr5842 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_rulePlusExpr_in_rulePlusExpr5881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplyExpr_in_entryRuleMultiplyExpr5919 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplyExpr5929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixExpr_in_ruleMultiplyExpr5976 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_31_in_ruleMultiplyExpr6048 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_32_in_ruleMultiplyExpr6077 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleMultiplyExpr_in_ruleMultiplyExpr6116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixExpr_in_entryRulePrefixExpr6154 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrefixExpr6164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_rulePrefixExpr6219 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_63_in_rulePrefixExpr6248 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_64_in_rulePrefixExpr6277 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_65_in_rulePrefixExpr6306 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_66_in_rulePrefixExpr6335 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_67_in_rulePrefixExpr6364 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_rulePrefixExpr_in_rulePrefixExpr6401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAccessExpr_in_rulePrefixExpr6430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAccessExpr_in_entryRuleAccessExpr6465 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAccessExpr6475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExpr_in_ruleAccessExpr6522 = new BitSet(new long[]{0x000000A000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleAccessExpr6558 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAccessExpr6580 = new BitSet(new long[]{0x000000A000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_37_in_ruleAccessExpr6638 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAccessExpr6658 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleAccessExpr6670 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAccessExpr6693 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleAccessExpr6705 = new BitSet(new long[]{0x000000A000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_39_in_ruleAccessExpr6748 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAccessExpr6771 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleAccessExpr6807 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAccessExpr6830 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleAccessExpr6844 = new BitSet(new long[]{0x000000A000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAtomicExpr_in_entryRuleAtomicExpr6883 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomicExpr6893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpr_in_ruleAtomicExpr6940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExpr6975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleAtomicExpr7004 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExpr7024 = new BitSet(new long[]{0x0000000008000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_27_in_ruleAtomicExpr7037 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExpr7057 = new BitSet(new long[]{0x0000000008000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleAtomicExpr7071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleAtomicExpr7100 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAtomicExpr7112 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAtomicExpr7133 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleAtomicExpr7145 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAtomicExpr7166 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAtomicExpr7178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleAtomicExpr7207 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAtomicExpr7228 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_ruleAtomicExpr7240 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAtomicExpr7261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_ruleAtomicExpr7273 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAtomicExpr7294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleAtomicExpr7323 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExpr7343 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleAtomicExpr7355 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRecordFieldExpr_in_ruleAtomicExpr7376 = new BitSet(new long[]{0x0000004008000000L});
    public static final BitSet FOLLOW_27_in_ruleAtomicExpr7389 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRecordFieldExpr_in_ruleAtomicExpr7410 = new BitSet(new long[]{0x0000004008000000L});
    public static final BitSet FOLLOW_38_in_ruleAtomicExpr7424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleAtomicExpr7453 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExpr7473 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleAtomicExpr7485 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAtomicExpr7506 = new BitSet(new long[]{0x0000010008000000L});
    public static final BitSet FOLLOW_27_in_ruleAtomicExpr7519 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAtomicExpr7540 = new BitSet(new long[]{0x0000010008000000L});
    public static final BitSet FOLLOW_40_in_ruleAtomicExpr7554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleAtomicExpr7583 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExpr7603 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAtomicExpr7615 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAtomicExpr7636 = new BitSet(new long[]{0x0000000408000000L});
    public static final BitSet FOLLOW_27_in_ruleAtomicExpr7649 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAtomicExpr7670 = new BitSet(new long[]{0x0000000408000000L});
    public static final BitSet FOLLOW_34_in_ruleAtomicExpr7684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleAtomicExpr7713 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExpr7733 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAtomicExpr7745 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAtomicExpr7766 = new BitSet(new long[]{0x0000000408000000L});
    public static final BitSet FOLLOW_27_in_ruleAtomicExpr7779 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAtomicExpr7800 = new BitSet(new long[]{0x0000000408000000L});
    public static final BitSet FOLLOW_34_in_ruleAtomicExpr7814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleAtomicExpr7834 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAtomicExpr7856 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAtomicExpr7867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpr_in_entryRuleLiteralExpr7904 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralExpr7914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLiteralExpr7966 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLiteralExpr7991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBOOL_in_ruleLiteralExpr8030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_ruleLiteralExpr8068 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLiteralExpr8088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordFieldExpr_in_entryRuleRecordFieldExpr8128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordFieldExpr8138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRecordFieldExpr8180 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleRecordFieldExpr8197 = new BitSet(new long[]{0xC000000200000050L,0x000000000003F9CFL});
    public static final BitSet FOLLOW_ruleExpr_in_ruleRecordFieldExpr8218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBOOL_in_entryRuleBOOL8255 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBOOL8266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBOOLEAN_TRUE_in_ruleBOOL8313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBOOLEAN_FALSE_in_ruleBOOL8346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBOOLEAN_TRUE_in_entryRuleBOOLEAN_TRUE8392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBOOLEAN_TRUE8403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleBOOLEAN_TRUE8441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleBOOLEAN_TRUE8460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBOOLEAN_FALSE_in_entryRuleBOOLEAN_FALSE8501 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBOOLEAN_FALSE8512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleBOOLEAN_FALSE8550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleBOOLEAN_FALSE8569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_entryRuleREAL8610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleREAL8621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL8661 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleREAL8679 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL8694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_synpred1_InternalSpear1872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_synpred2_InternalSpear2054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred3_InternalSpear4286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred4_InternalSpear4521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred5_InternalSpear4757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred6_InternalSpear4938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred7_InternalSpear5173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOp_in_synpred8_InternalSpear5408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred9_InternalSpear5760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred10_InternalSpear5995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_synpred11_InternalSpear6539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_synpred12_InternalSpear6604 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred12_InternalSpear6612 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_synpred12_InternalSpear6619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred13_InternalSpear6729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_synpred14_InternalSpear6788 = new BitSet(new long[]{0x0000000000000002L});

}