package com.aimorc.registration.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}


