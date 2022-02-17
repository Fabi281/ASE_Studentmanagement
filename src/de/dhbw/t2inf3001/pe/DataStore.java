package de.dhbw.t2inf3001.pe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataStore {

	public static List<String> read(String id) {
		List<String> result = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(DataStore.class.getResourceAsStream("datastore.csv")));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(";");
				String currentId = tokens[0].replaceAll("\"", "");
				if (currentId.equals(id)) {
					for (String token : tokens) {
						result.add(token.replaceAll("\"", ""));
					}
					return result;
				}
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					//ignore
				}
			}
		}
		return result;
	}
	
}
