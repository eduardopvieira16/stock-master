package br.com.vieira.stockmaster.model;

import java.sql.Timestamp;

public class Supplier {

	private Long id;
	private String category;
	private Timestamp createdAt;
	private Timestamp updateAt;

	public Supplier() {
	}

	public Supplier(Long id, String category, Timestamp createdAt, Timestamp updateAt) {
		super();
		this.id = id;
		this.category = category;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

}
