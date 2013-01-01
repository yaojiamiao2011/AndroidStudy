package com.dongbaosoft.Android.part04;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.dongbaosoft.Android.comm.ref.BeanRefUtil;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public class MySharedPreferneces {
	private final String FILE_NAME = "myspdata";
	private final String PACK_NAME = "com.dongbaosoft.Android.part01";

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	private Activity activity;

	MySharedPreferneces() {
	};

	public MySharedPreferneces(Activity activity) {

		setActivity(activity);
	}

	private SharedPreferences getSp() {
		Context context = null;
		try {
			context = getActivity().createPackageContext(PACK_NAME, 0);
			return context.getSharedPreferences(FILE_NAME,
					Context.MODE_WORLD_WRITEABLE);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void writeLoginInfo(Login login) {
		SharedPreferences sp = getSp();
		SharedPreferences.Editor editor = sp.edit();
		editor.putString("userId", login.getUserId().toString());
		editor.putString("userName", login.getUserName().toString());
		editor.putString("passWord", login.getPassWord().toString());
		editor.putBoolean("isSaveId", login.getIsSaveId());
		editor.putBoolean("isSavePwd", login.getIsSavePwd());
		editor.commit();

	}


	public Login getLoginInfo() {
		Login login = new Login();
		SharedPreferences sp = getSp();
		Map<String, String> valMap = new HashMap<String, String>();

		Class c=null;
		try {
			c = Class.forName(Login.class.getName());
			Field[] fs = c.getDeclaredFields();
			for (Field f : fs) {
				Log.v("MySharedPreferneces",  f.getName());
				if (f.getType().getSimpleName().equals("long"))
					valMap.put(f.getName(),String.valueOf( sp.getLong(f.getName(), 0)));
				else if (f.getType().getSimpleName().equals("Boolean"))
					valMap.put(f.getName(),String.valueOf( sp.getBoolean(f.getName(), false)));
				else if (f.getType().getSimpleName().equals("String"))
					valMap.put(f.getName(),sp.getString(f.getName(),""));
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BeanRefUtil.setFieldValue(login, valMap);
/**
 * 

		try {
			Class c = Class.forName(Login.class.getName());
			Field[] fs = c.getDeclaredFields();
			Method[] ms = c.getDeclaredMethods();
			// Class[] types = new Class[] {};
			for (Field f : fs) {
				int index = IsHasMethod(ms, "set" + f.getName());
				if (index >= 0) {
					//Log.v("MySharedPreferneces", "set" + f.getName());

					if (f.getType().getSimpleName().equals("long")) {
						Log.v("MySharedPreferneces", f.getName());

					}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

 */
//		login.setUserId(sp.getString("userId", ""));
//		login.setUserName(sp.getString("userName", ""));
//		login.setPassWord(sp.getString("passWord", ""));
//		login.setIsSaveId(sp.getBoolean("isSaveId", false));
//		login.setIsSavePwd(sp.getBoolean("isSavePwd", false));
		return login;
	}

}
