package br.com.vieira.stockmaster.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.vieira.stockmaster.mapper.ProductMapper;
import br.com.vieira.stockmaster.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	private final JdbcTemplate jdbcTemplate;

	public ProductDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Product> listProduct() {
		String listAll = "SELECT p.product_id, p.supplier_id, p.category_id, p.product_name, p.description, p.cost_price, p.sale_price, p.unit_measure, p.image, p.current_stock, p.minimum_stock, s.supplier_name, s.tax_id, s.email, c.category FROM product p LEFT JOIN supplier s ON p.supplier_id = s.supplier_id LEFT JOIN category c ON p.category_id = c.category_id ORDER BY p.product_id ASC";
		return jdbcTemplate.query(listAll, new ProductMapper());
	}

	@Override
	public List<Product> listByNameProduct(String product) {
		String listByName = "SELECT p.product_id, p.supplier_id, p.category_id, p.product_name, p.description, p.cost_price, p.sale_price, p.unit_measure, p.image, p.current_stock, p.minimum_stock, s.supplier_name, s.tax_id, s.email, c.category FROM product p LEFT JOIN  supplier s ON p.supplier_id = s.supplier_id LEFT JOIN  category c ON p.category_id = c.category_id WHERE p.product_name LIKE ?";
		return jdbcTemplate.query(listByName, new ProductMapper(), "%" + product + "%");
	}

	@Override
	public Product searchByCodeProduct(Long id) {
		String searchByCode = "SELECT p.product_id, p.supplier_id, p.category_id, p.product_name, p.description, p.cost_price, p.sale_price, p.unit_measure, p.image, p.current_stock, p.minimum_stock, s.supplier_name, s.tax_id, s.email, c.category FROM product p LEFT JOIN  supplier s ON p.supplier_id = s.supplier_id LEFT JOIN  category c ON p.category_id = c.category_id WHERE p.product_id = ?";
		return jdbcTemplate.queryForObject(searchByCode, new ProductMapper(), id);
	}

	@Override
	public Product createProduct(Product product) {
		String createProduct = "INSERT INTO product (supplier_id, category_id, product_name, description, cost_price, sale_price, unit_measure, image, current_stock, minimum_stock) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(createProduct, product.getSupplier().getId(), product.getCategory().getId(), product.getProduct(), product.getDescription(), product.getCostPrice(), product.getSalePrice(), product.getUnitMeasure(), product.getImage(), product.getCurrentStock(), product.getMinimumStock());
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		String updateProduct = "UPDATE product SET supplier_id = ?, category_id = ?, product_name = ?, description = ?, cost_price = ?, sale_price = ?, unit_measure = ?, image = ?, current_stock = ?, minimum_stock = ? WHERE product_id = ?";
		jdbcTemplate.update(updateProduct, product.getSupplier().getId(), product.getCategory().getId(), product.getProduct(), product.getDescription(), product.getCostPrice(), product.getSalePrice(), product.getUnitMeasure(), product.getImage(), product.getCurrentStock(), product.getMinimumStock(), product.getId());
		return product;
	}

	@Override
	public Product deleteProduct(Long id) {
		String selectProduct = "SELECT p.product_id, p.supplier_id, p.category_id, p.product_name, p.description, p.cost_price, p.sale_price, p.unit_measure, p.image, p.current_stock, p.minimum_stock, s.supplier_name, s.tax_id, s.email, c.category FROM product p LEFT JOIN supplier s ON p.supplier_id = s.supplier_id LEFT JOIN category c ON p.category_id = c.category_id";
		Product toDelete = jdbcTemplate.queryForObject(selectProduct, new ProductMapper(), id);
		if (toDelete != null) {
			String deleteProduct = "DELETE FROM access_level WHERE access_level_id = ?";
			jdbcTemplate.update(deleteProduct, id);
			return toDelete;
		}
		return null;
	}
}
