package com.dongbaosoft.Android.part02;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

import com.dongbaosoft.Android.comm.ActivityBasic;
import com.dongbaosoft.Android.part01.R;

@SuppressLint("HandlerLeak")
public class Activity02Pressbar extends ActivityBasic implements Runnable {

	Button btn1, btn2;
	ProgressBar pres;
	boolean isRuning = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity02pressbar);

		btn1 = (Button) findViewById(R.id.button1);
		pres = (ProgressBar) findViewById(R.id.progressBar1);
		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				isRuning = !isRuning;
				if (isRuning == true) {
					new Thread(Activity02Pressbar.this).start();
					btn1.setText("Stop");
				} else
					btn1.setText("Start");

			}
		});
	}

	Handler hnd = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			// pres.setProgress(msg.arg1);
			int value;
			value = pres.getProgress();
			if (value >= 100)
				value = 0;
			value = value + msg.arg1;
			pres.setProgress(value);

			super.handleMessage(msg);
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_activity_pressbar, menu);
		return true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isRuning) {
			// if (isRuning==true)
			{
				try {
					Thread.sleep(500);

					Message msg = new Message();
					msg.arg1 = 5;
					hnd.sendMessage(msg);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
