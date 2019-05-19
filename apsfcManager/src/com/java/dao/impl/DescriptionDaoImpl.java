/**
 * 
 */
package com.java.dao.impl;

import java.util.List;

import com.java.dao.IDescriptionDao;
import com.java.pojo.Description;
import com.java.pojo.Send;
import com.java.pojo.Types;
import com.java.util.DBUtil;

/** 
 * 类描述：
 * 作者： wujinxiao 
 * 创建日期：2019年5月17日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class DescriptionDaoImpl implements IDescriptionDao {
	  
	  
      
	DBUtil dbutil=new DBUtil();
	/* (non-Javadoc)
	 * @see com.java.dao.IDescriptionDao#desFindAll()
	 */
	@Override
		public List<Description> desFindAll() {
			
			String sql="select * from description";
			List des=null;
			try {
				des=dbutil.getQueryList(Description.class, sql, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return des;
		}
	public List<Send> sendFindAll() {
		
		String sql="select * from send";
		List send=null;
		try {
			send=dbutil.getQueryList(Send.class, sql, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return send;
	}
}
