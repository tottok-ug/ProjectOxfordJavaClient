package com.tottokug.projectoxford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;

public interface OxfordResponse<T extends OxfordResponse<?>> {

	int getResponseStatus();

	String getMessage();

	byte[] getResponseBody();

	String getContentType();

	boolean inputStream();

	<T extends OxfordResponse<?>> T build(HttpResponse response);

	public static String readInput(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuffer json = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			json.append(line);
		}
		return json.toString();
	}
}
