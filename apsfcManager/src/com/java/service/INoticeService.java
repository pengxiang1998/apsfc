/**
 * 
 */
package com.java.service;

import java.util.List;

import com.java.pojo.Notice;
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
public interface INoticeService {
	List<Notice> getNoticeAll();
	int deleteTypes(int id);
	
	/** 
	 * 方法描述：
	 * @param id
	 * @return
	 */
	int addNotice(Notice notice);
	int deleteNotice(int id);
	Notice getNoticeById(int id);

}
