package com.hotent.core.api.bpm.model;

import java.util.Map;

public interface IBpmDefinition {

	public void setDefId(Long defId);
	
	/**
	 * 返回 流程定义ID
	 * 
	 * @return
	 */
	public Long getDefId();
	
	

	public Short getIsUseOutForm();

	public void setIsUseOutForm(Short isUseOutForm);

	

	public void setTypeId(Long typeId);
	
	public String getFormDetailUrl() ;

	public void setFormDetailUrl(String formDetailUrl) ;

	/**
	 * 返回 分类ID
	 * 
	 * @return
	 */
	public Long getTypeId();

	public void setSubject(String subject);

	/**
	 * 返回 流程标题
	 * 
	 * @return
	 */
	public String getSubject();

	public void setDefKey(String defKey);

	/**
	 * 返回 流程定义Key
	 * 
	 * @return
	 */
	public String getDefKey();

	public void setTaskNameRule(String taskNameRule);

	/**
	 * 返回 任务标题生成规则
	 * 
	 * @return
	 */
	public String getTaskNameRule();

	public void setDescp(String descp);
	

	/**
	 * 返回 流程描述
	 * 
	 * @return
	 */
	public String getDescp();

	public void setCreatetime(java.util.Date createtime);

	/**
	 * 返回 创建时间
	 * 
	 * @return
	 */
	public java.util.Date getCreatetime();

	public void setStatus(Short status);
	
	public String getTestStatusTag() ;

	public void setTestStatusTag(String testStatusTag) ;

	/**
	 * 返回 流程状态
	 * 
	 * @return
	 */
	public Short getStatus();

	public void setDefXml(String defXml);

	/**
	 * 返回 流程定义XML(设计器)
	 * 
	 * @return
	 */
	public String getDefXml();

	public void setActDeployId(Long actDeployId);

	/**
	 * 返回 activiti流程定义ID
	 * 
	 * @return
	 */
	public Long getActDeployId();

	public void setActDefKey(String actDefKey);

	/**
	 * 返回 act流程定义Key
	 * 
	 * @return
	 */
	public String getActDefKey();

	public void setActDefId(String actDefId);

	/**
	 * 返回 actDefId
	 * 
	 * @return
	 */
	public String getActDefId();

	public void setCreateBy(Long createBy);

	/**
	 * 返回 createBy
	 * 
	 * @return
	 */
	public Long getCreateBy();

	public void setUpdateBy(Long updateBy);

	/**
	 * 返回 updateBy
	 * 
	 * @return
	 */
	public Long getUpdateBy();

	public void setReason(String reason);

	/**
	 * 返回 reason
	 * 
	 * @return
	 */
	public String getReason();

	public void setVersionNo(Integer versionNo);

	/**
	 * 返回 versionNo
	 * 
	 * @return
	 */
	public Integer getVersionNo();

	public void setParentDefId(Long parentDefId);

	/**
	 * 返回 隶属主定义ID
	 * 
	 * @return
	 */
	public Long getParentDefId();

	public void setIsMain(Short isMain);

	/**
	 * 返回 是否为主版本
	 * 
	 * @return
	 */
	public Short getIsMain();

	public void setUpdatetime(java.util.Date updatetime);

	/**
	 * 返回 updatetime
	 * 
	 * @return
	 */
	public java.util.Date getUpdatetime();

	public String getTypeName();

	public void setTypeName(String typeName);
	

	public Short getShowFirstAssignee();

	public void setShowFirstAssignee(Short showFirstAssignee) ;
	
	public Short getToFirstNode();

	public void setToFirstNode(Short toFirstNode);

	

	public String getCanChoicePath();

	public void setCanChoicePath(String canChoicePath) ;
	
	
	
	Short getIsPrintForm() ;

	public void setIsPrintForm(Short isPrintForm) ;
	
	/**
	 * 允许抄送后转发。
	 * @return
	 */
	public Integer getAllowFinishedDivert() ;

	
	public void setAllowFinishedDivert(Integer allowFinishedDivert) ;

	/**
	 * 完成后抄送。
	 * @return
	 */
	public Integer getAllowFinishedCc();

	public void setAllowFinishedCc(Integer allowFinishedCc);

	/**
	 * 是否允许转办
	 * @return
	 */
	public Integer getAllowDivert();

	public void setAllowDivert(Integer allowDivert) ;

	/**
	 * 流程定义附件。
	 * @return
	 */
	public Long getAttachment() ;

	public void setAttachment(Long attachment) ;

	/**
	 * 通知类型。
	 * @return
	 */
	public String getInformType() ;

	public void setInformType(String informType) ;

	/**
  	 * 相同任务节点是否允许跳转。
  	 * 0：不允许
  	 * 1：允许
  	 */
	public Short getSameExecutorJump();

	public void setSameExecutorJump(Short sameExecutorJump) ;

	//可选择路径的节点MAP
	public void setCanChoicePathNodeMap(Map canChoicePathNodeMap) ;
	
	//提交是否需要确认
	public Integer getSubmitConfirm();

	public void setSubmitConfirm(Integer submitConfirm);

	/**
	 * 归档时发送消息给发起人 类型
	 * @return
	 */
	public String getInformStart() ;

	public void setInformStart(String informStart) ;

	/**
	 * 允许引用。
	 * @return
	 */
	public Integer getAllowRefer();

	public void setAllowRefer(Integer allowRefer);

	/**
	 * 允许实例数量
	 * @return
	 */
	public Integer getInstanceAmount() ;

	public void setInstanceAmount(Integer instanceAmount) ;

	/**
	 * 直接启动不需要使用表单
	 * @return
	 */
	public Integer getDirectstart() ;

	public void setDirectstart(Integer directstart) ;

	/**
	 * 抄送消息类型
	 * @return
	 */
	public String getCcMessageType() ;

	public void setCcMessageType(String ccMessageType) ;

	

	/**
	 * allowMobile
	 * @return  the allowMobile
	 * @since   1.0.0
	 */
	public Integer getAllowMobile() ;

	/**
	 * @param allowMobile the allowMobile to set
	 */
	public void setAllowMobile(Integer allowMobile) ;

	/**
	 * allowRevert
	 * @return  the allowRevert
	 * @since   1.0.0
	 */
	public Integer getAllowRevert() ;

	/**
	 * @param allowRevert the allowRevert to set
	 */
	public void setAllowRevert(Integer allowRevert) ;

	public String getSkipSetting() ;

	public void setSkipSetting(String skipSetting);
}
