package com.clicker.signup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clicker.model.Clicker;
import com.clicker.repositories.ClickerRepository;
import com.clicker.security.EmailExistException;
import com.clicker.security.UserIdExistException;

@Service
@Transactional
public class ClickerServiceImpl implements ClickerService {

	@Autowired
	ClickerRepository clickerRepository;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public void addClicker(Clicker clicker) throws UserIdExistException,EmailExistException {
		hashPassword(clicker);
		
		List<Clicker> c = clickerRepository.findClickerByEmail(clicker.getEmail());
		if(!c.isEmpty()){
			throw new EmailExistException("Email id "+clicker.getEmail()+" exist in System");
		}
		
		c = clickerRepository.findClickerByUserName(clicker.getUserName());
		
		if(!c.isEmpty()){
			throw new UserIdExistException("User id "+clicker.getUid()+" exist in system");
		}
		clickerRepository.save(clicker);
	}

	
	
	private void hashPassword(Clicker clicker) {
				clicker.setPassword(encoder.encode(clicker.getPassword()));
	}

}
