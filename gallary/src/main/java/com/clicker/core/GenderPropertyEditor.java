package com.clicker.core;

import java.beans.PropertyEditorSupport;

import com.clicker.model.Gender;

public class GenderPropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(Gender.fromCode(text));
	}
	
	@Override
	public String getAsText() {
			Gender gender = (Gender) getValue();
			return gender.getCode();
	}

}
