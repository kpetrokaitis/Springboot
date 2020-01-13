package com.website.payload;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.website.model.Gender;

public class SignUpRequest {

	@NotBlank
	@Size(max = 20)
	private String first_name;
	
	@NotBlank
	@Size(max = 30)
	private String last_name;
	
	private Long national_id;
	
	@NotBlank
	@Size(max = 15)
	private String username;
	
	@NaturalId
	@NotBlank
	@Size(max = 40)
	@Email
	private String email;
	
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;
	
	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(length = 60)
	private Gender gender;
	
	@NotBlank
	@Size(min = 6, max = 20)
	private String password;

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public Long getNational_id() {
		return national_id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public String getPassword() {
		return password;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setNational_id(Long national_id) {
		this.national_id = national_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}
