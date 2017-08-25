package com.oliveiradouglas.parking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.oliveiradouglas.parking.models.Color;
import com.oliveiradouglas.parking.models.Model;
import com.oliveiradouglas.parking.models.Vehicle;

public class VehicleDAO extends SqlDAO {
	@Override
	public String getTableName() {
		return "vehicles";
	}

	@Override
	protected String[] getTableFields() {
		String[] fields = { "color_id", "type", "brand", "model", "vehicle_plate" };
		return fields;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Vehicle createObjectFromResultSet(ResultSet rs) throws SQLException {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(rs.getInt("id"));

		Color color = new Color();
		color.setId(rs.getInt("color_id"));
		vehicle.setColor(color);

		vehicle.setBrand(rs.getString("brand"));
		vehicle.setModel(rs.getString("model"));
		vehicle.setType(rs.getString("type"));
		vehicle.setPlate(rs.getString("vehicle_plate"));

		return vehicle;
	}

	@Override
	protected void setPropertiesToStatement(PreparedStatement stmt, Model object) throws SQLException {
		Vehicle vehicle = (Vehicle) object;
		stmt.setInt(1, vehicle.getColor().getId());
		stmt.setString(2, vehicle.getType());
		stmt.setString(3, vehicle.getBrand());
		stmt.setString(4, vehicle.getModel());
		stmt.setString(5, vehicle.getPlate());
	}

	public Vehicle findByPlate(Vehicle vehicle) throws SQLException {
		String sql = String.format("SELECT * FROM %s WHERE vehicle_plate = ?;", getTableName());

		List<Vehicle> vehicles = select(sql, (stmt) -> {
			stmt.setString(1, vehicle.getPlate());
		});

		return (vehicles.size() == 1 ? vehicles.get(0) : null);
	}

}
