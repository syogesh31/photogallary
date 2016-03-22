package com.clicker.security;

import org.springframework.security.authentication.AccountStatusException;

public class AccountNotActivatedException extends AccountStatusException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8904290985407650064L;

	public AccountNotActivatedException(String msg) {
		super(msg);
	}

}
