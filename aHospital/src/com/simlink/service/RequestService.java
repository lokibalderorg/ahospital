package com.simlink.service;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.simlink.response.LoginResponse;
import com.simlink.task.LoginTask;
import com.simlink.task.RegisterTask;

public class RequestService {

	private static String loginRequestUrl="";
	private static RequestQueue mRequestQueue;
	private static ImageLoader mImageLoader; 
	private static Gson mGson;
	
	public RequestService() {
	}
	
	public static void init(Context context) {  
		mGson = new Gson();
		
        mRequestQueue = Volley.newRequestQueue(context);  
        //TODO
        //int memClass = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();  
        // Use 1/8th of the available memory for this memory cache.  
        //int cacheSize = 1024 * 1024 * memClass / 8;  
        //mImageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache(cacheSize));  
    
        //load from conf
	}  
	
	public static RequestQueue getRequestQueue() {  
        if (mRequestQueue != null) {  
            return mRequestQueue;  
        } else {  
            throw new IllegalStateException("RequestQueue not initialized");  
        }  
    }  
  
    public static ImageLoader getImageLoader() {  
        if (mImageLoader != null) {  
            return mImageLoader;  
        } else {  
            throw new IllegalStateException("ImageLoader not initialized");  
        }  
    }  
	
    public static void commitLoginRequest(final LoginTask task) {
    	StringRequest request = new StringRequest(
				Method.POST,
				loginRequestUrl,
				new Listener<String>() {
                    public void onResponse(String response) {
                    	LoginResponse loginResponse = mGson.fromJson(response, LoginResponse.class);
                    	task.onLogin(loginResponse);
                    }
                },
                new ErrorListener() {
					public void onErrorResponse(VolleyError error) {
						task.onLoginError(error);
					}
                }){
	        @Override
	        protected Map<String,String> getParams(){
	            Map<String,String> params = new HashMap<String, String>();
	            task.prepareLoginReqParam(params);
	            return params;
	        }
	  
	        //@Override ?
	        //public Map<String, String> getHeaders() throws AuthFailureError {
	           // Map<String,String> params = new HashMap<String, String>();
	          //  params.put("Content-Type","application/x-www-form-urlencoded");
	         //   return params;
	        //}
	    };
	    
		mRequestQueue.add(request);
    	return;
    }
    
    public static void commitRegisterRequest(RegisterTask task) {
    	
    	return;
    }
    
	/*public static void commitLoginRequest(final UserEntity userEntity,
				Listener<String> successListener, 
				ErrorListener errorListener) {
		
		StringRequest request = new StringRequest(
				Method.POST,
				loginRequestUrl,
				successListener,
				errorListener){
	        @Override
	        protected Map<String,String> getParams(){
	            Map<String,String> params = new HashMap<String, String>();
	            params.put("username", userEntity.getUsername());
	            params.put("password", userEntity.getPassword());
	            return params;
	        }
	  
	        //@Override
	        //public Map<String, String> getHeaders() throws AuthFailureError {
	           // Map<String,String> params = new HashMap<String, String>();
	          //  params.put("Content-Type","application/x-www-form-urlencoded");
	         //   return params;
	        //}
	    };
	    
		mRequestQueue.add(request);
	}*/

	
	//TODO
	//other commit request...
}
