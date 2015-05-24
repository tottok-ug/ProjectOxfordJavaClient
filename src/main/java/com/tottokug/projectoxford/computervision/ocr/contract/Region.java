package com.tottokug.projectoxford.computervision.ocr.contract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Region {

	private List<Line> lines;
	private BoundingBox bb;
	private String boundingBox;

	public void setBoundingBox(BoundingBox boundingBox) {
		this.bb = boundingBox;
	}

	public void setBoundingBox(String boundingBox) {
		String[] b = boundingBox.split(",");
		this.setBoundingBox(new BoundingBox(Integer.parseInt(b[0]), Integer.parseInt(b[1]), Integer.parseInt(b[2]),
				Integer.parseInt(b[3])));
	}

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
