package com.simlink.service;

import java.util.HashMap;
import java.util.Map;

import com.simlink.entity.MsgEntity;
import com.simlink.response.LoginResponse;
import com.simlink.task.LoginTask;
import com.simlink.task.RegisterTask;

public class RequestServiceMock extends RequestService{
	
	public static void commitLoginRequest(LoginTask task) {

		Map<String,String> params = new HashMap<String, String>();
		task.prepareLoginReqParam(params);
		
		LoginResponse response = new LoginResponse();
		MsgEntity msg = new MsgEntity();
		msg.setGlobal("welcome to use aHospital");
		response.setMsg(msg);
		
		task.onLogin(response);
    	return;
    }
    
    public static void commitRegisterRequest(RegisterTask task) {
    	
    	return;
    }
}
