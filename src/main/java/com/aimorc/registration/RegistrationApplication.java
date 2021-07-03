package com.aimorc.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aimorc.registration.entity.User;
import com.aimorc.registration.repository.RegistrationRepository;
import com.aimorc.registration.repository.UserRepository;

@SpringBootApplication
public class RegistrationApplication {
	
	//Run|Debug
	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
	}
}

