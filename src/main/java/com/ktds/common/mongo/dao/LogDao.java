package com.ktds.common.mongo.dao;

import com.ktds.common.mongo.vo.LoggerVO;
import com.ktds.common.mongo.vo.OperationHistoryVOForMongo;

public interface LogDao {

	public void writeLog(LoggerVO loggerVO);
	public void writeLog(OperationHistoryVOForMongo operationHistoryVOForMongo);
	
}
