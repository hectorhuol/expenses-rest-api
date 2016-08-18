package com.financial.analisys.expenses.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.financial.analisys.expenses.rest.api.domain.CategoryBO;
import com.financial.analisys.expenses.rest.api.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(path = "/category", method = RequestMethod.POST)
	public CategoryBO createCategory(@RequestBody CategoryBO categoryBO) {
		return categoryService.createCategory(categoryBO);
	}

	@RequestMapping(path = "/category", method = RequestMethod.PUT)
	public void updateCategory(@RequestBody CategoryBO categoryBO) {
		categoryService.updateCategory(categoryBO);
	}

	@RequestMapping(path = "/category/{id}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable String id) {
		categoryService.deleteCategory(id);
	}

	@RequestMapping(path = "/category/{id}", method = RequestMethod.GET)
	public CategoryBO getCategory(@PathVariable String id) {
		return categoryService.getCategory(id);
	}

	@RequestMapping(path = "/category", method = RequestMethod.GET)
	public List<CategoryBO> getAllCategories() {
		return categoryService.getAllCategories();
	}

}
