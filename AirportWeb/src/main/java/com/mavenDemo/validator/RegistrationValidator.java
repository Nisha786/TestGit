package com.mavenDemo.validator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mavenDemo.Model.UserDTO;
import com.mavenDemo.repository.RegistrationRepository;

@Component
public class RegistrationValidator implements Validator {

	@Autowired
	private RegistrationRepository registrationRepository;

	public boolean supports(Class<?> clazz) {
		System.out.println("inside suports");
		return UserDTO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		UserDTO userDto = (UserDTO) target;
		System.out.println("Inside validate");
		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.firstName.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.lastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "emailId", "error.emailId.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "mobileNo", "error.mobileNo.empty");

		if (userDto.getFirstName() != null && userDto.getFirstName().trim().length() > 10) {
			errors.rejectValue("firstName", "error.firstName.length");
		}
		if (userDto.getLastName() != null && userDto.getLastName().trim().length() > 10) {
			errors.rejectValue("lastName", "error.lastName.length");
		}

		if (userDto.getEmailId().contains("@gmail.com") != true) {
			errors.rejectValue("emailId", "error.emailId.first.rule");
		}

		List<UserDTO> emailList = registrationRepository.checkEmail(userDto.getEmailId());
		if (emailList.size() > 0) {
			errors.rejectValue("emailId", "error.emailId.info");
		}

		if (userDto.getPassword() != null && userDto.getPassword().trim().length() > 16
				&& userDto.getPassword().trim().length() < 6) {
			errors.rejectValue("password", "error.password.length");
		}

		if (userDto.getMobileNo() != null && userDto.getMobileNo().toString().length() != 10) {
			errors.rejectValue("mobileNo", "error.mobileNo.first.rule");
		}
	}

}
