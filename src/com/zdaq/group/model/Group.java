package com.zdaq.group.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 团购信息
 * 
 * */
public class Group implements Serializable{
	private static final long serialVersionUID = -5058383918255957285L;
	private int id; //id
	private String name; //名字
	private double price; //价格
	private double discount_private; //折后价格
	private int people_num; //团购人数
	private int num; // 机器数量
	private Date dead_line; //截止日期
	private String img; //图片地址
	private String del_flg;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount_private() {
		return discount_private;
	}
	public void setDiscount_private(double discount_private) {
		this.discount_private = discount_private;
	}
	public int getPeople_num() {
		return people_num;
	}
	public void setPeople_num(int people_num) {
		this.people_num = people_num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getDead_line() {
		return dead_line;
	}
	public void setDead_line(Date dead_line) {
		this.dead_line = dead_line;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	
}
