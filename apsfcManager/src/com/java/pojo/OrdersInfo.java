package com.java.pojo;

/*
 * 分布式查询订单实体类
 */
public class OrdersInfo {
	//用户编号
	private int userid;
	
	//菜品名称
	private String meunname;
	
	//日期
	private String date;
	
	//派送状态
	private int delivery=-1;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getMeunname() {
		return meunname;
	}

	public void setMeunname(String meunname) {
		this.meunname = meunname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDelivery() {
		return delivery;
	}

	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	
}
