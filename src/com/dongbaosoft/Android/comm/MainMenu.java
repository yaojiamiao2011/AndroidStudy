package com.dongbaosoft.Android.comm;

import android.app.Activity;
import java.util.ArrayList;
import java.util.HashMap;

import com.dongbaosoft.Android.part05.Chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainMenu implements OnItemClickListener {

	private Context context;

	private MainMenu() {
	}

	public MainMenu(Context context) {
		this.context = context;
	}


	public HashMap<String, Object> addItem(int id,String itemName)
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("itemText", itemName);
        return map;

	}

	public void startNewActivity(Class cls) {
		context.startActivity(new Intent(context, cls));
	}

	public ListView createMenuList3() {

		ListView listView = new ListView(context);

		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

		listItem.add(addItem(1, "7.1，ShapeDrawable."));
		listItem.add(addItem(2, "7.2，Bitmap."));
		
		String[] from = { "id", "itemText" };
		int[] to = { android.R.id.text1, android.R.id.text2 };
		ListAdapter apt = new SimpleAdapter(context,listItem, android.R.layout.simple_list_item_2,  from, to);
        listView.setAdapter(apt);
        listView.setOnItemClickListener(this);

		return listView;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		switch (arg2) {
		case 0:startNewActivity(Chat.class);

			break;

		default:
			Toast.makeText(context, "No Activity.", Toast.LENGTH_LONG).show();
			break;
		}
	}

}
