package com.clicker.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


@Component
@ConditionalOnProperty(prefix="clicker.security" ,name="email.activation.enabled" , havingValue="true", matchIfMissing=false)
public class ActivationBasedPreAuthChecks extends AccountStatusUserDetailsChecker {

	@Override
	public void check(UserDetails user) {
		super.check(user);
		AuthUser authUser = (AuthUser) user;
		if (authUser.isActive()== null || !authUser.isActive()) {
			throw new AccountNotActivatedException("User is not yet activated. Kindly proceed with activation process before login");
		}
		
	}
	
}
