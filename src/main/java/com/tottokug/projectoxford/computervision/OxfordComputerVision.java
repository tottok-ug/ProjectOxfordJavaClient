package com.tottokug.projectoxford.computervision;

import java.io.IOException;
import java.io.InputStream;

import com.tottokug.projectoxford.computervision.analyze.AnalyzeResponse;
import com.tottokug.projectoxford.computervision.exception.ComputerVisionException;
import com.tottokug.projectoxford.computervision.ocr.OCRResponse;
import com.tottokug.projectoxford.computervision.ocr.contract.Language;

public interface OxfordComputerVision {

	public AnalyzeResponse analyzeImage(String url, String[] visualFeatures) throws ComputerVisionException;

	public AnalyzeResponse analyzeImage(InputStream stream, String[] visualFeatures) throws ComputerVisionException,
			IOException;

	public OCRResponse recognizeText(String url, Language languageCode, boolean detectOrientation)
			throws ComputerVisionException;

	public OCRResponse recognizeText(InputStream stream, Language languageCode, boolean detectOrientation)
			throws ComputerVisionException, IOException;

	public byte[] getThumbnail(int width, int height, boolean smartCropping, String url)
			throws ComputerVisionException, IOException;

	public byte[] getThumbnail(int width, int height, boolean smartCropping, InputStream stream)
			throws ComputerVisionException, IOException;

}
