package com.niit.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.bean.UserInfo;
import com.niit.dao.UserInfoDao;
@Repository("userinfoDao") 
@Transactional
public class UserInfoDaoImpl implements UserInfoDao {
@Autowired
SessionFactory sessionfactory;
	public boolean adduserinfo(UserInfo userinfo) {
		try{
		sessionfactory.getCurrentSession().save(userinfo);	
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
	public boolean updateAddress(UserInfo user) {
		try
        {
        sessionfactory.getCurrentSession().update(user);
        return true;
        }
        catch(Exception e)
        {
        return false;
        }
}

	public UserInfo getUser(String username) {
		{
		    Session session=sessionfactory.openSession();
	        UserInfo user=session.get(UserInfo.class,username); 
	        session.close();
			return user;
	}
}
}
