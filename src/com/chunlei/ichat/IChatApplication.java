package com.chunlei.ichat;

import com.easemob.chat.EMChat;

import android.app.Application;

public class IChatApplication extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		EMChat.getInstance().init(this);
	}
}
