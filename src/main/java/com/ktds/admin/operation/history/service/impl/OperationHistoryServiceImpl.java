package com.ktds.admin.operation.history.service.impl;

import java.util.List;

import com.ktds.admin.operation.history.biz.OperationHistoryBiz;
import com.ktds.admin.operation.history.service.OperationHistoryService;
import com.ktds.admin.operation.history.vo.OperationHistoryListVO;
import com.ktds.admin.operation.history.vo.OperationHistorySearchVO;
import com.ktds.admin.operation.history.vo.OperationHistoryVO;

public class OperationHistoryServiceImpl implements OperationHistoryService {

	private OperationHistoryBiz operationHistoryBiz;

	public void setOperationHistoryBiz(OperationHistoryBiz operationHistoryBiz) {
		this.operationHistoryBiz = operationHistoryBiz;
	}

	@Override
	public OperationHistoryListVO getAllHistory(OperationHistorySearchVO historySearchVO) {
		// TODO Auto-generated method stub
		return operationHistoryBiz.getAllHistory(historySearchVO);
	}
	
	
}
