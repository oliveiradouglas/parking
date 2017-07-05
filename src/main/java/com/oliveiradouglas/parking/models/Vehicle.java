package com.oliveiradouglas.parking.models;

public class Vehicle {
	private int id;
	private Color color;
	private VehicleModel model;
	private String vehiclePlate;

	public Vehicle(Color color, VehicleModel model, String vehiclePlate) {
		this.color = color;
		this.model = model;
		this.vehiclePlate = vehiclePlate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Color getColor() {
		return color;
	}

	public VehicleModel getModel() {
		return model;
	}

	public String getVehiclePlate() {
		return vehiclePlate;
	}
}
