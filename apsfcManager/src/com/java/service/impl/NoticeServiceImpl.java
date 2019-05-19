/**
 * 
 */
package com.java.service.impl;

import java.util.List;

import com.java.dao.INoticeDao;
import com.java.dao.ITypeDao;
import com.java.dao.impl.NoticeDaoImpl;
import com.java.dao.impl.TypeDaoImpl;
import com.java.pojo.Notice;
import com.java.pojo.Types;
import com.java.service.INoticeService;

/** 
 * 类描述：
 * 作者： pengxiang 
 * 创建日期：2019年5月14日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class NoticeServiceImpl implements INoticeService {
	INoticeDao noticeDao=new NoticeDaoImpl();
	/* (non-Javadoc)
	 * @see com.java.service.INoticeService#getTypesAll()
	 */

	/* (non-Javadoc)
	 * @see com.java.service.INoticeService#getNoticeAll()
	 */
	@Override
	public List<Notice> getNoticeAll() {
		// TODO Auto-generated method stub
		return noticeDao.getNoticeAll();
	}

	
	@Override
	public Notice getNoticeById(int id) {
		// TODO Auto-generated method stub
		return noticeDao.getNoticeById(id);
	}

	/* (non-Javadoc)
	 * @see com.java.service.INoticeService#deleteTypes(int)
	 */
	@Override
	public int deleteNotice(int id) {
		// TODO Auto-generated method stub
		return noticeDao.deleteNotice(id);
	}


	/* (non-Javadoc)
	 * @see com.java.service.INoticeService#deleteTypes(int)
	 */
	@Override
	public int deleteTypes(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	/* (non-Javadoc)
	 * @see com.java.service.INoticeService#addNotice(com.java.pojo.Notice)
	 */
	@Override
	public int addNotice(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.addNotice(notice);
	}

	/* (non-Javadoc)
	 * @see com.java.service.INoticeService#deleteTypes(int)
	 */
	public Notice noticeDetails(int id){
		return noticeDao.getNoticeById(id);
	}

	
	

}
