package com.java.service.impl;

import com.java.dao.IUserDao;
import com.java.dao.impl.UserDaoImpl;
import com.java.pojo.User;
import com.java.service.IUserService;

public class UserServiceImpl implements IUserService {
	IUserDao userdao=new UserDaoImpl();

	@Override
	public User login(String name, String pwd) {
		// TODO Auto-generated method stub
		return userdao.login(name, pwd);
	}
	@Override
	public int register(User user) {
		
		return userdao.register(user);
	}
	public int updateUser(User user) {
		return userdao.updateUser(user);
}

	public User getUserById(int id) {
	// TODO Auto-generated method stub
	return userdao.getUserById(id);
}


}
