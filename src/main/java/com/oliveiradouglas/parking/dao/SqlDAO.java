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
	protected abstract String[] getTableFields();
	protected abstract <T> T createObjectFromResultSet(ResultSet rs) throws SQLException;
	protected abstract void setPropertiesToStatement(PreparedStatement stmt, Model object) throws SQLException;

	protected String createBaseSelectSql() {
		return String.format("SELECT * FROM %s %s", getTableName(), getTableAlias());
	}

	public String getTableAlias() {
		return getTableName().substring(0, 1);
	}
	
	@Override
	public <T> List<T> findAll() throws SQLException {
		return select(createBaseSelectSql(), null);
	}
	
	protected <T> List<T> select(String sql, PreparedStatementResolver resolver) throws SQLException {
		List<T> records = new ArrayList<>();
		
		try (Connection con = ConnectionManager.getInstance().getConnection()) {
			try (PreparedStatement stmt = con.prepareStatement(sql)) {
				if (resolver != null) {
					resolver.setQueryParameters(stmt);
				}
				
				ResultSet result = stmt.executeQuery();

				while(result.next()) {
					records.add(createObjectFromResultSet(result));
				}
				
				result.close();
			}
		}
		
		return records;
	}
	
	public <T> T findById(int id) throws SQLException {
		String sqlBase = createBaseSelectSql();
		String sql 	   = String.format(sqlBase + " %s %s.id = ?;", getSqlClauseForCondition(sqlBase), getTableAlias());

		List<T> records = select(sql, (stmt) -> {
			stmt.setInt(1, id);
		});

		return (records.size() == 1 ? records.get(0) : null);
	}
	
	private String getSqlClauseForCondition(String sqlBase) {
		if (sqlBase.contains("WHERE")) {
			return "AND";
		}
		
		return "WHERE";
	}
	
	public void insert(Model object) throws SQLException {
		String fieldsJoined = String.join(", ", getTableFields()); 
		String sql = String.format(
			"INSERT INTO %s (%s) VALUES (%s);", 
			getTableName(), 
			fieldsJoined, 
			fieldsJoined.replaceAll("[a-zA-Z_]+", "?")
		);

		try (Connection con = ConnectionManager.getInstance().getConnection()) {
			try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {				
				setPropertiesToStatement(stmt, object);
				
				if (stmt.executeUpdate() > 0) {
					ResultSet result = stmt.getGeneratedKeys();
					result.next();
					object.setId(result.getInt(1));
					result.close();
				} else {
					throw new SQLException("Error on save record on database");
				}
			}
		}
	}
	
	public void update(Model object) throws SQLException {
		String sql = String.format(
			"UPDATE %s SET %s WHERE id = ?;", 
			getTableName(), 
			String.join(" = ?, ", getTableFields()) + " = ?"
		);

		try (Connection con = ConnectionManager.getInstance().getConnection()) {
			try (PreparedStatement stmt = con.prepareStatement(sql)) {				
				setPropertiesToStatement(stmt, object);
				stmt.setInt(getTableFields().length + 1, object.getId());
				
				if (stmt.executeUpdate() != 1) {
					throw new SQLException("Error on upate record on database");
				}
			}
		}
	}
	
	public void delete(Model object) throws SQLException {
		String sql = String.format("DELETE FROM %s WHERE id = ?;", getTableName());
		try (Connection con = ConnectionManager.getInstance().getConnection()) {
			try (PreparedStatement stmt = con.prepareStatement(sql)) {				
				stmt.setInt(1, object.getId());
				
				if (stmt.executeUpdate() != 1) {
					throw new SQLException("Error on save record on database");
				}
			}
		}
	}
}
