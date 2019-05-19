/**
 * 
 */
package com.java.dao.impl;

import com.java.dao.IOrderDao;
import com.java.pojo.MenusInfo;
import com.java.pojo.Orders;
import com.java.pojo.OrdersInfo;
import com.java.util.DBUtil;
import com.java.util.Page;
import com.java.util.Page1;

/** 
 * 类描述：
 * 作者： pengxiang 
 * 创建日期：2019年5月16日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class OrderDaoImpl implements IOrderDao {
	DBUtil dbutil=new DBUtil();
	/* (non-Javadoc)
	 * @see com.java.dao.IOrderDao#addOrders(com.java.pojo.Orders)
	 */
	@Override
	public int addOrders(Orders orders) {
		// TODO Auto-generated method stub
		String sql="insert into orders(userid,menuid,menusum,times,delivery) values(?,?,?,?,?)";
		Object[] obj={orders.getId(),orders.getMenuid(),orders.getMenusum(),orders.getTimes(),orders.getDelivery()};
		int result=0;
		try {
			result=dbutil.execute(DBUtil.getConnection(), sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	/* (non-Javadoc)
	 * @see com.java.dao.IOrderDao#getOrderAll(com.java.util.Page)
	 */
	@Override
	public Page getOrderAll(Page page) {
		// TODO Auto-generated method stub
		String sql="select orders.id id,userid,users.realname,users.phone,users.address,menus.name menuname,orders.menusum,menus.price,orders.times,delivery from orders inner join users on orders.userid=users.id inner join menus on orders.menuid=menus.id";
		Page page1=null;
		
			page1 = dbutil.getQueryPage(Orders.class, sql, null, page);
		
		return page1;
	}
	/* (non-Javadoc)
	 * @see com.java.dao.IOrderDao#getOrderByID(com.java.util.Page, java.lang.String)
	 */
	@Override
	public Page getOrderByID(Page page, String userid) {
		// TODO Auto-generated method stub
		String sql="select userid,users.realname,users.phone,users.address,menus.name menuname,orders.menusum,menus.price,orders.times,delivery from orders inner join users on orders.userid=users.id inner join menus on orders.menuid=menus.id where users.name=? order by orders.times desc";
		Page page1=null;
		Object[] obj={userid};
		
			//page1 = dbutil.getQueryPage(Orders.class, sql, null, page);
			page1=dbutil.getQueryPage(Orders.class, sql, obj, page);
		
		return page1;
	}
	@Override
	public Page getOrderByMenuName(Page page, String userid, String menuname) {
		// TODO Auto-generated method stub
		String sql="select users.realname,users.phone,users.address,menus.name menuname,orders.menusum,menus.price,orders.times,delivery from orders inner join users on orders.userid=users.id inner join menus on orders.menuid=menus.id where users.name=? and menus.name like '%"+menuname+"%'";
		Page page1=null;
		Object[] obj={userid};
		
			//page1 = dbutil.getQueryPage(Orders.class, sql, null, page);
			page1=dbutil.getQueryPage(Orders.class, sql, obj, page);
		
		return page1;
	}
	@Override
	public int deleteOrder(int id) {
		// TODO Auto-generated method stub
		String sql="delete from orders where id=?";
		Object[] objs={id};
		int result=0;
		try {
			result=dbutil.execute(sql, objs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public int updateDelivery(int id) {
		// TODO Auto-generated method stub
		String sql="update orders set delivery=? where id=?";
		Object[] objs={"是",id};
		int result=0;
		try {
			result=dbutil.execute(sql, objs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public Page1 getOrderAll1(Page1 page) {
		// TODO Auto-generated method stub
		String sql="select orders.id id,userid,users.realname,users.phone,users.address,menus.name menuname,orders.menusum,menus.price,orders.times,delivery from orders inner join users on orders.userid=users.id inner join menus on orders.menuid=menus.id";
		Page1 page1=null;
		
			page1 = dbutil.getQueryPage1(Orders.class, sql, null, page);
		
		return page1;
	}
	
}
