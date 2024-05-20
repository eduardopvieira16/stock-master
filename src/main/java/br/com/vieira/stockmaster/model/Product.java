package br.com.vieira.stockmaster.model;

import java.sql.Timestamp;

public class Product {

	private Long id;
	private String product;
	private String description;
	private Double costPrice;
	private Double salePrice;
	private String unitMeasure;
	private String image;
	private Long currentStock;
	private Long minimumStock;
	private Timestamp createdAt;
	private Timestamp updateAt;

	public Product() {
	}

	public Product(Long id, String product, String description, Double costPrice, Double salePrice, String unitMeasure,
			String image, Long currentStock, Long minimumStock, Timestamp createdAt, Timestamp updateAt) {
		super();
		this.id = id;
		this.product = product;
		this.description = description;
		this.costPrice = costPrice;
		this.salePrice = salePrice;
		this.unitMeasure = unitMeasure;
		this.image = image;
		this.currentStock = currentStock;
		this.minimumStock = minimumStock;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public String getUnitMeasure() {
		return unitMeasure;
	}

	public void setUnitMeasure(String unitMeasure) {
		this.unitMeasure = unitMeasure;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(Long currentStock) {
		this.currentStock = currentStock;
	}

	public Long getMinimumStock() {
		return minimumStock;
	}

	public void setMinimumStock(Long minimumStock) {
		this.minimumStock = minimumStock;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", product=" + product + ", description=" + description + ", costPrice="
				+ costPrice + ", salePrice=" + salePrice + ", unitMeasure=" + unitMeasure + ", image=" + image
				+ ", currentStock=" + currentStock + ", minimumStock=" + minimumStock + ", createdAt=" + createdAt
				+ ", updateAt=" + updateAt + "]";
	}
}