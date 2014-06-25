package com.chunlei.ichat;

import com.easemob.chat.EMChatManager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SearchView;

public class AddFriendActivity extends Activity implements OnClickListener {
	private SearchView mSearchView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_friend);
		
		mSearchView = (SearchView) findViewById(R.id.add_friend_search);
		mSearchView.setOnSearchClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_friend, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		//EMChatManager.getInstance().getChatOptions()
	}

}
