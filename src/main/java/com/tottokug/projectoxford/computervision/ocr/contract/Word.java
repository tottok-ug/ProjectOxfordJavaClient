package com.tottokug.projectoxford.computervision.ocr.contract;

public class Word {

	String text;
	BoundingBox bb;

	public Word(String text, BoundingBox bb) {
		this.text = text;
		this.bb = bb;
	}

	public BoundingBox getBoundingBox() {
		return bb;
	}

	public String getText() {
		return text;
	}

}
