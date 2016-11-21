package com.ktds.common.mongo.logger;

import org.slf4j.Logger;

import com.ktds.admin.operation.history.vo.OperationHistoryVO;
import com.ktds.common.mongo.dao.LogDao;
import com.ktds.common.mongo.vo.LoggerVO;
import com.ktds.common.mongo.vo.OperationHistoryVOForMongo;

public class MongoDBLogger{
	private Logger logger;
	private LogDao logDao;

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}
	
	
	public <T> void trace(String message, T object) {
		// TODO Auto-generated method stub
		logger.trace(message);
		
		LoggerVO loggerVO = new LoggerVO();
		loggerVO.setMessage(message);
		loggerVO.setType("trace");
		loggerVO.setObject(object);
	}
	public <T> void debug(String message, T object) {
		// TODO Auto-generated method stub
		logger.debug(message);
		
		LoggerVO loggerVO = new LoggerVO();
		loggerVO.setMessage(message);
		loggerVO.setType("debug");
		loggerVO.setObject(object);
	}
	public <T> void info(String message, T object) {
		// TODO Auto-generated method stub
		logger.info(message);
		
		LoggerVO loggerVO = new LoggerVO();
		loggerVO.setMessage(message);
		loggerVO.setType("info");
		loggerVO.setObject(object);
	}
	public <T> void warn(String message, T object) {
		// TODO Auto-generated method stub
		logger.warn(message);
		
		LoggerVO loggerVO = new LoggerVO();
		loggerVO.setMessage(message);
		loggerVO.setType("warn");
		loggerVO.setObject(object);
	}
	public <T> void error(String message, T object) {
		// TODO Auto-generated method stub
		logger.error(message);
		
		LoggerVO loggerVO = new LoggerVO();
		loggerVO.setMessage(message);
		loggerVO.setType("error");
		loggerVO.setObject(object);
	}
}
