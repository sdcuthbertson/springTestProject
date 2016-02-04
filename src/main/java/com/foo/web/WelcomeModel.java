package com.foo.web;

import java.io.Serializable;

public class WelcomeModel implements Serializable {

	private static final long serialVersionUID = 6476371764414162135L;

	private String forename;
	private String surname;
	private String message;
	
	public String getForename() {
		return forename;
	}
	
	public void setForename(String forename) {
		this.forename = forename;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
