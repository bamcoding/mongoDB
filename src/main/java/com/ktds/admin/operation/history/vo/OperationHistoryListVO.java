package com.ktds.admin.operation.history.vo;

import java.util.List;

import com.ktds.common.util.pager.Pager;

public class OperationHistoryListVO {
	List<OperationHistoryVO> OperationHistoryList;
	Pager pager;
	public List<OperationHistoryVO> getOperationHistoryList() {
		return OperationHistoryList;
	}
	public void setOperationHistoryList(List<OperationHistoryVO> operationHistoryList) {
		OperationHistoryList = operationHistoryList;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	
}
