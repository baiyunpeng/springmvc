package com.pmp.entity.log;

import com.pmp.aop.aspectj.log.Log;
import com.pmp.common.DateUtil;

public class LogEntity {

	private String Level;
	private String className;
	private String methodName;
	private String moduleType;
	private String operationType;
	private String userType;
	private String username;
	private String userAlias;
	private String logInfo;
	private String describe;
	private String IP;
	private String dateTime;

	public LogEntity() {

	}

	public LogEntity(Builder builder) {
		this.Level = builder.Level;
		this.className = builder.className;
		this.methodName = builder.methodName;
		this.moduleType = builder.moduleType;
		this.operationType = builder.operationType;
		this.userType = builder.userType;
		this.username = builder.username;
		this.userAlias = builder.userAlias;
		this.logInfo = builder.logInfo;
		this.describe = builder.describe;
		this.IP = builder.IP;
		this.dateTime = builder.dateTime;
	}


	public static class Builder {
		private String Level;
		private String className;
		private String methodName;
		private String moduleType;
		private String operationType;
		private String userType;
		private String username;
		private String userAlias;
		private String logInfo;
		private String describe;
		private String IP;
		private String dateTime;

		public Builder() {

		}

		public Builder(Log log) {
			this.Level = log.level();
			this.moduleType = log.moduleType();
			this.operationType = log.operationType();
			this.logInfo = log.logInfo();
			this.describe = log.describe();
			this.dateTime = DateUtil.getNowDateTime();
		}

		public Builder Level(String level) {
			this.Level = level;
			return this;
		}

		public Builder className(String className) {
			this.className = className;
			return this;
		}

		public Builder methodName(String methodName) {
			this.methodName = methodName;
			return this;
		}

		public Builder moduleType(String moduleType) {
			this.moduleType = moduleType;
			return this;
		}

		public Builder operationType(String operationType) {
			this.operationType = operationType;
			return this;
		}

		public Builder userType(String userType) {
			this.userType = userType;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder userAlias(String userAlias) {
			this.userAlias = userAlias;
			return this;
		}

		public Builder logInfo(String logInfo) {
			this.logInfo = logInfo;
			return this;
		}

		public Builder describe(String describe) {
			this.describe = describe;
			return this;
		}

		public Builder IP(String IP) {
			this.IP = IP;
			return this;
		}

		public Builder dateTime(String dateTime) {
			this.dateTime = dateTime;
			return this;
		}

		public LogEntity builder() {
			LogEntity logEntity = new LogEntity(this);
			return logEntity;
		}
	}

	public String getLevel() {
		return Level;
	}

	public void setLevel(String level) {
		Level = level;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	public String getLogInfo() {
		return logInfo;
	}

	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}
