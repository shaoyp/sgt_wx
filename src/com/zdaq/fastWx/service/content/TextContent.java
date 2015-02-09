package com.zdaq.fastWx.service.content;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zdaq.fastWx.message.resp.Article;
import com.zdaq.fastWx.message.resp.KeFuMessage;
import com.zdaq.fastWx.message.resp.Music;
import com.zdaq.fastWx.message.resp.MusicMessage;
import com.zdaq.fastWx.message.resp.NewsMessage;
import com.zdaq.fastWx.message.resp.TextMessage;
import com.zdaq.fastWx.message.resp.TransInfo;
import com.zdaq.fastWx.util.MessageUtil;

public class TextContent extends BaseContent{
	/**
	 * 根据文本内容回复各类消息
	 * 
	 * @param request
	 * @return
	 */
	final Logger logger = Logger.getLogger(TextContent.class);

	@Override
	public String getContent(Map<String, String> requestMap) {
		String respMessage = "";
		// 默认返回的文本消息内容
		String respContent = "请求处理异常，请稍候尝试！";
		// 消息内容
		String msgContent = requestMap.get("Content"); 
		//初始化
		//文本
		TextMessage textMessage = null;
		//图文
		NewsMessage newsMessage = null;
		List<Article> articles = null;
		Article article = null;
		//音乐
		MusicMessage musicMessage = null;
		Music music = null;
		//客服
		KeFuMessage keFuMessage = null;
		TransInfo transInfo = null;
		
		//-------------------回复文本内容开始--------------------------
		if(msgContent.equals("定点发送")){
			respContent = "该起床了";
			textMessage = getTextContent(requestMap, respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
			//logger.debug("-----------------回复文字消息："+respMessage);
		}
		
		else if (msgContent.equals("文本")){
			respContent = "文本消息";
			textMessage = getTextContent(requestMap, respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
			//logger.debug("-----------------回复文字消息："+respMessage);
		}
		else if(msgContent.equals("openid")){
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName"); 
			respContent = "发送方账号：" + fromUserName + ",请求方账号：" + toUserName;
			textMessage = getTextContent(requestMap, respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
			//logger.debug("-----------------回复文字消息："+respMessage);
		}
		//-------------------回复文本内容结束--------------------------
		//-------------------回复图文内容开始--------------------------
		else if(msgContent.equals("图文")){
			articles =  new ArrayList<>();
			article = new Article();
			article.setTitle("图文标题1");
			article.setDescription("图文介绍1");
			article.setPicUrl("http://img2.imgtn.bdimg.com/it/u=1130442088,252635752&fm=21&gp=0.jpg");
			article.setUrl("http://www.baidu.com");
			articles.add(article);
			article = new Article();
			article.setTitle("图文标题2");
			article.setDescription("图文介绍2");
			article.setPicUrl("http://img4.imgtn.bdimg.com/it/u=365645947,3303748251&fm=21&gp=0.jpg");
			article.setUrl("http://www.sina.com");
			articles.add(article);
			newsMessage = getNewsContent(requestMap, articles);
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
			//logger.debug("-----------------回复图文消息："+respMessage);
		}
		//-------------------回复图文内容结束--------------------------
		//-------------------回复音乐内容开始--------------------------
		else if(msgContent.equals("音乐")){
			music = new Music();
			music.setDescription("音乐描述");
			music.setHQMusicUrl("");
			music.setTitle("音频文件");
			music.setMusicUrl("http://music.baidu.com/song/10494260/download?__o=%2Fsong%2F10494260");
			musicMessage = getVoiceContent(requestMap, music);
			respMessage = MessageUtil.musicMessageToXml(musicMessage);
			//logger.debug("-----------------回复音频消息："+respMessage);
		}
		//-------------------回复音乐内容结束--------------------------
		
		else{
			keFuMessage = getKeFuContent(requestMap, transInfo);
			respMessage = MessageUtil.keFuMessageToXml(keFuMessage);
		}
		return respMessage;
	}
		public static void main(String[] args) {
			Map<String, String> requestMap = new HashMap<String, String>();
			requestMap.put("FromUserName","MyServer");
			requestMap.put("ToUserName","shao");
			requestMap.put("MsgType","text");
			requestMap.put("Content","sdfdf");
			TextContent textContent = new TextContent();
			System.out.println("输出：");
			System.out.println( textContent.getContent(requestMap));
			
		}
}
