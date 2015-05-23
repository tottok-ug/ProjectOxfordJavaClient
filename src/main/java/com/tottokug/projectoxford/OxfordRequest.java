package com.tottokug.projectoxford;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Map;

public interface OxfordRequest {

	String getpath();

	Map<String, Object> getPathParameters();

	Map<String, Object> getPostParamters();

	public static String getUrl(String path, Map<String, Object> pathParameter) {
		StringBuffer url = new StringBuffer(path);

		boolean start = true;
		for (Map.Entry<String, Object> param : pathParameter.entrySet()) {
			if (start) {
				url.append("?");
				start = false;
			} else {
				url.append("&");
			}

			try {
				url.append(param.getKey() + "=" + URLEncoder.encode(param.getValue().toString(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		return url.toString();
	}

	HttpRequestMethod getMethod();

}
