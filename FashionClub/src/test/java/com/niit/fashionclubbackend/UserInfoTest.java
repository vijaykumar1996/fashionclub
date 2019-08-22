package com.niit.fashionclubbackend;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bean.UserInfo;
import com.niit.dao.UserInfoDao;

public class UserInfoTest {
	@Autowired
	static UserInfoDao userinfoDao;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    userinfoDao=(UserInfoDao) context.getBean("userinfoDao");
}
	@Ignore
	@Test
	public void adduserinfo(){
		UserInfo u=new UserInfo();
		u.setCustomerName("vijay");
		u.setCustomerAddr("hyd");
		u.setRole("manager");
		u.setUsername("kumar");
		u.setEnabled(true);
		u.setPassword("nuuu");
		assertTrue("Problem in adding the userinfo",userinfoDao.adduserinfo(u));
	}
}