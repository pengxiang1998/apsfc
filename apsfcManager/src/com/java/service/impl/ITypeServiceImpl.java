/**
 * 
 */
package com.java.service.impl;

import java.util.List;

import com.java.dao.ITypeDao;
import com.java.dao.impl.TypeDaoImpl;
import com.java.pojo.Types;
import com.java.service.ITypeSrevice;

/** 
 * 类描述：
 * 作者： pengxiang 
 * 创建日期：2019年5月14日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class ITypeServiceImpl implements ITypeSrevice {
	ITypeDao typesDao=new TypeDaoImpl();
	/* (non-Javadoc)
	 * @see com.java.service.ITypeSrevice#getTypesAll()
	 */
	@Override
	public List<Types> getTypesAll() {
		// TODO Auto-generated method stub
		return typesDao.getTypesAll();
	}
	/* (non-Javadoc)
	 * @see com.java.service.ITypeSrevice#addTypes(com.java.pojo.Types)
	 */
	@Override
	public int addTypes(Types types) {
		// TODO Auto-generated method stub
		//1调用根据类别名查询
		Types type= typesDao.getTypesByName(types.getName());
		if(type!=null){
			return -1;
		}
		return typesDao.addTypes(types);//相反则直接调用相应方法即可，即使用方法自己的返回值
	}
	/* (non-Javadoc)
	 * @see com.java.service.ITypeSrevice#updateTypes(com.java.pojo.Types)
	 */
	@Override
	public int updateTypes(Types types) {
		// TODO Auto-generated method stub
		//1根据ID查询
		Types type=typesDao.getTypesById(types.getId());
		//若查出的name与元相同
		if(type.getName().equals(types.getName())){
			return 1;
		}
		Types type1=typesDao.getTypesByName(types.getName());
		if(type1!=null){
			return -1;
		}
		return typesDao.updateTypes(types);
	}
	/* (non-Javadoc)
	 * @see com.java.service.ITypeSrevice#getTypesById(int)
	 */
	@Override
	public Types getTypesById(int id) {
		// TODO Auto-generated method stub
		return typesDao.getTypesById(id);
	}
	/* (non-Javadoc)
	 * @see com.java.service.ITypeSrevice#deleteTypes(int)
	 */
	@Override
	public int deleteTypes(int id) {
		// TODO Auto-generated method stub
		return typesDao.deleteTypes(id);
	}
	
	
	

}
