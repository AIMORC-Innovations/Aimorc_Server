package com.LoginRegistration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.LoginRegistration.entity.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {

	public Register findById(int userid);

	@Query(value = "select security_id , security_answer from registration where security_id=? and security_answer=? and userid=?", nativeQuery = true)
	public Register findBySecurityIdAndSecurityAns(@Param("security_id") int security_id,
			@Param("security_answer") String security_answer, @Param("userid") int userid);

}
