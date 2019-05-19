/**
 * 
 */
package com.java.service;

import java.util.List;

import com.java.dao.IOrderDao;
import com.java.dao.impl.OrderDaoImpl;
import com.java.pojo.ShoppingCart;
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
public interface IOrderService {
	/**
	 * 
	 * 方法描述：添加订单
	 * @param list 购物车信息
	 * @param userid
	 * @return 影响的行数
	 * @throws Exception
	 */
	
	boolean addOrders(List<ShoppingCart> list,int userid)throws Exception;
	Page getOrderAll(Page page);
	Page1 getOrderAll1(Page1 page);
	Page getOrderByID(Page page, String userid);
	 Page getOrderByMenuName(Page page, String userid, String menuname);
	int deleteOrder(int id);
	int updateDelivery(int id);

}
