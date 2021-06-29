package com.LoginRegistration.entity;

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



@Entity
@Table(name = "registration")
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "regid")
	private Long regid;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "userid" )
	private Login login;
	
	//private Long userId;
	private String firstname;
	private String lastname;
	private String dob;
	private String gender;
	private String phonenum;
	private String address;
	private String created_on;
	private String security_answer;
	private Long security_id;


	
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Long getRegid() {
		return regid;
	}

	public void setRegid(Long regid) {
		this.regid = regid;
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

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	public String getSecurity_answer() {
		return security_answer;
	}

	public void setSecurity_answer(String security_answer) {
		this.security_answer = security_answer;
	}

	public Long getSecurity_id() {
		return security_id;
	}

	public void setSecurity_id(Long security_id) {
		this.security_id = security_id;
	}

	public Register(Long regid, Login login, String firstname, String lastname, String dob, String gender,
			String phonenum, String address, String created_on, String security_answer, Long security_id) {
		super();
		this.login = login;
		this.regid = regid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.gender = gender;
		this.phonenum = phonenum;
		this.address = address;
		this.created_on = created_on;
		this.security_answer = security_answer;
		this.security_id = security_id;
	}

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Registration [regid=" + regid + ", login=" + login + ", firstname=" + firstname + ", lastname="
				+ lastname + ", dob=" + dob + ", gender=" + gender + ", phonenum=" + phonenum + ", address=" + address
				+ ", created_on=" + created_on + ", security_answer=" + security_answer + ", security_id=" + security_id
				+ "]";
	}

}
