package br.com.vieira.stockmaster.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.vieira.stockmaster.dao.ProductDao;
import br.com.vieira.stockmaster.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductDao productDao;

	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> listAll() {
		return productDao.listProduct();
	}

	@Override
	public List<Product> listByName(String product) {
		return productDao.listByNameProduct(product);
	}

	@Override
	public Product searchByCode(Long id) {
		return productDao.searchByCodeProduct(id);
	}

	@Override
	public Product saveProduct(Product product) {
		if (product.getId() == null) {
			return productDao.createProduct(product);
		} else {
			return productDao.updateProduct(product);
		}
	}

	@Override
	public Product deleteProduct(Long id) {
		return productDao.deleteProduct(id);
	}
}
