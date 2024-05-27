package br.com.vieira.stockmaster.service;

import java.util.List;

import br.com.vieira.stockmaster.model.Product;

public interface ProductService {
	/* Only Read - List and Search */
	List<Product> listAll();
	List<Product> listByName(String product);
	Product searchByCode(Long id);
	/* Create - Update - Delete */
	Product saveProduct(Product product);
	Product deleteProduct(Long id);
}
