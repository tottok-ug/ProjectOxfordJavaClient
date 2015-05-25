package com.tottokug.projectoxford.computervision;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tottokug.projectoxford.auth.BasicOxfordCredentilas;
import com.tottokug.projectoxford.computervision.exception.ComputerVisionException;
import com.tottokug.projectoxford.computervision.ocr.OCRRequest;
import com.tottokug.projectoxford.computervision.ocr.OCRResponse;
import com.tottokug.projectoxford.computervision.ocr.contract.BoundingBox;
import com.tottokug.projectoxford.computervision.ocr.contract.Language;
import com.tottokug.projectoxford.computervision.ocr.contract.Line;
import com.tottokug.projectoxford.computervision.ocr.contract.Region;
import com.tottokug.projectoxford.computervision.ocr.contract.Word;

public class OxfordComputerVisionClientTest {

	static Logger logger = LoggerFactory.getLogger(OxfordComputerVisionClientTest.class);

	@Test
	public void test() {

		OxfordComputerVisionClient visionClient = new OxfordComputerVisionClient(new BasicOxfordCredentilas(
				Messages.getString("OxfordComputerVisionClientTest.subscriptKey"))); //$NON-NLS-1$
		for (int i = 1; i < 7; i++) {
			logger.debug(String.format("/nc%05d.jpg", i));
			InputStream stream = getClass().getResourceAsStream(String.format("/nc%05d.jpg", i)); //$NON-NLS-1$

			OCRRequest request = new OCRRequest();
			request.withDetectOrientation(true).withLanguage(Language.JAPANESE).withInputStream(stream);
			OCRResponse response;
			try {
				response = visionClient.recognizeText(request);
				logger.debug("RESPONSED -===================================================");
				logger.debug("RESPONSE CODE = " + response.getStatus());
				if (response.getStatus() == 200) {
					Language language = response.getLanguage();
					logger.debug("LANGUAGE = " + language.toString());
					double textAngle = response.getTextAngle();
					logger.debug("textAngle = " + textAngle);
					String orientation = response.getOrientation();
					logger.debug("orientation = " + orientation);
					List<Region> regions = response.getRegions();
					for (Region region : regions) {
						List<Line> lines = region.getLines();
						for (Line line : lines) {
							logger.debug(line.getWordInLine());
						}
					}
				}
			} catch (ComputerVisionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
