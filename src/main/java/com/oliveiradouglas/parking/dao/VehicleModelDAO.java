package com.oliveiradouglas.parking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oliveiradouglas.parking.enums.VehicleModelType;
import com.oliveiradouglas.parking.jdbc.DAO;
import com.oliveiradouglas.parking.model.VehicleBrand;
import com.oliveiradouglas.parking.model.VehicleModel;

public class VehicleModelDAO extends DAO {
	@Override
	public String getTableName() {
		return "vehicle_models";
	}

	@Override
	@SuppressWarnings("unchecked")
	protected List<VehicleModel> makeListFromResultSet(ResultSet rs) {
		List<VehicleModel> models = new ArrayList<>();

		try {
			while (rs.next()) {
				VehicleModel model = new VehicleModel(
						rs.getString("description"), 
						VehicleModelType.valueOf(rs.getString("type"))
				);
				
				model.setId(rs.getInt("id"));
				models.add(model);
			}

			return models;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<VehicleModel> findAllOfTheBrand(VehicleBrand vehicleBrand) {
		return new ArrayList<VehicleModel>();
	}

}
