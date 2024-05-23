package br.com.vieira.stockmaster.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.stockmaster.model.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getLong("product_id"));
		product.setProduct(rs.getString("product_name"));
		product.setDescription(rs.getString("description"));
		product.setCostPrice(rs.getDouble("cost_price"));
		product.setSalePrice(rs.getDouble("sale_price"));
		product.setUnitMeasure(rs.getString("unit_measure"));
		product.setImage(rs.getString("image"));
		product.setCurrentStock(rs.getLong("current_stock"));
		product.setMinimumStock(rs.getLong("minimum_stock"));
		product.setSupplier(rs.getLong("supplier_id"), rs.getString("supplier_name"), rs.getString("tax_id"),
				rs.getString("email"));
		product.setCategory(rs.getLong("category_id"), rs.getString("category"));
		return product;
	}

}
