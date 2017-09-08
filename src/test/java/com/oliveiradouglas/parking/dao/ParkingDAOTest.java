package com.oliveiradouglas.parking.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.oliveiradouglas.parking.models.Color;
import com.oliveiradouglas.parking.models.Parking;
import com.oliveiradouglas.parking.models.Vehicle;

public class ParkingDAOTest {
	private ParkingDAO dao;
	private Parking parking;
	private Vehicle vehicle;
	private VehicleDAO vehicleDAO;

	@Before
	public void before() {
		dao     = new ParkingDAO();
		parking = new Parking();
		
		vehicle = new Vehicle();
		
		Color color = new Color();
		color.setId(1);
		
		vehicle.setColor(color);
		vehicle.setType(Vehicle.CAR);
		vehicle.setBrand("Chevrolet");
		vehicle.setModel("Onix");
		vehicle.setPlate("FRS5982");

		vehicleDAO = new VehicleDAO();
		try {
			vehicleDAO.insert(vehicle);
		} catch (SQLException e) {
			System.out.println("Erro ao inserir veiculo");
		}

		parking.setVehicle(vehicle);
		parking.setNotes("Veiculo batido");
		parking.setEntry(LocalDateTime.now());

		try {
			dao.insert(parking);
		} catch (SQLException e) {
			System.out.println("Erro ao inserir parking");
		}
	}
	
	@Test
	public void testInsertParking() throws SQLException {
		Parking parkingOfDb = dao.findById(parking.getId());
		assertEquals(parking, parkingOfDb);
		assertNull(parkingOfDb.getOutput());
	}
	
	@Test
	public void testUpdateParking() throws SQLException {
		parking.setOutput(LocalDateTime.now());
		dao.update(parking);
		
		Parking parkingOfDb = dao.findById(parking.getId());
		assertEquals(parking.getOutput().withSecond(0).withNano(0), parkingOfDb.getOutput().withSecond(0).withNano(0));		
	}
	
	@Test
	public void testGiveLow() throws SQLException {
		parking.giveLow();
		assertNotNull(parking.getOutput());
	}
	
	@Test
	public void testFindByVehiclePlate() throws SQLException {
		Parking parkingOfDb = dao.findByVehiclePlate(vehicle);
		assertEquals(parking, parkingOfDb);
	}

	@After
	public void after() throws SQLException {
		dao.delete(parking);
		vehicleDAO.delete(vehicle);
	}
}
