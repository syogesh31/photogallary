package com.clicker.security;

public class UserIdExistException extends Exception {
	
	public UserIdExistException(String message) {
			super(message);
	}
}
