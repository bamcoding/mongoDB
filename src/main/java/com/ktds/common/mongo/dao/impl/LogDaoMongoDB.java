package com.ktds.common.mongo.dao.impl;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.ktds.common.mongo.dao.LogDao;
import com.ktds.common.mongo.vo.LoggerVO;
import com.ktds.common.mongo.vo.OperationHistoryVOForMongo;

public class LogDaoMongoDB implements LogDao{
	private MongoTemplate mongoTemplate;
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void writeLog(LoggerVO loggerVO) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(loggerVO);
	}

	@Override
	public void writeLog(OperationHistoryVOForMongo operationHistoryVOForMongo) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(operationHistoryVOForMongo);
	}
	
	
}
