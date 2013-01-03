package com.dongbaosoft.Android.part04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dongbaosoft.Android.comm.ActivityBasic01;

public class FileStore extends ActivityBasic01 implements OnClickListener {
	final String SDFileName="ex_file.txt";
	EditText edt1;
	Button btn1, btn2, btn3, btn4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		edt1 = createEditText("", "please type text.");

		btn1 = createButton("1.Save to file.");
		btn1.setOnClickListener(this);
		btn2 = createButton("2.Show file memo...");
		btn2.setOnClickListener(this);

		btn3 = createButton("3.Save to SDCard.");
		btn3.setOnClickListener(this);
		btn4 = createButton("4.Load from SDCard...");
		btn4.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == btn1) {
			try {
				FileOutputStream fos = openFileOutput("mytestfile", 0);
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
		} else if (v == btn2) {
			Log.v("FileStore", "btn2");
			try {
				FileInputStream fis = openFileInput("mytestfile");
				DataInputStream dis = new DataInputStream(fis);
				// Log.v("FileStore", " "+(dis.readInt()));
				// Log.v("FileStore", " "+(dis.readUTF()));
				Toast.makeText(this, String.valueOf(dis.readInt()),
						Toast.LENGTH_SHORT).show();
				Toast.makeText(this, String.valueOf(dis.readUTF()),
						Toast.LENGTH_SHORT).show();
				dis.close();
				fis.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (v == btn3) {
            //如何从SDCard中获取数据
			String flagsd=Environment.getExternalStorageState();
			if (flagsd.equals(Environment.MEDIA_MOUNTED))
			{
				String sDir=Environment.getExternalStorageDirectory().getPath()+File.separator+"com"+File.separator +"dongbaosoft";
				try {
					File myfile=new File(sDir,SDFileName);
					if (!myfile.exists())
					{
						new File(sDir).mkdirs();
						myfile.createNewFile();
					}
					FileOutputStream fos=new FileOutputStream(myfile);
					//fos.write(edt1.getText().toString().getBytes());
					//fos.flush();
					DataOutputStream dos = new DataOutputStream(fos);
					dos.writeUTF(edt1.getText().toString());
					dos.flush();
					dos.close();
					fos.close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
				Toast.makeText(this, "SD Card is fail! error info = "+flagsd, Toast.LENGTH_SHORT).show();
		}else if (v==btn4)
		{
			
			String flagsd=Environment.getExternalStorageState();
			if (flagsd.equals(Environment.MEDIA_MOUNTED))
			{
				String sDir=Environment.getExternalStorageDirectory().getPath()+File.separator+"com"+File.separator +"dongbaosoft";
				File myfile=new File(sDir,SDFileName);
				if (!myfile.exists())
					Toast.makeText(this, "file not exists: "+SDFileName, Toast.LENGTH_SHORT).show();
				else
				{
					try {
						FileInputStream fis=new FileInputStream(myfile);
						DataInputStream dis=new DataInputStream(fis);
						Toast.makeText(this, String.valueOf(dis.readUTF()),
								Toast.LENGTH_SHORT).show();
						//byte[] buffer=new byte[1024];
						//fis.read(buffer);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
					
			}
			else Toast.makeText(this, "SD Card is fail! error info = "+flagsd, Toast.LENGTH_SHORT).show();
			}

	}

}
