package com.tottokug.projectoxford.client.computervision.ocr;

import static org.junit.Assert.assertThat;

import org.apache.commons.codec.language.bm.Lang;
import org.hamcrest.core.Is;
import org.junit.Test;

import com.tottokug.projectoxford.computervision.ocr.Language;

public class LanguageTest {

	@Test
	public void testLanguage() {

		assertThat(Language.CS.toString(), Is.is("cs"));

	}

}
