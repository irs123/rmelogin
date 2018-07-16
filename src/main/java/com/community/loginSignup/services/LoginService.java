package com.community.loginSignup.services;

import com.community.loginSignup.dto.LoginRequestDto;

public interface LoginService {
	public boolean getLogin(LoginRequestDto loginRequestDto) throws Exception;
	
	public String getUuid(LoginRequestDto loginRequestDto) throws Exception;
}
