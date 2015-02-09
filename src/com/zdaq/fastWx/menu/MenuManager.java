package com.zdaq.fastWx.menu;



import com.zdaq.fastWx.util.AccessToken;
import com.zdaq.fastWx.util.WeiXinConstant;
import com.zdaq.fastWx.util.WeixinUtil;

import net.sf.json.JSONObject;

/**
 * 菜单管理器类
 * 
 * @date 2015-01-13
 */
public class MenuManager {

	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = WeiXinConstant.APPID;
		// 第三方用户唯一凭证密钥
		String appSecret = WeiXinConstant.APPSECRET;
		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
		System.out.println("token:"+at.getToken());
		if (null != at) {
			// 调用接口创建菜单
			String result = createMenu(at.getToken());

			// 判断菜单创建结果
			System.out.println("创建菜单结果："+result);
		}
	}

	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		CommonButton btn11 = new CommonButton();
		btn11.setName(WeiXinConstant.MENU1_CHILDREN1_NAME);
		btn11.setType(WeiXinConstant.MENU_TYPE_VIEW);
		//btn11.setKey(WeiXinConstant.MENU1_CHILDREN1_KEY);
		btn11.setUrl(WeiXinConstant.MENU1_CHILDREN1_URL);

		CommonButton btn12 = new CommonButton();
		btn12.setName(WeiXinConstant.MENU1_CHILDREN2_NAME);
		btn12.setType(WeiXinConstant.MENU_TYPE_VIEW);
		//btn12.setKey(WeiXinConstant.MENU1_CHILDREN2_KEY);
		btn12.setUrl(WeiXinConstant.MENU1_CHILDREN2_URL);

		CommonButton btn13 = new CommonButton();
		btn13.setName(WeiXinConstant.MENU1_CHILDREN3_NAME);
		btn13.setType(WeiXinConstant.MENU_TYPE_VIEW);
		//btn13.setKey(WeiXinConstant.MENU1_CHILDREN3_KEY);
		btn13.setUrl(WeiXinConstant.MENU1_CHILDREN3_URL);

		CommonButton btn14 = new CommonButton();
		btn14.setName(WeiXinConstant.MENU1_CHILDREN4_NAME);
		btn14.setType(WeiXinConstant.MENU_TYPE_VIEW);
		//btn14.setKey(WeiXinConstant.MENU1_CHILDREN4_KEY);
		btn14.setUrl(WeiXinConstant.MENU1_CHILDREN4_URL);

		CommonButton btn15 = new CommonButton();
		btn15.setName(WeiXinConstant.MENU1_CHILDREN5_NAME);
		btn15.setType(WeiXinConstant.MENU_TYPE_VIEW);
		//btn15.setKey(WeiXinConstant.MENU1_CHILDREN5_KEY);
		btn15.setUrl(WeiXinConstant.MENU1_CHILDREN5_URL);
		
		
		CommonButton btn21 = new CommonButton();
		btn21.setName(WeiXinConstant.MENU2_CHILDREN1_NAME);
		btn21.setType(WeiXinConstant.MENU_TYPE_VIEW);
		//btn21.setKey(WeiXinConstant.MENU2_CHILDREN1_KEY);
		btn21.setUrl(WeiXinConstant.MENU2_CHILDREN1_URL);

		CommonButton btn22 = new CommonButton();
		btn22.setName(WeiXinConstant.MENU2_CHILDREN2_NAME);
		btn22.setType(WeiXinConstant.MENU_TYPE_VIEW);
		//btn22.setKey(WeiXinConstant.MENU2_CHILDREN2_KEY);
		btn22.setUrl(WeiXinConstant.MENU2_CHILDREN2_URL);

		CommonButton btn23 = new CommonButton();
		btn23.setName(WeiXinConstant.MENU2_CHILDREN3_NAME);
		btn23.setType(WeiXinConstant.MENU_TYPE_VIEW);
		//btn23.setKey(WeiXinConstant.MENU2_CHILDREN3_KEY);
		btn23.setUrl(WeiXinConstant.MENU2_CHILDREN3_URL);
