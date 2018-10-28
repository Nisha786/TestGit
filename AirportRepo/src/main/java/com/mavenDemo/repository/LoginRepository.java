package com.mavenDemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mavenDemo.*;
import com.mavenDemo.Model.UserDTO;

@Repository
public class LoginRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<UserDTO> userSignIn(String emailId, String password) {

		System.out.println("inside Login repository");
		if (emailId != null && password != null) {

			@SuppressWarnings("unchecked")
			List<UserDTO> userDto = hibernateTemplate
					.find("from UserDTO usrDto where usrDto.emailId = ? and usrDto.password = ?", emailId, password);
			return userDto;
		} else {

			return null;
		}
	}

/*	public void userSignIn(UserDTO userDto) {

		System.out.println("Inside loginRepository");
		System.out.println(userDto.getEmailId());
		System.out.println(userDto.getPassword());

	} */

}
