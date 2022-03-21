package de.lebenshilfe_schleiz.foodorder.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

public class JSONUtils {
	
	public static JSONArray readJsonArrayFromUrl(String url) throws IOException, JSONException {
		InputStream stream = new URL(url).openStream();
		try {
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(
							stream, Charset.forName("UTF-8")));

			String jsonText = readAll(reader);

			JSONTokener tokener = new JSONTokener(jsonText);
			JSONArray jsonArray = (JSONArray)tokener.nextValue();

			return jsonArray;
		} finally {
			stream.close();
		}
	}
	
	private static String readAll(BufferedReader buffRead) throws IOException {
		StringBuilder sb = new StringBuilder();
		String currentLine;
		while ((currentLine = buffRead.readLine()) != null) {
			sb.append(currentLine);
		}
		return sb.toString();
	}
	
}