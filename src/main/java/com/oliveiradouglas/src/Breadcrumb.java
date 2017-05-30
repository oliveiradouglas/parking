package com.oliveiradouglas.src;

public class Breadcrumb {
	private String link;
	private String text;
	private boolean active;
	
	public Breadcrumb(String link, String text, boolean active) {
		this.link = link;
		this.text = text;
		this.active = active;
	}

	public String getLink() {
		return link;
	}

	public String getText() {
		return text;
	}

	public boolean isActive() {
		return active;
	}
}
