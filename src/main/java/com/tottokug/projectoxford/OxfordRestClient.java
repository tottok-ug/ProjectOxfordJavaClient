package com.tottokug.projectoxford;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.tottokug.projectoxford.auth.BasicOxfordCredentilas;
import com.tottokug.projectoxford.auth.OxfordCredentials;
import com.tottokug.projectoxford.computervision.exception.ComputerVisionException;

public abstract class OxfordRestClient implements OxfordClient {

	Logger logger = LoggerFactory.getLogger(OxfordRestClient.class);

	protected String endpoint;

	protected OxfordRestClient(OxfordCredentials credentials) {
		this.credentials = credentials;
	}

	protected OxfordRestClient(String subscriptKey) {
		this.credentials = new BasicOxfordCredentilas(subscriptKey);
	}

	private HttpRequestInterceptor preRequestInterceptor;
	private HttpRequestInterceptor postRequestInterceptor;
	OxfordCredentials credentials;

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

	private static final String headerKey = "ocp-apim-subscription-key";
	private String subscriptionKey;
	private Gson gson = new Gson();

	@Override
	public <T extends OxfordResponse> T request(OxfordRequest request, T response) throws ComputerVisionException {
		logger.debug("Starting API request");
		logger.debug("request.path = " + request.getpath());
		logger.debug("request.method = " + request.getMethod().toString());
		String url = endpoint + request.getpath();
		logger.debug("url = " + url);
		switch (request.getMethod()) {
			case DELETE:
				return delete(url, response);
			case GET:
				return get(url, response);
			case POST:
				return post(url, request.getPostParamters(), request.getContentType(), response);
			case PUT:
				return put(url, request.getPostParamters(), response);
			case PATCH:
				return patch(url, request.getPostParamters(), request.getContentType(), response);
			default:
				throw new ComputerVisionException(
						"Error! Incorrect method provided: " + request.getMethod().toString());

		}
	}

	private <T extends OxfordResponse> T post(String url, Map<String, Object> data, String contentType, T response)
			throws ComputerVisionException {
		return webInvoke("POST", url, data, contentType, response);
	}

	private <T extends OxfordResponse> T get(String url, T response) throws ComputerVisionException {
		HttpGet request = new HttpGet(url);
		request.setHeader(headerKey, this.subscriptionKey);
		try (CloseableHttpClient client = getHttpClient()) {
			HttpResponse httpResponse = client.execute(request);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				return response.build(httpResponse);
			} else {
				throw new Exception("Error executing GET request! Received error code: "
						+ httpResponse.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			throw new ComputerVisionException(e.getMessage());
		}
	}

	private <T extends OxfordResponse> T patch(String url, Map<String, Object> data, String contentType, T response)
			throws ComputerVisionException {
		return webInvoke("PATCH", url, data, contentType, response);
	}

	private <T extends OxfordResponse> T webInvoke(String method, String url, Map<String, Object> data,
			String contentType, T response) throws ComputerVisionException {
		HttpEntityEnclosingRequestBase request = null;

		if (method.matches("POST")) {
			request = new HttpPost(url);
		} else if (method.matches("PATCH")) {
			request = new HttpPatch(url);
		}

		boolean isStream = false;

		/* Set header */
		if (contentType != null && !contentType.isEmpty()) {
			request.setHeader("Content-Type", contentType);
			if (contentType.toLowerCase().contains("octet-stream")) {
				isStream = true;
			}
		} else {
			request.setHeader("Content-Type", "application/json");
		}

		request.setHeader(headerKey, this.credentials.getSubscriptionKey());

		for (Header header : request.getAllHeaders()) {
			logger.debug(header.getName() + " = " + header.getValue());
		}

		try (CloseableHttpClient client = getHttpClient()) {
			if (!isStream) {
				String json = this.gson.toJson(data).toString();
				StringEntity entity = new StringEntity(json);
				request.setEntity(entity);
			} else {
				request.setEntity(new ByteArrayEntity((byte[]) data.get("data")));
			}
			HttpResponse httpResponse = client.execute(request);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				return response.build(httpResponse);
			} else {
				throw new Exception("Error executing POST request! Received error code: "
						+ httpResponse.getStatusLine().getStatusCode() + "["
						+ EntityUtils.toString(httpResponse.getEntity()) + "]");
			}
		} catch (Exception e) {
			logger.trace(e.getMessage(), e);
			throw new ComputerVisionException(e.getMessage());
		}
	}

	private <T extends OxfordResponse> T put(String url, Map<String, Object> data, T response)
			throws ComputerVisionException {
		HttpPut request = new HttpPut(url);
		request.setHeader(headerKey, this.subscriptionKey);

		try (CloseableHttpClient client = getHttpClient()) {
			String json = this.gson.toJson(data).toString();
			StringEntity entity = new StringEntity(json);
			request.setEntity(entity);
			request.setHeader("Content-Type", "application/json");
			HttpResponse httpResponse = client.execute(request);

			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == 200 || statusCode == 201) {
				return response.build(httpResponse);
			} else {
				throw new Exception("Error executing PUT request! Received error code: "
						+ httpResponse.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			throw new ComputerVisionException(e.getMessage());
		}
	}

	private <T extends OxfordResponse> T delete(String url, T response) throws ComputerVisionException {
		HttpDelete request = new HttpDelete(url);
		request.setHeader(headerKey, this.subscriptionKey);

		try (CloseableHttpClient client = getHttpClient()) {
			HttpResponse httpResponse = client.execute(request);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new Exception("Error executing DELETE request! Received error code: "
						+ httpResponse.getStatusLine().getStatusCode());
			}
			return response.build(httpResponse);
		} catch (Exception e) {
			throw new ComputerVisionException(e.getMessage());
		}
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
				url.append(param.getKey() + "=" + URLEncoder.encode(param.getValue().toString(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		return url.toString();
	}

}
