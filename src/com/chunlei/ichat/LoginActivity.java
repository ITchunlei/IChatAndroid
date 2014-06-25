/**
 * Copyright (C) 2014 Wangchunlei
 * @date 2014-6-23
 * @author Wangchunlei
 * @email ITchunlei@163.com
 */
package com.chunlei.ichat;
import com.chunlei.ichat.R;
import com.easemob.EMCallBack;
import com.easemob.chat.EMChatManager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener, EMCallBack {
	private Button mRegisterBtn;
	private Button mLoginBtn;
	private EditText mAccountEtxt;
	private EditText mPasswordEtxt;
	
	
	private void login() {
		String account = mAccountEtxt.getText().toString();
		String password = mPasswordEtxt.getText().toString();
		EMChatManager.getInstance().login(account, password, this);
	}
	
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
			login();
			break;
		case R.id.login_register:
			startActivity(new Intent(this, RegisterActivity.class));
			break;
		default:
			break;
		}
	}

	@Override
	public void onError(int arg0, final String arg1) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(LoginActivity.this, "login error!" + arg1, 2000).show();
			}
		});
	}

	@Override
	public void onProgress(int arg0, String arg1) {
		
	}

	@Override
	public void onSuccess() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(LoginActivity.this, "login success!", 2000).show();
				LoginActivity.this.startActivity(new Intent(LoginActivity.this, IChatActivity.class));
				LoginActivity.this.finish();
			}
		});
		
	}

}
