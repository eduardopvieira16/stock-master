package br.com.vieira.stockmaster.model;

public class User {
	private Long id;
	private String name;
	private String email;
	private String password;
	private AccessLevel accessLevel;

	public User() {
	}

	public User(Long id, String name, String email, String password, AccessLevel accessLevel) {
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

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(Integer id, String access) {
		AccessLevel al = new AccessLevel();
		al.setId(id);
		al.setLevel(access);
		this.accessLevel = al;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", accessLevel="
				+ accessLevel + "]";
	}

}
