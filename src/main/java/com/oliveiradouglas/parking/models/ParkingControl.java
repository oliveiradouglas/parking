package com.oliveiradouglas.parking.models;

import java.util.Date;

public class ParkingControl {
	private int id;
	private Vehicle vehicle;
	private Color color;
	private String vehiclePlate;
	private String notes;
	private Date entry;
	private Date exit;

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
