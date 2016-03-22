package com.clicker.signup;

import com.clicker.model.Clicker;
import com.clicker.security.EmailExistException;
import com.clicker.security.UserIdExistException;

public interface ClickerService {

	void addClicker(Clicker  clicker) throws UserIdExistException,EmailExistException;
}
