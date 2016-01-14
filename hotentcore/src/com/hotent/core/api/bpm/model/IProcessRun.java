package com.hotent.core.api.bpm.model;

import java.util.Date;

/**
 * 流程运行实例对象接口。
 * @author ray
 *
 */
public  interface IProcessRun {

	//流程RUNID
	Long getRunId() ;
	
	void setRunId(Long runId);
	// 流程定义ID
	Long getDefId();
	void setDefId(Long defId);
	// 流程实例标题
	String getSubject() ;
	void setSubject(String subject) ;
	// 创建人ID
	Long getCreatorId() ;
	void setCreatorId(Long creatorId);
	// 创建人
	String getCreator();
	void setCreator(String creator);
	// 创建时间
	java.util.Date getCreatetime() ;
	void setCreatetime(java.util.Date createtime);
	//业务表单简述
	String getBusDescp() ;
	void setBusDescp(String busDescp) ;
	// 状态
	Short getStatus() ;
	void setStatus(Short status);
	// ACT流程实例ID
	String getActInstId() ;
	void setActInstId(String actInstId);
	// ACT流程定义ID
	String getActDefId();
	void setActDefId(String actDefId) ;
	// businessKey
	String getBusinessKey();
	void setBusinessKey(String businessKey);
	// businessKey 数字型
	Long getBusinessKeyNum() ;
	void setBusinessKeyNum(Long businessKeyNum) ;
	// businessUrl
	String getBusinessUrl();
	void setBusinessUrl(String businessUrl) ;
	// 结束时间
	Date getEndTime() ;
	void setEndTime(Date endTime);
	//执行持续时间总长（毫秒)
	Long getDuration() ;
	void setDuration(Long duration) ;
	//流程定义名称
	String getProcessName();
	void setProcessName(String processName);
	// 主键名称
	String getPkName() ;
	void setPkName(String pkName) ;
	// 表名
	String getTableName() ;
	void setTableName(String tableName) ;
	// 父流程运行的ID。
	Long getParentId();
	void setParentId(Long parentId);
	
	// 发起人所在组织名称
	String getStartOrgName() ;
	void setStartOrgName(String startOrgName) ;
	// 发起人所在组织Id。
	Long getStartOrgId();
	void setStartOrgId(Long startOrgId);
	// 追回状态
	Short getRecover() ;
	void setRecover(Short recover);
	//表单定义
	Long getFormDefId();
	void setFormDefId(Long formDefId);
	//数据源
	String getDsAlias() ;
	void setDsAlias(String dsAlias) ;
	// 表单Key或Url
	String getFormKeyUrl() ;
	void setFormKeyUrl(String formKeyUrl) ;
	// 表单类型
	Short getFormType() ;
	void setFormType(Short formType) ;
	
	String getFlowKey();
	
	void setFlowKey(String flowKey);
	
	
	
	

}
