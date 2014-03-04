package com.simlink.task;

import java.util.Map;

import com.android.volley.VolleyError;
import com.simlink.response.LoginResponse;

public interface LoginTask {
	public void onLogin(LoginResponse response);
	
	public void onLoginError(VolleyError error);
	
	public void prepareLoginReqParam(Map<String,String> params);
}
