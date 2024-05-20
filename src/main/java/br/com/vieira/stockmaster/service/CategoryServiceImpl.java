package br.com.vieira.stockmaster.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.vieira.stockmaster.dao.CategoryDao;
import br.com.vieira.stockmaster.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryDao categoryDao;

	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> listAll() {
		return categoryDao.listCategory();
	}

	@Override
	public List<Category> listByName(String category) {
		return categoryDao.listByNameCategory(category);
	}

	@Override
	public Category searchByCode(Integer id) {
		return categoryDao.searchByCodeCategory(id);
	}

	@Override
	public Category saveCategory(Category category) {
		if (category.getId() == null) {
			return categoryDao.createCategory(category);
		} else {
			return categoryDao.updateCategory(category);
		}
	}

	@Override
	public Category deleteCategory(Long id) {
		return categoryDao.deleteCategory(id);
	}
}