/*
		CommonButton btn24 = new CommonButton();
		btn24.setName(WeiXinConstant.MENU2_CHILDREN4_NAME);
		btn24.setType(WeiXinConstant.MENU_TYPE);
		btn24.setKey(WeiXinConstant.MENU2_CHILDREN4_KEY);

		CommonButton btn25 = new CommonButton();
		btn25.setName(WeiXinConstant.MENU2_CHILDREN5_NAME);
		btn25.setType(WeiXinConstant.MENU_TYPE);
		btn25.setKey(WeiXinConstant.MENU2_CHILDREN5_KEY);*/

		CommonButton btn31 = new CommonButton();
		btn31.setName(WeiXinConstant.MENU3_CHILDREN1_NAME);
		btn31.setType(WeiXinConstant.MENU_TYPE);
		btn31.setKey(WeiXinConstant.MENU3_CHILDREN1_KEY);
		

		CommonButton btn32 = new CommonButton();
		btn32.setName(WeiXinConstant.MENU3_CHILDREN2_NAME);
		//btn32.setType(WeiXinConstant.MENU_TYPE);
		//btn32.setKey(WeiXinConstant.MENU3_CHILDREN2_KEY);
		btn32.setType(WeiXinConstant.MENU_TYPE_VIEW);
		btn32.setUrl(WeiXinConstant.MENU3_CHILDREN2_URL);

		CommonButton btn33 = new CommonButton();
		btn33.setName(WeiXinConstant.MENU3_CHILDREN3_NAME);
		//btn33.setType(WeiXinConstant.MENU_TYPE);
		//btn33.setKey(WeiXinConstant.MENU3_CHILDREN3_KEY);
		btn33.setType(WeiXinConstant.MENU_TYPE_VIEW);
		btn33.setUrl(WeiXinConstant.MENU3_CHILDREN3_URL);

		CommonButton btn34 = new CommonButton();
		btn34.setName(WeiXinConstant.MENU3_CHILDREN4_NAME);
		//btn34.setType(WeiXinConstant.MENU_TYPE);
		//btn34.setKey(WeiXinConstant.MENU3_CHILDREN4_KEY);
		btn34.setType(WeiXinConstant.MENU_TYPE_VIEW);
		btn34.setUrl(WeiXinConstant.MENU3_CHILDREN4_URL);
		
/*		CommonButton btn35 = new CommonButton();
		btn35.setName(WeiXinConstant.MENU3_CHILDREN5_NAME);
		btn35.setType(WeiXinConstant.MENU_TYPE);
		btn35.setKey(WeiXinConstant.MENU3_CHILDREN5_KEY);*/
		
		
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName(WeiXinConstant.MENU1_PARENT_NAME);
		mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14,btn15 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName(WeiXinConstant.MENU2_PARENT_NAME);
		/*mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24, btn25 });*/
		mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23 });
		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName(WeiXinConstant.MENU3_PARENT_NAME);
	/*	mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33,btn34,btn35 });*/
		mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33,btn34});

		/**
		 * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br>
		 * 
		 * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
		 * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br>
		 * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

		return menu;
	}
	// 菜单创建（POST） 限100（次/天）
		public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

		/**
		 * 创建菜单
		 * 
		 * @param menu
		 *            菜单实例
		 * @param accessToken
		 *            有效的access_token
		 * @return 0表示成功，其他值表示失败
		 */
		public static String createMenu(String accessToken) {

			// 拼装创建菜单的url
			String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
			// 将菜单对象转换成json字符串
			String jsonMenu = JSONObject.fromObject(getMenu()).toString();
			System.out.println("菜单对象转成json:"+jsonMenu);
			// 调用接口创建菜单
			JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", jsonMenu);

			if (null != jsonObject) {
//				if (0 != jsonObject.getInt("errcode")) {
//					result = jsonObject.getInt("errcode");
//					System.out.println("创建菜单失败 errcode:{} errmsg:{}"
//							+ jsonObject.getInt("errcode")
//							+ jsonObject.getString("errmsg"));
//				}
				return jsonObject.toString();
			}

			return "{}";
		}

		private static String menu_find_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

		/**
		 * 获取菜单列表
		 * 
		 * @param menu
		 *            菜单实例
		 * @param accessToken
		 *            有效的access_token
		 * @return 0表示成功，其他值表示失败
		 */
		public static String getMenus(String accessToken) {
			// 拼装创建菜单的url
			String url = menu_find_url.replace("ACCESS_TOKEN", accessToken);
			// 调用接口获取菜单
			JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", "");

			if (null != jsonObject) {
				return jsonObject.toString();
			}
			return "{}";
		}
		
		private static String menu_del_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

		/**
		 * 获取菜单列表
		 * 
		 * @param menu
		 *            菜单实例
		 * @param accessToken
		 *            有效的access_token
		 * @return 0表示成功，其他值表示失败
		 */
		public static String delMenus(String accessToken) {
			// 拼装创建菜单的url
			String url = menu_del_url.replace("ACCESS_TOKEN", accessToken);
			// 调用接口获取菜单
			JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", "");

			if (null != jsonObject) {
				return jsonObject.toString();
			}
			return "{}";
		}
	}