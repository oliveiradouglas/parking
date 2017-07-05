package com.oliveiradouglas.parking.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
	private Vehicle vehicle;
	private Color color;
	private VehicleModel model;

	@Before
	public void before() {
		color = new Color(1, "Azul");
		model = new VehicleModel(1, "Ford - Fiesta");
		vehicle = new Vehicle(color, model, "FWZ1645");
	}
	
	@Test
	public void testGetAndSetId() {
		vehicle.setId(1);
		assertEquals(1, vehicle.getId());
	}
	
	@Test
	public void testGetColor() {
		assertEquals(color, vehicle.getColor());
	}
	
	@Test
	public void testGetModel() {
		assertEquals(model, vehicle.getModel());
	}
	
	@Test
	public void testGetVehiclePlate() {
		assertEquals("FWZ1645", vehicle.getVehiclePlate());
	}
}
