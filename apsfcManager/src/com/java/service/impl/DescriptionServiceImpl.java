/**
 * 
 */
package com.java.service.impl;

import java.util.List;

import com.java.dao.IDescriptionDao;
import com.java.dao.impl.DescriptionDaoImpl;
import com.java.pojo.Description;
import com.java.pojo.Send;
import com.java.service.IDescriptionService;

/** 
 * 类描述：
 * 作者： wujinxiao 
 * 创建日期：2019年5月17日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class DescriptionServiceImpl implements IDescriptionService {
       IDescriptionDao descriptionDao=new DescriptionDaoImpl();
	   IDescriptionDao senddDescriptionDao=new DescriptionDaoImpl();
	public List<Description> desFindAll() {
		
		return descriptionDao.desFindAll();
	}

	/* (non-Javadoc)
	 * @see com.java.service.IDescriptionService#sendFindAll()
	 */
	@Override
	public List<Send> sendFindAll() {
		
		return senddDescriptionDao.sendFindAll();
	}

}
