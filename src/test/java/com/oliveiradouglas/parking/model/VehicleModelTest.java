package com.oliveiradouglas.parking.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.oliveiradouglas.parking.enums.VehicleModelType;

public class VehicleModelTest {
	private VehicleModel model;

	@Before
	public void before() {
		model = new VehicleModel("Fiesta", VehicleModelType.CAR); 
	}
	
	@Test
	public void testConstructorMustSetTheProperties() {
		assertEquals("Fiesta", model.getDescription());
		assertEquals(VehicleModelType.CAR, model.getType());
	}
	
	@Test
	public void testGetAndSetBrand() {
		VehicleBrand brand = new VehicleBrand("Ford"); 
		model.setBrand(brand);
		assertEquals(brand, model.getBrand());
	}
	
	@Test
	public void testGetAndSetId() {
		model.setId(1);
		assertEquals(1, model.getId());
	}
}
