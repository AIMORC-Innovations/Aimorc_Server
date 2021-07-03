package com.aimorc.registration.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aimorc.registration.entity.Registration;
import com.aimorc.registration.entity.User;
import com.aimorc.registration.repository.RegistrationRepository;
import com.aimorc.registration.repository.UserRepository;

@Service
public class RegistrationService {

	Logger logger = LoggerFactory.getLogger("RegistrationService");

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private UserRepository userRepository;

	public RegistrationService(RegistrationRepository registrationRepository) {
		this.registrationRepository = registrationRepository;
	}

	public List<Registration> getAllRegisteredUsers() {
		return registrationRepository.findAll();
	}

	public Registration findRegistrationById(Long registrationId) {
		return registrationRepository.findById(registrationId).get();
	}

	public Registration saveRegisrationEntry(Registration userToRegister) throws Exception {
		if (userToRegister == null) {
			throw new Exception("Invalid Entry");
		}
		return registrationRepository.save(userToRegister);
	}

	public Registration registerUser(Registration userToRegister) {
		User createdUser = userRepository.save(userToRegister.getUser());
		userToRegister.setUser(createdUser);

		/*
		 * User user = new User ( "M J Lakshmi", "Password", "9-2-2021 13:1:58");
		 * 
		 * Registration reg = new Registration(new Long(1245), user, "Raghav", "M J",
		 * "2021-02-10", "Male", "985623121", "Bangalore", "9-2-2021 13:1:58", "Dog",
		 * new Long(1));
		 * 
		 * Registration savedValue = registrationRepository.save(reg);
		 * System.out.println("\n\n\n-----------> " +
		 * registrationRepository.findById(savedValue.getRegid()));
		 */

		Registration savedValue = registrationRepository.save(userToRegister);
		return savedValue;
	}

	public void deleteUser(Long registrationId) {
		registrationRepository.deleteById(registrationId);
	}
}

