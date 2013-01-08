package com.dongbaosoft.Android.part04;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.dongbaosoft.Android.comm.ActivityBasic01;
import com.dongbaosoft.Android.comm.ShowRecord;
import com.dongbaosoft.Android.part01.R;

public class SQLiteTest extends ActivityBasic01 implements OnClickListener {

	private final String dbname = "mydatabase";
	Button btn1, btn2, btn3, btn4, btn5;
	SQLiteDatabase db = null;
	ListView listview = null;
	LinearLayout listlayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		/*
		 * final LinearLayout layout2 = new LinearLayout(this); listlayout =
		 * layout2; layout2.setId(1002);
		 * layout2.setOrientation(LinearLayout.VERTICAL);
		 */// setContentView(layout2);
			// listlayout=(LinearLayout)findViewById(R.layout.commlayout);

		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		listlayout = (LinearLayout) inflater.inflate(R.layout.commlayout, null);

		btn1 = createButton("1,Create Database.");
		btn1.setOnClickListener(this);
		btn2 = createButton("2.Delete Database.");
		btn2.setOnClickListener(this);
		btn3 = createButton("3.Insert Record.");
		btn3.setOnClickListener(this);
		btn4 = createButton("4.Query Data(fix show).");
		btn4.setOnClickListener(this);
		btn5 = createButton("5.Query Data(动态创建)");
		btn5.setOnClickListener(this);

		listview = new ListView(this);
		myLayOut.addView(listview);

	}

	public void execsql(String sql) {

		Log.v("will execSQL:", sql);
		try {
			db.execSQL(sql);
		} catch (Exception e) {
			Log.e("execSQL error:", sql);

		}
	}

	@Override
	public void onClick(View v) {
		String[] from = { "_id", "userName", "password" };
		// TODO Auto-generated method stub
		if (db == null)
			db = this.openOrCreateDatabase(dbname, MODE_PRIVATE, null);
		if (v == btn1) {

			String sql = "create table User(_id int primary key,userName varchar(30),password varchar(100))";
			execsql(sql);

		} else if (v == btn2) {
			deleteDatabase(dbname);
		} else if (v == btn3) {
			int i;
			for (i = 1; i < 100; i++) {
				String sql1 = String.format(
						"insert into User values (%d,\"%s\",\"%s\")", i, "name"
								+ i, "pwd" + i);
				execsql(sql1);

			}

		} else if (v == btn4) {
			String sql = "select * from User";
			Cursor rst;
			Log.v("Record:", "get data1.");
			rst = db.rawQuery(sql, null);
			Log.v("Record:", "get data2.");
			// 手工打印；
			String id, userName, password;
			if (rst.moveToFirst()) {
				do {
					id = "" + rst.getInt(0);
					userName = rst.getString(1);
					password = rst.getString(2);
					String log = String.format("id=%s;userName=%s;password=%s",
							id, userName, password);
					Log.v("Record:", log);
				} while (rst.moveToNext());
			}

			SimpleCursorAdapter apt = new SimpleCursorAdapter(this,
					R.layout.table_user, rst, from, new int[] { R.id.txId,
							R.id.txUserName, R.id.txPassWord });
			/*
			 * ArrayList<HashMap<String, Object>> listData = new
			 * ArrayList<HashMap<String, Object>>(); listData =
			 * ShowRecord.p_getListData(rst, from); SimpleAdapter apt = new
			 * SimpleAdapter(this, listData, R.layout.table_user, from, new
			 * int[] { R.id.txId, R.id.txUserName, R.id.txPassWord });
			 */listview.setAdapter(apt);

		} else if (v == btn5) {
			String sql = "select * from User";
			Cursor rst;
			Log.v("Record:", "get data1.");
			rst = db.rawQuery(sql, null);
			Toast.makeText(this, "myLayOut id=" + myLayOut.getId(),
					Toast.LENGTH_LONG).show();
			ShowRecord.p_ShowData(this, listlayout, listview, rst, from);
		}
	}

}
