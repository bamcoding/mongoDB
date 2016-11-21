package com.ktds.common.mongo.logger;

import org.slf4j.Logger;

public class MongoLogger {

	private static MongoDBLogger mongoDBLogger;
	private static MongoDBHistoryLogger mongoDBHistoryLogger;
		
	public void setMongoDBLogger(MongoDBLogger mongoDBLogger) {
		MongoLogger.mongoDBLogger = mongoDBLogger;
	}
	
	public static MongoDBLogger getMongoDBLogger(Logger logger) {
		MongoLogger.mongoDBLogger.setLogger(logger);
		return mongoDBLogger;
	}
		
	public void setMongoDBHistoryLogger(MongoDBHistoryLogger mongoDBHistoryLogger) {
		MongoLogger.mongoDBHistoryLogger = mongoDBHistoryLogger;
	}

	public static MongoDBHistoryLogger getMongoDBHistoryLogger(Logger logger) {
		MongoLogger.mongoDBHistoryLogger.setLogger(logger);
		return mongoDBHistoryLogger;
	}
}
