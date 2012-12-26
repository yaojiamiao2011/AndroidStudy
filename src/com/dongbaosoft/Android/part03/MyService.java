package com.dongbaosoft.Android.part03;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends MyServiceBasic {
	private final static String tag = "MyService";

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.v(tag, "onBind");
		return myBiner;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.v(tag, "onCreate");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v(tag, "onDestroy");
	}

	@Override
	public void onRebind(Intent intent) {
		// TODO Auto-generated method stub
		super.onRebind(intent);
		Log.v(tag, "onRebind");
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		Log.v(tag, "onStart");
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.v(tag, "onUnbind");
		return super.onUnbind(intent);
	}

}
