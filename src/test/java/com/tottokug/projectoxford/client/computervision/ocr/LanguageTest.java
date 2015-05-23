package com.tottokug.projectoxford.client.computervision.ocr;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.junit.Test;

public class LanguageTest {

    @Test
    public void testLanguage() {
	assertThat(Language.CS.toString(), Is.is("cs"));
	
    }

}
