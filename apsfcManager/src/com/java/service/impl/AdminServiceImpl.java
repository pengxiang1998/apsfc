/**
 * 
 */
package com.java.service.impl;

import com.java.dao.IAdminDao;
import com.java.dao.impl.AdminDaoImpl;
import com.java.pojo.Admin;
import com.java.service.IAdminService;

/** 
 * 类描述：
 * 作者： pengxiang 
 * 创建日期：2019年5月13日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class AdminServiceImpl implements IAdminService {

	/* (non-Javadoc)
	 * @see com.java.service.IAdminService#login(java.lang.String, java.lang.String)
	 */
	//多态
	IAdminDao admindao=new AdminDaoImpl();
	public Admin login(String name, String pwd) {
		// TODO Auto-generated method stub
		return admindao.login(name, pwd);
	}
	/* (non-Javadoc)
	 * @see com.java.service.IAdminService#updateAdmin(com.java.pojo.Admin)
	 */
	@Override
	public int updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Admin ad=admindao.getAdminName(admin.getName());
		//如果ad不等于空，且name相等，id不相等，不可以修改
		if(ad!=null&&(admin.getName().equals(ad.getName()))&&(ad.getId()!=admin.getId())){
			return -1;
			
		}
		return admindao.updateAdmin(admin);
	}

}
