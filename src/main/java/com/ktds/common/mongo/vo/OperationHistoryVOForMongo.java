package com.ktds.common.mongo.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ktds.admin.operation.history.vo.OperationHistoryVO;

@Document(collection="history")
public class OperationHistoryVOForMongo {
	@Id
	private String id;
	private OperationHistoryVO operationHistoryVO ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public OperationHistoryVO getOperationHistoryVO() {
		return operationHistoryVO;
	}
	public void setOperationHistoryVO(OperationHistoryVO operationHistoryVO) {
		this.operationHistoryVO = operationHistoryVO;
	}
}
