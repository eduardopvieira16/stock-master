package br.com.vieira.stockmaster.service;

import java.util.List;

import br.com.vieira.stockmaster.model.Category;

public interface CategoryService {

	/* Only Read - List and Search */
	List<Category> listAll();

	List<Category> listByName(String category);

	Category searchByCode(Integer id);

	/* Create - Update - Delete */
	Category saveCategory(Category category);

	Category deleteCategory(Long id);
}
