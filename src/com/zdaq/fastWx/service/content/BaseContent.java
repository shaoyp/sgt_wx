package com.zdaq.fastWx.service.content;

import java.util.Date;
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


public abstract class BaseContent {
	/**
	 * 回复基类
	 * 
	 * @date 2015-01-13
	 */
	final Logger logger = Logger.getLogger(BaseContent.class);
	// 发送方帐号（open_id）
	private String fromUserName;
	// 公众帐号
	private String toUserName;
	// 消息时间
	private long createTime;
	public abstract String getContent(Map<String, String> requestMap);
	/**
	 *  回复文本格式：
	 *  <xml>
     *  <ToUserName><![CDATA[toUser]]></ToUserName>
     *  <FromUserName><![CDATA[fromUser]]></FromUserName>
     *  <CreateTime>12345678</CreateTime>
     *  <MsgType><![CDATA[text]]></MsgType>
     *  <Content><![CDATA[你好]]></Content>
     *  </xml>
	 * */
	public TextMessage getTextContent(Map<String, String> requestMap,String text){
		this.fromUserName = requestMap.get("FromUserName");
		this.toUserName = requestMap.get("ToUserName");
		this.createTime = new Date().getTime();
		// 回复文本基本消息
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(createTime);
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);
		textMessage.setContent(text);
		return textMessage;
	}
	/**
	 *  回复图文格式：
	 *  <xml>
	 *  <ToUserName><![CDATA[toUser]]></ToUserName>
	 *	<FromUserName><![CDATA[fromUser]]></FromUserName>
	 *	<CreateTime>12345678</CreateTime>
	 *	<MsgType><![CDATA[news]]></MsgType>
	 *	<ArticleCount>1</ArticleCount>
	 *	<Articles>
	 *	<item>
	 *	<Title><![CDATA[title1]]></Title> 
	 *	<Description><![CDATA[description1]]></Description>
	 *	<PicUrl><![CDATA[picurl]]></PicUrl>
	 *	<Url><![CDATA[url]]></Url>
	 *	</item>
	 *	</Articles>
	 *	</xml> 
	 * */
	public NewsMessage getNewsContent(Map<String, String> requestMap,List<Article> articles){
		this.fromUserName = requestMap.get("FromUserName");
		this.toUserName = requestMap.get("ToUserName");
		this.createTime = new Date().getTime();
		// 回复文本基本消息
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(createTime);
		newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setArticleCount(articles.size());
		newsMessage.setArticles(articles);
		return newsMessage;
	}
	/**
	 *  回复音乐格式：
	 *  <xml>
	 *	<ToUserName><![CDATA[toUser]]></ToUserName>
	 *	<FromUserName><![CDATA[fromUser]]></FromUserName>
	 *	<CreateTime>12345678</CreateTime>
	 *	<MsgType><![CDATA[music]]></MsgType>
	 *	<Music>
	 *	<Title><![CDATA[TITLE]]></Title>
	 *	<Description><![CDATA[DESCRIPTION]]></Description>
	 *	<MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
	 *	<HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
	 *	<ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>
	 *	</Music>
	 *	</xml>
	 * */
	public MusicMessage getVoiceContent(Map<String, String> requestMap,Music music){
		this.fromUserName = requestMap.get("FromUserName");
		this.toUserName = requestMap.get("ToUserName");
		this.createTime = new Date().getTime();
		// 回复文本基本消息
		MusicMessage musicMessage = new MusicMessage();
		musicMessage.setToUserName(fromUserName);
		musicMessage.setFromUserName(toUserName);
		musicMessage.setCreateTime(createTime);
		musicMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);
		musicMessage.setMusic(music);
		return musicMessage;
	}
	/**
	 *  多客服格式：
	 *  <xml>
	 *	<ToUserName><![CDATA[touser]]></ToUserName>
	 *	<FromUserName><![CDATA[fromuser]]></FromUserName>
	 *	<CreateTime>1399197672</CreateTime>
	 *	<MsgType><![CDATA[transfer_customer_service]]></MsgType>
	 *	<TransInfo>
	 *	   <KfAccount>![CDATA[test1@test]]</KfAccount>
	 *	</TransInfo>
	 *	</xml>
	 * */
	public KeFuMessage getKeFuContent(Map<String, String> requestMap,TransInfo transInfo){
		this.fromUserName = requestMap.get("FromUserName");
		this.toUserName = requestMap.get("ToUserName");
		this.createTime = new Date().getTime();
		// 回复文本基本消息
		KeFuMessage keFuMessage = new KeFuMessage();
		keFuMessage.setToUserName(fromUserName);
		keFuMessage.setFromUserName(toUserName);
		keFuMessage.setCreateTime(createTime);
		keFuMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_CUSTOMERSERVICE);
		if(transInfo != null){
			keFuMessage.setTransInfo(transInfo);
		}
		return keFuMessage;
	}

}
