package com.tottokug.projectoxford.computervision.ocr;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tottokug.projectoxford.HttpRequestMethod;
import com.tottokug.projectoxford.OxfordRequestAbstract;
import com.tottokug.projectoxford.computervision.ocr.contract.Language;

public class OCRRequest extends OxfordRequestAbstract {

	Logger logger = LoggerFactory.getLogger(OCRRequest.class);

	String url;
	boolean detectOrientation;
	byte[] data;

	public OCRRequest withUrl(String url) {
		this.url = url;
		return this;
	}

	public OCRRequest withLanguage(Language languageCode) {
		this.getPathParameters().put("language", languageCode.toString().toLowerCase());
		return this;
	}

	public OCRRequest withDetectOrientation(boolean detectOrientation) {
		this.detectOrientation = detectOrientation;
		this.getPathParameters().put("detectOrientation", detectOrientation ? 1 : 0);
		return this;

	}

	public OCRRequest withInputStream(InputStream stream) {
		try {
			this.data = IOUtils.toByteArray(stream);
			this.getPostParamters().put("data", this.data);
		} catch (IOException e) {
			logger.error(e.getMessage());
			logger.trace(e.getMessage(), e);
		}
		return this;
	}

	@Override
	public HttpRequestMethod getMethod() {
		return HttpRequestMethod.POST;
	}

	@Override
	public String getContentType() {
		if (data != null) {
			return "application/octet-stream";
		}
		return "application/json";
	}

	@Override
	public String getEndpoint() {
		return "/ocr";
	}

}
