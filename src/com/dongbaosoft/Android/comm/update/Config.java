package com.dongbaosoft.Android.comm.update;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public class Config {
	private static final String TAG = "Config";
	
	public static final String UPDATE_SERVER = "http://dongbaosoft.com/demo/android/";
	public static final String UPDATE_APKNAME = "AndroidStudy.apk";
	public static final String UPDATE_VERJSON = "ver.txt";
	public static final String UPDATE_SAVENAME = "updateapksamples.apk";
	
	
	public static int getVerCode(Context context) {
		int verCode = -1;
		try {
			verCode = context.getPackageManager().getPackageInfo(
					"jtapp.updateapksamples", 0).versionCode;
		} catch (NameNotFoundException e) {
			Log.e(TAG, e.getMessage());
		}
		return verCode;
	}
	
	public static String getVerName(Context context) {
		String verName = "";
		try {
			verName = context.getPackageManager().getPackageInfo(
					"jtapp.updateapksamples", 0).versionName;
		} catch (NameNotFoundException e) {
			Log.e(TAG, e.getMessage());
		}
		return verName;

	}
	

}
