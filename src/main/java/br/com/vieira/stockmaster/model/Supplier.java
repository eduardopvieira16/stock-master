package br.com.vieira.stockmaster.model;

import java.sql.Timestamp;

public class Supplier {

	private Long id;
	private String supplier;
	private String taxId; // Informar o CNPJ or CPF
	private String email;
	private String phone;
	private String celPhone;
	private String cep;
	private String address;
	private String numberAddress;
	private String neighborhood;
	private String city;
	private String uf;
	private Timestamp createdAt;
	private Timestamp updateAt;

	public Supplier() {
	}

	public Supplier(Long id, String supplier, String taxId, String email, String phone, String celPhone, String cep,
			String address, String numberAddress, String neighborhood, String city, String uf, Timestamp createdAt,
			Timestamp updateAt) {
		this.id = id;
		this.supplier = supplier;
		this.taxId = taxId;
		this.email = email;
		this.phone = phone;
		this.celPhone = celPhone;
		this.cep = cep;
		this.address = address;
		this.numberAddress = numberAddress;
		this.neighborhood = neighborhood;
		this.city = city;
		this.uf = uf;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCelPhone() {
		return celPhone;
	}

	public void setCelPhone(String celPhone) {
		this.celPhone = celPhone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumberAddress() {
		return numberAddress;
	}

	public void setNumberAddress(String numberAddress) {
		this.numberAddress = numberAddress;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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
		return "Supplier [id=" + id + ", supplier=" + supplier + ", taxId=" + taxId + ", email=" + email + ", phone="
				+ phone + ", celPhone=" + celPhone + ", cep=" + cep + ", address=" + address + ", numberAddress="
				+ numberAddress + ", neighborhood=" + neighborhood + ", city=" + city + ", uf=" + uf + ", createdAt="
				+ createdAt + ", updateAt=" + updateAt + "]";
	}

}
