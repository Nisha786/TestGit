package com.mavenDemo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mavenDemo.Model.UserDTO;
import com.mavenDemo.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
	public String showLogin(Map<String, Object> map) throws InterruptedException {
		System.out.println("++++++++Login page++++++++");
 		map.put("loginData", new UserDTO());
		UserDTO userDto = new UserDTO();
		System.out.println("++++++++mmmmmmmmmmSOP is added by Nirmala Deviji++++++++");
		
		System.out.println("++++++++SOP is added by Nirmala Deviji++++++++");
		System.out.println("++++++++SOP is added by Rahul ++++++++");

		return "login";
	}

	@RequestMapping(value = "/verifyLogin", method = RequestMethod.POST)
	public String signInAction(@ModelAttribute("loginData") UserDTO userDto, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("Inside loginController");
		System.out.println(userDto.getEmailId());
		System.out.println(userDto.getPassword());

		List<UserDTO> u = loginService.userSignIn(userDto);
		if (u != null) {

			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userDto.getEmailId());
			System.out.println(request.getSession().getAttribute("userInfo"));
			return "welcome";
		} else {
			return "login";
		}
	}

}
