package com.zdaq.group.action;

import java.io.PrintWriter;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.zdaq.common.action.BaseAction;
import com.zdaq.fastWx.util.WeiXinConstant;
import com.zdaq.fastWx.util.WeixinUtil;

public class GroupAction extends BaseAction{
	private static final long serialVersionUID = 5886683194446528824L;
	Logger logger = Logger.getLogger(GroupAction.class);
	private String get_access_token_url="https://api.weixin.qq.com/sns/oauth2/access_token?" +
	        "appid=APPID" +
	        "&secret=SECRET&" +
	        "code=CODE&grant_type=authorization_code";
	//private String get_userinfo="https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	private String access_token = null; // 获取token
	private String openid = null; //获取openid
	public String execute(){
		System.out.println("进入-----------------------groupaction");
		logger.info("进入-----------------------groupaction");
		// 响应消息
		//PrintWriter out = null;
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			//out = response.getWriter();
			// 获取code
			String code=request.getParameter("code");
			System.out.println("获取code：" + code);
		     logger.info("获取code：" + code);
	        //配置URL
	        get_access_token_url=get_access_token_url.replace("APPID", WeiXinConstant.APPID);
	        get_access_token_url=get_access_token_url.replace("SECRET", WeiXinConstant.APPSECRET);
	        get_access_token_url=get_access_token_url.replace("CODE", code);
	        //发送请求
	        JSONObject jsonObject = WeixinUtil.httpRequest(get_access_token_url, "POST", null);
	        access_token = jsonObject.getString("access_token");
	        openid = jsonObject.getString("openid");
	        System.out.println("获取openid：" + openid + ",token:" + access_token + ",json:" + jsonObject);
	        logger.info("获取openid：" + openid + ",token:" + access_token + ",json:" + jsonObject);
	        //获取返回信息
			if (null != jsonObject) {
				if (0 != jsonObject.getInt("errcode")) {
					jsonObject.getInt("errcode");
					System.out.println("创建菜单失败 errcode:{} errmsg:{}"
							+ jsonObject.getInt("errcode")
						+ jsonObject.getString("errmsg"));
					logger.info("创建菜单失败 errcode:{} errmsg:{}"
							+ jsonObject.getInt("errcode")
						+ jsonObject.getString("errmsg"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
}
