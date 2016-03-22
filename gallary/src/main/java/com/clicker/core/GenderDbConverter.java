package com.clicker.core;

import javax.persistence.AttributeConverter;

import com.clicker.model.Gender;

public class GenderDbConverter implements AttributeConverter<Gender, String> {

	@Override
	public String convertToDatabaseColumn(Gender attribute) {
		return attribute.getCode();
	}

	@Override
	public Gender convertToEntityAttribute(String dbData) {
		return Gender.fromCode(dbData);
	}

}
