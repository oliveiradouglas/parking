package com.oliveiradouglas.parking.model;

public class Color {
	private String name;
	private int id;

	public Color(String name) {
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
}
