package br.com.vieira.stockmaster.model;

import java.sql.Timestamp;

public class StockMovement {

	private Long id;
	private String movementType;
	private String description;
	private Long quantity;
	private Timestamp createdAt;
	private Category category;
	private Supplier supplier;
	private AccessLevel accessLevel;
	private User user;

	public StockMovement() {
	}

	public StockMovement(Long id, String movementType, String description, Long quantity, Timestamp createdAt,
			Category category, Supplier supplier, AccessLevel accessLevel, User user) {
		super();
		this.id = id;
		this.movementType = movementType;
		this.description = description;
		this.quantity = quantity;
		this.createdAt = createdAt;
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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "StockMovement [id=" + id + ", movementType=" + movementType + ", description=" + description
				+ ", quantity=" + quantity + ", createdAt=" + createdAt + ", category=" + category + ", supplier="
				+ supplier + ", accessLevel=" + accessLevel + ", user=" + user + "]";
	}
}
