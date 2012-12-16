package com.dongbaosoft.Android.comm;

import android.app.Activity;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ChkChange implements OnCheckedChangeListener{

	private Activity aty;
	
	ChkChange() {
	}
	ChkChange(Activity aty) {
		this.aty =aty;
	}
	
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		Toast.makeText(aty, buttonView.getText().toString(), Toast.LENGTH_LONG).show();
	}
	

}
