package com.LoginRegistration.entity;

public class Forgotpassword {
	private String username;
	private int security_id;
	private String security_answer;
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
	public Forgotpassword(String username, int security_id, String security_answer) {
		super();
		this.username = username;
		this.security_id = security_id;
		this.security_answer = security_answer;
	}
	public Forgotpassword() {
		super();
	}
	@Override
	public String toString() {
		return "Forgotpassword [username=" + username + ", security_id=" + security_id + ", security_answer="
				+ security_answer + "]";
	}
	
	
}
