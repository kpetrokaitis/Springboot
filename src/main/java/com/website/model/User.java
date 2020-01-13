package com.website.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.website.model.audit.DateAudit;

@Entity
@Table(name="SPRING_USER", uniqueConstraints =  {
		@UniqueConstraint(columnNames = {
				"username"
		}),
		@UniqueConstraint(columnNames = {
				"email"
		})
})
public class User extends DateAudit{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	private String first_name;
	
	@NotBlank
	@Size(max = 30)
	private String last_name;
	@NotBlank
	@Size(max = 15)
	private String username;
	
	@NaturalId
	@NotBlank
	@Size(max = 40)
	@Email
	private String email;
	
	private Long national_id;
	
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;
	
	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(length = 60)
	private Gender gender;
	
	@NotBlank
	@Size(max = 100)
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "spring_user_roles" ,
			   joinColumns = @JoinColumn(name = "spring_user_id"),
			   inverseJoinColumns = @JoinColumn(name = "spring_role_id"))
	private Set<Role> roles = new HashSet<>();
	
	public User() {  }

	public User(String first_name, String last_name, String username, String email, long national_id, Date birthday, Gender gender,  String password) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.email = email;
		this.national_id = national_id;
		this.birthday = birthday;
		this.gender = gender;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public Long getNational_id() {
		return national_id;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNational_id(Long national_id) {
		this.national_id = national_id;
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

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	

	
	
}
