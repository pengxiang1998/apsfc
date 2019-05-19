/**
 * 
 */
package com.java.dao.impl;

import java.util.List;

import com.java.dao.IMenusDao;
import com.java.pojo.Menus;
import com.java.pojo.MenusInfo;
import com.java.pojo.Notice;
import com.java.pojo.Types;
import com.java.util.DBUtil;
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
public class MenusDaoImpl implements IMenusDao {
	DBUtil dbutil=new DBUtil();
	/* (non-Javadoc)
	 * @see com.java.dao.IMenusDao#getMenusAll(com.java.util.Page)
	 */
	@Override
	public List<Menus> getMenusAll() {
		String sql="select menus.id, menus.name,imgpath,burden,types.name as typename,brief,price1,sums1,price,sums from menus inner JOIN types on types.id=menus.typeid ORDER BY sums1 desc LIMIT 0,4 ";
		List list=null;
		try {
			list=dbutil.getQueryList(Menus.class, sql, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Page getMenusAll(Page page) {
		// TODO Auto-generated method stub
		String sql="select menus.id, menus.name,imgpath,burden,types.name as typename,brief,price1,sums1,price,sums from menus inner join types on types.id=menus.typeid";
		Page page1=null;
		
			page1 = dbutil.getQueryPage(MenusInfo.class, sql, null, page);
		
		return page1;
	}
	/* (non-Javadoc)
	 * @see com.java.dao.IMenusDao#deleteTypes(int)
	 */
	@Override
	public int deleteMenus(String name) {
		// TODO Auto-generated method stub
		String sql="delete from menus where name=?";
		Object[] objs={name};
		int result=0;
		try {
			result=dbutil.execute(sql, objs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see com.java.dao.IMenusDao#addMenus(com.java.pojo.Menus)
	 */
	@Override
	public int addMenus(Menus menus) {
		// TODO Auto-generated method stub
		String sql="insert into menus(name,burden,price,price1,brief,typeid,imgpath) values(?,?,?,?,?,?,?)";
		Object[]obj={menus.getName(),menus.getBurden(),menus.getPrice(),menus.getPrice1(),menus.getBrief(),menus.getTypeid(),menus.getImgpath()};
		int result=0;
		try {
			result=dbutil.execute(sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see com.java.dao.IMenusDao#getMenusByName(java.lang.String)
	 */
	@Override
	public Menus getMenusByName(String name) {
		// TODO Auto-generated method stub
		String sql="select * from menus where name=?";
		Object[] obj={name};
		Menus menus=null;
		try {
			menus=(Menus) dbutil.getObject(Menus.class, sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menus;
	}
	/* (non-Javadoc)
	 * @see com.java.dao.IMenusDao#updateTypes(com.java.pojo.Types)
	 */
	/* (non-Javadoc)
	 * @see com.java.dao.IMenusDao#updateMenus(com.java.pojo.Menus)
	 */
	@Override
	public int updateMenus(Menus menus) {
		// TODO Auto-generated method stub
String sql="update menus set name=?,burden=?,price=?,price1=?,brief=?,typeid=? where id=?";
		
		Object[] paramList={menus.getName(),menus.getBurden(),menus.getPrice(),menus.getPrice1(),menus.getBrief(),menus.getTypeid(),menus.getId()};
		int result=0;
		try {
			result=dbutil.execute(sql, paramList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	/* (non-Javadoc)
	 * @see com.java.dao.IMenusDao#getMenusByID(int)
	 */
	@Override
	public Menus getMenusByID(int id)  {
		// TODO Auto-generated method stub
		String sql="select * from menus where id=?";
		Object[] obj={id};
		Menus menus=null;
		try {
			 menus=(Menus) dbutil.getObject(Menus.class, sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menus;
	}

	
	

}
