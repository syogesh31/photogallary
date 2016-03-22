package com.clicker.reference;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clicker.model.Gender;

@Service
public class UiReferentialService {
	
	public List<Gender> getGenderList() {
		return  Gender.Options;
	}
}
