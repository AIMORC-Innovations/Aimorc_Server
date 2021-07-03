package com.LoginRegistration.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.LoginRegistration.entity.Login;
import com.LoginRegistration.entity.Register;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	/*
	 * @Query(value = "select * from registration where regid=?", nativeQuery =
	 * true) public Optional<Register> fetchByUserid(int regid);
	 * 
	 * 
	 * @Query(value = "SELECT userid from login where username= ?", nativeQuery =
	 * true) Login findByusername(String username);
	 */
	/*
	 * @Query(value = "select * from login where username=?", nativeQuery = true)
	 * public Optional<Login> fetchuserid(@Param("username") String username);
	 */

	Optional <Login> findByUsername(String username); 

	Register save(Register register); 
	/* public Optional<Login> findByUsername(String username); */
}
