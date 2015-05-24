package com.tottokug.projectoxford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class OxFordResponseAbstract implements OxfordResponse {

	static Logger logger = LoggerFactory.getLogger(OxFordResponseAbstract.class);
	private int statusCode;
	private String responseBody;
	private byte[] entity;
	private Header contentType;
	private long contentLength;

	@Override
	public int getResponseStatus() {
		// TODO Auto-generated method stub
		return 0;
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

	public OxFordResponseAbstract(HttpResponse response) {
		this.statusCode = response.getStatusLine().getStatusCode();
		try {
			this.entity = IOUtils.toByteArray(response.getEntity().getContent());
			this.contentType = response.getEntity().getContentType();
			this.contentLength = response.getEntity().getContentLength();

		} catch (UnsupportedOperationException | IOException e) {
			e.printStackTrace();
		}
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
