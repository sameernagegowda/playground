package com.bhs.sb.bs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bhs.sb.bs.dao.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT u from User u WHERE u.email = ?1")
	public User findUserByEmail(String email);
}
