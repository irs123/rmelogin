package com.community.loginSignup.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.community.login.Signup.enums.UserType;

public class RegisterationRequestDto {
	
	private String userName;
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String country;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserType userType;
		
	public RegisterationRequestDto() {
		
	}
	public RegisterationRequestDto(String userName, String email, String firstName, String lastName, String phoneNumber,
			String country, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.country = country;
		this.password = password;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
