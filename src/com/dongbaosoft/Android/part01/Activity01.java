package com.dongbaosoft.Android.part01;

import com.dongbaosoft.Android.comm.ActivityBasic;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity01 extends ActivityBasic {

	 Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity01);
		
		Bundle bundle=getIntent().getExtras();
		Log.v("Activity01", "userName="+bundle.getString("userName"));
		
       	intent=new Intent(this,MyActivity.class);
       	//intent=new Intent(MyActivity.this,this.getClass());
       Button btn1	=(Button)findViewById(R.id.button11);
        
        btn1.setOnClickListener(new OnClickListener(){

 
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Toast.makeText(MyActivity.this, "onClick btn1!!", Toast.LENGTH_LONG).show();
				intent.putExtra("resultStr", "succ");
				Activity01.this.setResult(RESULT_OK,intent);
				Activity01.this.finish();
			}
        	
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_activity01, menu);
		return true;
	}

}
