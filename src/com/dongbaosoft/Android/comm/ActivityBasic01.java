package com.dongbaosoft.Android.comm;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class ActivityBasic01 extends ActivityBasic {
	

	public Button CreateButton(String text)
	{
		Button btnTemp=new Button(this);
		btnTemp.setText(text);
		LinearLayout layout=(LinearLayout)findViewById(1001);
		layout.addView(btnTemp);
		return btnTemp;
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		final LinearLayout layout = new LinearLayout(this);
		layout.setId(1001);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);
		
	}

}
