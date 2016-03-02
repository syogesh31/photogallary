package com.clicker.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class Clicker {
	
	
	@NotNull
	String userName;
	
	@NotNull
	String password;
	
	@NotNull
	Gender gender;
	
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
