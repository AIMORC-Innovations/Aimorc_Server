package com.LoginRegistration.entity;

public class Userdata {
	private String username;
	private String password;
	private String lastlogin;
	private String firstname;
	private String lastname;
	private String dob;
	private String gender;
	private String address;
	private String phonenum;
	private String created_on;
	private int security_id;
	private String security_answer;

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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
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

	public String getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	public Userdata(String username, String password, String lastlogin, String firstname, String lastname, String dob,
			String gender, String address, String phonenum, String created_on, int security_id,
			String security_answer) {
		super();
		this.username = username;
		this.password = password;
		this.lastlogin = lastlogin;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.phonenum = phonenum;
		this.created_on = created_on;
		this.security_id = security_id;
		this.security_answer = security_answer;
	}

	public Userdata() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Userdata [username=" + username + ", password=" + password + ", lastlogin=" + lastlogin + ", firstname="
				+ firstname + ", lastname=" + lastname + ", dob=" + dob + ", gender=" + gender + ", address=" + address
				+ ", phonenum=" + phonenum + ", created_on=" + created_on + ", security_id=" + security_id
				+ ", security_answer=" + security_answer + "]";
	}

}
