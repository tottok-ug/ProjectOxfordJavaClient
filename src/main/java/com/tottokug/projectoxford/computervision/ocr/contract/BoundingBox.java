package com.tottokug.projectoxford.computervision.ocr.contract;

public class BoundingBox {

	public BoundingBox(double minX, double minY, double width, double height) {
		this.minX = minX;
		this.minY = minY;
		this.width = width;
		this.height = height;
	}

	double minX, minY, width, height;

	public double getMinX() {
		return minX;

	}

	public double getWidth() {
		return minY;

	}

	public double getMinY() {
		return width;

	}

	public double getHeight() {
		return height;

	}

}
