package com.tottokug.projectoxford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class OxfordResponseAbstract implements OxfordResponse {

	static Logger logger = LoggerFactory.getLogger(OxfordResponseAbstract.class);
	protected int statusCode;
	protected String responseBody;
	protected byte[] entity;
	protected Header contentType;
	protected long contentLength;
	protected Header contentEncoding;

	@Override
	public int getResponseStatus() {
		return statusCode;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getResponseBody() {
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String readInput(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuffer json = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			json.append(line);
		}
		logger.debug(json.toString());
		return json.toString();
	}

}
