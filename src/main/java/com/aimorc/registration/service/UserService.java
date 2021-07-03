package com.aimorc.registration.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aimorc.registration.entity.UpdatePassword;
import com.aimorc.registration.entity.User;
import com.aimorc.registration.repository.UserRepository;

@Service
public class UserService {
	
	Logger logger = LoggerFactory.getLogger("UserService");
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getAllLoginInUsers() {
		return userRepository.findAll();
	}

	public User findLoginById(Long userid) {
		return userRepository.findById(userid).get();
	}
	

	public User saveUserEntry(User userToUser) throws Exception {
		if (userToUser == null) {
			throw new Exception("Invalid Entry");
		}
		return userRepository.save(userToUser);
	}

	public User loginUser(User userToLogin) {
		/*
		 * User user = new User ( "M J", "Password", "9-2-2021 13:1:58"); User
		 * savedValue = userRepository.save(user);
		 * System.out.println("\n\n\n-----------> " +
		 * userRepository.findById(savedValue.getUserid()));
		 */
		User savedValue1 = userRepository.save(userToLogin);
		return savedValue1;
	}
	
	public void deleteUser(Long userid) {
		userRepository.deleteById(userid);
	}

	public User findLoginById(User username) {
		return userRepository.findByName(username).get();
	}

	public Optional<User> getuserid(String username) {
		return userRepository.fetchuserid(username);
	}
	
	@Transactional
	public ResponseEntity<String> updatePassword(User login) {
		System.out.println("password is " + login.getPassword());
		Optional<User> logins = this.userRepository.findByUsername(login.getUsername());
		String encryptedpassword = getEncodedString(login.getPassword());
		System.out.println("encryptedpassword = " + encryptedpassword);
		if (!logins.get().getPassword().toString().equalsIgnoreCase(encryptedpassword)) {
			userRepository.updatePassword(login.getUsername(), encryptedpassword);
			return new ResponseEntity<String>("Password updated succesfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Password entered already exist!", HttpStatus.OK);

	}
	
	public static String getEncodedString(String password) {
		String encrytedpassword = Base64.getEncoder().encodeToString(password.getBytes());
		return encrytedpassword;
	}
	
	@Transactional
	public ResponseEntity<String> updatePassword(UpdatePassword password) {
		System.out.println("password is " + password.getOldpassword());

		Optional<User> userid = this.userRepository.findByUsername(password.getUsername());

		String encryptedoldpassword = getEncodedString(password.getOldpassword());
		System.out.println("encryptedoldpassword = " + encryptedoldpassword);

		String encryptednewpassword = getEncodedString(password.getNewpassword());
		System.out.println("encryptednewpassword = " + encryptednewpassword);


		if(encryptedoldpassword.toString().equals(encryptednewpassword)) 
		{
			return new ResponseEntity<String>("Old password is same as new password! give some different password", HttpStatus.BAD_REQUEST);
		}
		
		if (userid.get().getPassword().toString().equalsIgnoreCase(encryptedoldpassword)) {
			userRepository.updatePassword(password.getUsername(), encryptednewpassword);
			return new ResponseEntity<String>("Password updated succesfully", HttpStatus.OK);
		}
		
		
		return new ResponseEntity<String>("Check Credentials and update!", HttpStatus.BAD_REQUEST);

	}

}


