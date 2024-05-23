package br.com.vieira.stockmaster.dao;

import java.util.List;

import br.com.vieira.stockmaster.model.Product;

public interface ProductDao {

	/* Only Read - List and Search */
	List<Product> listProduct();

	List<Product> listByNameProduct(String product);

	Product searchByCodeProduct(Long id);

	/* Create - Update - Delete */
	Product createProduct(Product product);

	Product updateProduct(Product product);

	Product deleteProduct(Long id);
}
