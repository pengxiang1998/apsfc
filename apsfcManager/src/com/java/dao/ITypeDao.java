/**
 * 
 */
package com.java.dao;

import java.util.List;

import com.java.pojo.Types;

/** 
 * 类描述：
 * 作者： pengxiang 
 * 创建日期：2019年5月14日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public interface ITypeDao {
	/**
	 * 查询所有类别信息
	 * 方法描述：
	 * @return所有类别信息
	 */
	List<Types> getTypesAll();
	/**
	 * 
	 * 方法描述：添加类别
	 * @param types name 类别名称
	 * @return 类别信息
	 */
	int addTypes(Types types);
	Types getTypesByName(String name);
	/**
	 * 
	 * 方法描述：修改类别
	 * @param types 类别信息
	 * @return
	 */
	int updateTypes(Types types);
	Types getTypesById(int id);
	/**
	 * 删除类别
	 * 方法描述：
	 * @param id
	 * @return 影响的行数
	 */
	int deleteTypes(int id);
	

}
