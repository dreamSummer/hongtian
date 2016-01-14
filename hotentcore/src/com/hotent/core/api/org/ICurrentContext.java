package com.hotent.core.api.org;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.hotent.core.api.org.model.IPosition;
import com.hotent.core.api.org.model.ISysOrg;
import com.hotent.core.api.org.model.ISysUser;


/**
 * 当前上下文接口。
 * @author ray
 *
 */
public interface ICurrentContext {
	
	/**
	 * 获取当前用户。
	 * @return
	 */
	ISysUser getCurrentUser();
	
	/**
	 * 获取local对象。
	 * @return
	 */
	Locale getLocale();
	
	/**
	 * 设置local对象。
	 * @param locale
	 */
	void setLocale(Locale locale);
	
	/**
	 * 获取当前用户ID。
	 * @return
	 */
	Long getCurrentUserId();
	
	/**
	 * 设置当前用户帐号。
	 * @param account
	 */
	void setCurrentUserAccount(String account);
	
	/**
	 * 设置当前用户。
	 * @param sysUser
	 */
	void setCurrentUser(ISysUser sysUser);
	
	/**
	 * 设置当前岗位ID.
	 * @param posId
	 */
	void setCurrentPos(Long posId);
	
	/**
	 * 获取当前组织。
	 * @return
	 */
	ISysOrg getCurrentOrg();
	
	/**
	 * 获取当前公司。
	 * @return
	 */
	ISysOrg getCurrentCompany();
	
	/**
	 * 获取当前公司。
	 * @return
	 */
	Long getCurrentCompanyId();
	
	/**
	 * 获取当前岗位。
	 * @return
	 */
	IPosition getCurrentPos();
	
	/**
	 * 获取当前岗位ID。
	 * @return
	 */
	Long getCurrentPosId();
	
	/**
	 * 获取当前组织ID。
	 * @return
	 */
	Long getCurrentOrgId();
	
	/**
	 * 获取当前皮肤。
	 * @param request
	 * @return
	 */
	String getCurrentUserSkin(HttpServletRequest request);
	
	/**
	 * 清除当前用户。
	 */
	void cleanCurUser();
	
	/**
	 * 清除当前组织。
	 */
	void removeCurrentOrg();
	
	/**
	 * 清除上下文组织。
	 */
	void clearAll();
	
	/**
	 * 清除当前用户。
	 */
	void removeCurrentUser();
	
	/**
	 * 获取当前人是否为超级管理员。
	 * @return
	 */
	boolean isSuperAdmin();
	
	/**
	 * 获取当前人是否为超级管理员。
	 * @param user
	 * @return
	 */
	boolean isSuperAdmin(ISysUser user);

}
