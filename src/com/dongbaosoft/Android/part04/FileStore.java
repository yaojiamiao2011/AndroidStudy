package com.dongbaosoft.Android.part04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dongbaosoft.Android.comm.ActivityBasic01;

public class FileStore extends ActivityBasic01 implements OnClickListener {
	EditText edt1;
	Button btn1, btn2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		edt1 = createEditText("", "please type text.");

		btn1 = createButton("Save to file.");
		btn1.setOnClickListener(this);
		btn2=createButton("Show file memo...");
		btn2.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == btn1) {
			try {
				FileOutputStream fos = openFileOutput("mytestfile",0
						);
				DataOutputStream dos = new DataOutputStream(fos);
				try {
					dos.writeInt(100);
					dos.writeUTF(edt1.getText().toString());
					dos.flush();
					dos.close();
					fos.flush();
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (v==btn2){
			Log.v("FileStore", "btn2");
			try {
				FileInputStream fis=  openFileInput("mytestfile");
				DataInputStream dis=new DataInputStream(fis);
				//Log.v("FileStore", " "+(dis.readInt()));
				//Log.v("FileStore", " "+(dis.readUTF()));
				 Toast.makeText(this, String.valueOf(dis.readInt()), Toast.LENGTH_SHORT) .show();
				 Toast.makeText(this, String.valueOf(dis.readUTF()), Toast.LENGTH_SHORT) .show();
				dis.close();
				fis.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
