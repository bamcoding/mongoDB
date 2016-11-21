package com.ktds.common.mongo.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="logs")
public class LoggerVO {

	@Id
	private String id;
	private String type;
	private String message;
	private Object object;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObject() {
		return object;
	}
	//T는 타입이라는 뜻으로 뭐든지 들어갈 수 있다.
	public <T> void setObject(T object) {
		this.object = object;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
