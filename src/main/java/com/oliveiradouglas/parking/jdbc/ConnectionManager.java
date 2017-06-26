package com.oliveiradouglas.parking.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;


public class ConnectionManager {
	private static ConnectionManager instance;
	private static DataSource dataSource;
	private ConnectionManager() {}
	
	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
			
			MysqlDataSource mysqlDataSource = new MysqlDataSource();
			mysqlDataSource.setUrl("");
			mysqlDataSource.setUser("root"); // pegar do properties
			mysqlDataSource.setPassword("123456"); // pegar do properties
			dataSource = mysqlDataSource;
		}
		
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
