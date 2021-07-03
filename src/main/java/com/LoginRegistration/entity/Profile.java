package com.LoginRegistration.entity;

public class Profile {
	
	private String username;
	private String firstname;
	private String lastname;
	private String dob;
	private String gender;
	private String phonenum;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Profile(String username, String firstname, String lastname, String dob, String gender, String phonenum,
			String address) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.gender = gender;
		this.phonenum = phonenum;
		this.address = address;
	}
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Profile [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", gender=" + gender + ", phonenum=" + phonenum + ", address=" + address + "]";
	}
	
	
}
