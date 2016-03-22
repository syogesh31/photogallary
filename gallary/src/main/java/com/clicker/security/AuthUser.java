package com.clicker.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.clicker.model.Clicker;

public class AuthUser extends User {
	
	/**
	 * Class for authentication checks
	 */
	private static final long serialVersionUID = -5766479416362505323L;
	final Boolean active;

	public AuthUser(Clicker clicker,
			Collection<? extends GrantedAuthority> authorities) {
		super(clicker.getUserName(), clicker.getPassword(),authorities);
		active = clicker.isActive();
	}

	public Boolean isActive() {
		return active;
	}

}
