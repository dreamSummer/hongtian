package com.hotent.core.api.bpm.model;

public class ITaskOpinion {

	/**
	 * 初始化\尚未审批=-2
	 */
	public final static Short STATUS_INIT = (short) -2;
	/**
	 * 正在审批
	 */
	public final static Short STATUS_CHECKING = (short) -1;
	/**
	 * 弃权=0
	 */
	public final static Short STATUS_ABANDON = (short) 0;
	/**
	 * 同意=1
	 */
	public final static Short STATUS_AGREE = (short) 1;
	/**
	 * 反对=2
	 */
	public final static Short STATUS_REFUSE = (short) 2;
	/**
	 * 驳回=3
	 */
	public final static Short STATUS_REJECT = (short) 3;
	/**
	 * 撤销=4
	 */
	public final static Short STATUS_RECOVER = (short) 4;

	/**
	 * 会签通过
	 */
	public final static Short STATUS_PASSED = (short) 5;

	/**
	 * 会签不通过。
	 */
	public final static Short STATUS_NOT_PASSED = (short) 6;

	/**
	 * 知会意见。
	 */
	public final static Short STATUS_NOTIFY = (short) 7;

	/**
	 * 更改执行路径
	 */
	public final static Short STATUS_CHANGEPATH = (short) 8;
	
	/**
	 * 终止
	 */
	public final static Short STATUS_ENDPROCESS=(short)14;
	
	/**
	 * 沟通意见。
	 */
	public final static Short STATUS_COMMUNICATION=(short)15;
	
	/**
	 * 沟通反馈。
	 */
	public final static Short STATUS_COMMUN_FEEDBACK=(short)20;
	
	/**
	 * 办结转发
	 */
	public final static Short STATUS_FINISHDIVERT=(short)16;
	
	/**
	 * 转办。
	 */
	public final   static Short STATUS_DELEGATE=(short)21;
	
	/**
	 * 转办取消。
	 */
	public final static Short STATUS_DELEGATE_CANCEL=(short)22;
	
	/**
	 * 更改执行人。
	 */
	public final static Short STATUS_CHANGE_ASIGNEE = (short) 23;
	/**
	 * 驳回到发起人
	 */
	public final static Short STATUS_REJECT_TOSTART = (short) 24;
	/**
	 * 撤销到发起人
	 */
	public final static Short STATUS_RECOVER_TOSTART = (short) 25;
	
	
	
	/**
	 * 撤销
	 */
	public final static Short STATUS_REVOKED=(short)17;
	
	/**
	 * 逻辑删除
	 */
	public final static Short STATUS_DELETE=(short)18;
	
	/**
	 * 抄送
	 */
	public final static Short STATUS_NOTIFY_COPY=(short)19;
	
	/**
	 * 代理。
	 */
	public final   static Short STATUS_AGENT=(short)26;
	/**
	 * 代理撤消。
	 */
	public final   static Short STATUS_AGENT_CANCEL=(short)27;
	
	/**
	 * 表单意见。
	 */
	public final   static Short STATUS_OPINION=(short)28;
	/**
	 * 驳回取消
	 */
	public final   static Short STATUS_BACK_CANCEL=(short)29;
	
	/**
	 * 撤销取消
	 */
	public final   static Short STATUS_REVOKED_CANCEL=(short)30;
	/**
	 * 通过取消
	 */
	public final   static Short STATUS_PASS_CANCEL=(short)31;
	/**
	 * 拒绝取消
	 */
	public final   static Short STATUS_REFUSE_CANCEL=(short)32;
	/**
	 * 提交
	 */
	public final   static Short STATUS_SUBMIT=(short)33;
	/**
	 * 重新提交
	 */
	public final   static Short STATUS_RESUBMIT=(short)34;
	
	/**
	 * 干预
	 */
	public final   static Short STATUS_INTERVENE=(short)35;
	
	/**
	 * 重启任务
	 */
	public final   static Short STATUS_RESTART_TASK=(short)36;
	
	/**
	 * 执行过，用于自动节点记录状态。
	 */
	public final static Short STATUS_EXECUTED=(short)37;

}
