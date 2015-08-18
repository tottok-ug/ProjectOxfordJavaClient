package com.tottokug.projectoxford;

import org.apache.http.HttpResponse;

public interface OxfordResponse<T extends OxfordResponse<?>> {

	int getResponseStatus();

	String getMessage();

	byte[] getResponseBody();

	String getContentType();

	boolean inputStream();

	<T extends OxfordResponse<?>> T build(HttpResponse response);

}
