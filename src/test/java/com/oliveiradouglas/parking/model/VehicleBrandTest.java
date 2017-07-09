package com.oliveiradouglas.parking.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class VehicleBrandTest {
	private VehicleBrand brand;

	@Before
	public void before() {
		brand = new VehicleBrand("Ford");
	}
	
	@Test
	public void testConstructorWithNameMustSetName() {
		assertEquals("Ford", brand.getName());
	}
	
	@Test
	public void testGetAndSetId() {
		brand.setId(1);
		assertEquals(1, brand.getId());
	}
	
	@Test
	public void testGetAndSetModels() {
		List<VehicleModel> models = new ArrayList<>();
		brand.setModels(models);
		assertEquals(models, brand.getModels());
	}
}
