package com.website.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.website.model.Role;
import com.website.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	 Optional<Role> findByName(RoleName roleName);
	    
}
