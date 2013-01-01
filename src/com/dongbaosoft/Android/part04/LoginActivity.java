package com.dongbaosoft.Android.part04;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.dongbaosoft.Android.part01.R;

public class LoginActivity extends Activity implements OnClickListener{
	private Button btnOK;
	public Login login=null;

	private MySharedPreferneces mysp;
	private EditText edtUserName;
	private EditText edtPassWord;
	private CheckBox isSavePwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_04login);
		// Show the Up button in the action bar.

		mysp = new MySharedPreferneces(this);
		// login=new Login();

		login = mysp.getLoginInfo();
		
		Log.v("LoginActivyty", "username="+login.getUserName());

		edtUserName = (EditText) findViewById(R.id.userName);
		edtPassWord = (EditText) findViewById(R.id.passWord);
		isSavePwd = (CheckBox) findViewById(R.id.isSavePwd);

		edtUserName.setText(login.getUserName());
		edtPassWord.setText(login.getPassWord());
		isSavePwd.setChecked(login.getIsSavePwd());

		btnOK = (Button) findViewById(R.id.btnOK);
		btnOK.setOnClickListener(this);
		

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//Map<String, String> valMap = new HashMap<String, String>();
		
		login.setUserName(edtUserName.getText().toString());
		login.setPassWord(edtPassWord.getText().toString());
		login.setIsSavePwd(isSavePwd.isChecked());
		mysp.writeLoginInfo(login);
		
	}

}
