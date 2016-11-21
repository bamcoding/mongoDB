
package com.ktds.admin.operation.history.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.ktds.admin.operation.history.dao.OperationLogHistoryDao;
import com.ktds.admin.operation.history.vo.OperationHistorySearchVO;
import com.ktds.admin.operation.history.vo.OperationHistoryVO;
/**
 * 16/11/21 몽고 디비 연동
 * @author 206-017
 *
 */
public class OperationHistoryDaoMongoDB implements OperationLogHistoryDao{

	private MongoTemplate mongoTemplate;
	
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public int getHistoryById(String boardId, String userId) {
		throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
	}

	@Override
	public int addReadHistory(String boardId, String userId) {
		throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
	}

	@Override
	public int addAllHistory(OperationHistoryVO operationHistoryVO) {
		throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
	}

	@Override
	public List<OperationHistoryVO> getAllHistory(OperationHistorySearchVO historySearchVO) {
		throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
	}

	@Override
	public int getHistoryCount(OperationHistorySearchVO historySearchVO) {
		throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
	}

	@Override
	public void writeLog(String logType, String message) {
		// TODO Auto-generated method stub
		OperationHistoryVO history = new OperationHistoryVO();
		history.setOperation(message);
		history.setOperationType(logType);
		mongoTemplate.insert(history);
	}

}
