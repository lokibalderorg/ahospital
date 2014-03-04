package com.simlink.response;

import com.simlink.entity.UserEntity;

public class LoginResponse extends ServiceResponse{
	
	private UserEntity result;

	public UserEntity getResult() {
		return result;
	}

	public void setResult(UserEntity result) {
		this.result = result;
	}
	
	
}
