package com.oliveiradouglas.parking.models;

import java.sql.SQLException;
import java.time.LocalDateTime;

import com.oliveiradouglas.parking.dao.ParkingDAO;

public class Parking extends Model {
	private Vehicle vehicle;
	private String notes;
	private LocalDateTime entry;
	private LocalDateTime output;

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vechile) {
		this.vehicle = vechile;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDateTime getEntry() {
		return entry;
	}

	public void setEntry(LocalDateTime entry) {
		this.entry = entry;
	}

	public LocalDateTime getOutput() {
		return output;
	}

	public void setOutput(LocalDateTime output) {
		this.output = output;
	}

	public void giveLow() throws SQLException {
		this.setOutput(LocalDateTime.now());
		
		ParkingDAO dao = new ParkingDAO();
		dao.update(this);
	}
}
