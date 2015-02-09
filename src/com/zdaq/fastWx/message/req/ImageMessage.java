package com.zdaq.fastWx.message.req;


/**
 * 图片消息
 * 
 * @date 2015-01-13
 */
public class ImageMessage extends BaseMessage {
	// 图片链接
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}
