package com.oliveiradouglas.parking.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.oliveiradouglas.parking.model.Color;

public class ColorDAOTest {
	private static ColorDAO dao;

	@BeforeClass
	public static void init() {
		dao = new ColorDAO();
	}
	
	@Test
	public void testFindAllMustReturnAllRegistredColors() {
		List<Color> colors = dao.findAll();
		assertEquals(12, colors.size());
		assertEquals("Outra", colors.get(colors.size()-1).getName());
	}
	
	@Test
	public void testGetTableNameMustReturnColors() {
		assertEquals("colors", dao.getTableName());
	}
}
