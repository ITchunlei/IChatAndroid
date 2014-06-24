/**
 * Copyright (C) 2014 Wangchunlei
 * @date 2014-6-23
 * @author Wangchunlei
 * @email ITchunlei@163.com
 */
package com.chunlei.ichat;
import com.chunlei.ichat.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener {
	private Button mRegisterBtn;
	private Button mLoginBtn;
	private EditText mAccountEtxt;
	private EditText mPasswordEtxt;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		mRegisterBtn = (Button) findViewById(R.id.login_register);
		mLoginBtn = (Button) findViewById(R.id.login_ok);
		mAccountEtxt = (EditText) findViewById(R.id.login_account);
		mPasswordEtxt = (EditText) findViewById(R.id.login_password);
		
		// register listener
		mRegisterBtn.setOnClickListener(this);
		mLoginBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		int id = view.getId();
		switch(id) {
		case R.id.login_ok:
			startActivity(new Intent(this, IChatActivity.class));
			finish();
			break;
		case R.id.login_register:
			startActivity(new Intent(this, RegisterActivity.class));
			break;
		default:
			break;
		}
	}

}
