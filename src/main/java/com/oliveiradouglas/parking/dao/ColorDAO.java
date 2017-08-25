package com.oliveiradouglas.parking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oliveiradouglas.parking.models.Color;
import com.oliveiradouglas.parking.models.Model;

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

	@Override
	protected String[] getTableFields() {
		String[] fields = {"name"};
		return fields;
	}

	@Override
	protected void setPropertiesToStatement(PreparedStatement stmt, Model object) throws SQLException {
		Color color = (Color) object;
		stmt.setString(1, color.getName());
	}
}
