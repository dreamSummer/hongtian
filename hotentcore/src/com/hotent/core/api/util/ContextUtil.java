package com.hotent.core.api.util;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.hotent.core.api.org.ICurrentContext;
import com.hotent.core.api.org.model.IPosition;
import com.hotent.core.api.org.model.ISysOrg;
import com.hotent.core.api.org.model.ISysUser;
import com.hotent.core.util.AppUtil;


public class ContextUtil {
	
	public static final String CurrentOrg="CurrentOrg_";
	public static final String CurrentCompany ="CurrentCompany_";
	
	public static final String CurrentPos="CurrentPos_";

	
	public static String getPositionKey(Long userId){
		String posKey=ContextUtil.CurrentPos + userId;
		return posKey;
	}
	
	public static String getOrgKey(Long userId){
		String orgKey=ContextUtil.CurrentOrg + userId;
		return orgKey;
	}
	
	public static String getCompanyKey(Long userId){
		String orgKey=ContextUtil.CurrentCompany + userId;
		return orgKey;
	}
	
	private static ICurrentContext context_;
	
	public synchronized static ICurrentContext getContext(){
		if(context_==null){
			context_=AppUtil.getBean(ICurrentContext.class);
		}
		return context_;
	}
	
	
	
	/**
	 * 获取当前用户。
	 * @return
	 */
	public static ISysUser getCurrentUser(){
		ICurrentContext context=getContext();
		return context.getCurrentUser();
	}
	
	/**
	 * 获取local对象。
	 * @return
	 */
	public static  Locale getLocale(){
		ICurrentContext context=getContext();
		return context.getLocale();
	}
	
	/**
	 * 设置local对象。
	 * @param locale
	 */
	public static  void setLocale(Locale locale){
		ICurrentContext context=getContext();
		context.setLocale(locale);
	}
	
	/**
	 * 获取当前用户ID。
	 * @return
	 */
	public static   Long getCurrentUserId(){
		ICurrentContext context=getContext();
		return context.getCurrentUserId();
	}
	
	/**
	 * 设置当前用户帐号。
	 * @param account
	 */
	public static void setCurrentUserAccount(String account){
		ICurrentContext context=getContext();
		context.setCurrentUserAccount(account);
	}
	
	/**
	 * 设置当前用户。
	 * @param sysUser
	 */
	public static void setCurrentUser(ISysUser sysUser){
		ICurrentContext context=getContext();
		context.setCurrentUser(sysUser);
	}
	
	/**
	 * 设置当前岗位ID.
	 * @param posId
	 */
	public static void setCurrentPos(Long posId){
		ICurrentContext context=getContext();
		context.setCurrentPos(posId);
	}
	
	/**
	 * 获取当前组织。
	 * @return
	 */
	public static ISysOrg getCurrentOrg(){
		ICurrentContext context=getContext();
		return context.getCurrentOrg();
	}
	
	/**
	 * 获取当前公司。
	 * @return
	 */
	public static ISysOrg getCurrentCompany(){
		ICurrentContext context=getContext();
		return context.getCurrentCompany();
	}
	
	/**
	 * 获取当前公司。
	 * @return
	 */
	public static Long getCurrentCompanyId(){
		ICurrentContext context=getContext();
		return context.getCurrentCompanyId();
	}
	
	/**
	 * 获取当前岗位。
	 * @return
	 */
	public static IPosition getCurrentPos(){
		ICurrentContext context=getContext();
		return context.getCurrentPos();
	}
	
	/**
	 * 获取当前岗位ID。
	 * @return
	 */
	public static Long getCurrentPosId(){
		ICurrentContext context=getContext();
		return context.getCurrentPosId();
	}
	
	/**
	 * 获取当前组织ID。
	 * @return
	 */
	public static Long getCurrentOrgId(){
		ICurrentContext context=getContext();
		return context.getCurrentOrgId();
	}
	
	/**
	 * 获取当前皮肤。
	 * @param request
	 * @return
	 */
	public static String getCurrentUserSkin(HttpServletRequest request){
		ICurrentContext context=getContext();
		return context.getCurrentUserSkin(request);
	}
	
	/**
	 * 清除当前用户。
	 */
	public static void cleanCurUser(){
		ICurrentContext context=getContext();
		context.cleanCurUser();
	}
	
	/**
	 * 清除当前组织。
	 */
	public static void removeCurrentOrg(){
		ICurrentContext context=getContext();
		context.removeCurrentOrg();
	}
	
	/**
	 * 清除上下文组织。
	 */
	public static void clearAll(){
		ICurrentContext context=getContext();
		context.clearAll();
	}
	
	/**
	 * 清除当前用户。
	 */
	public static void removeCurrentUser(){
		ICurrentContext context=getContext();
		context.removeCurrentUser();
	}
	
	/**
	 * 当前人是否超级管理员。
	 * @return
	 */
	public static boolean isSuperAdmin(){
		ICurrentContext context=getContext();
		return context.isSuperAdmin();
	}
	
	public static boolean isSuperAdmin(ISysUser user){
		ICurrentContext context=getContext();
		return context.isSuperAdmin(user);
	}
	
}
