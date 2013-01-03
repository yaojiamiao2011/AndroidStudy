package com.dongbaosoft.Android.part04;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.dongbaosoft.Android.comm.ActivityBasic01;
import com.dongbaosoft.Android.part01.Activity01;

public class SQLiteTest extends ActivityBasic01 implements OnClickListener {

	private final String dbname = "mydatabase";
	Button btn1, btn2, btn3, btn4;
	SQLiteDatabase db = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		btn1 = createButton("1,Create Database.");
		btn1.setOnClickListener(this);
		btn2 = createButton("2.Delete Database.");
		btn2.setOnClickListener(this);
		btn3 = createButton("3.Insert Record.");
		btn3.setOnClickListener(this);
		btn4 = createButton("4.Query Data(fix show).");
		btn4.setOnClickListener(this);

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
		// TODO Auto-generated method stub
		if (db == null)
			db = this.openOrCreateDatabase(dbname, MODE_PRIVATE, null);
		if (v == btn1) {

			String sql = "create table User(id int primary key,userName varchar(30),password varchar(100))";
			execsql(sql);

		} else if (v == btn2) {
			deleteDatabase(dbname);
		} else if (v == btn3) {
			int i;
			for (i = 1; i < 100; i++) {
				String sql1 =  String.format("insert into User values (%d,\"%s\",\"%s\")", i, "name" + i,
						"pwd" + i);
				execsql(sql1);

			}

		} else if (v == btn4) {
			String sql = "select * from User";
			Cursor rst;
			Log.v("Record:", "get data1.");
			rst = db.rawQuery(sql, null);
			Log.v("Record:", "get data2.");
			// ÊÖ¹¤´òÓ¡£»
			String id, userName, password;
			if (rst.moveToFirst()) {
				do {
					id = "" + rst.getInt(0);
					userName = rst.getString(1);
					password = rst.getString(2);
					String log =String.format("id=%s;userName=%s;password=%s", id, userName,
							password);
					Log.v("Record:", log);
				} while (rst.moveToNext());
			}

		}
	}

}
