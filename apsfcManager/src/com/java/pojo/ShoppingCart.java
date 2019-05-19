package com.java.pojo;

/*
 * 购物车实体类
 */
public class ShoppingCart {

	//菜品编号
	private int menuid;
	//菜品名称
	private String name;
	//菜品单价
	private float price;
	//菜品数量
	private int sum;
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
}
