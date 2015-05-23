package com.tottokug.projectoxford.computervision;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.tottokug.projectoxford.auth.OxfordCredentials;
import com.tottokug.projectoxford.computervision.analyze.AnalyzeResponse;
import com.tottokug.projectoxford.computervision.exception.ComputerVisionException;
import com.tottokug.projectoxford.computervision.ocr.Language;
import com.tottokug.projectoxford.computervision.ocr.OCRRequest;
import com.tottokug.projectoxford.computervision.ocr.OCRResponse;
import com.tottokug.projectoxford.computervision.thumbnail.ThumbnailRequest;
import com.tottokug.projectoxford.computervision.thumbnail.ThumbnailResponse;

public class OxfordComputerVisionClient extends OxfordRestClient implements OxfordComputerVision {

	public OxfordComputerVisionClient(OxfordCredentials oxfordCredentials) {
		super(oxfordCredentials);
		this.endpoint = "https://api.projectoxford.ai/vision/v1";

	}

	public ThumbnailResponse thumbnail(ThumbnailRequest request) {
		return null;
	}

	@Override
	public OCRResponse recognizeText(String url, Language languageCode, boolean detectOrientation)
			throws ComputerVisionException {
		OCRRequest ocrRequest = new OCRRequest();
		ocrRequest.withUrl(url).withLanguage(languageCode).withDetectOrientation(detectOrientation);
		return this.recognizeText(ocrRequest);
	}

	@Override
	public OCRResponse recognizeText(InputStream stream, Language languageCode, boolean detectOrientation)
			throws ComputerVisionException, IOException {
		OCRRequest ocrRequest = new OCRRequest();
		ocrRequest.withInputStream(stream).withLanguage(languageCode).withDetectOrientation(detectOrientation);
		return this.recognizeText(ocrRequest);
	}

	public OCRResponse recognizeText(OCRRequest request) {
		OxfordResponse oxResponse = this.request(request);
		OCRResponse ocrResponse = new OCRResponse(oxResponse);
		return ocrResponse;
	}

	// public OxfordResponse request(OxfordRequest request) {
	// String path = endpoint + request.getpath();
	// String uri = OxfordRequest.getUrl(path, request.getPathParameters());
	// Map<String, Object> params = request.getPostParamters();
	//
	// return null;
	// }

	@Override
	public AnalyzeResponse analyzeImage(String url, String[] visualFeatures) throws ComputerVisionException {

		return null;
	}

	@Override
	public AnalyzeResponse analyzeImage(InputStream stream, String[] visualFeatures) throws ComputerVisionException,
			IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getThumbnail(int width, int height, boolean smartCropping, String url)
			throws ComputerVisionException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getThumbnail(int width, int height, boolean smartCropping, InputStream stream)
			throws ComputerVisionException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OxfordResponse request(OxfordRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
