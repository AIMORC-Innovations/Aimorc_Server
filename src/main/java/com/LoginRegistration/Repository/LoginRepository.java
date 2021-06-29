package com.LoginRegistration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.LoginRegistration.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
