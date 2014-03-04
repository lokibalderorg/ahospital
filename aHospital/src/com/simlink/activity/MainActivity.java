package com.simlink.activity;

import java.util.Map;

import com.android.volley.VolleyError;
import com.example.ahospital.R;
import com.simlink.entity.UserEntity;
import com.simlink.response.LoginResponse;
import com.simlink.response.ServiceResponse;
import com.simlink.service.RequestServiceMock;
import com.simlink.task.LoginTask;
import com.simlink.task.RegisterTask;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements LoginTask,RegisterTask {

	//view item
	private Button mbButtonLogin;
	private EditText mEdittextUsername;
	
	UserEntity userEntity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		RequestServiceMock.init(this.getApplicationContext());
		
		findViews();
		initViews();
		initListeners();
	}
	
	public void findViews() {
		mbButtonLogin = (Button) findViewById(R.id.login_button);
		mEdittextUsername = (EditText) findViewById(R.id.username_edittext);
		return;
	}
	
	public void initViews() {
		return;
	}
	
	public void initListeners() {
		mbButtonLogin.setOnClickListener(loginOnClickListener);
		return;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	private Button.OnClickListener loginOnClickListener = new Button.OnClickListener() {
    	public void onClick(View v) {
    		RequestServiceMock.commitLoginRequest(MainActivity.this);
    	}
    };

	//Login Task
	@Override
	public void onLogin(LoginResponse response) {
		Log.i("aHospitalLog","start to new activity");
		Intent intent = new Intent();
		intent.setClass(MainActivity.this,LoginResultActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString("Login_result",mEdittextUsername.getText().toString() + response.getMsg().getGlobal());
		intent.putExtras(bundle);
		startActivity(intent);
		
	}

	@Override
	public void onLoginError(VolleyError arg0) {
		// TODO Auto-generated method stub
		Log.i("aHospitalLog", "Login request error:onErrorResponse:"+arg0.getMessage());
		new AlertDialog.Builder(this)
		.setTitle("Error")
		.setMessage("Login Request Error; Invalid username or password")
		.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialoginterface, int i) {
					}
		})
		.show();
	}

	@Override
	public void onRegister(ServiceResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRegisterError(VolleyError arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prepareRegisterReqParam(Map<String, String> params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prepareLoginReqParam(Map<String, String> params) {
		// TODO Auto-generated method stub
		params.put("username", userEntity.getUsername());
		params.put("password", userEntity.getPassword());
	}

}
