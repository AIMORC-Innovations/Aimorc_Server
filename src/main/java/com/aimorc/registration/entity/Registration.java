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
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "registration")
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "regid")
	private Long regid;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "userid" )
	private User user;
	
	//private Long userId;
	//@NotNull(message = "hey your request is null!!!")
	@NotBlank(message = "firstname is mandatory")
	private String firstname;
	
	@NotBlank(message = "lastname is mandatory")
	private String lastname;
	
	@NotBlank(message = "dob is mandatory")
	private String dob;
	
	@NotBlank(message = "gender is mandatory")
	private String gender;
	
	@NotBlank(message = "phonenum is mandatory")
	private String phonenum;
	
	@NotBlank(message = "address is mandatory")
	private String address;
	
	@NotBlank(message = "created_on is mandatory")
	private String created_on;
	
	@NotBlank(message = "security_answer is mandatory")
	private String security_answer;
	
	@NotNull(message = "security_id is mandatory")
	private Long security_id;


	public User getUser() {
		return user;
	}

	public User setUser(User user) {
		return this.user = user;
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

	public Registration(Long regid, User user, String firstname, String lastname, String dob, String gender,
			String phonenum, String address, String created_on, String security_answer, Long security_id) {
		super();
		this.user = user;
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

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Registration [regid=" + regid + ", user=" + user + ", firstname=" + firstname + ", lastname="
				+ lastname + ", dob=" + dob + ", gender=" + gender + ", phonenum=" + phonenum + ", address=" + address
				+ ", created_on=" + created_on + ", security_answer=" + security_answer + ", security_id=" + security_id
				+ "]";
	}

}
