Project Oxford Java Client
===



## Project Oxford


## How To Use

Vision API - OCR

```Java

OxfordComputerVisionClient visionClient = new OxfordComputerVisionClient(new BasicOxfordCredentilas(
				"**********"));
		InputStream stream = getClass().getResourceAsStream("test.png");

		OCRRequest request = new OCRRequest();
		request.withDetectOrientation(true).withLanguage(Language.JAPANESE).withInputStream(stream);
		OCRResponse response = visionClient.recognizeText(request);
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
		
```
