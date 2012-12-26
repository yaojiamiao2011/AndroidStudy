package com.dongbaosoft.Android.part02;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.dongbaosoft.Android.part01.R;

@SuppressLint("ShowToast")
public class Activity03dialogActivity extends Activity {

	Button btn1,btn2,btn3;
	protected ProgressDialog dlg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity03dialog);
		// Show the Up button in the action bar.

		((Button)findViewById(R.id.button2)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
		//btn1=(Button)findViewById(R.id.button1);
		((Button)findViewById(R.id.button1)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				p_CreateDlg();
				
				
				//用线程来关闭；
				
				new Thread(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						dlg.dismiss();
						super.run();
					}
					
				}.start();
				
			}

			public void p_CreateDlg() {
				dlg=new ProgressDialog(Activity03dialogActivity.this);
				dlg.setTitle("my title");
				dlg.setMessage("progress...");
				dlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				dlg.setCancelable(true);
				dlg.setButton("cancle,click me", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(Activity03dialogActivity.this,"will cancle",Toast.LENGTH_SHORT );
						Log.v("Activity03dialogActivity","will cancel.");
					}
				});
				dlg.show();
			}
		});
		
	}



}
