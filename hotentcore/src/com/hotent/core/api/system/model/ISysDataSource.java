package com.hotent.core.api.system.model;

public interface ISysDataSource {

	void setId(Long id) ;

	/**
	 * 返回 主键
	 * 
	 * @return
	 */
	Long getId() ;

	void setName(String name) ;

	/**
	 * 返回 名称
	 * 
	 * @return
	 */
	String getName() ;

	void setAlias(String alias);
	/**
	 * 返回 别名
	 * 
	 * @return
	 */
	String getAlias() ;

	void setDbType(String dbType) ;

	/**
	 * 返回 数据源的类型-mysql,oracle,sqlserver
	 * 
	 * @return
	 */
	String getDbType() ;

	void setSettingJson(String settingJson);

	/**
	 * 返回 设置字段
	 * 
	 * @return
	 */
	String getSettingJson();


	/**
	 * initOnStart
	 * @return  the initOnStart
	 * @since   1.0.0
	 */
	
	Boolean getInitOnStart();

	/**
	 * @param initOnStart the initOnStart to set
	 */
	void setInitOnStart(Boolean initOnStart) ;

	/**
	 * enabled
	 * @return  the enabled
	 * @since   1.0.0
	 */
	
	Boolean getEnabled() ;

	/**
	 * @param enabled the enabled to set
	 */
	void setEnabled(Boolean enabled) ;

	void setClassPath(String classPath);
	/**
	 * 返回 类路径
	 * 
	 * @return
	 */
	String getClassPath() ;

	void setInitMethod(String initMethod);

	/**
	 * 返回 初始化方法
	 * 
	 * @return
	 */
	String getInitMethod();

	void setCloseMethod(String closeMethod) ;

	/**
	 * 返回 关闭方法
	 * 
	 * @return
	 */
	String getCloseMethod() ;

	Long getRunId() ;

	void setRunId(Long runId);

}
