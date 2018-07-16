package com.community.loginSignup.services;

import com.community.loginSignup.dto.RegisterationRequestDto;

public interface RegisterationService {

	
	public void register(RegisterationRequestDto registerationRequestDto);
	public void verifyEmail(String email)throws Exception;
	public void verifyUserName(String userName)throws Exception;
	public void verifyPhoneNumber(String phoneNumber) throws Exception;
}