package com.community.loginSignup.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;



public class Encryption {
	@Autowired
	private static SessionFactory sessionFactory;

	private static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public static String getEncryptedPassword(String password) throws NoSuchAlgorithmException {

		MessageDigest messageDigest = MessageDigest.getInstance("MD5");

		messageDigest.update(password.getBytes());

		byte byteData[] = messageDigest.digest();

		StringBuffer stringBuffer = new StringBuffer();

		for (int i = 0; i < byteData.length; i++) {
			stringBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));

		}

		return stringBuffer.toString();

	}
}
