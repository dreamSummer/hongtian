package com.hotent.core.api.org.model;

/**
 * 用户接口。
 * @author ray
 *
 */
public interface ISysUser {

	
	/**
	 * 用户ID
	 * @return
	 */
	public Long getUserId() ;

	/**
	 * 返回 姓名
	 * @return
	 */
	public String getFullname() ;

	/**
	 * 返回 帐号
	 * @return
	 */
	public String getAccount() ;


}
