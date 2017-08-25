package com.oliveiradouglas.parking.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.Test;

import com.oliveiradouglas.parking.models.Color;
import com.oliveiradouglas.parking.models.Parking;
import com.oliveiradouglas.parking.models.Vehicle;

public class ParkingDAOTest {
	// insert
	// update
	// dar baixa tem que gerar lançamento
	
	@Test
	public void testInsertParking() throws SQLException {
		ParkingDAO dao = new ParkingDAO();
		Parking parking = new Parking();
		
		Vehicle vehicle = new Vehicle();
		Color color = new Color();
		color.setId(1);
		vehicle.setColor(color);
		vehicle.setType(Vehicle.CAR);
		vehicle.setBrand("Chevrolet");
		vehicle.setModel("Onix");
		vehicle.setPlate("FRS5982");
		
		VehicleDAO vehicleDAO = new VehicleDAO();
		vehicleDAO.insert(vehicle);
		
		parking.setVehicle(vehicle);
		parking.setNotes("Veiculo batido");
		parking.setEntry(LocalDateTime.now());
		
		dao.insert(parking);
		
		Parking parkingOfDb = dao.findById(parking);
		assertEquals(parking, parkingOfDb);
		
		dao.delete(parking);
		vehicleDAO.delete(vehicle);
	}
}
