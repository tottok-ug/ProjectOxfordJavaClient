package com.tottokug.projectoxford.computervision;

import java.util.Map;

import com.tottokug.projectoxford.client.computervision.ocr.OCRRequest;
import com.tottokug.projectoxford.client.computervision.ocr.OCRResponse;
import com.tottokug.projectoxford.client.computervision.thumbnail.ThumbnailRequest;
import com.tottokug.projectoxford.client.computervision.thumbnail.ThumbnailResponse;

public class OxfordComputerVisionClient extends OxfordClientAbstract {

    public ThumbnailResponse thumbnail(ThumbnailRequest request) {
	return null;
    }

    public OCRResponse ocr(OCRRequest request) {
	OxfordResponse oxResponse = this.request(request);
	OCRResponse ocrResponse = new OCRResponse(oxResponse);
	return null;
    }

    public OxfordResponse request(OxfordRequest request) {
	String path = endpoint + request.getpath();
	String uri = getUrl(path, request.getPathParameters());
	Map<String, Object> params = request.getPostParamters();

	return null;
    }
}
