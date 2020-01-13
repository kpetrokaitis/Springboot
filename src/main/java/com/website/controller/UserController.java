package com.website.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.exception.ResourceNotFoundException;
import com.website.model.User;
import com.website.payload.UserProfile;
import com.website.payload.UserSummary;
import com.website.payload.UsersList;
import com.website.repository.UserRepository;
import com.website.security.CurrentUser;
import com.website.security.UserPrincipal;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN')")
	public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
		UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getFirst_name(), currentUser.getLast_name());
		return userSummary;
	}
	
	//Find user profile
	@GetMapping("/users/{username}")
	@PreAuthorize("hasRole('USER'")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getFirst_name(), user.getLast_name(), user.getNational_id(), user.getBirthday(), user.getCreatedAt());
        return userProfile;
	}
	
	//To implement search and pageable modify endpoints in client side
	@GetMapping("/users") 
	@PreAuthorize("hasRole('USER')")
	public UsersList getUsersList(@RequestParam Optional<String> firstname,
								  @RequestParam Optional<String> lastname,
								  @RequestParam Optional<Integer> page, 
								  @RequestParam Optional<String> sortBy) {
		Pageable fiveElementsPage = PageRequest.of(page.orElse(0), 5, Sort.by(sortBy.orElse("id")).ascending());
		UsersList usersList = new UsersList(userRepository.findAllByFirstname(firstname.orElse("_"), fiveElementsPage));
		return usersList;
	}
	
	
	
}
