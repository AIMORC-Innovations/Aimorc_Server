package com.LoginRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.LoginRegistration.Exception.UserNotFoundException;
import com.LoginRegistration.entity.Login;
import com.LoginRegistration.services.LoginServices;

@RestController
public class LoginRegistrationController {

	@Autowired
	private LoginServices loginservices;

	@PostMapping("/login")
	public Login getuserdetails(@RequestBody Login login) throws UserNotFoundException {
		return this.loginservices.getuserdetails(login.getUsername(), login.getPassword())
				.orElseThrow(() -> new UserNotFoundException("User not found with this name: " + login.getUsername()));
	}

}
