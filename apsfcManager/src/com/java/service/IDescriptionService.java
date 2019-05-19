/**
 * 
 */
package com.java.service;

import java.util.List;

import com.java.pojo.Description;
import com.java.pojo.Send;

/** 
 * 类描述：
 * 作者： wujinxiao 
 * 创建日期：2019年5月17日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public interface IDescriptionService {

	
	/**
	 * 
	 * 方法描述：查询配送说明
	 * @return 所有说明信息
	 */
	List<Send> sendFindAll();
	
	/**
	 * 
	 * 方法描述：查询"关于我们"说明
	 * @return 所有说明信息
	 */
	List<Description> desFindAll();
	
	
	
}
