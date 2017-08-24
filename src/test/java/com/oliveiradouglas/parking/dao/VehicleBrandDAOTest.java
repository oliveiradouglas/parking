package com.oliveiradouglas.parking.dao;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.oliveiradouglas.parking.models.VehicleBrand;

public class VehicleBrandDAOTest {
	@Test
	public void testFindAllMustReturnAllStoredColorsInDatabase() throws SQLException {
		VehicleBrandDAO dao = new VehicleBrandDAO();
		List<VehicleBrand> brands = dao.findAll();
		assertTrue(brands.size() >= 26);
	}
}
