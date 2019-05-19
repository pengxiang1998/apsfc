/**
 * 
 */
package com.java.service;

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
public interface ITypeSrevice {
	List<Types> getTypesAll();
	int addTypes(Types types);
	/*
	 * 添加类别
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
