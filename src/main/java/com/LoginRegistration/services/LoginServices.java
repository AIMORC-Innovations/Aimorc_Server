package com.LoginRegistration.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LoginRegistration.Exception.UserNotFoundException;
import com.LoginRegistration.Repository.LoginRepository;
import com.LoginRegistration.Repository.RegisterRepository;
import com.LoginRegistration.entity.Login;
import com.LoginRegistration.entity.Profile;
import com.LoginRegistration.entity.Register;

@Service
public class LoginServices<userdetails> {

	@Autowired
	private LoginRepository loginrepository;

	@Autowired
	private RegisterRepository registerrepository;

	/*
	 * public Login getLoginById(int userid) { Login loginoutput = null;
	 * 
	 * Optional<Login> loginoptionaldata = loginrepository.findById(userid); if
	 * (loginoptionaldata.isPresent()) { loginoutput = new Login(); Login login =
	 * loginoptionaldata.get(); loginoutput.setUserid(login.getUserid());
	 * loginoutput.setUsername(login.getUsername());
	 * loginoutput.setPassword(login.getPassword());
	 * loginoutput.setLastlogin(login.getLastlogin()); }
	 * 
	 * return loginoutput;
	 * 
	 * }
	 */
	/*
	 * public Login loginUser(Login user) {
	 * 
	 * Login savedValue = loginrepository.save(user); return savedValue; }
	 * 
	 */
	/*
	 * public Login validateuser(String username) { System.out.println(username +
	 * "inside GET MAP");
	 * 
	 * if (loginrepository.findByusername(username) != null) {
	 * System.out.println(username + "inside GET IF validate"); } return null; }
	 * 
	 * public Optional<Register> getprofiledetails(int userid) { return
	 * registerrepository.findById(userid);
	 * 
	 * }
	 */

	/*
	 * public Optional<Login> getuserid(String username) { return
	 * loginrepository.fetchuserid(username); }
	 */
	
	/*
	 * public List<Register> getProfileByName(int userid ) { Register loginoutput =
	 * null;
	 * 
	 * Optional<Register> loginoptionaldata = registerrepository.findById(userid);
	 * if(loginoptionaldata.isPresent()) { loginoutput = new Register(); Register
	 * register =loginoptionaldata.get();
	 * loginoutput.setFirstname(register.getFirstname());
	 * loginoutput.setLastname(register.getLastname());
	 * loginoutput.setDob(register.getDob());
	 * loginoutput.setGender(register.getGender());
	 * loginoutput.setPhonenum(register.getPhonenum());
	 * loginoutput.setAddress(register.getAddress()); }
	 * 
	 * return (List<Register>) loginoutput; }
	 */
	
	
	  public Register getuserId(String username) { 
		  return	  loginrepository.findByUsername(username).get().getRegister(); }
	 
	 
	/*
	 * public Profile getprofiledetails(Login login) throws UserNotFoundException{
	 * int userid =
	 * loginrepository.findByUsername(login.getUsername()).get().getUserid();
	 * System.out.println(userid); Register register =
	 * registerrepository.findById(userid); System.out.println(register); Profile
	 * profile = new Profile(); profile.setFirstname(register.getFirstname());
	 * profile.setLastname(register.getLastname());
	 * profile.setDob(register.getDob());
	 * profile.setPhonenum(register.getPhonenum());
	 * profile.setGender(register.getGender());
	 * profile.setAddress(register.getAddress()); return profile; }
	 */
		
		  @Transactional public ResponseEntity<String> updateuserdetails(Profile
		  profile) { int userid =
		  loginrepository.findByUsername(profile.getUsername()).get().getUserid();
		  registerrepository.updateDetails(profile.getFirstname(),
		  profile.getLastname(), profile.getDob(), profile.getGender(),
		  profile.getPhonenum(), profile.getAddress(), userid); return new
		  ResponseEntity<String>("Details updated succesfully", HttpStatus.OK);
		  
		  }
		 		
			/*
			 * public Register updateProfile(Register register,Login login) {
			 * 
			 * var Reguserid = loginrepository.findByUsername(username).getUserid();
			 * System.out.println(Reguserid);
			 * 
			 * 
			 * }
			 */
		 
	 
		/*
		 * public Register updateProfile(String username) { return
		 * loginrepository.findByUsername(username).;
		 * 
		 * }
		 */

}
