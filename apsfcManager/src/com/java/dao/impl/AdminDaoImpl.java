/**
 * 
 */
package com.java.dao.impl;

import com.java.dao.IAdminDao;
import com.java.pojo.Admin;
import com.java.util.DBUtil;

/** 
 * 类描述：
 * 作者： pengxiang 
 * 创建日期：2019年5月13日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class AdminDaoImpl implements IAdminDao {
	DBUtil dbutil=new DBUtil();

	
	public Admin login(String name,String pwd) {
		// TODO Auto-generated method stub
		//1.sql语句
		String sql="select * from admin where name=? and pwd=?";
		//参数列表
		Object[] paramList={name,pwd};
		//调用查询方法
		Admin admin=null;
		//执行dbutil的查询操作
		try {
			admin=(Admin) dbutil.getObject(Admin.class, sql, paramList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}

	
	@Override
	public int updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		//1 sql 语句
		String sql="update admin set name=?,pwd=? where id=?";
		
		//2 参数列表
		Object[] paramlist={admin.getName(),admin.getPwd(),admin.getId()};
		//3调用修改方法
		int result=0;
		try {
			result=dbutil.execute(sql, paramlist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	@Override
	public Admin getAdminName(String name) {
		String sql="select * from admin where name=?";
		Object[] paramList={name};
		Admin admin=null;
		try {
			admin=(Admin) dbutil.getObject(Admin.class, sql, paramList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
		// TODO Auto-generated method stub
		
		/*String sql="select * from admin where name=? ";
		//参数列表
		Object[] paramList={name};
		//调用查询方法
		Admin admin=null;
		//执行dbutil的查询操作
		try {
			admin=(Admin) dbutil.getObject(Admin.class, sql, paramList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;*/
	}

	
	

}
