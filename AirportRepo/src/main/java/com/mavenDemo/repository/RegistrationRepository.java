package com.mavenDemo.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mavenDemo.Model.UserDTO;

@Repository
public class RegistrationRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public boolean checkLogin(UserDTO userDto) {
		System.out.println("Inside Registration repository");
		System.out.println(userDto.getFirstName());
		System.out.println(userDto.getLastName());
		System.out.println(userDto.getEmailId());
		System.out.println(userDto.getPassword());
		System.out.println(userDto.getMobileNo());
		
		if(userDto != null) {
			hibernateTemplate.save(userDto);
			return true;
		} else {
			return false;
		}
	}

		public List<UserDTO> checkEmail(String emailId) {

		List<UserDTO> list = hibernateTemplate.find("from UserDTO userDto where userDto.emailId=?", emailId);
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			UserDTO userDto = (UserDTO) itr.next();
			emailId = userDto.getEmailId();
		}
		return list;		
		
	} 

}
