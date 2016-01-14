package com.hotent.core.api.util;

import com.hotent.core.api.system.IPropertyService;
import com.hotent.core.util.AppUtil;

/**
 * 属性帮助接口。
 * @author yongguo
 *
 */
public class PropertyUtil {

	public static String getByAlias(String alias){
		IPropertyService service=AppUtil.getBean(IPropertyService.class);
		return service.getByAlias(alias);
	}
	
	public static String getByAlias(String alias,String defaultValue){
		IPropertyService service=AppUtil.getBean(IPropertyService.class);
		return service.getByAlias(alias, defaultValue);
	}
	
	public static Integer getIntByAlias(String alias){
		IPropertyService service=AppUtil.getBean(IPropertyService.class);
		return service.getIntByAlias(alias);
	}
	
	public static Integer getIntByAlias(String alias,Integer defaulValue){
		IPropertyService service=AppUtil.getBean(IPropertyService.class);
		return service.getIntByAlias(alias,defaulValue);
	}
	
	public static Long getLongByAlias(String alias){
		IPropertyService service=AppUtil.getBean(IPropertyService.class);
		return service.getLongByAlias(alias);
	}
	
	public static boolean getBooleanByAlias(String alias){
		IPropertyService service=AppUtil.getBean(IPropertyService.class);
		return service.getBooleanByAlias(alias);
	}
	
	public static boolean getBooleanByAlias(String alias,boolean defaulValue){
		IPropertyService service=AppUtil.getBean(IPropertyService.class);
		return service.getBooleanByAlias(alias, defaulValue);
	}

}
