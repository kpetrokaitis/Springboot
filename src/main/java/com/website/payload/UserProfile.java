package com.website.payload;

import java.time.Instant;
import java.util.Date;

public class UserProfile {
	 private Long id;
	    private String username;
	    private String first_name;
	    private String last_name;
	    private long national_id;
	    private Date birthday;
	    private Instant joinedAt;
	  
	    public UserProfile(Long id, String username, String first_name, String last_name, long national_id, Date birthday, Instant joinedAt) {
	        this.id = id;
	        this.username = username;
	        this.first_name = first_name;
	        this.last_name = last_name;
	        this.national_id = national_id;
	        this.birthday = birthday;
	        this.joinedAt = joinedAt;
	      
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
	    
	    public long getNationalId() {
	    	return national_id;
	    }
	    
	    public void setNationalId(long national_id) {
	    	this.national_id = national_id;
	    }
	    
	    public Date getBirthday() {
	    	return birthday;
	    }
	    
	    public void setBirthday(Date birthday) {
	    	this.birthday = birthday;
	    }
	    
		public Instant getJoinedAt() {
			return joinedAt;
		}

		public void setJoinedAt(Instant joinedAt) {
			this.joinedAt = joinedAt;
		}
	    
	    
}
