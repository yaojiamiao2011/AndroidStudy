package com.dongbaosoft.Android.part04;

import java.io.Serializable;

public class Login implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8964525874015180812L;

	private String userId;
	private String userName;
	private String passWord;
	private Boolean isSaveId;
	private Boolean isSavePwd;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Boolean getIsSaveId() {
		return isSaveId;
	}
	public void setIsSaveId(Boolean isSaveId) {
		this.isSaveId = isSaveId;
	}
	public Boolean getIsSavePwd() {
		return isSavePwd;
	}
	public void setIsSavePwd(Boolean isSavePwd) {
		this.isSavePwd = isSavePwd;
	}

}
