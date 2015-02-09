package com.zdaq.group.model;

import java.io.Serializable;
/**
 * 团购订单
 * 
 */
public class GroupOrder implements Serializable{
	private static final long serialVersionUID = -6834899933726031560L;
	private int id; // 信息id
	private String user_id; // 用户id
	private String nun; // 团购数量
	private double price; // 团购价格

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getNun() {
		return nun;
	}
	public void setNun(String nun) {
		this.nun = nun;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
}
