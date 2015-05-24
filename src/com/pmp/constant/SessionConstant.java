package com.pmp.constant;

public interface SessionConstant {
	/**
	 * 当前session中的用户User标识
	 */
	public static final String GLOBAL_SESSION_USER = "GLOBAL_SESSION_USER";
	/**
	 * Token 标示
	 */
	public static final String GLOBAL_SESSION_TOKEN = "GLOBAL_SESSION_TOKEN";
	/**
	 * 重复提交判断标志
	 */
	public static final String GLOBAL_SESSION_SUBMIT = "GLOBAL_SESSION_SUBMIT";

	/**
	 * 提交表单成功
	 */
	public static final String GLOBAL_SESSION_SUBMIT_SUCCESS = "SUCCESS";

	/**
	 * 提交表单失败
	 */
	public static final String GLOBAL_SESSION_SUBMIT_FAILURE = "FAILURE";
}
