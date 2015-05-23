package com.tottokug.projectoxford.computervision;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tottokug.projectoxford.auth.BasicOxfordCredentilas;
import com.tottokug.projectoxford.computervision.ocr.Language;
import com.tottokug.projectoxford.computervision.ocr.OCRRequest;

public class OxfordComputerVisionClientTest {

	@Test
	public void test() {

		OxfordComputerVisionClient visionClient = new OxfordComputerVisionClient(new BasicOxfordCredentilas(
				"**********"));
		
		OCRRequest request = new OCRRequest();
		request.withDetectOrientation(true).withLanguage(Language.JAPANESE).withInputStream(stream);
		visionClient.recognizeText(request);

	}
}
