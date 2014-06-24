package com.chunlei.ichat;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.chunlei.ichat.model.User;

class ContactsListAdapter extends BaseAdapter {
	private Context mContext;
	private List<User> mUsers;
	
	public ContactsListAdapter(Context context, List<User> users) {
		mContext = context;
		users = mUsers;
	}
	
	@Override
	public int getCount() {
		return mUsers.size();
	}

	@Override
	public Object getItem(int index) {
		return mUsers.get(index);
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		
		
		
		
		return null;
	}
}

