package com.oliveiradouglas.parking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.oliveiradouglas.parking.models.Color;

public class ColorDAO extends SqlDAO {
	@Override
	public String getTableName() {
		return "colors";
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Color createObjectFromResultSet(ResultSet rs) throws SQLException {
		Color color = new Color();
		color.setId(rs.getInt("id"));
		color.setName(rs.getString("name"));
		
		return color;
	}
}
