package com.oliveiradouglas.parking.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ColorTest {
	private Color color;

	@Before
	public void before() {
		color = new Color(1, "Azul");
	}
	
	@Test
	public void testGetId() {
		assertEquals(1, color.getId());
	}
	
	@Test
	public void testGetName() {
		assertEquals("Azul", color.getName());
	}
}
