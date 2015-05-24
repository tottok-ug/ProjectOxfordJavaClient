package com.tottokug.projectoxford;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public abstract class OxfordRequestAbstract implements OxfordRequest {

	Map<String, Object> pathParameter;
	Map<String, Object> postParameter;

	@Override
	public String getpath() {
		StringBuffer url = new StringBuffer(getEndpoint());

		boolean start = true;
		if (pathParameter != null) {
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
		}

		return url.toString();

	}

	@Override
	public Map<String, Object> getPathParameters() {
		if (pathParameter == null) {
			pathParameter = new HashMap<String, Object>();
		}
		return pathParameter;
	}

	@Override
	public Map<String, Object> getPostParamters() {
		if (postParameter == null) {
			postParameter = new HashMap<String, Object>();
		}
		return postParameter;
	}

}
