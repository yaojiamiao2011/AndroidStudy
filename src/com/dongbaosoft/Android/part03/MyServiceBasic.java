package com.dongbaosoft.Android.part03;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyServiceBasic extends Service {
	public final IBinder myBiner = new MyBinder();
	public final ServiceConnection myConn= new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.v("MyServiceBasic", "onServiceDisconnected");
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Log.v("MyServiceBasic", "onServiceConnected");
		}
	};

	public class MyBinder extends Binder {
		MyServiceBasic getService() {
			return MyServiceBasic.this;
		}
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
