package com.zdaq.fastWx.action;

import java.io.PrintWriter;

import org.apache.log4j.Logger;

import com.zdaq.common.action.BaseAction;
import com.zdaq.fastWx.service.MainService;
import com.zdaq.fastWx.util.SignUtil;

/**
 * 微信入口
 * 
 * @date 2015-01-13
 */
public class MainAction extends BaseAction {

	private static final long serialVersionUID = -9018789310209318123L;
	final Logger logger = Logger.getLogger(MainAction.class);
	public String execute() {
		logger.info("----------------------Fast weixinAction 进入------------------------");
		// 响应消息
		PrintWriter out = null;
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			// 随机字符串
			String echostr = request.getParameter("echostr");
			if (null == echostr || echostr.isEmpty()) { // 非验证时走自动回复流程
				logger.info("----------------------Fast weixinAction  调用核心业务类接收消息、处理消息------------------------");
				// 调用核心业务类接收消息、处理消息
				String respMessage = MainService.processRequest(request);
				out.print(respMessage);
			} else {
				logger.info("----------------------weixinAction 检验signature----------------------");
				// 微信加密签名
				String signature = request.getParameter("signature");
				// 时间戳
				String timestamp = request.getParameter("timestamp");
				// 随机数
				String nonce = request.getParameter("nonce");
				// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
				if (SignUtil.checkSignature(signature, timestamp, nonce)) {
					out.print(echostr);
				}
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;

	}

}
