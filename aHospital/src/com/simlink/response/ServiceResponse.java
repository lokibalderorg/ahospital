package com.simlink.response;

import com.simlink.entity.MsgEntity;

public class ServiceResponse {
	private int statusCode;
	
	private MsgEntity msg;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public MsgEntity getMsg() {
		return msg;
	}

	public void setMsg(MsgEntity msg) {
		this.msg = msg;
	}
	
	
}
