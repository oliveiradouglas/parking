package com.oliveiradouglas.parking.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.oliveiradouglas.parking.jdbc.ConnectionManager;

public class ConnectionManagerTest {
	@Test
	public void testGetInstanceMustAlwayReturnTheSameInstanceOfClass() {
		ConnectionManager manager1 = ConnectionManager.getInstance();
		ConnectionManager manager2 = ConnectionManager.getInstance();
		
		assertEquals(manager1, manager2);
	}
	
	@Test
	public void testGetConnectionMustReturnAConnection() throws SQLException {
		Connection connection1 = ConnectionManager.getInstance().getConnection();
		assertNotNull(connection1);
		connection1.close();
	}
	
	@Test
	public void testGetConnectionMustReturnMultipleConnections() throws SQLException {
		Connection connection1 = ConnectionManager.getInstance().getConnection();
		Connection connection2 = ConnectionManager.getInstance().getConnection();
		
		assertFalse(connection1.equals(connection2));
		
		connection1.close();
		connection2.close();
	}
}
