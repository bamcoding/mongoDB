package com.ktds.common.mongo.logger;

import org.slf4j.Logger;

import com.ktds.admin.operation.history.vo.OperationHistoryVO;
import com.ktds.common.mongo.dao.LogDao;
import com.ktds.common.mongo.vo.LoggerVO;
import com.ktds.common.mongo.vo.OperationHistoryVOForMongo;

public class MongoDBHistoryLogger{
	private Logger logger;
	private LogDao logDao;

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}
	
	
	
	public <T> void trace(String message, OperationHistoryVO object) {
		// TODO Auto-generated method stub
		logger.trace(message);
		
		OperationHistoryVOForMongo loggerVO = new OperationHistoryVOForMongo();
		loggerVO.setOperationHistoryVO(object);
		logDao.writeLog(loggerVO);
	}
	public <T> void debug(String message, OperationHistoryVO object) {
		// TODO Auto-generated method stub
		logger.debug(message);
		
		OperationHistoryVOForMongo loggerVO = new OperationHistoryVOForMongo();
		loggerVO.setOperationHistoryVO(object);
		logDao.writeLog(loggerVO);
	}
	public <T> void info(String message, OperationHistoryVO object) {
		// TODO Auto-generated method stub
		logger.info(message);
		
		OperationHistoryVOForMongo loggerVO = new OperationHistoryVOForMongo();
		loggerVO.setOperationHistoryVO(object);
		logDao.writeLog(loggerVO);
	}
	public <T> void warn(String message, OperationHistoryVO object) {
		// TODO Auto-generated method stub
		logger.warn(message);
		
		OperationHistoryVOForMongo loggerVO = new OperationHistoryVOForMongo();
		loggerVO.setOperationHistoryVO(object);
		logDao.writeLog(loggerVO);
	}
	public <T> void error(String message, OperationHistoryVO object) {
		// TODO Auto-generated method stub
		logger.error(message);
		
		OperationHistoryVOForMongo loggerVO = new OperationHistoryVOForMongo();
		loggerVO.setOperationHistoryVO(object);
		logDao.writeLog(loggerVO);
	}
}
