package com.community.loginSignup.dao;

import com.community.loginSignup.model.RmeUser;

public interface UserDao {

   public void register(RmeUser rmeUser);
   
   public void checkEmailExist(String email) throws Exception;
   
   public void checkUserNameExist(String userName) throws Exception;
   
   public void checkphoneNumberExist(String phoneNumber) throws Exception;
  // public void community(RmeUserService rmeUserService) throws Exception;
   
}

