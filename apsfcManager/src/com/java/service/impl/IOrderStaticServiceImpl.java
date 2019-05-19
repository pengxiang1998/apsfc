/**
 * 
 */
package com.java.service.impl;

import com.java.dao.IOrderStatistic;
import com.java.dao.impl.IOrderStaticImpl;
import com.java.pojo.OrderStatistics;
import com.java.service.IOrderService;
import com.java.service.IOrderStaticService;
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
public class IOrderStaticServiceImpl implements IOrderStaticService {
	IOrderStatistic orderDao=new IOrderStaticImpl();
	/* (non-Javadoc)
	 * @see com.java.service.IOrderStaticService#getOrderAll(com.java.util.Page)
	 */
	@Override
	public Page getOrderAll(Page page) {
		// TODO Auto-generated method stub
		return orderDao.getOrderAll(page);
	}

}
