package com.oliveiradouglas.parking.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ColorTest {
	private Color color;

	@Before
	public void before() {
		color = new Color();
	}
	
	@Test
	public void testGetAndSetId() {
		color.setId(10);
		assertEquals(10, color.getId());
	}
	
	@Test
	public void testGetAndSetName() {
		color.setName("Verde");
		assertEquals("Verde", color.getName());
	}
}
