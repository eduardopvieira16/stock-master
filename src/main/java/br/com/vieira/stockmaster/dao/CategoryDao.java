package br.com.vieira.stockmaster.dao;

import java.util.List;

import br.com.vieira.stockmaster.model.Category;

public interface CategoryDao {

	/* Only Read - List and Search */
	List<Category> listCategory();

	List<Category> listByNameCategory(String category);

	Category searchByCodeCategory(Integer id);

	/* Create - Update - Delete */
	Category createCategory(Category category);

	Category updateCategory(Category category);

	Category deleteCategory(Long id);
}
