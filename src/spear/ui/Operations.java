package spear.ui;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.EcoreUtil2;

import jkind.JKindException;
import jkind.api.JKindApi;
import jkind.api.results.JKindResult;
import jkind.api.results.MapRenaming;
import jkind.api.results.MapRenaming.Mode;
import jkind.api.results.Renaming;
import spear.language.CallRef;
import spear.language.FnCallExpr;
import spear.language.NamedFormula;
import spear.language.Procedure;
import spear.language.ReqSection;
import spear.language.Section;
import spear.language.SectionElement;
import spear.language.Utils;
import spear.translator.LibraryReader;
import spear.translator.MonolithicLustreTranslator;
import spear.translator.NameGenerator;
import spear.translator.Translator;
import spear.ui.preferences.PreferencesUtil;
import spear.views.JKindResultsView;

public class Operations {
	private final static String seperator = System.getProperty("line.separator");
	
	public static void buildProcedureRanking(Procedure p, Map<Procedure,Integer> memo) {
		if(memo.containsKey(p)) { return; }
		Integer maxRank = 0;
		for(FnCallExpr f : Utils.getAllContentsOfType(EcoreUtil2.getContainerOfType(p,Procedure.class),FnCallExpr.class))
		{
			CallRef cr = f.getId();
			if(! (cr instanceof Procedure)) { continue; }
			Procedure cp = (Procedure)f.getId();
			buildProcedureRanking(cp,memo);
			Integer rank = memo.get(cp);
			if(rank >= maxRank) { maxRank = rank+1; }
		}
		memo.put(p, maxRank);
	}
	
	public static TreeMap<Integer, List<Procedure>> topoOrderProceduresByRank(Procedure p) {
		Map <Procedure,Integer> memo = new HashMap<>();
		buildProcedureRanking(p,memo);
		TreeMap<Integer,List<Procedure>> sortedByRank = new TreeMap<>();
		
		for(Map.Entry<Procedure, Integer> e : memo.entrySet()) {
			if(sortedByRank.containsKey(e.getValue())) {
				sortedByRank.get(e.getValue()).add(e.getKey());
			} else {
				List<Procedure> list = new LinkedList<>();
				list.add(e.getKey());
				sortedByRank.put(e.getValue(), list);
			}
		}
		return sortedByRank;
	}
	
	public static String translate(Procedure p) {
		Translator translator = new MonolithicLustreTranslator();
		
		for(List<Procedure> list : topoOrderProceduresByRank(p).values()) {
			for(Procedure tp : list) {
				translator.action(tp);
			}
		}
		String library = new LibraryReader().getLibraryString();
		return library + seperator + translator.toString();
	}
	
	public static void reason(Procedure p, JKindResultsView page) {
		try {
			final String translation = translate(p);
			Renaming renaming = new MapRenaming(NameGenerator.getNames(), Mode.IDENTITY);
			final JKindApi api = PreferencesUtil.getJKindApi();
			
			ArrayList<String> al = new ArrayList<>();
			for (Section s : p.getSections()) {
				if (s instanceof ReqSection) {
					ReqSection rs = (ReqSection) s;
					for (SectionElement se : rs.getElements()) {
						if (se instanceof NamedFormula) {
							NamedFormula nf = (NamedFormula) se;
							al.add(nf.getName());							
						}
					}
				}
			}
			final JKindResult result = new JKindResult("result",al,renaming);
			page.setInput(result);
			
			WorkspaceJob job = new WorkspaceJob("Reasoning over Lustre Specification") {
				@Override
				public IStatus runInWorkspace(IProgressMonitor monitor) {
					
					try {
						api.execute(translation, result, monitor);	
					} catch (Exception e) {
						System.err.println(result.getText());
						throw e;
					}
					
					System.out.println(result.getText());
					return monitor.isCanceled() ? Status.CANCEL_STATUS : Status.OK_STATUS;
				}
			};
			job.schedule();
		} catch (JKindException e) {
			e.printStackTrace();
		}
	}
}
