package com.dongbaosoft.Android.part05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dongbaosoft.Android.comm.ActivityBasic01;
import com.dongbaosoft.Android.comm.thread.SocketThread;


public class Chat extends ActivityBasic01 implements OnClickListener{

	final int PORT=9999;
	final String SERVERIP="192.168.40.16";
	EditText etList, etLine;
	Button btConn, btSend;
	
	Socket mSocket;
	InputStreamReader isReader;
	BufferedReader bfReader;
	PrintWriter writer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		etList=createEditText("", "");
		etList.setMinLines(8);

		etLine =createEditText("", "type your info.");
		btConn =createButton("Conn");
		btConn.setOnClickListener(this);
		btSend =createButton("Send");
		btSend.setOnClickListener(this);
		
	}

	Handler mHandler=new Handler(){

		public void handleMessage(Message msg) {
			String info=msg.getData().getString("info")+"\n";
			// TODO Auto-generated method stub
			Log.v("Handler", "info="+info);
			etList.append(info);
			super.handleMessage(msg);
		}
		
	};
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v==btConn)
		{
			try {
				mSocket=new Socket(SERVERIP,PORT);
				
				isReader = new InputStreamReader(mSocket.getInputStream());
				bfReader = new BufferedReader(isReader);
				SocketThread thd= new SocketThread(mSocket,true,mHandler);
				thd.start();
				
				
				writer=new PrintWriter(mSocket.getOutputStream());
				
				Toast.makeText(this, "Conn to Server.", Toast.LENGTH_SHORT).show();
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (v==btSend)
		{
			Log.v("send", etLine.getText().toString());
			writer.println(etLine.getText().toString());
			writer.flush();
		}
		
	}

}
