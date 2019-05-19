package com.java.dao.impl;

import com.java.dao.IUserDao;
import com.java.pojo.User;
import com.java.util.DBUtil;

public class UserDaoImpl implements IUserDao {
     DBUtil dbutil=new DBUtil();
     public int updateUser(User user) {
 		// TODO Auto-generated method stub
 		String sql="update users set name=?,pwd=?,realname=?,sex=?,age=?,card=?,address=?,phone=?,email=?,code=? where id=?";
 		Object[] param={user.getName(),user.getPwd(),user.getRealname(),user.getSex(),user.getAge(),user.getCard(),user.getAddress(),user.getPhone(),user.getEmail(),user.getCode(),user.getId()};
 		int result=0;
 		try {
 			result=dbutil.execute(sql, param);
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return result;
 	}
 	/* (non-Javadoc)
 	 * @see com.java.dao.IUserDao#getUserById(int)
 	 */
 	@Override
 	public User getUserById(int id) {
 		// TODO Auto-generated method stub
 		String sql="select * from users where id=?";
 		Object[] param={id};
 		User user=null;
 		try {
 			user= (User) dbutil.getObject(User.class, sql, param);
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return user;
 	}

	@Override
	//登录
	public User login(String name, String pwd) {
		String sql="select * from users where name=? and pwd=?";
		Object[] objects={name,pwd};
		User user=null;
		try {
			user=(User)dbutil.getObject(User.class, sql, objects);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public int  register(User user) {
		String sql="insert into users(name,pwd,realname,sex,age,card,address,phone,email,code,type) values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] objs={user.getName(),user.getPwd(),user.getRealname(),user.getSex(),user.getAge(),user.getCard(),user.getAddress(),user.getPhone(),user.getEmail(),user.getCode(),user.getType()};
		int result=0;
		try {
			result=dbutil.execute(sql, objs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


}
