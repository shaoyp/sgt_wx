package com.zdaq.fastWx.util;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;


/**
 * 公众平台通用接口工具类
 * 
 * @date 2015-01-13
 */
public class WeixinUtil {
	//private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);

	
	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	/**
	 * 获取access_token
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @return
	 */
	public static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;

		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				System.out.println("获取token失败 errcode:{} errmsg:{}"+jsonObject.getInt("errcode")+ jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}
	/**
	 * 获取网页授权open_id
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @return
	 */
	private static String  get_access_token_url="https://api.weixin.qq.com/sns/oauth2/access_token?" +
	        "appid=APPID" +
	        "&secret=SECRET&" +
	        "code=CODE&grant_type=authorization_code";
	public static String getOpenId(HttpServletRequest request,HttpServletResponse response) {
		Logger  logger = Logger.getLogger(WeixinUtil.class);
		logger.info("----------------获取网页授权-------------------------");
		String openid = "";
		//发送请求
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String code = request.getParameter("code");
			logger.info("获取code：" + code);
			//配置URL
			get_access_token_url = get_access_token_url.replace("APPID", WeiXinConstant.APPID);
			get_access_token_url = get_access_token_url.replace("SECRET", WeiXinConstant.APPSECRET);
			get_access_token_url = get_access_token_url.replace("CODE", code);
			JSONObject jsonObject = WeixinUtil.httpRequest(get_access_token_url, "GET", null);
			openid = jsonObject.getString("openid");
			if (null != jsonObject) {
				if (0 != jsonObject.getInt("errcode")) {
					jsonObject.getInt("errcode");
					logger.info("创建菜单失败 errcode:{} errmsg:{}"
							+ jsonObject.getInt("errcode")
						+ jsonObject.getString("errmsg"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e);
		}
		return openid;
	}
	/**
	 * 发送消息
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @return
	 */
	private static String send_hello_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	public static  int sendMessage(String openid){
		Logger  logger = Logger.getLogger(WeixinUtil.class);
		logger.info("----------------发送你好-------------------------");
		// 第三方用户唯一凭证
		String appId = WeiXinConstant.APPID;
		// 第三方用户唯一凭证密钥
		String appSecret = WeiXinConstant.APPSECRET;
		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
		
		
		int result = 0;
		// 拼装创建客服的url
		String url = send_hello_url.replace("ACCESS_TOKEN", at.getToken());
		// 将客服对象转换成json字符串
		//String jsonKefu = JSONObject.fromObject(kf).toString();
		String jsonSend = "{\"touser\":\""+openid+"\",\"msgtype\":\"text\",\"text\":{\"content\":\"您好，有什么可以帮助你的？\"}}";
		// 调用接口创建菜单
		JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", jsonSend);
		System.out.println("json:" + jsonObject);
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
	
	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr 提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			System.out.println("Weixin server connection timed out.");
		} catch (Exception e) {
			System.out.println("https request error:{}"+ e);
		}
		return jsonObject;
	}
}