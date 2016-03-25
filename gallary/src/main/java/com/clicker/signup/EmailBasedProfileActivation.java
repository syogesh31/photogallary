package com.clicker.signup;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.clicker.model.Clicker;

@Service
@ConditionalOnProperty(prefix="clicker.security" ,name="email.activation.enabled" , havingValue="true", matchIfMissing=false)
public class EmailBasedProfileActivation implements ProfileActivator {
	
//	Autoconfigure  Mail
	
	@Override
	public	void configureProfileAndContactUser(Clicker  clicker){
		clicker.setActive(false);
		// Send email with UUID code.
		
	}
	
}
