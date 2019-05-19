/**
 * 
 */
package com.java.dao;

import java.util.List;

import com.java.pojo.Menus;
import com.java.pojo.Notice;
import com.java.pojo.Types;
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
public interface IMenusDao {
	/**
	 * 
	 * 方法描述：分页查询所有菜单
	 * @param page 参数为当前分页的页码
	 * @return 返回分页后的数据。级封装在list中的数据
	 */
	Page getMenusAll(Page page);
	int deleteMenus(String name);
	
	/**
	 * 
	 * 方法描述：根据菜品名称查询
	 * @param name
	 * @return 菜品信息
	 */
	Menus getMenusByName(String name);
	/**
	 * 
	 * 方法描述：添加菜品
	 * @param menus
	 * @return 影响的行数
	 */
	
	int addMenus(Menus menus);
	int updateMenus(Menus menus);
	/**
	 * 
	 * 方法描述：根据菜品ID查询
	 * @param menus id
	 * @return 菜品信息
	 */
	Menus getMenusByID(int id);
	List<Menus> getMenusAll();
	



}
