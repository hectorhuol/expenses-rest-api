package com.financial.analisys.expenses.rest.api.service;

import java.util.List;

import com.financial.analisys.expenses.rest.api.domain.CategoryBO;

public interface CategoryService {

	CategoryBO createCategory(CategoryBO categoryBO);

	void updateCategory(CategoryBO categoryBO);

	void deleteCategory(String id);

	CategoryBO getCategory(String id);

	List<CategoryBO> getAllCategories();

}
