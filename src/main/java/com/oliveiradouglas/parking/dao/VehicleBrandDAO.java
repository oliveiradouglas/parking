package com.oliveiradouglas.parking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oliveiradouglas.parking.jdbc.DAO;
import com.oliveiradouglas.parking.model.VehicleBrand;

public class VehicleBrandDAO extends DAO {

	@Override
	public String getTableName() {
		return "vehicle_brands";
	}

	@Override
	@SuppressWarnings("unchecked")
	protected List<VehicleBrand> makeListFromResultSet(ResultSet rs) {
		List<VehicleBrand> brands = new ArrayList<>();

		try {
			while (rs.next()) {
				VehicleBrand brand = new VehicleBrand(rs.getString("name"));
				brand.setId(rs.getInt("id"));
				brands.add(brand);
			}

			return brands;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<VehicleBrand> findAllWithModels() {
		List<VehicleBrand> brands = findAll();
		VehicleModelDAO vehicleModelDAO = new VehicleModelDAO();
		for (VehicleBrand vehicleBrand : brands) {
			vehicleBrand.setModels(vehicleModelDAO.findAllOfTheBrand(vehicleBrand));
		}
		
		return brands;
	}

}
