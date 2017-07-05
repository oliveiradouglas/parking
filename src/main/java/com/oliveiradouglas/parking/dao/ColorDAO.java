package com.oliveiradouglas.parking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oliveiradouglas.parking.models.Color;


public class ColorDAO extends DAO {
	@Override
	public String getTableName() {
		return "colors";
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Color> makeListFromResultSet(ResultSet rs) {
		List<Color> colors = new ArrayList<>();
		
		try {
			while (rs.next()) {
				Color color = new Color();
				color.setId(rs.getInt("id"));				
				color.setName(rs.getString("name"));
				
				colors.add(color);
			}

			return colors;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
}
