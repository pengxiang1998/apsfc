/**
 * 
 */
package com.java.dao;

import com.java.pojo.Admin;

/** 
 * 类描述：管理员数据访问接口
 * 作者： pengxiang 
 * 创建日期：2019年5月13日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public interface IAdminDao {
	//实体类即数据映射
	/**
	 * 方法描述：管理员登录
	 * @param name 用户名
	 * @param pwd
	 * @return Admin
	 */
	Admin login(String name,String pwd);
	/**
	 * 
	 * 方法描述：修改管理员信息
	 * @param admin 用户名和密码
	 * @return 影响的行数
	 */
	
	int updateAdmin(Admin admin);
	
	/**
	 * 
	 * 方法描述：根据用户名查询
	 * @param name 用户名
	 * @return 用户信息
	 */
	Admin getAdminName(String name);
	

}
