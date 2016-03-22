package com.clicker.security;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;

public class ClickerPreAuthChecks extends AccountStatusUserDetailsChecker {

	@Override
	public void check(UserDetails user) {
		super.check(user);
		AuthUser authUser = (AuthUser) user;
		if (authUser.isActive()== null || !authUser.isActive()) {
			throw new AccountNotActivatedException("User is not yet activated. Kindly proceed with activation process before login");
		}
		
	}
	
}
