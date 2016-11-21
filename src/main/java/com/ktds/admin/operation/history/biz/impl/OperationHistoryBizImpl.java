package com.ktds.admin.operation.history.biz.impl;

import com.ktds.admin.operation.history.biz.OperationHistoryBiz;
import com.ktds.admin.operation.history.dao.OperationHistoryDao;
import com.ktds.admin.operation.history.dao.OperationLogHistoryDao;
import com.ktds.admin.operation.history.vo.OperationHistoryListVO;
import com.ktds.admin.operation.history.vo.OperationHistorySearchVO;
import com.ktds.admin.operation.history.vo.OperationHistoryVO;
import com.ktds.common.util.pager.Pager;
import com.ktds.common.util.pager.PagerFactory;

public class OperationHistoryBizImpl implements OperationHistoryBiz {

	private OperationHistoryDao operationHistoryDao;
	//몽고디비 연동
	private OperationLogHistoryDao operationLogHistoryDao;
	

	public OperationLogHistoryDao getOperationLogHistoryDao() {
		return operationLogHistoryDao;
	}

	public void setOperationLogHistoryDao(OperationLogHistoryDao operationLogHistoryDao) {
		this.operationLogHistoryDao = operationLogHistoryDao;
	}

	public OperationHistoryDao getOperationHistoryDao() {
		return operationHistoryDao;
	}

	public void setOperationHistoryDao(OperationHistoryDao operationHistoryDao) {
		this.operationHistoryDao = operationHistoryDao;
	}
	
	@Override
	public boolean getHistoryById(String userId, String boardId) {
		return operationHistoryDao.getHistoryById(boardId, userId) > 0;
	}

	@Override
	public boolean addAllHistory(OperationHistoryVO operationHistoryVO) {
		operationLogHistoryDao.writeLog("OperationHistoryBizImpl.addAllHistroy", "addAllHistory 호출");
		operationLogHistoryDao.writeLog("OperationHistoryBizImpl.addAllHistroy", operationHistoryVO.getOperationHistoryId());
		return operationHistoryDao.addAllHistory(operationHistoryVO) > 0;
	}

	@Override
	public OperationHistoryListVO getAllHistory(OperationHistorySearchVO historySearchVO) {
		
		int count = operationHistoryDao.getHistoryCount(historySearchVO);
		
		Pager pager = PagerFactory.getPager(true);
		pager.setTotalArticleCount(count);
		pager.setPageNumber(historySearchVO.getPageNumber());
		historySearchVO.setStartNumber(pager.getStartArticleNumber());
		historySearchVO.setEndNumber(pager.getEndArticleNumber());
		
		
		OperationHistoryListVO historyList = new OperationHistoryListVO();
		historyList.setOperationHistoryList(operationHistoryDao.getAllHistory(historySearchVO));
		historyList.setPager(pager);
		return historyList;
	}
	
}
