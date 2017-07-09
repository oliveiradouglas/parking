package com.oliveiradouglas.parking.model;

import java.util.List;

public class VehicleBrand {
	private String name;
	private int id;
	private List<VehicleModel> models;

	public VehicleBrand(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setModels(List<VehicleModel> models) {
		this.models = models;
	}

	public List<VehicleModel> getModels() {
		return models;
	}
}
