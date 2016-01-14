package com.hotent.core.api.bpm;

import com.hotent.core.api.bpm.model.IBpmDefinition;

/**
 * 流程定义接口。
 * @author ray
 *
 */
public interface IBpmDefinitionService {
	
	/**
	 * 根据流程定义ID获取流程定义对象。
	 * @param actDefId
	 * @return
	 */
	IBpmDefinition getMainDefByActDefKey(String actDefKey);
	
	/**
	 * 根据流程定义ID获取流程定义实例。
	 * @param actDefId
	 * @return
	 */
	IBpmDefinition getByActDefId(String actDefId);
	
	

}
