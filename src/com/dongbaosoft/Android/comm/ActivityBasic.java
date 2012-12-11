package com.dongbaosoft.Android.comm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ActivityBasic extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.v(this.getClass().getName(),this.getClass().getName()+ " - onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Log.v(this.getClass().getName(),this.getClass().getName()+ " - onDestroy");
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Log.v(this.getClass().getName(),this.getClass().getName()+ " - onPause");
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		Log.v(this.getClass().getName(),this.getClass().getName()+ " - onRestart");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.v(this.getClass().getName(),this.getClass().getName()+ " - onResume");
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Log.v(this.getClass().getName(),this.getClass().getName()+ " - onStart");
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.v(this.getClass().getName(),this.getClass().getName()+ " - onStop");
		super.onStop();
	}

}
