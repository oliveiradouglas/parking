package com.oliveiradouglas.parking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.oliveiradouglas.parking.models.Model;
import com.oliveiradouglas.parking.models.Parking;
import com.oliveiradouglas.parking.models.Vehicle;

public class ParkingDAO extends SqlDAO {

	@Override
	public String getTableName() {
		return "parkings";
	}

	@Override
	protected String[] getTableFields() {
		 String[] fields = {"vehicle_id", "notes", "entry", "output"};
		 return fields;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Parking createObjectFromResultSet(ResultSet rs) throws SQLException {
		Parking parking = new Parking();
		parking.setId(rs.getInt("id"));
		parking.setNotes(rs.getString("notes"));
		parking.setEntry(rs.getTimestamp("entry").toLocalDateTime());
		
		Timestamp output = rs.getTimestamp("output"); 
		parking.setOutput(output != null ? output.toLocalDateTime() : null);
		
		Vehicle vehicle = new Vehicle();
		vehicle.setId(rs.getInt("vehicle_id"));
		parking.setVehicle(vehicle);
		
		return parking;
	}

	@Override
	protected void setPropertiesToStatement(PreparedStatement stmt, Model object) throws SQLException {
		Parking parking = (Parking) object;
		
		stmt.setInt(1, parking.getVechile().getId());
		stmt.setString(2, parking.getNotes());
		stmt.setTimestamp(3, Timestamp.valueOf(parking.getEntry()));
		
		LocalDateTime output = parking.getOutput();
		stmt.setTimestamp(4, (output != null ? Timestamp.valueOf(output) : null));
	}

}
