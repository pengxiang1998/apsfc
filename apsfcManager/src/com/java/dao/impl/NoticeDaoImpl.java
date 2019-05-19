/**
 * 
 */
package com.java.dao.impl;

import java.util.List;

import com.java.dao.INoticeDao;
import com.java.pojo.Notice;
import com.java.pojo.Types;
import com.java.util.DBUtil;

/** 
 * 类描述：
 * 作者： pengxiang 
 * 创建日期：2019年5月14日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class NoticeDaoImpl implements INoticeDao {
	DBUtil dbutil=new DBUtil();
	
	/* (non-Javadoc)
	 * @see com.java.dao.INoticeDao#getNoticeAll()
	 */
	@Override
	public List<Notice> getNoticeAll() {
		// TODO Auto-generated method stub
		String sql="select * from notice";
		List list=null;
		try {
			list=dbutil.getQueryList(Notice.class, sql, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.java.dao.INoticeDao#deleteTypes(int)
	 */
	

	/* (non-Javadoc)
	 * @see com.java.dao.INoticeDao#getNoticeById(int)
	 */
	@Override
	public Notice getNoticeById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from notice where id=?";
		Object[] objs={id};
		Notice notice=null;
		try {
			notice=(Notice)dbutil.getObject(Notice.class, sql, objs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notice;
	}

	/* (non-Javadoc)
	 * @see com.java.dao.INoticeDao#deleteTypes(int)
	 */
	@Override
	public int deleteNotice(int id) {
		// TODO Auto-generated method stub
		String sql="delete from notice where id=?";
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

	/* (non-Javadoc)
	 * @see com.java.dao.INoticeDao#deleteTypes(int)
	 */
	@Override
	public int deleteTypes(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.java.dao.INoticeDao#addNotice(com.java.pojo.Notice)
	 */
	@Override
	public int addNotice(Notice notice) {
		// TODO Auto-generated method stub
		String sql="insert into notice (name,content,times) values(?,?,?)";
		Object[] objs={notice.getName(),notice.getContent(),notice.getTimes()};
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
	 * @see com.java.dao.INoticeDao#deleteTypes(int)
	 */
	@Override
	public Notice noticeDetails(int id) {
		// TODO Auto-generated method stub
		String sql="select * from notice where id=?";
		Object[] objs={id};
		Notice notice=null;
		try {
			notice=(Notice)dbutil.getObject(Notice.class, sql, objs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

	
}
