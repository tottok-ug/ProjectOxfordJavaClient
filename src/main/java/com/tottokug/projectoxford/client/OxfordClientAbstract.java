package com.tottokug.projectoxford.client;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.http.HttpRequestInterceptor;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public abstract class OxfordClientAbstract implements OxfordClient {
    protected String endpoint;

    private HttpRequestInterceptor preRequestInterceptor;
    private HttpRequestInterceptor postRequestInterceptor;

    protected CloseableHttpClient getHttpClient() {
	HttpClientBuilder builder = HttpClientBuilder.create();
	if (preRequestInterceptor != null) {
	    builder.addInterceptorFirst(preRequestInterceptor);
	}
	if (postRequestInterceptor != null) {
	    builder.addInterceptorFirst(postRequestInterceptor);
	}
	return builder.build();
    }

    void setInterceptorPreRequest(HttpRequestInterceptor interceptor) {
	this.preRequestInterceptor = interceptor;
    }

    void setInterceptorPostRequest(HttpRequestInterceptor interceptor) {
	this.postRequestInterceptor = interceptor;
    }

    public static String getUrl(String path, Map<String, Object> params) {
	StringBuffer url = new StringBuffer(path);

	boolean start = true;
	for (Map.Entry<String, Object> param : params.entrySet()) {
	    if (start) {
		url.append("?");
		start = false;
	    } else {
		url.append("&");
	    }

	    try {
		url.append(param.getKey()
			+ "="
			+ URLEncoder.encode(param.getValue().toString(),
				"UTF-8"));
	    } catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	    }
	}

	return url.toString();
    }

}
