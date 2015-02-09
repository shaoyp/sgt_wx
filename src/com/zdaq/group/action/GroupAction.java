package com.zdaq.group.action;

import java.io.PrintWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.zdaq.common.action.BaseAction;
import com.zdaq.fastWx.util.WeixinUtil;

public class GroupAction extends BaseAction{
	private static final long serialVersionUID = 5886683194446528824L;
	Logger logger = Logger.getLogger(GroupAction.class);
	private String openid = null; //获取openid
	public String execute(){
		try {
			//获取openId
			openid = WeixinUtil.getOpenId(request,response);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e);
		}
		return "success";
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
}
