package com.tottokug.projectoxford;

import java.util.Map;

public interface OxfordRequest {

	String getpath();

	Map<String, Object> getPathParameters();

	Map<String, Object> getPostParamters();

	String getContentType();

	HttpRequestMethod getMethod();

	String getEndpoint();

}
