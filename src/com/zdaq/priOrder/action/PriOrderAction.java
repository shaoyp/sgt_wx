package com.zdaq.priOrder.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zdaq.common.action.BaseAction;
import com.zdaq.fastWx.util.WeixinUtil;
import com.zdaq.priOrder.service.PriOrderService;

/**
 * 私人定制
 * 
 * */
public class PriOrderAction extends BaseAction{
	private static final long serialVersionUID = -656222972046741474L;
	Logger logger = Logger.getLogger(PriOrderAction.class);
	private PriOrderService service = new PriOrderService();
	Map<String, Object> map = new HashMap<String,Object>(); //参数集
	private String priContent;
	private String openid;
	public String show(){
		//获取openid
		openid = WeixinUtil.getOpenId(request, response);
		return "show";
	}
	public String order(){
		map.put("priContent", priContent);
		map.put("openid", openid);
		int count = service.insert(map);
		int result = WeixinUtil.sendMessage(openid);
		return "order";
	}
	public String getPriContent() {
		return priContent;
	}
	public void setPriContent(String priContent) {
		this.priContent = priContent;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
}
