package com.clicker.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(prefix="clicker.security" ,name="profile.activation.enabled" , havingValue =  "false", matchIfMissing=true)
public class StanderdPreAuthCheck extends AccountStatusUserDetailsChecker {

}
