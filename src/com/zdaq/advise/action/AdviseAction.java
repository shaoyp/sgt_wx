package com.zdaq.advise.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.zdaq.advise.service.AdviseService;
import com.zdaq.common.action.BaseAction;
import com.zdaq.fastWx.util.AccessToken;
import com.zdaq.fastWx.util.WeiXinConstant;
import com.zdaq.fastWx.util.WeixinUtil;

public class AdviseAction extends BaseAction{
	Logger logger = Logger.getLogger(AdviseAction.class);
	private static final long serialVersionUID = -7513329891384487766L;
	private String advise; //建议意见信息
	private String openid;
	private Map<String,Object> map = new HashMap<String,Object>();  //接收参数
	private AdviseService service = new AdviseService();
	/**
	 * 插入意见建议信息
	 * 
	 * */
	public String insertAdvise(){
			System.out.println("---------------advise action:"+advise+",openid:"+openid);
			logger.info("---------------advise action:"+advise+",openid:"+openid);
			map.put("advise", advise);
			//service.insert(map);
			//---------------------------测试客服接口-------------------------
			int code = sendMessage(openid);
			System.out.println("code:"+code);
			logger.info("code:"+code);
			
			//---------------------------The End--------------------------
		return "success";
	}
	private static String send_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	private int sendMessage(String openid){
		// 第三方用户唯一凭证
		String appId = WeiXinConstant.APPID;
		// 第三方用户唯一凭证密钥
		String appSecret = WeiXinConstant.APPSECRET;
		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
		
		
		int result = 0;
		// 拼装创建客服的url
		String url = send_url.replace("ACCESS_TOKEN", at.getToken());
		// 将客服对象转换成json字符串
		//String jsonKefu = JSONObject.fromObject(kf).toString();
		String jsonSend = "{\"touser\":\""+openid+"\",\"msgtype\":\"text\",\"text\":{\"content\":\"您好，有什么可以帮助你的？\"}}";
		// 调用接口创建菜单
		JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", jsonSend);
		System.out.println("json:" + jsonObject);
		logger.info("json:" + jsonObject);
		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				System.out.println("发送微信消息失败 errcode:{} errmsg:{}"
						+ jsonObject.getInt("errcode")
						+ jsonObject.getString("errmsg"));
				logger.info("发送微信消息失败 errcode:{} errmsg:{}"
						+ jsonObject.getInt("errcode")
						+ jsonObject.getString("errmsg"));
			}
		}

		return result;
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
