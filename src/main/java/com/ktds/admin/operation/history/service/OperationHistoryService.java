package com.ktds.admin.operation.history.service;

import java.util.List;

import com.ktds.admin.operation.history.vo.OperationHistoryListVO;
import com.ktds.admin.operation.history.vo.OperationHistorySearchVO;
import com.ktds.admin.operation.history.vo.OperationHistoryVO;

public interface OperationHistoryService {

	public OperationHistoryListVO getAllHistory(OperationHistorySearchVO historySearchVO);

}
