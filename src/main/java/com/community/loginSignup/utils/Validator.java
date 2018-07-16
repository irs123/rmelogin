package com.community.loginSignup.utils;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.community.loginSignup.dto.ErrorResponseDto;
import com.community.loginSignup.dto.LoginRequestDto;
import com.community.loginSignup.dto.RegisterationRequestDto;

public  class Validator {

	static boolean isEmpty(String str) {
		return StringUtils.isEmpty(str);
	}
	
	
	public static ErrorResponseDto registerRequestValidator(RegisterationRequestDto dto) {
		
		ErrorResponseDto er = new ErrorResponseDto();
		/*if(isEmpty((dto.getType()))
			er.getMsg().add("User Name cannot be empty");
*/
		if(isEmpty(dto.getUserName()))
			er.getMsg().add("User Name cannot be empty");
		if(isEmpty(dto.getFirstName()))
			er.getMsg().add("First name cannot be empty");
		if(isEmpty(dto.getLastName()))
			er.getMsg().add("Last name cannot be empty");
		if(isEmpty(dto.getEmail()))
			er.getMsg().add("Email cannot be empty");
		if(isEmpty(dto.getPassword()))
			er.getMsg().add("Password cannot be empty");
		if(isEmpty(dto.getPhoneNumber()))
			er.getMsg().add("Mobile number cannot be empty");
		if(isEmpty(dto.getCountry()))
			er.getMsg().add("Country Can not be empty");
		if (er.getMsg().isEmpty())
			return null;

		return er;
	}
	
	public static ErrorResponseDto loginRequestValidator(LoginRequestDto dto) {
		
	   ErrorResponseDto er = new ErrorResponseDto();
	   
	   if(isEmpty(dto.getUserName()))
		   er.getMsg().add("User name cannot be empty");
	   if(isEmpty(dto.getPassword()))
		   er.getMsg().add("Password cannot be empty");
	   if(er.getMsg().isEmpty())
		   return null;
	   return er;
	}
}
