package com.oliveiradouglas.parking.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VehicleModelTest {
	private VehicleModel vehicleModel;

	@Before
	public void before() {
		vehicleModel = new VehicleModel(1, "Description");
	}
	
	@Test
	public void testGetIdMustReturnIdProvidedInConstructor() {
		assertEquals(1, vehicleModel.getId());
	}
	
	@Test
	public void testGetDescriptionMustReturnDescriptionProvidedInConstructor() {
		assertEquals("Description", vehicleModel.getDescription());
	}
}
