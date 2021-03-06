package com.tottokug.projectoxford.computervision.ocr.contract;

import java.util.List;

public class Region {

	private String boundingBox; // e.g. "boundingBox":"27, 33, 398, 51"

	private List<Line> lines;

	public String getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(String boundingBox) {
		this.boundingBox = boundingBox;
	}

	public String getRegionText() {
		StringBuffer sb = new StringBuffer();
		for (Line line : getLines()) {
			sb.append(line.getWordInLine());
		}
		return sb.toString();

	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

}
