package com.oliveiradouglas.parking.models;

public class Setting {
	private int id;
	private String parkingName;
	private double firstHourValue;
	private double otherHoursValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParkingName() {
		return parkingName;
	}

	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}

	public double getFirstHourValue() {
		return firstHourValue;
	}

	public void setFirstHourValue(double firstHourValue) {
		this.firstHourValue = firstHourValue;
	}

	public double getOtherHoursValue() {
		return otherHoursValue;
	}

	public void setOtherHoursValue(double otherHoursValue) {
		this.otherHoursValue = otherHoursValue;
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
		Setting other = (Setting) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
