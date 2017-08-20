package com.oliveiradouglas.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.oliveiradouglas.parking.jdbc.ConnectionManager;
import com.oliveiradouglas.parking.models.Setting;

public class SettingDAO {

	public Setting findSetting() throws SQLException {
		Setting setting = null;
		String sql = "SELECT * FROM settings ORDER BY id DESC LIMIT 1;";
		try (Connection con = ConnectionManager.getInstance().getConnection()) {
			try (PreparedStatement stmt = con.prepareStatement(sql)) {				
				ResultSet result = stmt.executeQuery();

				if (result.next()) {
					setting = new Setting();
					setting.setId(result.getInt("id"));
					setting.setParkingName(result.getString("parking_name"));
					setting.setFirstHourValue(result.getDouble("first_hour_value"));
					setting.setOtherHoursValue(result.getDouble("other_hours_value"));
				}
			}
		}
		
		return setting;
	}

	public void save(Setting setting) throws SQLException {
		String sql = "INSERT INTO settings (parking_name, first_hour_value, other_hours_value) VALUES (?, ?, ?);";
		try (Connection con = ConnectionManager.getInstance().getConnection()) {
			try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {				
				stmt.setString(1, setting.getParkingName());
				stmt.setDouble(2, setting.getFirstHourValue());
				stmt.setDouble(3, setting.getOtherHoursValue());
				
				if (stmt.executeUpdate() > 0) {
					ResultSet result = stmt.getGeneratedKeys();
					result.next();
					setting.setId(result.getInt(1));
				} else {
					throw new SQLException("Error on save record on database");
				}
			}
		}
	}

	public void delete(Setting setting) throws SQLException {
		String sql = "DELETE FROM settings WHERE id = ?;";
		try (Connection con = ConnectionManager.getInstance().getConnection()) {
			try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {				
				stmt.setInt(1, setting.getId());
				
				if (stmt.executeUpdate() != 1) {
					throw new SQLException("Error on save record on database");
				}
			}
		}
	}

}
