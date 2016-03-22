package com.clicker.model;

import java.util.Arrays;
import java.util.List;

public enum Gender  {
	
	MALE("Male","M"),FEMALE("Female","F"),OTHER("Other","O");
	
	private String discription;
	private String code;
	public static List<Gender> Options = Arrays.asList(Gender.values());

	Gender(String discription,String code){
		this.discription = discription ;
		this.code = code;
	}

	public String getDiscription() {
		return discription;
	}

	public String getCode() {
		return code;
	}
	
	public static Gender fromCode(String code) {
		if(code.equalsIgnoreCase("M")) return MALE;
		else if(code.equalsIgnoreCase("F")) return FEMALE;
		return OTHER;
	}
	
}
