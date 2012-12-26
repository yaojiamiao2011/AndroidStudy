package com.dongbaosoft.Android.part03;

import com.dongbaosoft.Android.part01.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MyServiceClick implements OnClickListener {

	private Activity aty;
	ServiceConnection myConn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.v("ServiceConnection", "onServiceDisconnected");
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Log.v("ServiceConnection", "onServiceConnected");
		}
	};

	MyServiceClick() {
	};

	MyServiceClick(Activity aty) {
		this.aty = aty;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// aty.startService(new Intent(aty, MyService.class));
		if (v.getId() == R.id.stratServer) {
			aty.startService(new Intent(aty, MyService.class));
		} else if (v.getId() == R.id.endServer) {
			aty.stopService(new Intent(aty, MyService.class));
		} else if (v.getId() == R.id.bindServer) {
				aty.bindService(new Intent(aty,MyService.class), myConn, Context.BIND_AUTO_CREATE);
		} else if (v.getId() == R.id.unbindServer) {
			aty.unbindService(myConn);
		}
	}
}
