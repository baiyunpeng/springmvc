package com.pmp.common;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.pmp.entity.log.LogEntity;

public class LogUtils {

	public static void infoLog(LogEntity logEntity) {
		Logger logger = LogManager.getLogger(logEntity.getClassName());
		if (logger.isInfoEnabled()) {
			logger.info(logEntity.toString());
		}
	}

	public static void operationLog(LogEntity logEntity) {
		Logger logger = LogManager.getLogger(logEntity.getClassName());
		if (logger.isInfoEnabled()) {
			logger.info(logEntity.toString());
		}
	}

	public static void debugLog(LogEntity logEntity) {
		Logger logger = LogManager.getLogger(logEntity.getClassName());
		if (logger.isInfoEnabled()) {
			logger.debug(logEntity.toString());
		}
	}

	public static void errorLog(LogEntity logEntity) {
		Logger logger = LogManager.getLogger(logEntity.getClassName());
		if (logger.isInfoEnabled()) {
			logger.error(logEntity.toString());
		}
	}

}
