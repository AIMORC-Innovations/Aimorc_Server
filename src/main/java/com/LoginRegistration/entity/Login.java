package com.LoginRegistration.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

@Entity

@Table(name = "login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;

	private String username;
	private String password;
	private String lastlogin;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Login() {

	}

	public Login(int userid, String username, String password, String lastlogin) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.lastlogin = lastlogin;
	}

	public Login(int userid) {
		super();
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Login [userid=" + userid + ", username=" + username + ", password=" + password + ", lastlogin="
				+ lastlogin + "]";
	}

	

	

	
}
