package com.clicker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.clicker.security.AuthenticationService;
import com.clicker.security.ActivationBasedPreAuthChecks;

@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private AccountStatusUserDetailsChecker  accountStatusUserDetailsChecker;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		
		ObjectPostProcessor<DaoAuthenticationProvider> objectPostProcessor = new ObjectPostProcessor<DaoAuthenticationProvider>() {
			@Override
			public <O extends DaoAuthenticationProvider> O postProcess(O object) {
				object.setPreAuthenticationChecks(accountStatusUserDetailsChecker);
				return object;
			}
		};
		
		auth.userDetailsService(authenticationService).passwordEncoder(encoder).addObjectPostProcessor(objectPostProcessor);;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().				
				antMatchers("/registration","/login","/logout","/").permitAll().
				anyRequest().authenticated().
				and().
			formLogin().defaultSuccessUrl("/"). //TODO:  This should  be  USER  Homepage after login
				loginPage("/login").permitAll().
				failureUrl("/accessdenied").
				and().
			logout().logoutSuccessUrl("/");
	}
	
	

}
