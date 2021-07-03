package com.LoginRegistration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.LoginRegistration.entity.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {

	public Register findById(int userid);

}
