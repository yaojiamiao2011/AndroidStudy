package com.dongbaosoft.Android.part03;

import com.dongbaosoft.Android.comm.ActivityBasic;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class CreateComponent extends ActivityBasic {
	OnClickListener listen1;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		       final LinearLayout layout2=new LinearLayout(this);  
		        layout2.setOrientation(LinearLayout.VERTICAL);  
		        Button btn1=new Button(this);  
		        setContentView(layout2);  
		        Button btn2=new Button(this);  
		        btn1.setText("Button1");  
		        btn2.setText("Button2");  
		        layout2.addView(btn1);  
		        layout2.addView(btn2);  
		         
		          
		        listen1 = new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						setTitle("µã»÷button1 ");
						Button btn3=new Button(v.getContext());
						layout2.addView(btn3);
						btn3.setText("Button3");
						
					}
				};
				 btn1.setOnClickListener(listen1);

				 setContentView(layout2);  
	}

}
