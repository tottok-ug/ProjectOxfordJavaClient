package com.tottokug.projectoxford.computervision.ocr.contract;

import java.util.List;

public class Line {

	private boolean isVertical;
	private List<Word> words;
	private String boundingBox; // e.g. "boundingBox":"27, 66, 72, 18"

	public boolean isVertical() {
		return isVertical;
	}

	public void setVertical(boolean isVertical) {
		this.isVertical = isVertical;
	}

	public String getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(String boundingBox) {
		this.boundingBox = boundingBox;
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}
}
