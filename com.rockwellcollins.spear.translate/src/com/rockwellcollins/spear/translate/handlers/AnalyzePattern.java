package com.rockwellcollins.spear.translate.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;

import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.translate.lustre.PLTL;
import com.rockwellcollins.spear.translate.master.SConstant;
import com.rockwellcollins.spear.translate.master.SPattern;
import com.rockwellcollins.spear.translate.master.STypeDef;
import com.rockwellcollins.spear.translate.naming.NameMap;
import com.rockwellcollins.spear.ui.preferences.PreferencesUtil;

import jkind.api.JKindApi;
import jkind.api.results.JKindResult;
import jkind.lustre.Program;
import jkind.lustre.builders.ProgramBuilder;
import jkind.results.layout.Layout;
import jkind.results.layout.NodeLayout;

public class AnalyzePattern extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor();
		TextSelection ts = (TextSelection) xtextEditor.getSelectionProvider().getSelection();

		xtextEditor.getDocument().readOnly(resource -> {
			EObject e = new EObjectAtOffsetHelper().resolveContainedElementAt(resource, ts.getOffset());
			
			Pattern p = EcoreUtil2.getContainerOfType(e, Pattern.class);
			if(p == null) {
				System.out.println("No patterns found");
				return null;
			}
			
			analyzePattern(p);
			return null;
		});
		return null;
	}

	private void analyzePattern(Pattern p) {
		NameMap map = new NameMap();
		
		//need to handle typedefs and constants yet
		PatternDeps deps = new PatternDeps(p);
		
		List<STypeDef> typedefs = STypeDef.build(deps.getTypeDefs(), map);
		List<SConstant> constants = SConstant.build(deps.getConstants(), map);
		List<SPattern> spatterns = SPattern.build(deps.getPatterns(), map);
		
		ProgramBuilder programBuilder = new ProgramBuilder();
		programBuilder.addTypes(STypeDef.toLustre(typedefs, map));
		programBuilder.addConstants(SConstant.toLustre(constants, map));
		programBuilder.addNodes(PLTL.getPLTL());
		programBuilder.addNodes(SPattern.toLustre(spatterns, map));
		
		String mainName = map.lookup(p);
		programBuilder.setMain(mainName);

		Program program = programBuilder.build();
		
		JKindApi api = (JKindApi) PreferencesUtil.getKindApi();
		JKindResult result = new JKindResult("result");
		for(String prop : program.getMainNode().properties) {
			result.addProperty(prop,true);
		}
		IProgressMonitor monitor = new NullProgressMonitor();
		showView(result, new NodeLayout(program.getMainNode()));
		
		try {
			api.execute(program, result, monitor);
		} catch (Exception e) {
			System.out.println(result.getText());
			throw e;
		}
	}
	
	//it would be better if this was in a window or even a pop-up;
	private void showView(final JKindResult result, final Layout layout) {
		System.out.println(result.getText());
	}
}
