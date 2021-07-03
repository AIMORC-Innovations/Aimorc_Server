package com.LoginRegistration.entity;

public class Password {
	private String username;
	private int security_id;
	private String security_answer;
	private String oldpassword;
	private String updatepassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getSecurity_id() {
		return security_id;
	}

	public void setSecurity_id(int security_id) {
		this.security_id = security_id;
	}

	public String getSecurity_answer() {
		return security_answer;
	}

	public void setSecurity_answer(String security_answer) {
		this.security_answer = security_answer;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getUpdatepassword() {
		return updatepassword;
	}

	public void setUpdatepassword(String updatepassword) {
		this.updatepassword = updatepassword;
	}

	@Override
	public String toString() {
		return "Forgotpassword [username=" + username + ", security_id=" + security_id + ", security_answer="
				+ security_answer + ", oldpassword=" + oldpassword + ", updatepassword=" + updatepassword + "]";
	}

	public Password() {
		super();
		// TODO Auto-generated constructor stub
	}

}
