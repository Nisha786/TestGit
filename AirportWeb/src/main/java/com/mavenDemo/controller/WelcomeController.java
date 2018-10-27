package com.mavenDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/Welcome")
	public String showLogin() throws InterruptedException {
		System.out.println("welcome page");
		// map.put("login Data", new UserDTO());
		return "Welcome";
	}
}
