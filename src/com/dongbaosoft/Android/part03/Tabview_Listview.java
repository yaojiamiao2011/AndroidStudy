package com.dongbaosoft.Android.part03;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.TabActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

import com.dongbaosoft.Android.part01.R;

public class Tabview_Listview extends TabActivity {

	TabHost tab;
	public EditText edtUserName, edtPassWord;
	CheckBox isSaveInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_03tabview__listview);
		// Show the Up button in the action bar.

		tab = this.getTabHost();
		LayoutInflater.from(this).inflate(
				R.layout.activity_03tabview__listview, tab.getTabContentView());

		tab.setOnTabChangedListener(new OnTabChangeListener() {
			public void onTabChanged(String arg0) {
				Toast.makeText(Tabview_Listview.this, "changed to:" + arg0,
						Toast.LENGTH_SHORT).show();
			}
		});

		TabSpec tabSpec1 = tab.newTabSpec("tabview1");
		tabSpec1.setIndicator("首页", getResources().getDrawable(R.drawable.star));
		tabSpec1.setContent(R.id.lay01);
		tab.addTab(tabSpec1);

		tab.addTab(tab
				.newTabSpec("tabview1")
				.setIndicator("Service",
						getResources().getDrawable(R.drawable.icon))
				.setContent(R.id.lay02));
		tab.addTab(tab
				.newTabSpec("tabview3")
				.setIndicator("About",
						getResources().getDrawable(R.drawable.icon))
				.setContent(R.id.lay03));

		// 把首页中的listview绑定数据；
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		ListView list = (ListView) findViewById(R.id.lay01);
		for (int i = 0; i < 20; i++) {
			HashMap<String, Object> maprow = new HashMap<String, Object>();
			maprow.put("title", "name is :");
			maprow.put("namevalue", "pepole" + i);
			listItem.add(maprow);
		}

		SimpleAdapter ad = new SimpleAdapter(this, listItem,
				R.layout.activity_03listrow, new String[] { "title",
						"namevalue" }, new int[] { R.id.textView1,
						R.id.editText1 });

		list.setAdapter(ad);

		Button btnStart, btnStop;
		btnStart = (Button) findViewById(R.id.stratServer);
		btnStart.setOnClickListener(new MyServiceClick(this));
		btnStop = (Button) findViewById(R.id.endServer);
		btnStop.setOnClickListener(new MyServiceClick(this));

		// 获取配置信息；

		edtUserName = (EditText) findViewById(R.id.edtUserName);
		edtPassWord = (EditText) findViewById(R.id.edtPassWord);
		Button btnSave;
		btnSave = (Button) findViewById(R.id.btnSave);
		
		isSaveInfo = (CheckBox) findViewById(R.id.isSaveInfo);
		SharedPreferences sp = getSharedPreferences("User_Info", 0);
		isSaveInfo.setChecked(sp.getBoolean("isSaveInfo", false));
		
		if (isSaveInfo.isChecked()) {
			
			edtUserName.setText(sp.getString("UserName", ""));
			edtPassWord.setText(sp.getString("PassWord", ""));
		}

		btnSave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences sp1 = Tabview_Listview.this
						.getSharedPreferences("User_Info", 0);
				SharedPreferences.Editor editor = sp1.edit();
			    
				editor.putString("UserName", Tabview_Listview.this.edtUserName
						.getText().toString());
				editor.putString("PassWord", Tabview_Listview.this.edtPassWord
						.getText().toString());
				editor.putBoolean("isSaveInfo", Tabview_Listview.this.isSaveInfo.isChecked());
				editor.commit();

			}
		});

		
		//自动创建组件与事件；
		
	}

}
