package com.community.loginSignup.services;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.loginSignup.dao.UserDao;
import com.community.loginSignup.dto.RegisterationRequestDto;
import com.community.loginSignup.model.RmeUser;
import com.community.loginSignup.utils.Encryption;


@Service
public class RegisterationServiceImpl implements RegisterationService  {

	@Autowired
	UserDao dao;

	@Override
	@Transactional
	public void register(RegisterationRequestDto registerationRequestDto) {
		try {
			
			RmeUser rmeUser = new RmeUser();
			
		
			

			UUID uuid = UUID.randomUUID();
			String randomUUIDString = uuid.toString();

			rmeUser.setUserName(registerationRequestDto.getUserName());
			rmeUser.setEmail(registerationRequestDto.getEmail());
			rmeUser.setFirstName(registerationRequestDto.getFirstName());
			rmeUser.setLastName(registerationRequestDto.getLastName());
			rmeUser.setUserType(registerationRequestDto.getUserType());
			rmeUser.setPhoneNo(registerationRequestDto.getPhoneNumber());

			rmeUser.setCountry(registerationRequestDto.getCountry());
			rmeUser.setPassword(Encryption.getEncryptedPassword(registerationRequestDto.getPassword()));

			dao.register(rmeUser);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void verifyEmail(String email)throws Exception {
		try {
			dao.checkEmailExist(email);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Transactional
	public void verifyUserName(String userName) throws Exception {
	   try {
		   dao.checkUserNameExist(userName);
	   }catch(Exception e) {
		   throw new Exception(e.getMessage());
	   }
		
	}
	@Transactional
	public void verifyPhoneNumber(String phoneNumber) throws Exception{
		try {
			dao.checkphoneNumberExist(phoneNumber);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}


