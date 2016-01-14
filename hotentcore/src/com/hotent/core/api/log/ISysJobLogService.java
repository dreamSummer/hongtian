package com.hotent.core.api.log;

import java.util.Date;

public interface ISysJobLogService {
	
	/**
	 * 添加管理日志。
	 * @param jobLog
	 */
	void addLog(ISysJobLog jobLog);
	
	/**
	 * 获取日志对象。
	 * @param jobName
	 * @param trigName
	 * @param strStartTime
	 * @param strEndTime
	 * @param runTime
	 * @param content
	 * @param state
	 * @return
	 */
	ISysJobLog getJobLog(String jobName, String trigName, Date strStartTime,
			Date strEndTime, long runTime,String content,int state);
		
	
}
