/**
 * 
 */
package com.java.dao.impl;

import java.util.List;

import com.java.dao.ITypeDao;
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
public class TypeDaoImpl implements ITypeDao {
	DBUtil dbutil=new DBUtil();

	/* (non-Javadoc)
	 * @see com.java.dao.ITypeDao#getTypesAll()
	 */
	@Override
	public List<Types> getTypesAll() {
		// TODO Auto-generated method stub
		String sql="select * from types";
		List list=null;
		try {
			list=dbutil.getQueryList(Types.class, sql, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.java.dao.ITypeDao#addTypes(com.java.pojo.Types)
	 */
	@Override
	public int addTypes(Types types) {
		// TODO Auto-generated method stub
		String sql="insert into types(name) values(?)";
		Object[] objs={types.getName()};
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
	 * @see com.java.dao.ITypeDao#getTYpesByName(java.lang.String)
	 */
	public Types getTypesByName(String name) {
		// TODO Auto-generated method stub
		String sql="select * from types where name=?";
		Object[] objs={name};
		Types types=null;
		try {
			types=(Types)dbutil.getObject(Types.class, sql, objs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return types;
	}

	/* (non-Javadoc)
	 * @see com.java.dao.ITypeDao#updateTypes(com.java.pojo.Types)
	 */
	@Override
	public int updateTypes(Types types) {
		// TODO Auto-generated method stub
		String sql="update types set name=? where id=?";
		Object[] objs={types.getName(),types.getId()};
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
	 * @see com.java.dao.ITypeDao#getTypesById(int)
	 */
	@Override
	public Types getTypesById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from types where id=?";
		Object[] objs={id};
		Types types=null;
		try {
			types=(Types)dbutil.getObject(Types.class, sql, objs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return types;
	}

	/* (non-Javadoc)
	 * @see com.java.dao.ITypeDao#deleteTypes(int)
	 */
	@Override
	public int deleteTypes(int id) {
		// TODO Auto-generated method stub
		String sql="delete from types where id=?";
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
	 * @see com.java.dao.ITypeDao#getTypesByName(java.lang.String)
	 */
	

}
