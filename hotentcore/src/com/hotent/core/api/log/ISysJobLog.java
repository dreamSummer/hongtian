package com.hotent.core.api.log;

public interface ISysJobLog {
	
	
	public void setLogId(Long logId) ;
	/**
	 * 返回 logId
	 * @return
	 */
	public Long getLogId() ;

	public void setJobName(String jobName) ;
	/**
	 * 返回 jobName
	 * @return
	 */
	public String getJobName() ;

	public void setTrigName(String trigName) ;
	/**
	 * 返回 trigName
	 * @return
	 */
	public String getTrigName() ;

	public void setStartTime(java.util.Date startTime) ;
	/**
	 * 返回 startTime
	 * @return
	 */
	public java.util.Date getStartTime() ;

	public void setEndTime(java.util.Date endTime) ;
	/**
	 * 返回 endTime
	 * @return
	 */
	public java.util.Date getEndTime() ;

	public void setContent(String content) ;
	/**
	 * 返回 content
	 * @return
	 */
	public String getContent() ;

	public void setState(int state) ;
	/**
	 * 返回 state
	 * @return
	 */
	public int getState() ;

	public void setRunTime(Long runTime) ;
	/**
	 * 返回 runTime
	 * @return
	 */
	public Long getRunTime() ;
}
