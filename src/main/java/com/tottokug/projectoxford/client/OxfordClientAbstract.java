package com.tottokug.projectoxford.client;

import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public abstract class OxfordClientAbstract implements OxfordClient {
    HttpClient client;
    private HttpRequestInterceptor preRequestInterceptor;
    private HttpRequestInterceptor postRequestInterceptor;

    
    
    
    
    HttpClient getHttpClient() {
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

}
