package br.com.vieira.stockmaster.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_password")
	private String password;
	@ManyToOne
	@JoinColumn(name = "access_level_id_fk")
	private AccessLevel accessLevel;

	public User() {
	}

	public User(Long id, String name, String email, String password, AccessLevel accessLevel) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.accessLevel = accessLevel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public AccessLevel getAccessLevel() { return accessLevel; }
	 * 
	 * public void setAccessLevel() { AccessLevel accessLevel = new AccessLevel();
	 * 
	 * 
	 * accessLevel.setLevel(al);
	 * 
	 * this.accessLevel = accessLevel; }
	 */
	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", accessLevel="
				+ accessLevel + "]";
	}

}
