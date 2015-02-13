package com.zdaq.fastWx.util;

public class WeiXinConstant {
	// 与接口配置信息中的Token要一致
	public final static String TOKEN = "fasttoken";
	// 第三方用户唯一凭证
	public final static String APPID = "wx02ecb0be0929ec20";
	// 第三方用户唯一凭证密钥
	public final static String APPSECRET = "d84080996697679c4dbb3f9e33d12950";
	// 微信公众号
	public final static String WINXINNUM = "zdaq001";
	/**
	 * 客服常量
	 * 
	 * */
	public final static String KEFU_ACCOUNT = "kefu3";
	public final static String KEFU_NICKNAME = "客服1";
	public final static String KEFU_PASSWORD = "123456";
	/**
	 * 群发常量
	 * 
	 * */
	//图文
	public final static String QUNFA_MSGTYPE_NEWS = "mpnews";
	//文本
	public final static String QUNFA_MSGTYPE_TEXT = "text";
	//语音
	public final static String QUNFA_MSGTYPE_VOICE = "voice";
	//图片
	public final static String QUNFA_MSGTYPE_IMG = "image";

	
	/**
	 * 菜单常量
	 * 
	 * */
	//菜单事件
	public final static String MENU_TYPE = "click";
	public final static String MENU_TYPE_VIEW = "view";
	//----------------------------------------------------------------
	public final static String PROJECT_NAME = "http://www.z-aq.com/sgt_wx/";
	//第一个一级菜单  名字
	public final static String MENU1_PARENT_NAME = "上岗通";
	// 第一个一级菜单 第一个子菜单 名字
	public final static String MENU1_CHILDREN1_NAME = "用户点评";
	// 第一个一级菜单 第一个子编码 名字
	public final static String MENU1_CHILDREN1_KEY = "11";
	// 第一个一级菜单 第一个子菜单 URL
	public final static String MENU1_CHILDREN1_URL = PROJECT_NAME + "userReviews.html";
	// 第一个一级菜单 第二个子菜单 名字
	public final static String MENU1_CHILDREN2_NAME = "上岗通展示";
	// 第一个一级菜单 第二个子编码 名字
	public final static String MENU1_CHILDREN2_KEY = "12";
	// 第一个一级菜单 第二个子菜单 URL
	public final static String MENU1_CHILDREN2_URL = PROJECT_NAME + "360view.html";
	// 第一个一级菜单 第三个子菜单 名字
	public final static String MENU1_CHILDREN3_NAME = "配套APP";
	// 第一个一级菜单 第三个子编码 名字
	public final static String MENU1_CHILDREN3_KEY = "13";
	// 第一个一级菜单 第三个子菜单 URL
	public final static String MENU1_CHILDREN3_URL = PROJECT_NAME + "appView.html";
	// 第一个一级菜单 第四个子菜单 名字
	public final static String MENU1_CHILDREN4_NAME = "管理平台";
	// 第一个一级菜单 第四个子编码 名字
	public final static String MENU1_CHILDREN4_KEY = "14";
	// 第一个一级菜单 第四个子菜单 URL
	public final static String MENU1_CHILDREN4_URL = PROJECT_NAME + "pcView.html";
	// 第一个一级菜单 第五个子菜单 名字
	public final static String MENU1_CHILDREN5_NAME = "使用说明";
	// 第一个一级菜单 第五个子编码 名字
	public final static String MENU1_CHILDREN5_KEY = "15";
	// 第一个一级菜单 第五个子菜单 URL
	public final static String MENU1_CHILDREN5_URL = PROJECT_NAME + "manualView.html";
	//----------------------------------------------------------------
	//第二个一级菜单  名字
	public final static String MENU2_PARENT_NAME = "快速订购";
	// 第二个一级菜单 第一个子菜单 名字
	public final static String MENU2_CHILDREN1_NAME = "我要“团”";
	// 第二个一级菜单 第一个子编码 名字
	public final static String MENU2_CHILDREN1_KEY = "21";
	// 第二个一级菜单 第一个子菜单 URL
	//访问地址  http://www.z-aq.com/group.action
	public final static String GROUP_URL = "http%3a%2f%2fwww.z-aq.com%2fsgt_wx%2fgroup.action";
	public final static String MENU2_CHILDREN1_URL = 
			"https://open.weixin.qq.com/connect/oauth2/authorize?"
					+ "appid=" + APPID + "&"
					+ "redirect_uri= " + GROUP_URL + "&"
					+ "response_type=code&"
					+ "scope=" + "snsapi_base" + "&"
					+ "state=" + 123 + "#wechat_redirect";
	// 第二个一级菜单 第二个子菜单 名字
	public final static String MENU2_CHILDREN2_NAME = "立即订购";
	// 第二个一级菜单 第二个子编码 名字
	public final static String MENU2_CHILDREN2_KEY = "22";
	// 第二个一级菜单 第二个子菜单 URL
	public final static String MENU2_CHILDREN2_URL = "http://www.taobao.com/";
	// 第二个一级菜单 第三个子菜单 名字
	public final static String MENU2_CHILDREN3_NAME = "私人订制";
	// 第二个一级菜单 第三个子编码 名字
	public final static String MENU2_CHILDREN3_KEY = "23";
	// 第二个一级菜单 第三个子菜单 URL
	//访问地址  http://www.z-aq.com/priorder.action
	public final static String PRIORDER_URL = "http%3a%2f%2fwww.z-aq.com%2fsgt_wx%2fpriorder.action";
	public final static String MENU2_CHILDREN3_URL ="https://open.weixin.qq.com/connect/oauth2/authorize?"
					+ "appid=" + APPID + "&"
					+ "redirect_uri= " + PRIORDER_URL + "&"
					+ "response_type=code&"
					+ "scope=" + "snsapi_base" + "&"
					+ "state=" + 234 + "#wechat_redirect";
	
	
/*	// 第二个一级菜单 第四个子菜单 名字
	public final static String MENU2_CHILDREN4_NAME = "照片里的故事";
	// 第二个一级菜单 第四个子编码 名字
	public final static String MENU2_CHILDREN4_KEY = "24";
	// 第二个一级菜单 第四个子菜单 URL
	public final static String MENU2_CHILDREN4_URL = "";
	// 第二个一级菜单 第五个子菜单 名字
	public final static String MENU2_CHILDREN5_NAME = "您的故事";
	// 第二个一级菜单 第五个子编码 名字
	public final static String MENU2_CHILDREN5_KEY = "25";
	// 第二个一级菜单 第五个子菜单 URL
	public final static String MENU2_CHILDREN5_URL = "";*/
	//----------------------------------------------------------------
	//第三个一级菜单  名字
	public final static String MENU3_PARENT_NAME = "客户服务";
	// 第三个一级菜单 第一个子菜单 名字
	public final static String MENU3_CHILDREN1_NAME = "客户服务";
	// 第三个一级菜单 第一个子编码 名字
	public final static String MENU3_CHILDREN1_KEY = "31";
	// 第三个一级菜单 第一个子菜单 URL
	//public final static String MENU3_CHILDREN1_URL = "http://www.baidu.com/";
	// 第三个一级菜单 第二个子菜单 名字
	public final static String MENU3_CHILDREN2_NAME = "常见问题";
	// 第三个一级菜单 第二个子编码 名字
	public final static String MENU3_CHILDREN2_KEY = "32";
	// 第三个一级菜单 第二个子菜单 URL
	public final static String MENU3_CHILDREN2_URL =  PROJECT_NAME + "question.html";
	// 第三个一级菜单 第三个子菜单 名字
	public final static String MENU3_CHILDREN3_NAME = "意见建议";
	// 第三个一级菜单 第三个子编码 名字
	public final static String MENU3_CHILDREN3_KEY = "33";
	// 第三个一级菜单 第三个子菜单 URL
	//public final static String MENU3_CHILDREN3_URL = PROJECT_NAME + "adviseView.html";
	//访问地址  http://www.z-aq.com/advise.action
	public final static String ADVISE_URL = "http%3a%2f%2fwww.z-aq.com%2fsgt_wx%2fadvise.action";
	public final static String MENU3_CHILDREN3_URL ="https://open.weixin.qq.com/connect/oauth2/authorize?"
					+ "appid=" + APPID + "&"
					+ "redirect_uri= " + ADVISE_URL + "&"
					+ "response_type=code&"
					+ "scope=" + "snsapi_base" + "&"
					+ "state=" + 456 + "#wechat_redirect";
	// 第三个一级菜单 第四个子菜单 名字
	public final static String MENU3_CHILDREN4_NAME = "历史消息";
	// 第三个一级菜单 第四个子编码 名字
	public final static String MENU3_CHILDREN4_KEY = "34";
	// 第三个一级菜单 第四个子菜单 URL
	public final static String MENU3_CHILDREN4_URL = PROJECT_NAME + "historyView.html";
/*	// 第三个一级菜单 第五个子菜单 名字
	public final static String MENU3_CHILDREN5_NAME = "联系我们";
	// 第三个一级菜单 第五个子编码 名字
	public final static String MENU3_CHILDREN5_KEY = "35";
	// 第三个一级菜单 第五个子菜单 URL
	public final static String MENU3_CHILDREN5_URL = "http://www.baidu.com/";*/
	

}
