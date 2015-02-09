package com.zdaq.advise.model;

import java.io.Serializable;

/**
 * 意见建议
 * 
 * */
public class Advise implements Serializable{
	private static final long serialVersionUID = -494550649103841127L;
	private String id; //建议id
	private String user_id; //用户id
	private String advise; //建议内容
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
	public String getAdvise() {
		return advise;
	}
	public void setAdvise(String advise) {
		this.advise = advise;
	}
	
}
