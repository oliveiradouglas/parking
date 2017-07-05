package com.oliveiradouglas.parking.models;

import java.time.LocalDateTime;

public class ParkingControl {
	private int id;
	private Vehicle vehicle;
	private String notes;
	private LocalDateTime entry;
	private LocalDateTime exit;

	public ParkingControl(Vehicle vehicle, LocalDateTime entry) {
		this.vehicle = vehicle;
		this.entry = entry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
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

	public LocalDateTime getExit() {
		return exit;
	}

	public void setExit(LocalDateTime exit) {
		this.exit = exit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingControl other = (ParkingControl) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
