/**
 * 
 */
package com.java.service;

import java.util.List;

import com.java.pojo.Menus;
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
public interface IMenusService {
	
	/**
	 * 
	 * 方法描述：分页查询菜单
	 * @param page 当前页码
	 * @return 分页的数据
	 */
	
	Page getMenusAll(Page page);
	int deleteMenus(String name);
	//Menus getMenusByName(String name);
	/**
	 * 
	 * 方法描述：添加菜品
	 * @param menus
	 * @return 影响的行数
	 */
	int addMenus(Menus menus);
	Menus getMenusByID(int id);
	int updateMenus(Menus menus);
	List<Menus> getMenusAll();


}
