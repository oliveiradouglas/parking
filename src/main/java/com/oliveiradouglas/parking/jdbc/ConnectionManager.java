package com.oliveiradouglas.parking.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionManager {
	private static ConnectionManager instance;
	private static DataSource dataSource;

	private ConnectionManager() {
	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();

			Properties dbSettings = loadDbSettings();

			MysqlDataSource mysqlDataSource = new MysqlDataSource();
			mysqlDataSource.setUrl(String.format(
					"jdbc:mysql://%s/%s?serverTimezone=UTC",
					dbSettings.getProperty("host"),
					dbSettings.getProperty("database")));
			
			mysqlDataSource.setUser(dbSettings.getProperty("user"));
			mysqlDataSource.setPassword(dbSettings.getProperty("password"));
			dataSource = mysqlDataSource;
		}

		return instance;
	}

	private static Properties loadDbSettings() {
		try (InputStream fis = ClassLoader.class.getResourceAsStream("/db-settings.properties")) {
			Properties properties = new Properties();
			properties.load(fis);

			return properties;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
