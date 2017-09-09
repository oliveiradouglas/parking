package com.oliveiradouglas.parking.models;

public class Vehicle extends Model {
	public static final String CAR = "carros";
	public static final String MOTORCYCLE = "motos";

	private Color color;
	private String type;
	private String brand;
	private String model;
	private String plate;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlate() {
		return plate.substring(0, 3) + "-" + plate.substring(3);
	}

	public void setPlate(String plate) {
		this.plate = plate.replace("-", "");
	}

}
