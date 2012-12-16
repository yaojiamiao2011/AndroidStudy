package com.dongbaosoft.Android.comm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.dongbaosoft.Android.part01.Activity00;
import com.dongbaosoft.Android.part01.R;
import com.dongbaosoft.Android.part02.Activity02Pressbar;
import com.dongbaosoft.Android.part02.Activity03dialogActivity;

public class MainActivity extends Activity {

	Button btn1,btn2,btn3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1=(Button)findViewById(R.id.button1);
		btn1.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,Activity00.class));
			}
		});
		btn3=(Button)findViewById(R.id.button3);
		btn3.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,Activity03dialogActivity.class));
			}
		});
		
		
		btn2=(Button)findViewById(R.id.button2);
		btn2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,Activity02Pressbar.class));
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
