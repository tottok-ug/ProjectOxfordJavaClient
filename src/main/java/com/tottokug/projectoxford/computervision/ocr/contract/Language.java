package com.tottokug.projectoxford.computervision.ocr.contract;

public enum Language {

	AUTO_DETECT("unk"), UNK, CHINESE_SIMPLIFIED("zh-Hans"), ZH_HANS("zh-Hans"), CHINESE_TRADITIONAL("zh-Hant"), CZECH(
			"cs"), CS, DANISH("da"), DA("da"), DUTCH("nl"), NL, ENGLISH("en"), EN, FINNISH("fi"), FI, FRENCH("fr"), FR, GERMAN(
			"de"), DE, GREEK("el"), EL, HUNGARIAN("hu"), HU, ITALIAN("it"), IT, JAPANESE("Ja"), JA, KOREAN("ko"), KO, NORWEGIAN(
			"nb"), NB, POLISH("pl"), PL, PORTUGUESE("pt"), PT, RUSSIAN("ru"), RU, SPANISH("es"), ES, SWEDISH("sv"), SV, TURKISH(
			"tr"), TR;

	Language() {
		this.language = this.name().toLowerCase();

	}

	String language;

	Language(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return language;
	}
}
