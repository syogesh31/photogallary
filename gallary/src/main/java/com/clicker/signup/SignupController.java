package com.clicker.signup;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clicker.model.Clicker;


@Controller
public class SignupController {
	
	
	@RequestMapping("/signup")
	public String signup(@Valid Clicker clicker,BindingResult br) {
		return  "signup";

	}
	
	@RequestMapping(value="/saveclicker", method=RequestMethod.POST )
	public String saveuser(@Valid Clicker clicker,BindingResult br) {
		if(br.hasErrors()) return "signup";
		
		return  "thanksClicker";
	}
	
	
	@ModelAttribute("fnPh")
	String getFnPh(){
		return "First Name";
	}

	@ModelAttribute("lnPh")
	String getLnPh(){
		return "Last Name";
	}
	
	@ModelAttribute("emailPh")
	String getEmailPh(){
		return "Email";
	}
}