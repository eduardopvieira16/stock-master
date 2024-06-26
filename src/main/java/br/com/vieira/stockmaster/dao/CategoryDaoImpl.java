package br.com.vieira.stockmaster.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.vieira.stockmaster.mapper.CategoryMapper;
import br.com.vieira.stockmaster.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	private final JdbcTemplate jdbcTemplate;

	public CategoryDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Category> listCategory() {
		String listAll = "SELECT category_id, category FROM category ORDER BY category_id ASC";
		return jdbcTemplate.query(listAll, new CategoryMapper());
	}

	@Override
	public List<Category> listByNameCategory(String category) {
		String listByName = "SELECT category_id, category FROM category WHERE category LIKE ?";
		return jdbcTemplate.query(listByName, new CategoryMapper(), "%" + category + "%");
	}

	@Override
	public Category searchByCodeCategory(Integer id) {
		String searchByCode = "SELECT category_id, category FROM category WHERE category_id = ?";
		return jdbcTemplate.queryForObject(searchByCode, new CategoryMapper(), id);
	}

	@Override
	public Category createCategory(Category category) {
		String createCategory = "INSERT INTO category (category) VALUES(?)";
		jdbcTemplate.update(createCategory, category.getCategory());
		return category;
	}

	@Override
	public Category updateCategory(Category category) {
		String updateCategory = "UPDATE category SET category = ? WHERE category_id = ?";
		jdbcTemplate.update(updateCategory, category.getCategory(), category.getId());
		return category;
	}

	@Override
	public Category deleteCategory(Long id) {
		String selectCategory = "SELECT category_id, category FROM category WHERE category_id = ?";
		Category toDelete = jdbcTemplate.queryForObject(selectCategory, new CategoryMapper(), id);
		if (toDelete != null) {
			String deleteUser = "DELETE FROM category WHERE category_id = ?";
			jdbcTemplate.update(deleteUser, id);
			return toDelete;
		}
		return null;
	}
}
