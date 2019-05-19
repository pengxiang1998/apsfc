/**
 * 
 */
package com.java.service.impl;

import java.util.List;

import com.java.dao.IMenusDao;
import com.java.dao.impl.MenusDaoImpl;
import com.java.pojo.Admin;
import com.java.pojo.Menus;
import com.java.service.IMenusService;
import com.java.util.Page;

/** 
 * 类描述：
 * 作者： pengxiang 
 * 创建日期：2019年5月15日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class MenusServiceImpl implements IMenusService {

	/* (non-Javadoc)
	 * @see com.java.service.IMenusService#getMenusAll(com.java.util.Page)
	 */
	IMenusDao menusDao=new MenusDaoImpl();
	@Override
	public List<Menus> getMenusAll() {
		// TODO Auto-generated method stub
		return menusDao.getMenusAll();
	}

	@Override
	public Page getMenusAll(Page page) {
		// TODO Auto-generated method stub
		return menusDao.getMenusAll(page);
	}
	/* (non-Javadoc)
	 * @see com.java.service.IMenusService#deleteTypes(int)
	 */
	/* (non-Javadoc)
	 * @see com.java.service.IMenusService#deleteMenus(int)
	 */
	@Override
	public int deleteMenus(String name) {
		// TODO Auto-generated method stub
		return menusDao.deleteMenus(name);
	}
	/* (non-Javadoc)
	 * @see com.java.service.IMenusService#getMenusByName(java.lang.String)
	 */
	
	/* (non-Javadoc)
	 * @see com.java.service.IMenusService#addMenus(com.java.pojo.Menus)
	 */
	@Override
	public int addMenus(Menus menus) {
		// TODO Auto-generated method stub
		//查询菜品名是否已存在
		Menus m=menusDao.getMenusByName(menus.getName());
		if(m!=null){
			return -1;
		}
		return menusDao.addMenus(menus);
	}
	/* (non-Javadoc)
	 * @see com.java.service.IMenusService#getMenusByID(int)
	 */
	@Override
	public Menus getMenusByID(int id) {
		// TODO Auto-generated method stub
		return menusDao.getMenusByID(id);
	}
	/* (non-Javadoc)
	 * @see com.java.service.IMenusService#updateMenus(com.java.pojo.Menus)
	 */
	@Override
	public int updateMenus(Menus menus) {
		// TODO Auto-generated method stub
		Menus ad=menusDao.getMenusByID(menus.getId());
		//如果ad不等于空，且name相等，id不相等，不可以修改
		if(ad!=null&&(menus.getName().equals(ad.getName()))&&(ad.getId()!=menus.getId())){
			return -1;
			
		}
		return menusDao.updateMenus(menus);
	}
	

}
