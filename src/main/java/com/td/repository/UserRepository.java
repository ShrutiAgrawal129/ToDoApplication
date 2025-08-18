package com.td.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.td.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByName(String name);
	
	Optional<User> findById(Long u_id);
	
	@Modifying 
	@Query("UPDATE User u SET u.email= :email WHERE u.name= :name")
	void updateProfile(@Param("name") String name,
			@Param("email")String email);
	
	@Modifying
	@Query("UPDATE User u SET u.password=:npass where u.name=:name ")
	void chpass(@Param("name")String name,@Param("npass")String npass);
}
