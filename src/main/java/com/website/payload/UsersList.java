package com.website.payload;

import java.util.List;

import org.springframework.data.domain.Page;

import com.website.model.User;

public class UsersList {
	private List<User> users;
	
	public UsersList(List<User> list) {
		this.users = list;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
