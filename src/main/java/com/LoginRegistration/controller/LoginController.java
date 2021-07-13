package com.LoginRegistration.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.LoginRegistration.Exception.UserNotFoundException;
import com.LoginRegistration.entity.Password;
import com.LoginRegistration.entity.Login;
import com.LoginRegistration.entity.Profile;
import com.LoginRegistration.entity.Userdata;
import com.LoginRegistration.services.LoginServices;

@Controller
public class LoginController {

	@Autowired
	private LoginServices loginServices;

	String sessionusername;

	@PostMapping("/getUserId")
	@ResponseBody
	public int getUserId(@RequestBody Login login) {
		return this. loginServices.getUserId(login.getUsername());
		
	}

	@RequestMapping("/userlogin")
	public ResponseEntity<String> getUserDetails(@RequestBody Login login, HttpServletRequest request)
			throws UserNotFoundException {
		ResponseEntity<String> sessionvalid = loginServices.getUserDetails(login.getUsername(), login.getPassword(),
				login.getLastlogin());
		HttpSession session = request.getSession();
		session.setAttribute("username", login.getUsername());
		sessionusername = (String) session.getAttribute("username");
		return sessionvalid;
	}

	@PostMapping("/newregistration")
	public String registeruser(@RequestBody Userdata newuser) throws UserNotFoundException {
		loginServices.registeruser(newuser);
		return "redirect:/login";

	}

	@PostMapping("/forgotpassword")
	public ResponseEntity<String> getIdAndAns(@RequestBody Password fp, HttpServletRequest request)
			throws UserNotFoundException {
		ResponseEntity<String> sessionvalid = loginServices.getIdAndAns(fp);
		HttpSession session = request.getSession();
		session.setAttribute("username", fp.getUsername());
		sessionusername = (String) session.getAttribute("username");
		return sessionvalid;
	}

	@PostMapping("/setpassword")
	public ResponseEntity<String> setpassword(@RequestBody Login login, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			sessionusername = (String) session.getAttribute("username");
			login.setUsername(sessionusername);
			return this.loginServices.setpassword(login);
		}
		return new ResponseEntity<String>("Password entered already exist!", HttpStatus.OK);

	}


	@PostMapping("/getSecurityIdAndAns")
	public ResponseEntity<String> getSecurityIdAndAns(@RequestBody Password fp, HttpServletRequest request)
			throws UserNotFoundException {
		HttpSession session = request.getSession(false);
		if (session != null)
			sessionusername = (String) session.getAttribute("username");
		fp.setUsername(sessionusername);
		ResponseEntity<String> sessionvalid = loginServices.getSecurityIdAndAns(fp);
		return sessionvalid;
	}



	@PostMapping("/updatePassword")
	public ResponseEntity<String> updatePassword(@RequestBody Password password, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			sessionusername = (String) session.getAttribute("username");
			password.setUsername(sessionusername);
			return this.loginServices.updatePassword(password);
		}

		return new ResponseEntity<String>("Password entered already exist!", HttpStatus.OK);
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
           return "login";
	}
	

	
	@RequestMapping(value = "/profile", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody 
	public Profile getProfileDetails(HttpServletRequest request) throws UserNotFoundException {
		HttpSession session = request.getSession(false);
		if (session != null) 
			sessionusername = (String) session.getAttribute("username");
			return this.loginServices.getProfileDetails(sessionusername);
	} 
	
	

	@PostMapping("/updateProfileDetails")
	public ResponseEntity<String> updateuserdetails(@RequestBody Profile profile, HttpServletRequest request)
			throws UserNotFoundException {
		HttpSession session = request.getSession(false);
		if (session != null)
			sessionusername = (String) session.getAttribute("username");
		profile.setUsername(sessionusername);
		return this.loginServices.updateuserdetails(profile);
	}

//--------------------------------------------------JSP--------------------------------------------
	@RequestMapping("/register")
	public String registerPage() {
		return "registration";
	}

	@RequestMapping("/registersuccess")
	public String registersuccess() {
		return "redirect:/login";
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/passwordforgot")
	public String forgotpasswordPage() {
		return "forgotpassword";
	}

	@RequestMapping("/passwordchange")
	public String changepasswordPage() {
		return "changepassword";
	}

	@RequestMapping("/home")
	public String homePage(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			sessionusername = (String) session.getAttribute("username");
			return "home";
		}
		return "login";
	}

	
	@RequestMapping("/loginSecurityQuestion")
	public String loginSecurityQuestionPage() {
		return "loginsecurityquestion";
	}
	
	@RequestMapping("/loginChangePassword")
	public String loginChangePasswordPage() {
		return "loginchangepassword";
	}
	
	@RequestMapping("/profilePage")
	public String profilePage() {
		return "profile";
	}
	
	@RequestMapping("/updateProfile")
	public String editProfilepage() {
		return "editprofile";
	}
	
	
	
	
	 



}
