package com.aimorc.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aimorc.registration.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	//public Optional<Registration> findById(Long regid);
	
}
