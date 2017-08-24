package com.oliveiradouglas.parking.dao;

import java.sql.SQLException;
import java.util.List;

import com.oliveiradouglas.parking.models.Model;

public interface DAO {
	public <T> List<T> findAll() throws SQLException;
	public void insert(Model object) throws SQLException;
	public void delete(Model object) throws SQLException;
}
