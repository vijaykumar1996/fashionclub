package com.niit.dao;

import com.niit.bean.UserInfo;

public interface UserInfoDao {
public boolean adduserinfo(UserInfo userinfo);
public boolean updateAddress(UserInfo user);
		public UserInfo getUser(String username);
}
