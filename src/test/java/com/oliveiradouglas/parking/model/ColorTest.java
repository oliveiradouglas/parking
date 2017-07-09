package com.oliveiradouglas.parking.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ColorTest {
	@Test
	public void testConstructorWithNameMustSetTheName() {
		String colorName = "Azul";
		Color color = new Color("Azul");
		assertEquals(colorName, color.getName());
	}

	@Test
	public void testGetAndSetId() {
		Color color = new Color("Verde");
		color.setId(2);
		assertEquals(2, color.getId());
	}
}
