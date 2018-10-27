package com.mavenDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mavenDemo.Model.UserDTO;
import com.mavenDemo.repository.LoginRepository;
import com.mavenDemo.repository.RegistrationRepository;

@Repository
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	public void checkLogin(UserDTO userDto) {

		System.out.println("Inside Registration service");
		System.out.println(userDto.getUserId());
		System.out.println(userDto.getFirstName());
		System.out.println(userDto.getLastName());
		System.out.println(userDto.getEmailId());
		System.out.println(userDto.getPassword());
		System.out.println(userDto.getMobileNo());
		registrationRepository.checkLogin(userDto);
	}
}
