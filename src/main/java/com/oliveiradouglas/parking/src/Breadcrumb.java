package com.oliveiradouglas.parking.src;

public class Breadcrumb {
	private String link;
	private String messageKey;
	private boolean active;
	
	public Breadcrumb(String link, String messageKey, boolean active) {
		this.link = link;
		this.messageKey = messageKey;
		this.active = active;
	}

	public String getLink() {
		return link;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public boolean isActive() {
		return active;
	}
}
