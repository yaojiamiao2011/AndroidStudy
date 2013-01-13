package com.dongbaosoft.Android.part05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {
	final int PORT=9999;
	ServerSocket mSvrSock;
	ArrayList<MyClient> mClients=new ArrayList<MyClient>();
	void start(){
		try {
			mSvrSock=new ServerSocket(PORT);
			System.out.println("start...");
			while(true){
				MyClient client=new MyClient(mSvrSock.accept());
				mClients.add(client);
				new Thread(client).start();
				System.out.println("new client");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class MyClient implements Runnable{
		Socket mSock;
		BufferedReader mReader;
		PrintWriter mWriter;
		MyClient(Socket sock){
			mSock=sock;
			try {
				mReader=new BufferedReader(new InputStreamReader(mSock.getInputStream()));
				mWriter=new PrintWriter(mSock.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void run() {
			while(true){
				try {
					String text=mReader.readLine();
					if(text == null){
						mClients.remove(this);
						break;
					}
					System.out.println("text:"+text);
					broadcast(text);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("client exit");
		}
		
		void broadcast(String text){
			for(MyClient client:mClients){
				client.mWriter.println(text);
				client.mWriter.flush();
			}
		}
	}
	
	public static void main(String[] args) {
		new MyServer().start();
	}
}

