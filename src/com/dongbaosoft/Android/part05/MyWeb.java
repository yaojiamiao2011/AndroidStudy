package com.dongbaosoft.Android.part05;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dongbaosoft.Android.comm.ActivityBasic01;

public class MyWeb extends ActivityBasic01 implements OnClickListener {

	Button btnget, btnpost;
	TextView textView;
	URL url;
	HttpURLConnection conn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		btnget = createButton("GET web data");
		textView = new TextView(this);
		myLayOut.addView(textView);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		textView.setLayoutParams(params);

		String myString;
		try {
			// 定义获取文件内容的URL
			URL myURL = new URL(
					"HTTP://www.baidu.com/hello.txt&quot");
			// 打开URL链接
			URLConnection ucon = myURL.openConnection();
			// 使用InputStream，从URLConnection读取数据
			InputStream is = ucon.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			// 用ByteArrayBuffer缓存
			ByteArrayBuffer baf = new ByteArrayBuffer(50);
			int current = 0;
			while ((current = bis.read()) != -1) {
				baf.append((byte) current);
			}
			// 将缓存的内容转化为String,用UTF-8编码
			myString = EncodingUtils.getString(baf.toByteArray(), "UTF-8");
		} catch (Exception e) {
			myString = e.getMessage();
		}
		textView.setText(myString);
/*		try {
			url=new URL("dongbaosoft.com");
			conn= (HttpURLConnection) url.openConnection();
			

			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String str=reader.readLine();
			while (str!=null)
			{
				Log.v("MyWeb", str);
				textView.setText(textView.getText()+str);
				str=reader.readLine();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == btnget) {

		}
	}

}
