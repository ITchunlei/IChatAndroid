/**
 * Copyright (C) 2014 Wangchunlei
 * @date 2014-6-23
 * @author Wangchunlei
 * @email ITchunlei@163.com
 */

package com.chunlei.ichat;

import com.chunlei.ichat.R;
import com.easemob.chat.EMChatManager;
import com.easemob.exceptions.EaseMobException;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity implements OnClickListener {
	private EditText mAccount;
	private EditText mPassword;
	private EditText mRePassword;
	private Button mRegisterBtn;
	
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			Toast.makeText(RegisterActivity.this, "register succeuss!", 2000).show();
		}
	};
	
	private void register() {
		final String account = mAccount.getText().toString();
		final String password = mPassword.getText().toString();
		new Thread() {
			@Override
			public void run() {
				try {
					EMChatManager.getInstance().createAccountOnServer(account, password);
				} catch (EaseMobException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RegisterActivity.this.mHandler.sendEmptyMessage(0);
			}
		}.start();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		mAccount = (EditText) findViewById(R.id.register_account);
		mPassword = (EditText) findViewById(R.id.register_password);
		mRePassword = (EditText) findViewById(R.id.register_repassword);
		mRegisterBtn = (Button) findViewById(R.id.register_ok);
		
		mRegisterBtn.setOnClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		int id = view.getId();
		switch(id) {
		case R.id.register_ok:
			register();
			break;
		default:
			break;
		}
	}

}
