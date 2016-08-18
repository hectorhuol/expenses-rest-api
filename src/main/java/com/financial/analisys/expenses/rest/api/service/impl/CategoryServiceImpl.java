package com.financial.analisys.expenses.rest.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.analisys.expenses.api.domain.Category;
import com.financial.analisys.expenses.rest.api.domain.CategoryBO;
import com.financial.analisys.expenses.rest.api.service.CategoryService;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.ExpensesAPIFacade;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ExpensesAPIFacade expensesAPIFacade;

	@Override
	public CategoryBO createCategory(CategoryBO categoryBO) {
		Category category = expensesAPIFacade.getCategoriesManager()
				.createCategory(
						BOUtils.transformObject(categoryBO, Category.class));
		categoryBO.setCategoryId(category.getCategoryId());
		return categoryBO;
	}

	@Override
	public void updateCategory(CategoryBO categoryBO) {
		expensesAPIFacade.getCategoriesManager().updateCategory(
				BOUtils.transformObject(categoryBO, Category.class));
	}

	@Override
	public void deleteCategory(String id) {
		Category category = new Category();
		category.setCategoryId(id);
		expensesAPIFacade.getCategoriesManager().deleteCategory(category);
	}

	@Override
	public CategoryBO getCategory(String id) {
		Category category = new Category();
		category.setCategoryId(id);
		category = expensesAPIFacade.getCategoriesManager().getCategory(
				category);
		return BOUtils.transformObject(category, CategoryBO.class);
	}

	@Override
	public List<CategoryBO> getAllCategories() {
		List<Category> categories = expensesAPIFacade.getCategoriesManager()
				.getAllCategories();
		return BOUtils.transformObjectList(categories, CategoryBO.class);
	}

}
