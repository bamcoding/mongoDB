package com.ktds.admin.operation.history.dao;

import java.util.List;

import com.ktds.admin.operation.history.vo.OperationHistorySearchVO;
import com.ktds.admin.operation.history.vo.OperationHistoryVO;

public interface OperationHistoryDao {

	public int getHistoryById(String boardId, String userId);

	public int addReadHistory(String boardId, String userId);
	
	public int addAllHistory(OperationHistoryVO operationHistoryVO );

	public List<OperationHistoryVO> getAllHistory(OperationHistorySearchVO historySearchVO);

	public int getHistoryCount(OperationHistorySearchVO historySearchVO);
}
