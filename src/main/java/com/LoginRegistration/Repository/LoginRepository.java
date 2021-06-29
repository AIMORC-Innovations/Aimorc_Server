package com.LoginRegistration.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.LoginRegistration.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	@Query(value="select * from login where username=? and password=?",nativeQuery = true)
	public Optional<Login> validateuser(String username, String encryptedpassword);

}
