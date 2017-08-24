package com.oliveiradouglas.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oliveiradouglas.parking.jdbc.ConnectionManager;
import com.oliveiradouglas.parking.models.Model;

public abstract class SqlDAO implements DAO {
	public abstract String getTableName();
	protected abstract <T> T createObjectFromResultSet(ResultSet rs) throws SQLException;
	
	@Override
	public <T> List<T> findAll() throws SQLException {
		List<T> records = new ArrayList<>();
		String sql = String.format("SELECT * FROM %s;", getTableName());
		
		try (Connection con = ConnectionManager.getInstance().getConnection()) {
			try (PreparedStatement stmt = con.prepareStatement(sql)) {				
				ResultSet result = stmt.executeQuery();

				while(result.next()) {
					records.add(createObjectFromResultSet(result));
				}
				
				result.close();
			}
		}
		
		return records;
	}
	
	public void insert(Model object) throws SQLException {
//		String sql = String.format("INSERT INTO %s (%s) VALUES (%s);", getTableName(), fields.join(", "), "");
//		try (Connection con = ConnectionManager.getInstance().getConnection()) {
//			try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {				
//				setPropertiesToStatement(stmt);
//				
//				if (stmt.executeUpdate() > 0) {
//					ResultSet result = stmt.getGeneratedKeys();
//					result.next();
//					object.setId(result.getInt(1));
//				} else {
//					throw new SQLException("Error on save record on database");
//				}
//			}
//		}
	}
	
	public void delete(Model object) throws SQLException {}
}
