/**
 * 
 */
package com.java.dao.impl;

import com.java.dao.IOrderStatistic;
import com.java.pojo.OrderStatistics;
import com.java.pojo.Orders;
import com.java.util.DBUtil;
import com.java.util.Page;

/** 
 * 类描述：
 * 作者： pengxiang 
 * 创建日期：2019年5月17日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class IOrderStaticImpl implements IOrderStatistic {
	DBUtil dbutil=new DBUtil();
	/* (non-Javadoc)
	 * @see com.java.dao.IOrderStatistic#getOrderAll(com.java.util.Page)
	 */
	@Override
	public Page getOrderAll(Page page) {
		// TODO Auto-generated method stub
		String sql="select menus.id menuid ,menus.name menuname,SUM(menusum) sum,menus.price price from menus inner join orders on menus.id=orders.menuid group by menuid ";
		Page page1=null;
		
			page1 = dbutil.getQueryPage(OrderStatistics.class, sql, null, page);
		
		return page1;
	}

}
