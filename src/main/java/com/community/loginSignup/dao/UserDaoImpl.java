package com.community.loginSignup.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.community.loginSignup.model.RmeUser;

import org.hibernate.Criteria;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void register(RmeUser rmeUser) {
		getCurrentSession().save(rmeUser);
	}
	
	@Override
	public void checkEmailExist(String email) throws Exception {
		List<RmeUser> list1 = getCurrentSession().createQuery("from RmeUser where email = :email")
				.setString("email", email).list();
		if (!list1.isEmpty())
			throw new Exception("Email Address Already Exist");
	}
	@Override
	public void checkUserNameExist(String userName) throws Exception {
		List<RmeUser> list2 = getCurrentSession().createQuery("from RmeUser where userName =:userName")
				.setString("userName", userName).list();
		if(!list2.isEmpty())
			throw new Exception("User Name already Exists");
		
	}
	@Override
	public void checkphoneNumberExist(String phoneNumber) throws Exception {
		List<RmeUser> list3 = getCurrentSession().createQuery("from RmeUser where phoneNumber =: phoneNumber")
				.setString("phoneNumber", phoneNumber).list();
		if(!list3.isEmpty())
			throw new Exception("Phone Number Already Exists");
		
	}
}