package com.community.loginSignup.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.community.loginSignup.dto.LoginRequestDto;
import com.community.loginSignup.model.RmeUser;
import com.community.loginSignup.utils.Encryption;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean getLogin(LoginRequestDto loginRequestDto) throws Exception {
		boolean result = false;

		Criteria crit = getCurrentSession().createCriteria(RmeUser.class);
		crit.add(Restrictions.eq("userName", loginRequestDto.getUserName()));
		List<RmeUser> results = crit.list();
		System.out.println(results.size());
		if (results.isEmpty())
			throw new Exception("Invalid Username");
		if(results.get(0).getPassword()
				.equals(Encryption.getEncryptedPassword(loginRequestDto.getPassword()))) {
			return true;
		}
		return false;
	}

	@Override
	public String getUuid(LoginRequestDto loginRequestDto) {
	
		RmeUser rmeUser = null;
		Criteria crit = getCurrentSession().createCriteria(RmeUser.class);
		crit.add(Restrictions.eq("userName",loginRequestDto.getUserName()));
		List<RmeUser> results = crit.list();
		System.out.println(results.get(0).getUserId());
		 return results.get(0).getUserName();
		
		 
	}

}
