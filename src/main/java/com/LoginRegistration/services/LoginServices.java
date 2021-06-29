package com.LoginRegistration.services;

import java.util.Base64;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoginRegistration.Repository.LoginRepository;
import com.LoginRegistration.entity.Login;
//import com.LoginRegitrationException.UserNotFoundException;

@Service
public class LoginServices {

	@Autowired
	private LoginRepository loginrepository;

	

	public Optional<Login> getLoginById(int userid) {
		return loginrepository.findById(userid);
	}

}
