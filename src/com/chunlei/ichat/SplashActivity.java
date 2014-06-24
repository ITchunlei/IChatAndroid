/**
 * Copyright (C) 2014 Wangchunlei
 * @date 2014-6-23
 * @author Wangchunlei
 * @email ITchunlei@163.com
 */
package com.chunlei.ichat;
import com.chunlei.ichat.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SplashActivity extends Activity {
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			SplashActivity.this.startActivity(new Intent(SplashActivity.this, LoginActivity.class));
			SplashActivity.this.finish();
		}
	};
	
	private Thread mThread = new Thread() {
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SplashActivity.this.mHandler.sendEmptyMessage(0);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		mThread.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
