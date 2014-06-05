package spear.translator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/*
 * This class will read in the SpecDSL node library.
 */
public class LibraryReader {
	private final static String seperator = System
			.getProperty("line.separator");

	public String getLibraryString() {
		URL url = getClass().getResource("/resources/library.specdsl");
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));
			StringBuilder sb = new StringBuilder();
			String str = null;

			while ((str = in.readLine()) != null) {
				sb.append(str);
				sb.append(seperator);
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
