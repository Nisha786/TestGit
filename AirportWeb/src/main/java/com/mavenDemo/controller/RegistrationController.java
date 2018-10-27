package com.mavenDemo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mavenDemo.Model.UserDTO;
import com.mavenDemo.service.RegistrationService;
import com.mavenDemo.validator.RegistrationValidator;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationValidator registrationvalidator;

	@Autowired
	private RegistrationService registrationService;

	@RequestMapping("/registration")
	public String showRegistration(Map<String, Object> map){
		System.out.println("Inside Registration Controller");
		map.put("registrationData", new UserDTO());
		return "registration";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public String userSignInAction(@ModelAttribute("registrationData") UserDTO userDto, Map<String, Object> map,
			BindingResult result) {
		boolean status = false;
		if (result.hasErrors()) {

			return "registration";
		} else {
			System.out.println("registration page");
			System.out.println(userDto.getFirstName());
			System.out.println(userDto.getLastName());
			System.out.println(userDto.getEmailId());
			System.out.println(userDto.getPassword());
			System.out.println(userDto.getMobileNo());
			
			
		} 
		registrationvalidator.validate(userDto, result);
		System.out.println("validate call");
		registrationService.checkLogin(userDto);
		
		return "registration";
	}
}
