package com.LoginRegistration.services;

import java.util.Base64;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LoginRegistration.Exception.UserNotFoundException;
import com.LoginRegistration.Repository.LoginRepository;
import com.LoginRegistration.entity.Login;

@Service
public class LoginServices {

	@Autowired
	private LoginRepository loginrepository;

	public Optional<Login> getuserdetails(String username, String password) throws UserNotFoundException {
		String encryptedpassword = getEncodedString(password);
		System.out.println("encryptedpassword = " + encryptedpassword);

		return loginrepository.findByUsernameAndPassword(username, encryptedpassword);

	}

	public static String getEncodedString(String password) {
		String encrytedpassword = Base64.getEncoder().encodeToString(password.getBytes());
		return encrytedpassword;
	}

}
