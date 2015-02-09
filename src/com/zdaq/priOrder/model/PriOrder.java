package com.zdaq.priOrder.model;

import java.io.Serializable;
/**
 * 私人定制
 * 
 * */
public class PriOrder implements Serializable{
	private static final long serialVersionUID = -5613634607292636146L;
	private String id; //定制id
	private String user_id; //用户id
	private String order ; //建议内容
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	

}
