package com.oliveiradouglas.parking.models;

import java.time.LocalDateTime;

public class Parking extends Model {
	private Vehicle vehicle;
	private String notes;
	private LocalDateTime entry;
	private LocalDateTime exit;

	public Vehicle getVechile() {
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

	public LocalDateTime getExit() {
		return exit;
	}

	public void setExit(LocalDateTime exit) {
		this.exit = exit;
	}
}
