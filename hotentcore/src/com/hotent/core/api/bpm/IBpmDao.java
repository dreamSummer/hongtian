package com.hotent.core.api.bpm;

public interface IBpmDao {
	
	/**
	 * 根据deployId获取流程定义ID。
	 * @param deployId
	 * @return
	 */
	String getActDefIdByDeployId(String deployId);
	
	/**
	 * 根据deployId获取流程定义XML。
	 * @param deployId
	 * @return
	 */
	String getDefXmlByDeployId(String deployId);
	
	/**
	 * 写入流程定义xml到表ACT_GE_BYTEARRAY。
	 * @param deployId
	 * @param defXml
	 */
	void wirteDefXml(final String deployId, String defXml);
	
	
	/**
	 * 根据流程定义ID获取deployId。
	 * @param actDefId
	 * @return
	 */
	String getDeployIdByActdefId(String actDefId);
	
	/**
	 * 根据流程定义KEY获取流程定义XML。
	 * @param actDefkey
	 * @return
	 */
	String getXmlByDefKey(String actDefkey);
	

}
