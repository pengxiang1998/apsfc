package com.java.dao;

import com.java.pojo.User;

public interface IUserDao {
 
	//登录
	User login(String name,String pwd);
	int  register(User user);
	int updateUser(User user);
	
	User getUserById(int id);




}
