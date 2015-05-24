package com.tottokug.projectoxford.computervision;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tottokug.projectoxford.OxfordResponse;
import com.tottokug.projectoxford.OxfordRestClient;
import com.tottokug.projectoxford.auth.OxfordCredentials;
import com.tottokug.projectoxford.computervision.analyze.AnalyzeResponse;
import com.tottokug.projectoxford.computervision.exception.ComputerVisionException;
import com.tottokug.projectoxford.computervision.ocr.OCRRequest;
import com.tottokug.projectoxford.computervision.ocr.OCRResponse;
import com.tottokug.projectoxford.computervision.ocr.contract.Language;
import com.tottokug.projectoxford.computervision.thumbnail.ThumbnailRequest;
import com.tottokug.projectoxford.computervision.thumbnail.ThumbnailResponse;

public class OxfordComputerVisionClient extends OxfordRestClient implements OxfordComputerVision {

	Logger logger = LoggerFactory.getLogger(OxfordComputerVisionClient.class);

	public OxfordComputerVisionClient(OxfordCredentials oxfordCredentials) {
		super(oxfordCredentials);
		logger.debug("construct " + getClass().getName() + " : credentials = " + oxfordCredentials.getSubscriptionKey());
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

	public OCRResponse recognizeText(OCRRequest request) throws ComputerVisionException {
		OCRResponse ocrResponse = this.request(request, new OCRResponse());
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

}
