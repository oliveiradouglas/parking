package com.oliveiradouglas.parking.models;

public class Setting extends Model {
	private String parkingName;
	private double firstHourValue;
	private double otherHoursValue;

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
}
