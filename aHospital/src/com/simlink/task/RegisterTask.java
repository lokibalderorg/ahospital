package com.simlink.task;

import java.util.Map;

import com.android.volley.VolleyError;
import com.simlink.response.ServiceResponse;

public interface RegisterTask {
	public void onRegister(ServiceResponse response);
	
	public void onRegisterError(VolleyError error);
	
	public void prepareRegisterReqParam(Map<String,String> params);
}
