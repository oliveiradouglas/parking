package com.oliveiradouglas.parking.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.oliveiradouglas.parking.model.VehicleBrand;

public class VehicleBrandDAOTest {
	private static VehicleBrandDAO dao;

	@BeforeClass
	public static void init() {
		dao = new VehicleBrandDAO();
	}
	
	@Test
	public void testFindAllMustReturnAllRegistredVehicleBrands() {
		List<VehicleBrand> vehicleBrands = dao.findAll();
		assertNotNull(vehicleBrands);
	}
	
	@Test
	public void testGetTableName() {
		assertEquals("vehicle_brands", dao.getTableName());
	}
	
	@Test
	public void testFindAllWithModelsMustReturnAllRegistredVehicleBrandsWithYoursModels() {
		List<VehicleBrand> vehicleBrands = dao.findAllWithModels();
		assertNotNull(vehicleBrands);
		assertNotNull(vehicleBrands.get(0).getModels());
	}
}
