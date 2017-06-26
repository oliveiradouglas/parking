package com.oliveiradouglas.parking.jdbc;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import org.junit.Test;

public class ConnectionManagerTest {
	@Test
	public void testGetInstanceMustAlwayReturnTheSameInstanceOfClass() {
		ConnectionManager manager1 = ConnectionManager.getInstance();
		ConnectionManager manager2 = ConnectionManager.getInstance();
		
		assertEquals(manager1, manager2);
	}
	
	@Test
	public void testGetConnectionMustAlwayReturnTheSameConnection() {
		Connection connection1 = ConnectionManager.getInstance().getConnection();
		Connection connection2 = ConnectionManager.getInstance().getConnection();
		
		assertEquals(connection1, connection2);
	}
}
