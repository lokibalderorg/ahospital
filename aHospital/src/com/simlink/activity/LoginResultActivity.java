package com.simlink.activity;

import com.example.ahospital.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginResultActivity extends Activity {
	
	private TextView textview_result;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_result_view);
        findViews();
        initViews();
    }
	
	private void findViews() {
		textview_result = (TextView)findViewById(R.id.login_result_textview);
	}

	private void initViews() {
		Bundle bundle = this.getIntent().getExtras();
		textview_result.setText("Result:" + bundle.getString("Login_result"));
	}
}
