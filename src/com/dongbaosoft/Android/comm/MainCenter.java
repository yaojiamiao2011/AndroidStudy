package com.dongbaosoft.Android.comm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dongbaosoft.Android.part01.R;
import com.dongbaosoft.Android.part01.R.layout;
import com.dongbaosoft.Android.part01.R.menu;
import com.dongbaosoft.Android.part03.BundleActivity;
import com.dongbaosoft.Android.part03.Tabview_Listview;
import com.dongbaosoft.Android.part04.FileStore;
import com.dongbaosoft.Android.part04.LoginActivity;
import com.dongbaosoft.Android.part04.SQLiteTest;
import com.dongbaosoft.Android.part05.Chat;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class MainCenter extends TabActivity implements OnClickListener,OnItemClickListener {

	TabHost tab;
	LinearLayout layout1, layout2, layout3, layout4;
	ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main_center);
		tab = this.getTabHost();
		LayoutInflater.from(this).inflate(R.layout.activity_main_center,
				tab.getTabContentView());

		tab.setOnTabChangedListener(new OnTabChangeListener() {
			public void onTabChanged(String arg0) {
				Toast.makeText(MainCenter.this, "changed to:" + arg0,
						Toast.LENGTH_SHORT).show();
			}
		});
		layout1 = (LinearLayout) findViewById(R.id.layout1);
		layout2 = (LinearLayout) findViewById(R.id.layout2);
		layout3 = (LinearLayout) findViewById(R.id.layout3);
		layout4 = (LinearLayout) findViewById(R.id.layout4);

		listview = new ListView(this);
		layout1.addView(listview);

		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

		listItem.add(addItem(1,"SQLLite Test."));
		listItem.add(addItem(2,"FileStore."));
		listItem.add(addItem(3,"SharedPreferneces"));
		listItem.add(addItem(4,"BundleActivity"));
		listItem.add(addItem(51, "Chat"));
		
		String[] from = { "id", "itemText" };
		int[] to = { android.R.id.text1, android.R.id.text2 };
		ListAdapter apt = new SimpleAdapter(this,listItem, android.R.layout.simple_list_item_2,  from, to);
        listview.setAdapter(apt);

		listview.setOnItemClickListener(this);
		
		TabSpec tabSpec1 = tab.newTabSpec("tabview1");
		tabSpec1.setIndicator("Ê×Ò³", getResources().getDrawable(R.drawable.star));
		tabSpec1.setContent(R.id.layout1);
		tab.addTab(tabSpec1);

		tab.addTab(tab
				.newTabSpec("tabview1")
				.setIndicator("Service",
						getResources().getDrawable(R.drawable.icon))
				.setContent(R.id.layout2));
		tab.addTab(tab
				.newTabSpec("tabview3")
				.setIndicator("About",
						getResources().getDrawable(R.drawable.icon))
				.setContent(R.id.layout3));
		tab.addTab(tab
				.newTabSpec("tabview4")
				.setIndicator("About",
						getResources().getDrawable(R.drawable.icon))
				.setContent(R.id.layout4));
	}

	private HashMap<String, Object> addItem(int id,String itemName)
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("itemText", itemName);
        return map;

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_center, menu);
		return true;
	}

	private void startNewActivity(Class cls) {
		startActivity(new Intent(this, cls));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Log.v("onItemClick", "arg1="+arg1+",arg2="+arg2+",arg3="+arg3);
		switch (arg2) {
		case 1:
			startNewActivity(FileStore.class);
			break;
		case 0:
			startNewActivity(SQLiteTest.class);
			break;
		case 2:
			startNewActivity(LoginActivity.class);
			break;
		case 3:
			startNewActivity(BundleActivity.class);
			break;
		case 4:
			startNewActivity(Chat.class);
			break;
		default:
			break;
		}
	}

}
