package com.LoginRegistration.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registration")
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int regid;

	private int userid;
	private String firstname;
	private String lastname;
	private String dob;
	private String gender;
	private String phonenum;
	private String address;
	private int security_id;
	private String security_answer;
	private String created_on;
	public int getRegid() {
		return regid;
	}
	public void setRegid(int regid) {
		this.regid = regid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	
	public String getCreated_on() {
		return created_on;
	}
	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	public Register() {
		super();
		
	}
	public Register(int regid, int userid, String firstname, String lastname, String dob, String gender,
			String phonenum, String address, int security_id, String security_answer, String created_on) {
		super();
		this.regid = regid;
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.gender = gender;
		this.phonenum = phonenum;
		this.address = address;
		this.security_id = security_id;
		this.security_answer = security_answer;
		this.created_on = created_on;
	}
	@Override
	public String toString() {
		return "Register [regid=" + regid + ", userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", dob=" + dob + ", gender=" + gender + ", phonenum=" + phonenum + ", address=" + address
				+ ", security_id=" + security_id + ", security_answer=" + security_answer + ", created_on=" + created_on
				+ "]";
	}
	
	
	

}
