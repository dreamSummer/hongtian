package com.hotent.core.api.org.model;

/**
 * 岗位对象接口。
 * @author ray
 *
 */
public interface IPosition {
	
	/**
	 * 岗位ID
	 * @return
	 */
	Long getPosId() ;
	
	/**
	 * 设置岗位ID
	 * @param posId
	 */
	void setPosId(Long posId);
	
	/**
	 * 岗位名称。
	 * @return
	 */
	String getPosName() ;
	
	/**
	 * 刚问名称
	 * @param posName
	 */
	void setPosName(String posName) ;
	
	/**
	 * 岗位描述
	 * @return
	 */
	String getPosDesc() ;
	
	/**
	 * 设置岗位描述。
	 * @param posDesc
	 */
	void setPosDesc(String posDesc) ;
	
	/**
	 * 获取岗位编码。
	 * @return
	 */
	String getPosCode();
	
	/**
	 * 设置岗位编码。
	 * @param posCode
	 */
	void setPosCode(String posCode);
	
	/**
	 * 组织ID
	 * @return
	 */
	Long getOrgId();
	
	/**
	 * 设置组织ID。
	 * @param orgId
	 */
	void setOrgId(Long orgId) ;
	
	/**
	 * 职位ID
	 * @return
	 */
	Long getJobId() ;
	
	/**
	 * 设置职位ID。
	 * @param jobId
	 */
	void setJobId(Long jobId) ;
	

}
