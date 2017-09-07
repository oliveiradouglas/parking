package com.oliveiradouglas.parking.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.oliveiradouglas.parking.models.Color;
import com.oliveiradouglas.parking.models.Vehicle;

public class VehicleDAOTest {
	private static VehicleDAO dao;
	private Vehicle vehicle;

	@BeforeClass
	public static void init() {
		dao = new VehicleDAO();
	}

	@Before
	public void before() throws SQLException {
		vehicle = new Vehicle();

		Color color = new Color();
		color.setId(1);
		vehicle.setColor(color);
		vehicle.setType(Vehicle.CAR);
		vehicle.setBrand("Chevrolet");
		vehicle.setModel("Onix");
		vehicle.setPlate("ABC2222");

		dao.insert(vehicle);
	}

	@After
	public void after() throws SQLException {
		dao.delete(vehicle);
	}

	@Test
	public void testInsertVehicleMustStoreVehicleInDatabase() throws SQLException {
		Vehicle storedVehicle = dao.findById(vehicle.getId());
		assertEquals(vehicle, storedVehicle);
	}

	@Test
	public void testFindByPlate() throws SQLException {
		Vehicle storedVehicle = dao.findByPlate(vehicle);
		assertEquals(vehicle, storedVehicle);
	}
}
