package com.zdaq.advise.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;


import com.zdaq.advise.service.AdviseService;
import com.zdaq.common.action.BaseAction;
import com.zdaq.fastWx.util.WeixinUtil;

public class AdviseAction extends BaseAction{
	Logger logger = Logger.getLogger(AdviseAction.class);
	private static final long serialVersionUID = -7513329891384487766L;
	private String advise; //建议意见信息
	private String openid;
	private Map<String,Object> map = new HashMap<String,Object>();  //接收参数
	private AdviseService service = new AdviseService();
	public String show(){
		//获取openid
		openid = WeixinUtil.getOpenId(request, response);
		return "show";
	}
	public String insertAdvise(){
			map.put("advise", advise);
			map.put("openid", openid);
			int result = service.insert(map);
		return "insertAdvise";
	}

	
	public String getAdvise() {
		return advise;
	}
	public void setAdvise(String advise) {
		this.advise = advise;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
}
