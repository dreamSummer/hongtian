package com.hotent.core.api.system;

public interface IPropertyService {
	
	/**
	 * 根据别名获取属性值。
	 * @param alias
	 * @return
	 */
	String getByAlias(String alias);
	
	String getByAlias(String alias,String defaultValue);
	
	Integer getIntByAlias(String alias);
	
	Integer getIntByAlias(String alias,Integer defaulValue);
	
	Long getLongByAlias(String alias);
	
	boolean getBooleanByAlias(String alias);
	
	boolean getBooleanByAlias(String alias,boolean defaulValue);

}
