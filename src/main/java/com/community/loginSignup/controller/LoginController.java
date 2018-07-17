package com.community.loginSignup.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.community.loginSignup.dto.ErrorResponseDto;
import com.community.loginSignup.dto.LoginRequestDto;
import com.community.loginSignup.model.RmeUser;
import com.community.loginSignup.services.LoginService;
import com.community.loginSignup.utils.*;




@RestController()
public class LoginController {

	@Autowired
	LoginService loginService;

	
	@PostMapping(value ="login")
	ResponseEntity<Object> login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginCommunity") LoginRequestDto loginRequestDto) throws Exception{
		    RmeUser rmeUser = null;
		try {
			
			HttpSession session = request.getSession();
			session.setAttribute("uuid",loginService.getUuid(loginRequestDto));
			ErrorResponseDto err = Validator.loginRequestValidator(loginRequestDto);
			if(err!=null)
				return ResponseEntity.badRequest().body(err);
			boolean res = loginService.getLogin(loginRequestDto);
			if(!res)
				return ResponseEntity.badRequest().body("NOt intrested");
			return ResponseEntity.ok().body(loginRequestDto);
		}catch(Exception e) {
			e.printStackTrace();
			ErrorResponseDto er = new ErrorResponseDto();
			er.getMsg().add(e.getMessage());
			return ResponseEntity.badRequest().body(er);
		}
	}

	@RequestMapping(value = "/hello",method=RequestMethod.GET)
	@ResponseBody
	String hello() {
		return "hello";
	}
}
