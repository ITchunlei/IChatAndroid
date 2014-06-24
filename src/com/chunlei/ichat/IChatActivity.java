package com.chunlei.ichat;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class IChatActivity extends Activity {
	private ViewPager mViewPager;
	private IChatViewPagerAdapter mAdapter;
	private List<View> mViews;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ichat);
		mViewPager = (ViewPager) findViewById(R.id.view_pager);
		mViewPager.setCurrentItem(0);
		
		mViews = new ArrayList<View>();
		mViews.add(LayoutInflater.from(this).inflate(R.layout.chat, null));
		mViews.add(LayoutInflater.from(this).inflate(R.layout.discovery, null));
		mViews.add(LayoutInflater.from(this).inflate(R.layout.contacts, null));
		
		getFragmentManager().beginTransaction().commit();
		mAdapter = new IChatViewPagerAdapter(mViews);
		mViewPager.setAdapter(mAdapter);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ichat, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch(id) {
		case R.id.action_add_friend:
			startActivity(new Intent(this, AddFriendActivity.class));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	
	class IChatViewPagerAdapter extends PagerAdapter {
		private List<View> mViews;
		public IChatViewPagerAdapter(List<View> views) {
			mViews = views;
		}
		public int getCount() {  
	        return mViews.size();
	    }  
	    @Override  
	    public void destroyItem(ViewGroup container, int position, Object object) { 
	
	    }  
	    @Override  
	    public Object instantiateItem(ViewGroup container, int position) {
	    	View view = mViews.get(position);
	    	container.addView(view);
	        return view;  
	    }  
	    @Override  
	    public boolean isViewFromObject(View view, Object object) {  
	        return view == object;  
	    }  
		
	}

}
