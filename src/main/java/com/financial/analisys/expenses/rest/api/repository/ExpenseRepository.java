package com.financial.analisys.expenses.rest.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.financial.analisys.expenses.rest.api.domain.CategoryBO;
import com.financial.analisys.expenses.rest.api.domain.ExpenseBO;
import com.financial.analisys.expenses.rest.api.domain.UserBO;

@Repository
public interface ExpenseRepository extends MongoRepository<ExpenseBO, String> {

	List<ExpenseBO> findByUserAndCategory(UserBO userBO, CategoryBO categoryBO);

	List<ExpenseBO> findByUserAndCity(UserBO userBO, String cityName);

	List<ExpenseBO> findByUser(UserBO userBO);
}
