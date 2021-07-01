package com.LoginRegistration.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.LoginRegistration.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {
public Optional<Login> findByUsername(String username);
public Optional<Login> findByUsernameAndPassword(String username, String password);




}
