package com.ktds.admin.operation.history.dao;

/**
 * 16/11/21 몽고 디비 연동
 * @author 206-017
 *
 */
public interface OperationLogHistoryDao extends OperationHistoryDao {

	public void writeLog(String logType, String message);
}
