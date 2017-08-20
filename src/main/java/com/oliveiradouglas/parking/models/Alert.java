package com.oliveiradouglas.parking.models;

public class Alert {
	public final static String ERROR = "danger";
	public final static String SUCCESS = "success";
	
	private String message;
	private String type;

	public Alert(String message, String type) {
		this.message = message;
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public String getType() {
		return type;
	}
}
