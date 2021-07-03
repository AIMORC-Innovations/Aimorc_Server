package com.aimorc.registration.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aimorc.registration.entity.Registration;
import com.aimorc.registration.service.RegistrationService;

@RestController
@RequestMapping("/registration")
@Validated
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/newuserregistration")
	public List<Registration> getregistrations() {
		return this.registrationService.getAllRegisteredUsers();
	}

	@GetMapping("/newuserregistration/{registrationId}")
	public Registration findRegisteredUserById(@PathVariable("registrationId") Long registrationId) {
		return registrationService.findRegistrationById(registrationId);
	}

    @PostMapping("/newuserregistration")
    public Registration registerUser(@Valid @RequestBody Registration userToRegister){
        return registrationService.registerUser(userToRegister);
    }
    
}
