package com.tottokug.projectoxford.computervision.ocr.contract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Region {

	private List<Line> lines;
	private BoundingBox bb;

	public Region(List<Line> lines, BoundingBox bb) {
		this.lines = lines;
		this.bb = bb;
	}

	public Region(BoundingBox bb, Line... lines) {
		this.bb = bb;
		if (lines.length > 0) {
			this.lines = Arrays.asList(lines);
		} else {
			this.lines = new ArrayList<Line>();
		}
	}

	public void addLine(Line line) {
		this.lines.add(line);
	}

	public BoundingBox getBoundingBox() {
		return this.bb;
	}

	public List<Line> getLines() {
		return this.lines;
	}

}
