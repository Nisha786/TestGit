package com.mavenDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavenDemo.Model.UserDTO;
import com.mavenDemo.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public List<UserDTO> userSignIn(UserDTO userDto) {

		System.out.println("inside LoginService");
		System.out.println(userDto.getEmailId());
		System.out.println(userDto.getPassword());
		List<UserDTO> list = loginRepository.userSignIn(userDto.getEmailId(), userDto.getPassword());
		if (list != null && !list.isEmpty()) {
			System.out.println("Login Successful..!!");
			return list;

		} else {
			System.out.println("Invalid Username or Password !!");
			return null;
		}

	}
}