package com.clicker.core;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clicker.model.Clicker;
import com.clicker.reference.UiReferentialService;
import com.clicker.signup.ClickerService;

@Service
public abstract class BaseController {
	
	@Autowired
	private  UiReferentialService uiService;
	
	@Autowired
	private  ClickerService clickerService; 
	
	public ClickerService getClickerService() {
		return clickerService;
	}

	@RequestMapping("/{design}")
	public String design(@PathVariable String design){
		return design;
	}
	
	@RequestMapping("/signup")
	public String signup(@Valid Clicker clicker, BindingResult br) {
		return "signup";
	}
	
	@ModelAttribute("ui")
	public UiReferentialService getUiService() {
		return uiService;
	}
	

	@RequestMapping({"/","/index"})
	public String home(){
		return "index";
	}
	
	
}
