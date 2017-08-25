package com.oliveiradouglas.parking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.oliveiradouglas.parking.models.Model;
import com.oliveiradouglas.parking.models.Setting;

public class SettingDAO extends SqlDAO {
	@Override
	public String getTableName() {
		return "settings";
	}

	@Override
	protected String[] getTableFields() {
		String[] fields = {"parking_name", "first_hour_value", "other_hours_value"};
		return fields;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Setting createObjectFromResultSet(ResultSet rs) throws SQLException {
		Setting setting = new Setting();
		setting.setId(rs.getInt("id"));
		setting.setParkingName(rs.getString("parking_name"));
		setting.setFirstHourValue(rs.getDouble("first_hour_value"));
		setting.setOtherHoursValue(rs.getDouble("other_hours_value"));
		return setting;
	}

	@Override
	protected void setPropertiesToStatement(PreparedStatement stmt, Model object) throws SQLException {
		Setting setting = (Setting) object;
		
		stmt.setString(1, setting.getParkingName());
		stmt.setDouble(2, setting.getFirstHourValue());
		stmt.setDouble(3, setting.getOtherHoursValue());
	}
	
	public Setting findSetting() throws SQLException {
		String sql = String.format("SELECT * FROM %s ORDER BY id DESC LIMIT 1;", getTableName());

		List<Setting> settings = select(sql, null);

		return (settings.size() == 1 ? settings.get(0) : null);
	}
}
