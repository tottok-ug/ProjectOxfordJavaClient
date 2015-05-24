package com.tottokug.projectoxford;

public interface OxfordResponse {

	int getResponseStatus();

	String getMessage();

	byte[] getResponseBody();

	String getContentType();

	boolean inputStream();

}
