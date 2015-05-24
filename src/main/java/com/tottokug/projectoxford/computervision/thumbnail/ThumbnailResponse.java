package com.tottokug.projectoxford.computervision.thumbnail;

import org.apache.http.HttpResponse;

import com.tottokug.projectoxford.OxfordResponse;

public class ThumbnailResponse implements OxfordResponse {

	public int getResponseStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] getResponseBody() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inputStream() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T extends OxfordResponse> T build(HttpResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
