package com.financial.analisys.expenses.rest.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.analisys.expenses.api.domain.Category;
import com.financial.analisys.expenses.api.domain.Companion;
import com.financial.analisys.expenses.api.domain.Expense;
import com.financial.analisys.expenses.api.domain.User;
import com.financial.analisys.expenses.api.utils.FinancialUtils;
import com.financial.analisys.expenses.rest.api.domain.ExpenseBO;
import com.financial.analisys.expenses.rest.api.service.ExpenseService;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.ExpensesAPIFacade;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpensesAPIFacade expensesAPIFacade;

	@Override
	public ExpenseBO createExpense(ExpenseBO expenseBO) {
		Expense expense = expensesAPIFacade.getExpensesManager().createExpense(
				BOUtils.transformObject(expenseBO, Expense.class));
		expenseBO.setExpenseId(expense.getExpenseId());
		return expenseBO;
	}

	@Override
	public void updateExpense(ExpenseBO expenseBO) {
		expensesAPIFacade.getExpensesManager().updateExpense(
				BOUtils.transformObject(expenseBO, Expense.class));
	}

	@Override
	public void deleteExpense(String id) {
		Expense expense = new Expense();
		expense.setExpenseId(id);
		expensesAPIFacade.getExpensesManager().deleteExpense(expense);
	}

	@Override
	public ExpenseBO getExpense(String id) {
		Expense expense = new Expense();
		expense.setExpenseId(id);
		expense = expensesAPIFacade.getExpensesManager().getExpense(expense);
		return BOUtils.transformObject(expense, ExpenseBO.class);
	}

	@Override
	public List<ExpenseBO> getAllExpenses() {
		List<Expense> expenses = expensesAPIFacade.getExpensesManager()
				.getAllExpenses();
		return transformList(expenses);
	}

	@Override
	public List<ExpenseBO> getAllUserExpenses(String userId) {
		User user = new User();
		user.setUserId(userId);
		List<Expense> expenses = expensesAPIFacade.getExpensesManager()
				.getAllUserExpenses(user);
		return transformList(expenses);
	}

	@Override
	public List<ExpenseBO> getExpensesByCategoryByUser(String categoryId,
			String userId) {
		User user = new User();
		user.setUserId(userId);
		Category category = new Category();
		category.setCategoryId(categoryId);
		List<Expense> expenses = expensesAPIFacade.getExpensesManager()
				.getExpensesByCategoryByUser(category, user);
		return transformList(expenses);
	}

	@Override
	public List<ExpenseBO> getExpensesByCityByUser(String cityName,
			String userId) {
		User user = new User();
		user.setUserId(userId);
		List<Expense> expenses = expensesAPIFacade.getExpensesManager()
				.getExpensesByCityByUser(cityName, user);
		return transformList(expenses);
	}

	@Override
	public List<ExpenseBO> getExpensesByCompanionsByUser(
			List<String> companionsIds, String userId) {
		User user = new User();
		user.setUserId(userId);
		List<Companion> companions = getCompanionsList(companionsIds);
		List<Expense> expenses = expensesAPIFacade.getExpensesManager()
				.getExpensesByCompanionsByUser(companions, user);
		return transformList(expenses);
	}

	private List<Companion> getCompanionsList(List<String> companionsIds) {
		List<Companion> companions = new ArrayList<Companion>();
		for (String companionId : companionsIds) {
			Companion companion = new Companion();
			companion.setCompanionId(companionId);
			companions.add(companion);
		}
		return companions;
	}

	@Override
	public List<ExpenseBO> getExpensesByMonthByUser(String month, String userId) {
		User user = new User();
		user.setUserId(userId);
		List<Expense> expenses = expensesAPIFacade.getExpensesManager()
				.getExpensesByMonthByUser(
						FinancialUtils.getLocalDateTime(month).toLocalDate(),
						user);
		return transformList(expenses);
	}

	@Override
	public List<ExpenseBO> getExpensesByDayByUser(String day, String userId) {
		User user = new User();
		user.setUserId(userId);
		List<Expense> expenses = expensesAPIFacade.getExpensesManager()
				.getExpensesByDayByUser(
						FinancialUtils.getLocalDateTime(day).toLocalDate(),
						user);
		return transformList(expenses);
	}

	@Override
	public List<ExpenseBO> getExpensesBetweenDatesByUser(String startDate,
			String finishDate, String userId) {
		User user = new User();
		user.setUserId(userId);
		List<Expense> expenses = expensesAPIFacade.getExpensesManager()
				.getExpensesBetweenDatesByUser(
						FinancialUtils.getLocalDateTime(startDate),
						FinancialUtils.getLocalDateTime(finishDate), user);
		return transformList(expenses);
	}

	private List<ExpenseBO> transformList(List<Expense> expenses) {
		return BOUtils.transformObjectList(expenses, ExpenseBO.class,
				new String[] { "password" });
	}

}
