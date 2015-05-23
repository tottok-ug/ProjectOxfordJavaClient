package com.tottokug.projectoxford.computervision.ocr;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Test;

import com.tottokug.projectoxford.computervision.ocr.contract.Language;

public class LanguageTest {

	@Test
	public void testLanguage() {

		assertThat(Language.CS.toString(), Is.is("cs"));

	}

}
