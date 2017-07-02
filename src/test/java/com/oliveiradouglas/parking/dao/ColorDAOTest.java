package com.oliveiradouglas.parking.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.oliveiradouglas.parking.models.Color;

public class ColorDAOTest {
	private ColorDAO colorDAO;

	@Before
	public void before() throws SQLException {
		colorDAO = new ColorDAO();
	}
	
	@Test
	public void testFindAll() {
		List<Color> colors = colorDAO.findAll();
		assertEquals(12, colors.size());
	}
}
