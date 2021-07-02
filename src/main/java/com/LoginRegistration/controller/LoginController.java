package com.LoginRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.LoginRegistration.Exception.UserNotFoundException;
import com.LoginRegistration.entity.Forgotpassword;
import com.LoginRegistration.entity.Login;

import com.LoginRegistration.services.LoginServices;

@RestController
public class LoginController {

	@Autowired
	private LoginServices loginServices;

	@PostMapping("/login")
	public Login getUserDetails(@RequestBody Login login) throws UserNotFoundException {
		return this.loginServices.getUserDetails(login.getUsername(), login.getPassword())
				.orElseThrow(() -> new UserNotFoundException("User not found with this name: " + login.getUsername()));
	}

	@PostMapping("/forgotpassword")
	public ResponseEntity<String> getIdAndAns(@RequestBody Forgotpassword fp) throws UserNotFoundException {
		System.out.println("Controller" + fp);
		return this.loginServices.getIdAndAns(fp);

	}

	@PostMapping("/setpassword")
	public ResponseEntity<String> setpassword(@RequestBody Login login) {
		System.out.println("Username is " + login.getUsername() + "Password is " + login.getPassword());
		return this.loginServices.setpassword(login);
	}

}
