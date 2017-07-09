package com.oliveiradouglas.parking.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.oliveiradouglas.parking.model.VehicleBrand;
import com.oliveiradouglas.parking.model.VehicleModel;

public class VehicleModelDAOTest {
	private static VehicleModelDAO dao;

	@BeforeClass
	public static void init() {
		dao = new VehicleModelDAO();
	}
	
	@Test
	public void testFindAllMustReturnAllRegistredVehicleModels() {
		List<VehicleModel> models = dao.findAll();
		assertNotNull(models);
	}
	
	@Test
	public void testGetTableName() {
		assertEquals("vehicle_models", dao.getTableName());
	}
	
	@Test
	public void testFindAllOfTheBrandMustReturnAllRegistredsModelsOfBrand() {
		VehicleBrand brand = new VehicleBrand("Ford");
		brand.setId(1);
		
		List<VehicleModel> models = dao.findAllOfTheBrand(brand);
		assertNotNull(models);
		assertEquals(brand.getId(), models.get(0).getBrand().getId());
	}
}
