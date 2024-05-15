package br.com.vieira.stockmaster.model;

public class AccessLevel {

	private Integer id;
	private String level;

	public AccessLevel() {
	}

	public AccessLevel(String level) {
		super();
		this.level = level;
	}

	public AccessLevel(Integer id, String level) {
		super();
		this.id = id;
		this.level = level;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "AccessLevel [id=" + id + ", level=" + level + "]";
	}
}
