package com.clicker.signup;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clicker.model.Clicker;
import com.clicker.referance.UiReferentialService;


@Controller
public class SignupController {
	
	private  UiReferentialService uiService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String register(@ModelAttribute("clicker") Clicker clicker,	BindingResult br) {
		return "registration";

	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String saveuser(@Valid @ModelAttribute("clicker") Clicker clicker,	BindingResult br) {
			if (br.hasErrors())			return "registration";
			return "thanksClicker";
	}
	
	@ModelAttribute("ui")
	public UiReferentialService getUiService() {
		return uiService;
	}

	@Autowired
	public void setUiService(UiReferentialService uiService) {
		this.uiService = uiService;
	}
	

}
