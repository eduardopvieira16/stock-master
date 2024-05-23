package br.com.vieira.stockmaster.model;

import java.sql.Timestamp;

public class StockMovement {

	private Long id;
	private String movementType;
	private String description;
	private Long quantity;
	private Timestamp movementDate;
	private Category category;
	private Supplier supplier;
	private AccessLevel accessLevel;
	private User user;

	public StockMovement() {
	}

	public StockMovement(Long id, String movementType, String description, Long quantity, Timestamp movementDate,
			Category category, Supplier supplier, AccessLevel accessLevel, User user) {
		this.id = id;
		this.movementType = movementType;
		this.description = description;
		this.quantity = quantity;
		this.movementDate = movementDate;
		this.category = category;
		this.supplier = supplier;
		this.accessLevel = accessLevel;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMovementType() {
		return movementType;
	}

	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Timestamp getMovementDate() {
		return movementDate;
	}

	public void setMovementDate(Timestamp movementDate) {
		this.movementDate = movementDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Long id, String category) {
		Category cat = new Category();
		cat.setId(id);
		cat.setCategory(category);
		this.category = cat;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Long id, String supplier, String taxId, String email) {
		Supplier sup = new Supplier();
		sup.setId(id);
		sup.setSupplier(supplier);
		sup.setTaxId(taxId);
		sup.setEmail(email);
		this.supplier = sup;
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

	public User getUser() {
		return user;
	}

	public void setUser(Long id, String name, String email) {
		User us = new User();
		us.setId(id);
		us.setName(name);
		us.setEmail(email);
		this.user = us;
	}

	@Override
	public String toString() {
		return "StockMovement [id=" + id + ", movementType=" + movementType + ", description=" + description
				+ ", quantity=" + quantity + ", movementDate=" + movementDate + ", category=" + category + ", supplier="
				+ supplier + ", accessLevel=" + accessLevel + ", user=" + user + "]";
	}
}
