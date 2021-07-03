package com.aimorc.registration.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "login")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private long userid;
	
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL, mappedBy = "registration")
	 * 
	 * @JoinColumn(name = "userid") private Registration registration;
	 * 
	 * 
	 * public Registration getRegistration() { return registration; }
	 * 
	 * public void setRegistration(Registration registration) { this.registration =
	 * registration; }
	 */
	 
	@NotBlank(message = "username is mandatory")
	private String username;
	
	@NotBlank(message = "password is mandatory")
	private String password;
	
	@NotBlank(message = "lastlogin is mandatory")
	private String lastlogin;

	public User(String username, String password, String lastlogin) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.lastlogin = lastlogin;
	}

	public User() {

	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
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

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", lastlogin="
				+ lastlogin + "]";
	}

}
