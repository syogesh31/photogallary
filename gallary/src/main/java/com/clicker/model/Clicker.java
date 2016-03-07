package com.clicker.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Clicker {
	
	
	@NotEmpty(message="Please provide the Username")
	String userName;
	
	@NotEmpty(message="Please provide the password")
	String password;
	
	@NotNull(message="Please select the gender")
	Gender gender;
	
	@NotEmpty(message="Please provide First name")
	String firstName;
	
	@NotEmpty(message="Please provide Last name")
	String lastName;
	
	@NotEmpty(message="Please provide Email address")
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
