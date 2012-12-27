package com.dongbaosoft.Android.part03;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class BundleService extends Service {

	static public String ServiceState = "";

	@Override
	public IBinder onBind(Intent arg0) {
		Log.v("Service", "onBind");
		ServiceState = "onBind";
		return null;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		super.onUnbind(intent);
		Log.v("Service", "onUnbind");
		ServiceState = "onUnbind";
		return false;

	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.v("Service", "onCreate");
		ServiceState = "onCreate";
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.v("Service", "onDestroy");
		ServiceState = "onDestroy";
	}

	@Override
	public void onStart(Intent intent, int startid) {
		super.onStart(intent, startid);
		Log.v("Service", "onStart");
		ServiceState = "onStart";
	}
}
