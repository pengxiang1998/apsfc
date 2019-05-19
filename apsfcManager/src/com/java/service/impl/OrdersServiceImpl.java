/**
 * 
 */
package com.java.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.java.dao.IOrderDao;
import com.java.dao.impl.OrderDaoImpl;
import com.java.pojo.Orders;
import com.java.pojo.ShoppingCart;
import com.java.service.IOrderService;
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
public class OrdersServiceImpl implements IOrderService {
	IOrderDao orderDao=new OrderDaoImpl();
	/* (non-Javadoc)
	 * @see com.java.service.IOrderService#addOrders(java.util.List, int)
	 */
	@Override
	public boolean addOrders(List<ShoppingCart> list, int userid)
			throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			//开启事务
			DBUtil.beginTranscation();
			//2循环添加
			for (ShoppingCart cart : list) {
				Orders orders = new Orders();
				orders.setId(userid);
				orders.setMenuid(cart.getMenuid());
				orders.setMenuname(cart.getName());
				orders.setMenusum(String.valueOf(cart.getSum()));
				orders.setPrice(String.valueOf(cart.getPrice()));
				//下单时间
				orders.setTimes(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date()));
				orders.setDelivery("否");
				//调用添加方法
				orderDao.addOrders(orders);
				//3.
			}
			//提交事务
			DBUtil.endTranscation();
			flag=true;//表示添加成功
		} catch (Exception e) {
			// TODO: handle exception
			//回滚事务
			DBUtil.rollback();
			e.printStackTrace();
		}finally{
			//释放资源，关闭连接
			DBUtil.closeConn();
		}
		return flag;
	}
	/* (non-Javadoc)
	 * @see com.java.service.IOrderService#getOrderAll(com.java.util.Page)
	 */
	/* (non-Javadoc)
	 * @see com.java.service.IOrderService#getOrderAll(com.java.util.Page)
	 */
	@Override
	public Page getOrderAll(Page page) {
		// TODO Auto-generated method stub
		return orderDao.getOrderAll(page);
	}
	@Override
	public Page1 getOrderAll1(Page1 page) {
		// TODO Auto-generated method stub
		return orderDao.getOrderAll1(page);
	}
	/* (non-Javadoc)
	 * @see com.java.service.IOrderService#getOrderByID(com.java.util.Page, java.lang.String)
	 */
	@Override
	public Page getOrderByID(Page page, String userid) {
		// TODO Auto-generated method stub
		return orderDao.getOrderByID(page,userid);
	}
	@Override
	public Page getOrderByMenuName(Page page, String userid, String menuname) {
		// TODO Auto-generated method stub
		return orderDao.getOrderByMenuName(page,userid,menuname);
	}
	@Override
	public int deleteOrder(int id) {
		// TODO Auto-generated method stub
		return orderDao.deleteOrder(id);
	}
	@Override
	public int updateDelivery(int id) {
		// TODO Auto-generated method stub
		return orderDao.updateDelivery(id);
	}
	
	
}
