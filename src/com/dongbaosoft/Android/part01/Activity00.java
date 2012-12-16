package com.dongbaosoft.Android.part01;

import com.dongbaosoft.Android.comm.ActivityBasic;
import com.dongbaosoft.Android.comm.BtnClick;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class Activity00 extends ActivityBasic implements OnClickListener {

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		Bundle b = data.getExtras(); // data为B中回传的Intent
		String str = b.getString("resultStr");// str即为回传的值"Hello, this is B speaking"
		Log.v("MyActivity", str);
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity00);

		System.out.println("println out..");
		Log.w("MyActivity", "Log.w");
		Toast.makeText(this, "showme!!", Toast.LENGTH_LONG).show();

		Button btn01 = (Button) findViewById(R.id.Button01);

		btn01.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(Activity00.this, "onClick btn01!!",
						Toast.LENGTH_LONG).show();
			}

		});

		Button btn1 = (Button) findViewById(R.id.button1);

		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(Activity00.this, "onClick btn1!!",
						Toast.LENGTH_LONG).show();
				Intent intent = new Intent(Activity00.this, Activity01.class);
				Bundle bundle = new Bundle();
				bundle.putString("userName", "yao");
				bundle.putInt("runCount", 0);
				intent.putExtras(bundle);

				Activity00.this.startActivityForResult(intent, 1);
				// startActivity(intent);
			}

		});
		Button btn2 = (Button) findViewById(R.id.Button02);
		btn2.setOnClickListener(this);

		Button btn3 = (Button) findViewById(R.id.Button03);

		class MyClick3 implements OnClickListener {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(Activity00.this, "onClick btn3!!",
						Toast.LENGTH_LONG).show();
			}

		}
		;
		btn3.setOnClickListener(new MyClick3());

		Button btn4 = (Button) findViewById(R.id.Button04);
		btn4.setOnClickListener(new BtnClick(this));
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		// if (event.getAction()==MotionEvent.ACTION_DOWN)
		Toast.makeText(this, "test screen ", Toast.LENGTH_SHORT).show();
		return super.onTouchEvent(event);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(Activity00.this, "onClick btn2!!", Toast.LENGTH_LONG)
				.show();
	}
}