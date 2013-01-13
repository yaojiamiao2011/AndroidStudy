package com.dongbaosoft.Android.comm.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class SocketThread extends Thread {

	boolean isRun;
	Socket mSocket;
	Handler mHandler;
	
	BufferedReader reader;
	
	SocketThread(){}
	
	public SocketThread(Socket mSocket,boolean isRun,Handler mHandler){
		this.mSocket=mSocket;
		this.isRun = isRun;
		this.mHandler=mHandler;
		
		try {
			reader=new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String info;
		
		while (isRun)
		{
			try {
				info=reader.readLine()+"\n";
				Log.v("SocketThread", "info="+info);
				Message msg= mHandler.obtainMessage();
				msg.getData().putString("info", info);
				mHandler.sendMessage(msg);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.run();
	}

}
