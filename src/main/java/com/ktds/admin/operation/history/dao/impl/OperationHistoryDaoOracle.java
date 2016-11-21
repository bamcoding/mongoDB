package com.ktds.admin.operation.history.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.admin.operation.history.dao.OperationHistoryDao;
import com.ktds.admin.operation.history.vo.OperationHistorySearchVO;
import com.ktds.admin.operation.history.vo.OperationHistoryVO;

public class OperationHistoryDaoOracle extends SqlSessionDaoSupport implements OperationHistoryDao{

	@Override
	public int getHistoryById(String boardId, String userId) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("boardId", boardId);
		parameter.put("userId", userId);
		return getSqlSession().selectOne("operationHistoryDao.getHistoryById", parameter);
		
	}
	
	@Override
	public int addReadHistory(String boardId, String userId) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("boardId", boardId);
		parameter.put("userId", userId);
		return getSqlSession().insert("operationHistoryDao.addReadHistory", parameter);
	}

	@Override
	public int addAllHistory(OperationHistoryVO operationHistoryVO) {
		return getSqlSession().insert("operationHistoryDao.addAllHistory", operationHistoryVO);
	}

	@Override
	public List<OperationHistoryVO> getAllHistory(OperationHistorySearchVO historySearchVO) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("operationHistoryDao.getAllHistory", historySearchVO);
	}

	@Override
	public int getHistoryCount(OperationHistorySearchVO historySearchVO) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("operationHistoryDao.getHistoryCount", historySearchVO);
	}
}
