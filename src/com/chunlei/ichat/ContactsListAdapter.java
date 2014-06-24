package com.chunlei.ichat;

import java.util.Comparator;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.chunlei.ichat.model.User;
import com.chunlei.ichat.utils.PinYinUtil;

class ContactsListAdapter extends BaseAdapter {
	private Context mContext;
	private List<User> mUsers;
	
	public ContactsListAdapter(Context context, List<User> users) {
		mContext = context;
		mUsers = users;
	}
	
	@Override
	public int getCount() {
		return mUsers.size();
	}

	@Override
	public Object getItem(int index) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		
		return null;
	}
	
	
	class UserComparator implements Comparator {
		@Override
		public int compare(Object obj1, Object obj2) {
			User user1 = (User) obj1;
			User user2 = (User) obj2;
			String name1 = user1.getName();
			String name2 = user2.getName();
			char py1 = PinYinUtil.getPinYinHeadChar(name1);
			char py2 = PinYinUtil.getPinYinHeadChar(name2);
			if (py1 > py2) {
				return 1;
			} else if (py1 < py2) {
				return -1;
			} else {
				return 0;
			}
		}
		
		
	}
	
	
}

