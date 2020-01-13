package com.website.payload;

public class UserSummary {
	private Long id;
	private String username;
	private String first_name;
	private String last_name;
	
	public UserSummary(Long id, String username, String first_name, String last_name) {
		this.id = id;
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFirstname() {
		return first_name;
	}
	
	public void setFirstname(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastname() {
		return last_name;
	}
	
	public void setLastname(String last_name) {
		this.last_name = last_name;
	}
}

