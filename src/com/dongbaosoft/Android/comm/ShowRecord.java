package com.dongbaosoft.Android.comm;

import java.util.ArrayList;
import java.util.HashMap;



import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

/**
 * 根据数据源，自动产生列表；
 * 
 * @author yamiao
 * 
 */
public class ShowRecord {
	
	
	private static int[] p_createListView(Context con, LinearLayout Layout, String[] from)
	{
		//ArrayList<TextView> txView=null;
		int[] v;
		v=new int[from.length];
		Log.v("ShowRecord", "p_createListView will create:"+from.length);
		
		for (int i=0;i<from.length;i++)
		{
			TextView tmpView=new TextView(con);
			Layout.addView(tmpView);
			v[i]=tmpView.getId();
		}
		Log.v("ShowRecord", "p_createListView=ok");
		return v;
	}

	public final static ArrayList<HashMap<String, Object>> p_getListData(Cursor rst,String[] from)
	{
		ArrayList<HashMap<String, Object>> listData=new ArrayList<HashMap<String, Object>>();
		if (rst.moveToFirst()) {
			do {
				HashMap<String, Object> map=new HashMap<String, Object>();
				for (int i=0;i<from.length;i++)
				{
					map.put(from[i],rst.getString(i));
				}
			
				listData.add(map);

			} while (rst.moveToNext());
		}
		Log.v("ShowRecord", "p_getListData=ok");
		return listData;
	}
	
	
	public final static void p_ShowData(Context con, LinearLayout layout, ListView listview,
			Cursor rst, String[] from) {

		ArrayList<HashMap<String, Object>> listData=new ArrayList<HashMap<String, Object>>();
		listData =p_getListData(rst,from);
		
		int[] to=p_createListView(con, layout, from);
		//SimpleAdapter apt=new SimpleAdapter(con, listData,R.layout.commlayout, from, to);
		SimpleAdapter apt=new SimpleAdapter(con, listData, layout.getId(), from, to);
		listview.setAdapter(apt);
		
	}

}
