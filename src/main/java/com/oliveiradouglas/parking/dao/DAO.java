package com.oliveiradouglas.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.oliveiradouglas.parking.jdbc.ConnectionManager;

abstract class DAO {
	public abstract String getTableName();
	public abstract <T> List<T> makeListFromResultSet(ResultSet rs);
	
	public <T> List<T> findAll() {
		try (Connection connection = ConnectionManager.getInstance().getConnection()) {
			String sql = String.format("select * from %s;", getTableName());
			PreparedStatement stmt = connection.prepareStatement(sql);
			List<T> result;
			
			stmt.execute();
			ResultSet resultSet = stmt.getResultSet();
			result = makeListFromResultSet(resultSet);
			
			resultSet.close();
			stmt.close();

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
