package com.tottokug.projectoxford.computervision.ocr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonToken;
import com.tottokug.projectoxford.OxfordResponseAbstract;
import com.tottokug.projectoxford.computervision.ocr.contract.Language;
import com.tottokug.projectoxford.computervision.ocr.contract.Region;

public class OCRResponse extends OxfordResponseAbstract {

	static Logger logger = LoggerFactory.getLogger(OCRResponse.class);

	Language language;
	String orientation;
	double textAngle;
	List<Region> regions;

	public int getStatus() {
		// TODO Auto-generated method stub
		return this.statusCode;
	}

	public Language getLanguage() {
		// TODO Auto-generated method stub
		return language;
	}

	public double getTextAngle() {
		// TODO Auto-generated method stub
		return textAngle;
	}

	public String getOrientation() {
		// TODO Auto-generated method stub
		return orientation;
	}

	public List<Region> getRegions() {
		// TODO Auto-generated method stub
		return regions;
	}

	@Override
	public boolean inputStream() {
		return false;
	}

	@Override
	public OCRResponse build(HttpResponse response) {
		this.statusCode = response.getStatusLine().getStatusCode();
		try {
			this.entity = IOUtils.toByteArray(response.getEntity().getContent());
			this.contentType = response.getEntity().getContentType();
			logger.debug("contentType : " + this.contentType);
			this.contentLength = response.getEntity().getContentLength();
			logger.debug("contentLength : " + this.contentLength);
			this.contentEncoding = response.getEntity().getContentEncoding();
			logger.debug("centent Encoding: " + this.contentEncoding);
			this.parse();
		} catch (UnsupportedOperationException | IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public void setLanguage(String language) {
		this.language = Language.valueOf(language.toUpperCase());
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public void setTextAngle(double d) {
		this.textAngle = d;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	private void parse() {
		logger.debug("parsing...");
		Gson gson = new GsonBuilder().create();
		try {
			String json = IOUtils.toString(this.entity, "UTF-8");
			logger.debug("JSON = " + json);
			JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
			logger.debug("JSONObject" + jsonObject.toString());
			logger.debug("language is setted => " + jsonObject.get("language"));
			this.setLanguage(jsonObject.get("language").getAsString());
			this.setTextAngle(jsonObject.get("textAngle").getAsDouble());
			this.setOrientation(jsonObject.get("orientation").getAsString());
			if (jsonObject.get("regions").isJsonArray()) {
				if (this.regions == null) {
					this.regions = new ArrayList<Region>();
				}
				for (JsonElement js : jsonObject.get("regions").getAsJsonArray()) {
					logger.debug(" REGIONS => " + js.toString());
					Region region = new GsonBuilder().create().fromJson(js, Region.class);
					this.regions.add(region);
				}
			}
		} catch (IOException e) {
			logger.trace(e.getMessage(), e);
		}
		logger.debug("parsed !");

	}
}
