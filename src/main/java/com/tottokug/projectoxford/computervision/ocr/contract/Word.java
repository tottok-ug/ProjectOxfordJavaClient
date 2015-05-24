package com.tottokug.projectoxford.computervision.ocr.contract;

public class Word {

	private String boundingBox; // e.g. "boundingBox":"66, 66, 33, 18",

	private String text;

	public String getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(String boundingBox) {
		this.boundingBox = boundingBox;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
