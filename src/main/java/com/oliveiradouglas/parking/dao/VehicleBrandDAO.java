package com.oliveiradouglas.parking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.oliveiradouglas.parking.models.VehicleBrand;

public class VehicleBrandDAO extends SqlDAO {
	@Override
	public String getTableName() {
		return "vehicle_brands";
	}

	@SuppressWarnings("unchecked")
	@Override
	protected VehicleBrand createObjectFromResultSet(ResultSet rs) throws SQLException {
		VehicleBrand brand = new VehicleBrand();
		brand.setId(rs.getInt("id"));
		brand.setName(rs.getString("name"));
		
		return brand;
	}
}
