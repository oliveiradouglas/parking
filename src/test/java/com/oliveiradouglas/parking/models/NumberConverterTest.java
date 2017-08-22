package com.oliveiradouglas.parking.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.ParseException;

import org.junit.Test;

import com.oliveiradouglas.parking.src.NumberConverter;

public class NumberConverterTest {
	@Test
	public void testConvertStringToDouble() {
		try {
			assertEquals(10569784.56D, NumberConverter.convertStringToDouble("10.569.784,56"), 0.0000001);
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testConvertStringToDoubleWithSpacesMustRemoveAllSpacesAndConvertNumber() {
		try {
			assertEquals(89.30D, NumberConverter.convertStringToDouble(" 8 9,30"), 0.0000001);
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}
}
