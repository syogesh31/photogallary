package com.clicker.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.clicker.core.GenderDbConverter;

@Entity
@Table(name="CLKR")
public class Clicker {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	String uid;
	
	@Column(name="UNAME")
	@NotEmpty(message="Please provide the Username")
	String userName;
	
	@Column(name="PASSWORD")
	@NotEmpty(message="Please provide the password")
	String password;
	
	@Column(name="GENDER")
	@Convert(converter=GenderDbConverter.class)
	@NotNull(message="Please select the gender")
	Gender gender;
	
	@Column(name="FNAME")
	@NotEmpty(message="Please provide First name")
	String firstName;
	
	@Column(name="LNAME")
	@NotEmpty(message="Please provide Last name")
	String lastName;
	
	@Column(name="EMAIL")
	@NotEmpty(message="Please provide Email address")
	@Email
	String email;

	@Column(name="ENABLED")
	Boolean active;
	
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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean enabled) {
		this.active = enabled;
	}
}
