package com.tottokug.projectoxford.computervision.ocr;

import java.io.InputStream;
import java.util.Map;

import com.tottokug.projectoxford.computervision.OxfordRequest;
import com.tottokug.projectoxford.computervision.ocr.contract.Language;

public class OCRRequest implements OxfordRequest {

	@Override
	public String getpath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getPathParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getPostParamters() {
		// TODO Auto-generated method stub
		return null;
	}

	public OCRRequest withUrl(String url) {
		// TODO Auto-generated method stub
		return this;
	}

	public OCRRequest withLanguage(Language languageCode) {
		return this;
	}

	public OCRRequest withDetectOrientation(boolean detectOrientation) {
		return this;

	}

	public OCRRequest withInputStream(InputStream stream) {
		return this;
	}

}
