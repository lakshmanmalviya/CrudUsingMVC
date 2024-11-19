package com.abhiyantrikitech.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abhiyantrikitech.dto.LoginRequest;
import com.abhiyantrikitech.dto.SignupRequest;
import com.abhiyantrikitech.dto.UserDto;
import com.abhiyantrikitech.service.UserService;

@Controller
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService authService;

	@RequestMapping("/")
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String processSignInPageData(ModelMap model, @ModelAttribute("LoginRequest") LoginRequest loginReq) {
		UserDto user = authService.loginUser(loginReq, model);
		if (user != null) {
			model.put("loginDetails", user);
			return "home";
		}
		return "login";
	}

	@RequestMapping("/signup")
	public String showSignupPage() {
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String processSignupPageData(ModelMap model, @ModelAttribute("SignupRequest") SignupRequest signupReq) {
		return authService.createUser(signupReq, model).get();
	}

	@RequestMapping(value = "/home")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUserInformation(ModelMap model, @ModelAttribute("User") UserDto userReq) {
		UserDto user = authService.updateUser(userReq, model);
		if (user != null) {
			model.put("loginDetails", user);
			model.put("success", "updated the details successfully");
		}
		return "home";
	}

	@RequestMapping(value = "/about")
	public String about() {
		return "about";
	}

	@RequestMapping(value = "/contact")
	public String contact() {
		return "contact";
	}
}
