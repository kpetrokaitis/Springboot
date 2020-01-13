package com.website.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.website.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
	Optional<User> findByEmail(String email);
	
	Optional<User> findByUsername(String username);
	
	Optional<User> findByUsernameOrEmail(String username, String email);
		
	List<User> findByIdIn(List<Long> userIds);
	
	@Query("select u from User u where first_name like %?1%")
	
	List<User> findAllByFirstname(String firstname, Pageable page);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
}
