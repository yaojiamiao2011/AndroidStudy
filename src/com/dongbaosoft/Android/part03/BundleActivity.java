package com.dongbaosoft.Android.part03;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.dongbaosoft.Android.comm.ActivityBasic01;

public class BundleActivity extends ActivityBasic01 {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		final ServiceConnection _connection = new ServiceConnection() {  

			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onServiceDisconnected(ComponentName name) {
				// TODO Auto-generated method stub
				
			}  
	    };  
	    final Intent intent=new Intent(BundleActivity.this,BundleService.class);


	    Button btnStart = createButton("Strat Bundle");
		btnStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v("BundleActivity", "Strat Bundle");
				Toast.makeText(BundleActivity.this, "aaaa", Toast.LENGTH_LONG).show();
				bindService(intent, _connection, Service.BIND_AUTO_CREATE);

			}
		});
		
		Button btnStop = createButton("Stop Bundle");
		btnStop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v("BundleActivity", "Stop Bundle");
				Toast.makeText(BundleActivity.this, "ֹͣ����", Toast.LENGTH_LONG).show();
				unbindService(_connection);

			}
		});
	}

}
