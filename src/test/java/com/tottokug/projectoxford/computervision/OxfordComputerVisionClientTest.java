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
		InputStream stream = getClass().getResourceAsStream("/test.png"); //$NON-NLS-1$

		OCRRequest request = new OCRRequest();
		request.withDetectOrientation(true).withLanguage(Language.JAPANESE).withInputStream(stream);
		OCRResponse response;
		try {
			response = visionClient.recognizeText(request);
			if (response.getStatus() == 200) {
				Language language = response.getLanguage();
				int textAngle = response.getTextAngle();
				String orientation = response.getOrientation();
				List<Region> regions = response.getRegions();
				for (Region region : regions) {
					BoundingBox boundingBox = region.getBoundingBox();
					boundingBox.getMinX();
					boundingBox.getMinX();
					boundingBox.getWidth();
					boundingBox.getHeight();

					List<Line> lines = region.getLines();
					for (Line line : lines) {
						line.getBoundingBox();
						List<Word> words = line.getWords();
						for (Word word : words) {
							BoundingBox b = word.getBoundingBox();
							String text = word.getText();
						}
					}
				}
			}
		} catch (ComputerVisionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
