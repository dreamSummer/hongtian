package com.hotent.core.sms;

import java.util.List;

/**
 * 短消息接口类。
 * @author ray	
 *
 */
public interface IShortMessage {
	
	/**
	 * 发送短信方法
	 * @param mobiles	手机号码列表
	 * @param message	短消息
	 * @return
	 */
	public boolean sendSms(List<String> mobiles, String message);
}
