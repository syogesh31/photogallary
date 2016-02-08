package com.clicker.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class Clicker {
	@NotNull
	String firstName;
	
	@NotNull
	String lastName;
	
	@Email
	String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
