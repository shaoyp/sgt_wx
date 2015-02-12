package com.zdaq.group.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zdaq.common.action.BaseAction;
import com.zdaq.fastWx.util.WeixinUtil;
import com.zdaq.group.model.Group;
import com.zdaq.group.service.GroupService;
/**
 * 团购
 * 
 * */
public class GroupAction extends BaseAction{
	private static final long serialVersionUID = 5886683194446528824L;
	Logger logger = Logger.getLogger(GroupAction.class);
	private GroupService service = new GroupService();
	Map<String, Object> map = new HashMap<String,Object>(); //参数集
	private String openid = null; // 获取openid
	private Group group = null; // 团购信息

	private String num = null; //团购数量
	private String price = null; // 团购价格
	public String show(){
		try {
			//获取openId
			openid = WeixinUtil.getOpenId(request,response);
			//根据id获取团购信息
			group = service.getGroup(1);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e);
		}
		return "show";
	}
	public String order(){
		map.put("openid", openid);
		map.put("num", num);
		map.put("price", price);
		int count = service.insert(map);
		int result = WeixinUtil.sendMessage(openid);
		return "order";
	} 
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public GroupService getService() {
		return service;
	}
	public void setService(GroupService service) {
		this.service = service;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
