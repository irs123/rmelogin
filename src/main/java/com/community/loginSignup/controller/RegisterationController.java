package com.community.loginSignup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.community.loginSignup.dto.ErrorResponseDto;
import com.community.loginSignup.dto.RegisterationRequestDto;
import com.community.loginSignup.services.RegisterationService;
import com.community.loginSignup.utils.Validator;



@Controller
public class RegisterationController {
	
	@Autowired
	RegisterationService registerationService;
	
	@PostMapping(value="/register")
	ResponseEntity<Object> registeration(HttpSession httpSession , @ModelAttribute("requestdto") RegisterationRequestDto registerationRequestDto){
		
			ErrorResponseDto er = Validator.registerRequestValidator(registerationRequestDto);
			if(er !=null){
				return ResponseEntity.badRequest().body(er);
			}
		try {
			System.out.println(registerationRequestDto);
			registerationService.register(registerationRequestDto);
			return ResponseEntity.ok().body(registerationRequestDto);
		
		}catch (Exception e) {
			
			return ResponseEntity.badRequest().body(e);
		}
	}
	
	@PostMapping(value="verifyEmail")
	ResponseEntity<Object> verifyEmail(HttpSession httpSession , @ModelAttribute("email") String email){
		
		try {
			
			registerationService.verifyEmail(email);
			return ResponseEntity.ok().body(true);
		
		}catch (Exception e) {
			e.printStackTrace();
			ErrorResponseDto er = new ErrorResponseDto();
			er.getMsg().add(e.getMessage());
			return ResponseEntity.badRequest().body(er);
		}
	}
	
	
	@PostMapping(value = "verifyUserName")
	ResponseEntity<Object> verifyUserName(HttpSession httpSession, @ModelAttribute("userName") String userName){
		
		try {
			  registerationService.verifyUserName(userName);
			  return ResponseEntity.ok().body(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			ErrorResponseDto er = new ErrorResponseDto();
			er.getMsg().add(e.getMessage());
			return ResponseEntity.badRequest().body(er);
		}
	}
	
	@PostMapping(value = "verifyPhoneNumber")
	ResponseEntity<Object> verifyMobile(HttpSession httpSession , @ModelAttribute("phoneNumber") String phoneNumber ){
		try {
			  registerationService.verifyPhoneNumber(phoneNumber);
			  return ResponseEntity.ok().body(true);
			
		}catch(Exception e) {
			e.printStackTrace();
			ErrorResponseDto er = new ErrorResponseDto();
			er.getMsg().add(e.getMessage());
			return ResponseEntity.badRequest().body(er);
		}
		
		
		
	}

}



