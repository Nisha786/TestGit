package com.mavenDemo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mavenDemo.Model.UserDTO;

@Controller
public class Logout {

	@RequestMapping("/Logout")
	public String showLogin(Map<String, Object> map, HttpServletRequest request) throws InterruptedException {
		System.out.println("logout");
		System.out.println("Before session remove " + request.getSession().getAttribute("userInfo"));
		request.getSession().invalidate();
		System.out.println("After Session remove " + request.getSession().getAttribute("userInfo"));
		map.put("loginData", new UserDTO());
		return "login";
	}
}
