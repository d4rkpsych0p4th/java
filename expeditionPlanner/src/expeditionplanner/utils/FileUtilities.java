package expeditionplanner.utils;

import java.io.BufferedReader;
/**
 * 
 */
import java.io.FileReader;
import java.io.IOException;

public class FileUtilities {

	public static String getInputFromFile(String path) {
		String line = null;
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader fr = new BufferedReader(new FileReader(path));
			while ((line = fr.readLine()) != null) {
				result.append(line).append("//");
			}
			fr.close();
		} catch (IOException e) {
			System.err.println("No se ha podido leer el fichero: " + path + "\n" + e.getMessage());
		}
		
		return result.toString();
	}
	

}
