package com.dongbaosoft.Android.comm;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ActivityBasic01 extends ActivityBasic {
	public LinearLayout myLayOut=null;
	
	public EditText createEditText(String text,String hintText)
	{
		EditText edtTemp=new EditText(this);
		edtTemp.setText(text);
		edtTemp.setHint(hintText);
		myLayOut.addView(edtTemp);
		return edtTemp;
	}

	public Button createButton(String text)
	{
		Button btnTemp=new Button(this);
		btnTemp.setText(text);
		//LinearLayout layout=(LinearLayout)findViewById(1001);
		//layout.addView(btnTemp);
		myLayOut.addView(btnTemp);
		return btnTemp;
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		final LinearLayout layout = new LinearLayout(this);
		myLayOut=layout;
		layout.setId(1001);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);
		
	}

}
