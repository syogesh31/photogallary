package com.clicker.signup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clicker.core.BaseController;
import com.clicker.core.GenderPropertyEditor;
import com.clicker.model.Clicker;
import com.clicker.model.Gender;
import com.clicker.security.EmailExistException;
import com.clicker.security.UserIdExistException;


@Controller
public class SignupController extends  BaseController{
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String register(@ModelAttribute("clicker") Clicker clicker,	BindingResult br) {
		return "registration";

	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("clicker") Clicker clicker,	BindingResult br) {
			if (br.hasErrors())
				return "registration";
			
			try {
				getClickerService().addClicker(clicker);
			} catch (UserIdExistException e) {
				br.rejectValue("userName", "User Id already Exist. Please choose other UserId");
			} catch (EmailExistException e) {
				br.rejectValue("email", "Email Id already Exist. Click here to recover your account");
			}
			
			if (br.hasErrors())
				return "registration";
			
			return "thanksClicker";
	}
	
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "logout";
	}
	
	@RequestMapping(value="/accessdenied")
	public String getFailurePage(Model model,HttpSession session) {
		Exception e = (Exception) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		model.addAttribute("loginError", "true");
		return "login";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Gender.class, new GenderPropertyEditor());
	}
}
