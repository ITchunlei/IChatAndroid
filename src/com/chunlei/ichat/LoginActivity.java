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
import android.view.Menu;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
