package com.LoginRegistration.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.LoginRegistration.entity.Login;
import com.LoginRegistration.entity.Register;
import com.LoginRegistration.services.LoginServices;


@RestController
public class LoginRegistrationController {

	@Autowired
	private LoginServices loginservices;
	

	@GetMapping("/login/{userid}") 
	  public Optional<Login> getLoginById(@PathVariable int userid) 
	{
	     return this.loginservices.getLoginById(userid);
	   }
	

}
