package com.zdaq.fastWx.event;

import java.util.Map;

import com.zdaq.fastWx.message.resp.KeFuMessage;
import com.zdaq.fastWx.service.content.BaseContent;
import com.zdaq.fastWx.util.MessageUtil;
/**
 * 
 * 第三个菜单第一项  
 * 实现多客服
 * 
 * */
public class Menu3Children1 extends BaseContent{

	@Override
	public String getContent(Map<String, String> requestMap) {
		String respMessage = "";
		KeFuMessage keFuMessage = getKeFuContent(requestMap, null);
		respMessage = MessageUtil.keFuMessageToXml(keFuMessage);
		return respMessage;
	}

}
