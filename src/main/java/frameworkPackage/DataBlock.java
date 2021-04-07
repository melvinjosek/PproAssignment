package frameworkPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//import org.apache.commons.lang3.RandomStringUtils;

public class DataBlock {

	private static String getKey(String page, String dataCode, String field) {
		if (dataCode == null || dataCode == "")
			return page + "." + field;
		else
			return page + "." + dataCode + "." + field;
	}

	public static String readCsvValue(String page, String dataCode, String field) {
		String key = getKey(page, dataCode, field);
		String value = "";
		File file = new File(getCsvPath(page));
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				if (line.split(";")[0].equals(key)) {
					value = line.split(";")[1];
					break;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;
	}

	private static String getCsvPath(String page) {
		String dataFolder = System.getProperty("user.dir") + System.getProperty("file.separator") + "ext"
				+ System.getProperty("file.separator") + "data" + System.getProperty("file.separator");
		String fileName = page + ".csv";
		return dataFolder + fileName;
	}
}
