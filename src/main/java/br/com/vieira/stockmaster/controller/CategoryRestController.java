package br.com.vieira.stockmaster.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vieira.stockmaster.model.Category;
import br.com.vieira.stockmaster.service.CategoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/v1/category")
public class CategoryRestController {
    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/list/all")
    public List<Category> listAllCategories() {
        try {
        	return categoryService.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(path = "/list/name/{category}")
    public List<Category> listByNameCategory(@PathVariable("category") String category) {
        try {
        	return categoryService.listByName(category);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }

    @GetMapping(path = "/search/{id}")
    public Category searchByCodeCategory(@PathVariable("id") Integer id) {
        try {
        	return categoryService.searchByCode(id);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }

    @PostMapping
    public Category saveUser(@RequestBody Category category) {
        try {
        	return categoryService.saveCategory(category);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public Category deleteCategory(@PathVariable("id") Long id) {
        try {
        	return categoryService.deleteCategory(id);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }
}
