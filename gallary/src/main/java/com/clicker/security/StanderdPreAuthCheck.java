package com.clicker.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix="clicker.security" ,name="email.activation.enabled" , havingValue =  "false", matchIfMissing=true)
public class StanderdPreAuthCheck extends AccountStatusUserDetailsChecker {

}
