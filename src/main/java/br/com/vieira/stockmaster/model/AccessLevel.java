package br.com.vieira.stockmaster.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "access_level")
public class AccessLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "access_level_id")
	private Integer id;
	@Column(name = "access_level")
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
