package com.oliveiradouglas.parking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.oliveiradouglas.parking.models.Color;
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
	
	@Override
	protected String createBaseSelectSql() {
		return String.format("SELECT "
				+ "p.id id, p.notes notes, p.entry entry, p.output output, "
				+ "v.id vehicle_id, v.type vehicle_type, v.brand as vehicle_brand, v.model as vehicle_model, v.vehicle_plate vehicle_plate, "
				+ "c.id color_id, c.name as color_name "
				+ "FROM %s p "
				+ "INNER JOIN vehicles v "
				+ "ON p.vehicle_id = v.id "
				+ "INNER JOIN colors c "
				+ "ON c.id = v.color_id", getTableName());
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
		vehicle.setType(rs.getString("vehicle_type"));
		vehicle.setBrand(rs.getString("vehicle_brand"));
		vehicle.setModel(rs.getString("vehicle_model"));
		vehicle.setPlate(rs.getString("vehicle_plate"));
		
		Color color = new Color();
		color.setId(rs.getInt("color_id"));
		color.setName(rs.getString("color_name"));
		
		vehicle.setColor(color);
		parking.setVehicle(vehicle);
		
		return parking;
	}

	@Override
	protected void setPropertiesToStatement(PreparedStatement stmt, Model object) throws SQLException {
		Parking parking = (Parking) object;
		
		stmt.setInt(1, parking.getVehicle().getId());
		stmt.setString(2, parking.getNotes());
		stmt.setTimestamp(3, Timestamp.valueOf(parking.getEntry()));
		
		LocalDateTime output = parking.getOutput();
		stmt.setTimestamp(4, (output != null ? Timestamp.valueOf(output) : null));
	}

	public Parking findByVehiclePlate(Vehicle vehicle) throws SQLException {
		String sql = createBaseSelectSql() + " WHERE v.vehicle_plate = ?;";

		List<Parking> records = select(sql, (stmt) -> {
			stmt.setString(1, vehicle.getPlate());
		});

		return (records.size() > 0 ? records.get(records.size() - 1) : null);
	}

}
