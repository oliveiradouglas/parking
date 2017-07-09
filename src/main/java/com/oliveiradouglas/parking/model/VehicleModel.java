package com.oliveiradouglas.parking.model;

import com.oliveiradouglas.parking.enums.VehicleModelType;

public class VehicleModel {
	private VehicleBrand brand;
	private String description;
	private VehicleModelType type;
	private int id;

	public VehicleModel(String description, VehicleModelType type) {
		this.description = description;
		this.type = type;
	}

	public VehicleBrand getBrand() {
		return brand;
	}
	
	public void setBrand(VehicleBrand brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public VehicleModelType getType() {
		return type;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
