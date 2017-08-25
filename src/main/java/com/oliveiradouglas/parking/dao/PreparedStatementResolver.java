package com.oliveiradouglas.parking.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementResolver {
	public void setQueryParameters(PreparedStatement stmt) throws SQLException;
}
