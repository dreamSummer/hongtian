package com.hotent.core.db;

import com.alibaba.druid.pool.DruidDataSource;
import com.hotent.core.encrypt.EncryptUtil;

/**
 * 自定义DRUID数据源,实现将密码加密。
 * 如果需要使用EncryptUtil.encrypt(message)将密码进行加密。
 * @author ray
 *
 */
public class CustomDruidDataSource extends DruidDataSource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7472503562887812863L;
	
	private  volatile String decPwd="";

	@Override
	public String getPassword() {
		
		
		if("".equals(decPwd) ){
			try {
				
				String encPwd=super.getPassword();
				decPwd= EncryptUtil.decrypt(encPwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return decPwd;
	}
	
	

}
