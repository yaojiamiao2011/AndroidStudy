package com.dongbaosoft.Android.comm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.dongbaosoft.Android.comm.update.UpdateTool;
import com.dongbaosoft.Android.part01.Activity00;
import com.dongbaosoft.Android.part01.R;
import com.dongbaosoft.Android.part02.Activity02Pressbar;
import com.dongbaosoft.Android.part02.Activity03dialogActivity;
import com.dongbaosoft.Android.part03.BundleActivity;
import com.dongbaosoft.Android.part03.CreateComponent;
import com.dongbaosoft.Android.part03.Tabview_Listview;
import com.dongbaosoft.Android.part04.FileStore;
import com.dongbaosoft.Android.part04.LoginActivity;

public class MainActivity extends Activity {

	Button btn1, btn2, btn3, btn4, btn5, btn6, btn7,btn8
	,btn9;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn5=(Button)findViewById(R.id.button5);
		btn5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,CreateComponent.class));
			}
		});

		btn4 = (Button) findViewById(R.id.button4);
		btn4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,
						Tabview_Listview.class));
			}
		});

		btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, Activity00.class));
			}
		});
		btn3 = (Button) findViewById(R.id.button3);
		btn3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,
						Activity03dialogActivity.class));
			}
		});

		btn2 = (Button) findViewById(R.id.button2);
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,
						Activity02Pressbar.class));
			}

		});
		
		LinearLayout mainlayout=(LinearLayout)findViewById(R.id.mainlayout);
		btn6=new Button(this);
		btn6.setText("6.bundle Service");
		btn6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,
						BundleActivity.class));
			}
		});
		mainlayout.addView(btn6);
		
		btn7=new Button(this);
		btn7.setText("7,Update...");
		mainlayout.addView(btn7);
		btn7.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				UpdateTool t=new UpdateTool("com.dongbaosoft.Android.part01");
				int verCode= t.getVerCode(MainActivity.this);
				String verName=t.getVerName(MainActivity.this);
				boolean isUpdate =t.getServerVerCode(MainActivity.this);
				
			}
		});
		
		btn8=new Button(this);
		btn8.setText("8,SharedPreferences");
		mainlayout.addView(btn8);
		btn8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,
						LoginActivity.class));
			}
		});
		
		btn9=new Button(this);
		btn9.setText("9.File Store...");
		mainlayout.addView(btn9);
		btn9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,						FileStore.class));
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
