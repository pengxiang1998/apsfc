/**
 * 
 */
package com.java.service;

import com.java.pojo.Admin;

/** 
 * 类描述：管理员业务逻辑处理接口
 * 作者： pengxiang 
 * 创建日期：2019年5月13日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public interface IAdminService {
	Admin login(String name,String pwd);
	/**
	 * 
	 * 方法描述：修改管理员信息
	 * @param admin
	 * @return
	 */
	int updateAdmin(Admin admin);
}
