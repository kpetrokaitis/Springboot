package com.website.service;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.model.Role;
import com.website.model.User;
import com.website.repository.RoleRepository;
import com.website.repository.UserRepository;

@Service
public class AdminService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void setRolesByUserId(Map<Long, Set<Long>> rolesByUserId) {
		
		Map<Long, Role> roles = roleRepository.findAll()
				.stream().collect(Collectors.toMap(Role::getId, Function.identity()));
		
		for(User user : userRepository.findAllById(rolesByUserId.keySet())) {
			Set<Role> role = rolesByUserId.get(user.getId()).stream()
					.map(roles::get)
					.collect(Collectors.toSet());
			user.setRoles(role);
			userRepository.save(user);
		}
	}

}
