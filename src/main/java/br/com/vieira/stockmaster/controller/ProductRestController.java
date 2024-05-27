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

import br.com.vieira.stockmaster.model.Product;
import br.com.vieira.stockmaster.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/v1/product")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/list/all")
    public List<Product> listAllCategories() {
        try {
        	return productService.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(path = "/list/name/{product}")
    public List<Product> listByNameProduct(@PathVariable("product") String product) {
        try {
        	return productService.listByName(product);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }

    @GetMapping(path = "/search/{id}")
    public Product searchByCodeProduct(@PathVariable("id") Long id) {
        try {
        	return productService.searchByCode(id);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }

    @PostMapping
    public Product saveUser(@RequestBody Product product) {
        try {
        	return productService.saveProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public Product deleteProduct(@PathVariable("id") Long id) {
        try {
        	return productService.deleteProduct(id);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }
}
