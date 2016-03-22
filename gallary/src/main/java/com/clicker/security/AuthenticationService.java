package com.clicker.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clicker.model.Clicker;
import com.clicker.repositories.ClickerRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	Collection<? extends GrantedAuthority> DEFAULT_AUTHORITIES = Arrays.asList(new SimpleGrantedAuthority("ROLE_CLICKER"));
	
	@Autowired
	ClickerRepository clickerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		Clicker clicker = clickerRepository.findFirstClickerByUserName(username);
		
		if(clicker == null){
			throw new UsernameNotFoundException(username + " not found in System.");
		}
			
		return new AuthUser(clicker, DEFAULT_AUTHORITIES);
		
	}
	
}
