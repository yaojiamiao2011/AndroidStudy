package com.dongbaosoft.Android.comm.update;


import org.json.JSONArray;
import org.json.JSONObject;


import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.widget.Toast;


/*
 * 
 
在服务器上放置 ver.josn文件，内容如下：
[{"appname":"AndroidStudy","apkname":"AndroidStudy-2.apk","verName":1.0.1,"verCode":2}]
 
 
 */
public class UpdateTool {
	private String appName;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	UpdateTool() {
	};

	public UpdateTool(String appName) {
		setAppName(appName);
	};

	private static String TAG = "UpdateTool";

	/*
	 * 获取本地程序的版本代码
	 */
	public int getVerCode(Context context) {
		int verCode = -1;
		try {
			verCode = context.getPackageManager().getPackageInfo(getAppName(),
					0).versionCode;
			Toast.makeText(context, "verCode="+verCode, Toast.LENGTH_SHORT).show();
		} catch (NameNotFoundException e) {
			Log.e(TAG, e.getMessage());
		}
		return verCode;
	}

	/*
	 * 获取本地的版本号
	 */
	public String getVerName(Context context) {
		String verName = "";
		try {
			verName = context.getPackageManager().getPackageInfo(getAppName(),
					0).versionName;
			Toast.makeText(context, "verName="+verName, Toast.LENGTH_SHORT).show();
		} catch (NameNotFoundException e) {
			Log.e(TAG, e.getMessage());
		}
		return verName;
	}

	public boolean getServerVerCode(Context context) {
		try {
			String verjson = NetworkTool.getContent(Config.UPDATE_SERVER
					+ Config.UPDATE_VERJSON);
			JSONArray array = new JSONArray(verjson);
			if (array.length() > 0) {
				JSONObject obj = array.getJSONObject(0);
				int newVerCode;
				String newVerName;
				
				try {
					newVerCode = Integer.parseInt(obj.getString("verCode"));
					newVerName = obj.getString("verName");
					Toast.makeText(context, "newVerCode="+newVerCode, Toast.LENGTH_SHORT).show();
					Toast.makeText(context, "newVerName="+newVerName, Toast.LENGTH_SHORT).show();
					
				} catch (Exception e) {
					newVerCode = -1;
					newVerName = "";
					return false;
				}
			}
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return false;
		}
		return true;
	}
}
