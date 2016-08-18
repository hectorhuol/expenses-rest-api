package com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway;

import java.util.List;

import com.financial.analisys.expenses.api.domain.Category;
import com.financial.analisys.expenses.api.gateways.CategoriesGateway;
import com.financial.analisys.expenses.rest.api.domain.CategoryBO;
import com.financial.analisys.expenses.rest.api.exceptions.NoDataFoundException;
import com.financial.analisys.expenses.rest.api.repository.CategoryRepository;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

public class RestAPICategoriesGatewayImpl implements CategoriesGateway {

	private CategoryRepository categoryRepository;

	public RestAPICategoriesGatewayImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category createCategory(Category category) {
		CategoryBO categoryBO = categoryRepository.save(BOUtils
				.transformObject(category, CategoryBO.class));
		if (isObjectNull(categoryBO)) {
			category.setCategoryId(categoryBO.getCategoryId());
			return category;
		}
		throw new NoDataFoundException("No data found");
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.save(BOUtils.transformObject(category,
				CategoryBO.class));
	}

	@Override
	public void deleteCategory(Category category) {
		categoryRepository.delete(BOUtils.transformObject(category,
				CategoryBO.class));
	}

	@Override
	public Category getCategory(Category category) {
		CategoryBO categoryBO = categoryRepository.findOne(category
				.getCategoryId());
		if (isObjectNull(categoryBO))
			return BOUtils.transformObject(categoryBO, Category.class);
		throw new NoDataFoundException("No data found");
	}

	@Override
	public List<Category> getAllCategories() {
		List<CategoryBO> list = categoryRepository.findAll();
		if (isObjectNull(list))
			return BOUtils.transformObjectList(list, Category.class);
		throw new NoDataFoundException("No data found");
	}

	private boolean isObjectNull(Object object) {
		return object != null;
	}
}