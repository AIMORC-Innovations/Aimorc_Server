package com.aimorc.registration.repository;

import java.util.List;
import java.util.Optional;

import com.aimorc.registration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "select * from login where username = ?" , nativeQuery = true)
	Optional<User> findByName(User username);

	  @Query(value = "select * from login where username=?", nativeQuery = true) 
	  public Optional<User> fetchuserid(@Param("username") String username);
	 
}
