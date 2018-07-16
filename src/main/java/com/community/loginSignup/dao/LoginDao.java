package com.community.loginSignup.dao;

import com.community.loginSignup.dto.LoginRequestDto;

public interface LoginDao {
	
	public boolean getLogin(LoginRequestDto loginRequestDto) throws Exception;
	public String getUuid(LoginRequestDto loginRequestDto);

}
