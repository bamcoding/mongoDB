package com.ktds.admin.operation.history.biz;

import java.util.List;

import com.ktds.admin.operation.history.vo.OperationHistoryListVO;
import com.ktds.admin.operation.history.vo.OperationHistorySearchVO;
import com.ktds.admin.operation.history.vo.OperationHistoryVO;

public interface OperationHistoryBiz {

	public boolean getHistoryById(String userId, String boardId);

	public boolean addAllHistory(OperationHistoryVO operationHistoryVO);

	public OperationHistoryListVO getAllHistory(OperationHistorySearchVO historySearchVO);
}
