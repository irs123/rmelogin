package com.community.loginSignup.services;
import java.security.NoSuchAlgorithmException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.loginSignup.dao.LoginDao;
import com.community.loginSignup.dto.LoginRequestDto;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	 LoginDao dao;

	@Override
	@Transactional
	public boolean getLogin(LoginRequestDto loginRequestDto) throws Exception {
		return dao.getLogin(loginRequestDto);
	}

	@Override
	@Transactional
	public String getUuid(LoginRequestDto loginRequestDto) throws Exception {
		 return dao.getUuid(loginRequestDto);
		
	}

	

}
