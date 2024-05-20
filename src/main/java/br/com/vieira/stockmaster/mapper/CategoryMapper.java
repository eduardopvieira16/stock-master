package br.com.vieira.stockmaster.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.stockmaster.model.Category;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category = new Category();

		category.setId(rs.getLong("category_id"));
		category.setCategory(rs.getString("category"));
		category.setCreatedAt(rs.getTimestamp("created_at"));
		category.setUpdateAt(rs.getTimestamp("updated_at"));
		return category;
	}

}
