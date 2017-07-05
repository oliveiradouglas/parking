package com.oliveiradouglas.parking.models;

public class VehicleModel {
	private int id;
	private String description;
	
	public VehicleModel(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
}
