package com.LoginRegistration.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LoginRegistration.entity.Login;
import com.LoginRegistration.entity.Register;
@Repository
public interface RegisterRepository extends JpaRepository<Register,Integer>
{

	public Register findById(int userid);

	/* public Register save(Register newuser); */
	/*
	 * @Query(value = "select * from registration where userid=?", nativeQuery =
	 * true) public Optional<Login> findByUsername(String username);
	 */
	/*
	 * @Query(value = "select * from registration where regid=?", nativeQuery =
	 * true) public Optional<Register> fetchByUserid(int regid);
	 * 
	 * @Query(value = "SELECT userid from login where username= ?", nativeQuery =
	 * true) boolean findByusername(String username);
	 * 
	 * @Query(value = "select * from login where username=?", nativeQuery = true)
	 * public Optional<Login> fetchuserid(@Param("username") String username);
	 */

	/* Login findByUsername(String username); */
	@Modifying
	@Query(value = "UPDATE registration set firstname=:firstname,lastname=:lastname,dob=:dob,gender=:gender,phonenum=:phonenum, address=:address where userid=:userid", nativeQuery = true)
	public void updateDetails(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("dob")String dob,@Param("gender") String gender,@Param("phonenum") String phonenum,@Param("address") String address,@Param("userid") int userid); 
			
}
