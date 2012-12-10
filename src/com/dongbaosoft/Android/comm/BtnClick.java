package com.dongbaosoft.Android.comm;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class BtnClick implements OnClickListener {

	private Activity aty;

	BtnClick() {
	}

	public BtnClick(Activity aty) {
		this.aty = aty;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(aty, "onClick btn  (comm)!!  ", Toast.LENGTH_LONG).show();
	}

}
