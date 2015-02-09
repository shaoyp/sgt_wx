package com.zdaq.fastWx.service.content;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zdaq.fastWx.event.Menu3Children1;
import com.zdaq.fastWx.event.Menu3Children2;
import com.zdaq.fastWx.event.Menu3Children3;
import com.zdaq.fastWx.event.Menu3Children4;
import com.zdaq.fastWx.message.resp.TextMessage;
import com.zdaq.fastWx.util.MessageUtil;
import com.zdaq.fastWx.util.WeiXinConstant;

public class EventContent extends BaseContent{
	/**
	 * 根据事件回复各类消息
	 * 
	 * @param request
	 * @return
	 */
	final Logger logger = Logger.getLogger(EventContent.class);

	@Override
	public String getContent(Map<String, String> requestMap) {
		String respMessage = "";
		// 默认返回的文本消息内容
		String respContent = "请求处理异常，请稍候尝试！";
		// 事件类型
		String eventType = requestMap.get("Event");
		//按钮编号
		String eventKey = requestMap.get("EventKey");
		//文本
		TextMessage textMessage = null;
		//多客服
/*		KeFuMessage keFuMessage = null;
		TransInfo transInfo = null;*/
		if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
			respContent = "感谢您关注上岗通公众平台-！";
			textMessage = getTextContent(requestMap, respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		}
		// 取消订阅
		else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
			respContent = "真的要离开吗？";
			textMessage = getTextContent(requestMap, respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		}
		// 自定义菜单点击事件
		else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
			//点击第三个菜单中的第一项 
			if(eventKey.equals(WeiXinConstant.MENU3_CHILDREN1_KEY)){
				Menu3Children1 menu = new Menu3Children1();
				respMessage = menu.getContent(requestMap);
			}
			//点击第三个菜单中的第二项 
			if(eventKey.equals(WeiXinConstant.MENU3_CHILDREN2_KEY)){
				Menu3Children2 menu = new Menu3Children2();
				respMessage = menu.getContent(requestMap);
			}
			//点击第三个菜单中的第三项 
			if(eventKey.equals(WeiXinConstant.MENU3_CHILDREN3_KEY)){
				Menu3Children3 menu = new Menu3Children3();
				respMessage = menu.getContent(requestMap);
			}
			//点击第三个菜单中的第四项 
			if(eventKey.equals(WeiXinConstant.MENU3_CHILDREN4_KEY)){
				Menu3Children4 menu = new Menu3Children4();
				respMessage = menu.getContent(requestMap);
			}
		}
		return respMessage;
	}
		public static void main(String[] args) {
			Map<String, String> requestMap = new HashMap<String, String>();
			requestMap.put("FromUserName","MyServer");
			requestMap.put("ToUserName","shao");
			requestMap.put("MsgType","text");
			requestMap.put("Event","CLICK");
			requestMap.put("EventKey","31");
			EventContent eventContent = new EventContent();
			System.out.println("输出：");
			System.out.println( eventContent.getContent(requestMap));
			
		}
}
