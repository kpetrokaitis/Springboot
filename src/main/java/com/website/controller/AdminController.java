package com.website.controller;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.sql.Date;
import java.util.Collections;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.model.User;
import com.website.payload.ApiResponse;
import com.website.payload.ChangeRole;
import com.website.repository.UserRepository;
import com.website.service.AdminService;

@RestController
@RequestMapping("/api")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin/users/change")
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<?> changeUserRole(@RequestBody  ChangeRole changeRole) {
		Map<Long, Set<Long>> ids = new HashMap<Long, Set<Long>>();
		ids.put(changeRole.getUserId(), Collections.singleton(changeRole.getRoleId()));
		adminService.setRolesByUserId(ids);
		
		return ResponseEntity.ok(new ApiResponse(true, "Role updated successfully!"));
	
	}
	@PutMapping("/admin/edit/{id}")
	public User update(@PathVariable(value="id") Long id, @RequestBody Map<String, String> body){
        
		User user = userRepository.findById(id).orElse(new User());
       
        user.setFirst_name(body.get("first_name"));
        user.setLast_name(body.get("last_name"));
        user.setUsername(body.get("username"));
        user.setEmail(body.get("email"));
        return userRepository.save(user);
	}
	
	@DeleteMapping("admin/delete/{id}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<?> deleteUser(@PathVariable(value ="id") Long id) {
		userRepository.deleteById(id);
		return ResponseEntity.ok(new ApiResponse(true, "User deleted successfully!"));
	
	}
}
