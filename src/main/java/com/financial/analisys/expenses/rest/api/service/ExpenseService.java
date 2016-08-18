package com.financial.analisys.expenses.rest.api.service;

import java.util.List;

import com.financial.analisys.expenses.rest.api.domain.ExpenseBO;

public interface ExpenseService {

	ExpenseBO createExpense(ExpenseBO expenseBO);

	void updateExpense(ExpenseBO expenseBO);

	void deleteExpense(String id);

	ExpenseBO getExpense(String id);
	
	List<ExpenseBO> getAllExpenses();

	List<ExpenseBO> getAllUserExpenses(String userId);

	List<ExpenseBO> getExpensesByCategoryByUser(String categoryId, String userId);

	List<ExpenseBO> getExpensesByCityByUser(String cityName, String userId);

	List<ExpenseBO> getExpensesByCompanionsByUser(List<String> companionsIds,
			String userId);

	List<ExpenseBO> getExpensesByMonthByUser(String month, String userId);

	List<ExpenseBO> getExpensesByDayByUser(String day, String userId);

	List<ExpenseBO> getExpensesBetweenDatesByUser(String startDate,
			String finishDate, String userId);

}
