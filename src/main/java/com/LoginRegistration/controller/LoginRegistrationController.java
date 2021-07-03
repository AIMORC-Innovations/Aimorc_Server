package com.LoginRegistration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LoginRegistration.Exception.UserNotFoundException;
import com.LoginRegistration.Repository.LoginRepository;
import com.LoginRegistration.entity.Login;
import com.LoginRegistration.entity.Profile;
import com.LoginRegistration.entity.Register;
import com.LoginRegistration.services.LoginServices;
import com.fasterxml.jackson.annotation.JsonBackReference;





@RestController
public class LoginRegistrationController {
	
	@Autowired 
	private LoginRepository loginRepository;
	
	@Autowired 
	private LoginServices loginservices;
	

	/*
	 * @GetMapping("/login/{userid}") public ResponseEntity<Login>
	 * getLoginById(@PathVariable int userid) { Login login =
	 * loginservices.getLoginById(userid); return ResponseEntity.ok(login); }
	 */
	
	/*
	 * @PostMapping(value = "/login", produces="application/json") public Login
	 * loginUser(@RequestBody Login user){ return loginservices.loginUser(user); }
	 */
	/*
	 * @PostMapping(valu"/login") public
	 * ResponseEntity<LoginWrapper>savelogin(@RequestBody LoginWrapper loginwrapper)
	 * { loginwrapper = loginservices.savelogin(loginwrapper); return
	 * ResponseEntity.ok(loginwrapper); }
	 */
	 
	
	
	
	/*
	 * @GetMapping("/loginusername") public Login validateuser(@RequestBody String
	 * username) { return this.loginservices.validateuser(username); }
	 */
	 
	 
	/*
	 * @GetMapping("/getuser") public Login validateuser(@RequestBody String
	 * username)
	 * 
	 * { return this.loginservices.validateuser(username); }
	 */
	 
	/*
	 * @GetMapping("/profile/{userid}") public Optional
	 * getprofiledetails(@PathVariable("userid") String userid) { return
	 * this.loginservices.getprofiledetails(Integer.parseInt(userid)); }
	 */
	 
		/*
		 * @PostMapping("/getuserid") public Optional getuserid(@RequestBody Login
		 * login) {
		 * 
		 * Optional loginRepository = loginservices.getuserid(login.getUsername());
		 * return loginRepository; }
		 */
	  
	  
		
		
		  @PostMapping("login/userDetails")
		  
		  public Object getuserdetails(@RequestBody Login login) {
		  
		  
		  var userid = loginservices.getuserId(login.getUsername()); return userid; }
		 
		  
		/*
		 * @PostMapping("/updateprofiledetails") public ResponseEntity<String>
		 * updateuserdetails(@RequestBody Profile profile)throws UserNotFoundException {
		 * System.out.println("Username is " + profile.getUsername()); return
		 * this.loginServices.updateuserdetails(profile); }
		 * 
		 */

		/*
		 * @PostMapping("/profiledetails") public Profile getuserdetails(@RequestBody
		 * Login login)throws UserNotFoundException { System.out.println("Username is "
		 * + login.getUsername()); return this.loginservices.getprofiledetails(login); }
		 */
			/*
			 * @PostMapping("/updateUserDetails") public Register
			 * UpdateProfileDetails(@RequestBody Register register) { var userid =
			 * getuserId( return loginservices.updateProfile(register);
			 * 
			 * }
			 * 
			 */
	@PostMapping("/updateprofiledetails")
	public ResponseEntity<String> updateuserdetails(@RequestBody Profile profile)throws UserNotFoundException  {
		System.out.println("Username is " + profile.getUsername());
		return this.loginservices.updateuserdetails(profile);
	}	
	
		/*
		 * @GetMapping("/profile/{userid}") public List<Register>
		 * getProfileByName(@PathVariable int userid) { return
		 * this.loginservices.getProfileByName(userid);
		 * 
		 * }
		 */
		
	 
}
