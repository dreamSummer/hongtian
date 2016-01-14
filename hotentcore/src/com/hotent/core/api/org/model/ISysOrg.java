package com.hotent.core.api.org.model;

public interface ISysOrg {
	
	public final static Long BEGIN_DEMID=1L;//默认维度
	public final static Long BEGIN_ORGID=1L;//默认组织ID
	public final static Integer BEGIN_DEPTH=0;//默认深度
	public final static String BEGIN_PATH="1";//默认路径
	public final static Short BEGIN_TYPE=1;//默认组织类型
	public final static Long BEGIN_ORGSUPID=-1L;//默认组织父ID
	public final static Short BEGIN_SN=1;//默认sn
	public final static Short BEGIN_FROMTYPE=0;//默认组织类型
	
	public final static Short FROMTYPE_AD=1;
	public final static Short FROMTYPE_DB=0;

	public final static Integer IS_LEAF_N=1; //不是叶子节点
	public final static Integer IS_LEAF_Y=0; //是叶子节点

	public final static String IS_PARENT_N="false"; //不是父类节点
	public final static String IS_PARENT_Y="true"; //是父类节点
	
	
	void setOrgId(Long orgId);
	/**
	 * 返回 组织ID
	 * @return
	 */
	Long getOrgId();

	void setDemId(Long demId) ;
	/**
	 * 返回 维度编号
	 * @return
	 */
	Long getDemId();
    		
	
	String getDemName() ;
	/**
	 * 返回 维度名称
	 * @return
	 */
	void setDemName(String demName);
	
	
	void setOrgName(String orgName);
	/**
	 * 返回 名称
	 * @return
	 */
	String getOrgName() ;

	void setOrgDesc(String orgDesc) ;
	/**
	 * 返回 描述
	 * @return
	 */
	String getOrgDesc();

	/**
	 *  路径。
	 * @param orgPathname
	 */
	void setOrgPathname(String orgPathname) ;
	/**
	 * 返回 组织路径
	 * @return
	 */
	String getOrgPathname() ;
	
	/**
	 * 上级ID。
	 * @param orgSupId
	 */
	void setOrgSupId(Long orgSupId);
	/**
	 * 返回 上级
	 * @return
	 */
	Long getOrgSupId() ;

	/**
	 * 上级组织名称
	 * @return
	 */
	String getOrgSupName();
	
	/**
	 * 上级组织名称
	 * @param orgSupName
	 */
	void setOrgSupName(String orgSupName);
	
	/**
	 * 上级路径。
	 * @param path
	 */
	void setPath(String path);
	/**
	 * 返回 路径
	 * @return
	 */
	String getPath() ;
	
	/**
	 * 返回 路径
	 * @param depth
	 */
	void setDepth(Integer depth) ;
	/**
	 * 返回 层次
	 * @return
	 */
	Integer getDepth() ;

	/**
	 * 组织类型。
	 * @param orgType
	 */
	void setOrgType(Long orgType) ;
	/**
	 * 返回 类型
	 * @return
	 */
	Long getOrgType() ;

	/**
	 * 数据来源（0，系统添加,1,来自AD同步)
	 * @return
	 */
	public Short getFromType() ;
	
	public void setFromType(Short fromType) ;
}
