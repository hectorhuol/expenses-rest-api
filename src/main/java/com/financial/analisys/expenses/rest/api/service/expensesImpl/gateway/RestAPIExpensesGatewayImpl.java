package com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway;

import java.util.List;

import com.financial.analisys.expenses.api.domain.Expense;
import com.financial.analisys.expenses.api.domain.User;
import com.financial.analisys.expenses.api.gateways.ExpensesGateway;
import com.financial.analisys.expenses.rest.api.domain.ExpenseBO;
import com.financial.analisys.expenses.rest.api.domain.UserBO;
import com.financial.analisys.expenses.rest.api.exceptions.NoDataFoundException;
import com.financial.analisys.expenses.rest.api.repository.ExpenseRepository;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

public class RestAPIExpensesGatewayImpl implements ExpensesGateway {

	private ExpenseRepository expenseRepository;

	public RestAPIExpensesGatewayImpl(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	@Override
	public Expense createExpense(Expense expense) {
		ExpenseBO expenseBO = expenseRepository.save(BOUtils.transformObject(
				expense, ExpenseBO.class));
		if (isObjectNull(expenseBO)) {
			expense.setExpenseId(expenseBO.getExpenseId());
			return expense;
		}
		throw new NoDataFoundException("No data found");
	}

	@Override
	public void updateExpense(Expense expense) {
		expenseRepository.save(BOUtils
				.transformObject(expense, ExpenseBO.class));
	}

	@Override
	public void deleteExpense(Expense expense) {
		expenseRepository.delete(BOUtils.transformObject(expense,
				ExpenseBO.class));
	}

	@Override
	public Expense getExpense(Expense expense) {
		ExpenseBO expenseBO = expenseRepository.findOne(expense.getExpenseId());
		if (isObjectNull(expenseBO))
			return BOUtils.transformObject(expenseBO, Expense.class);
		throw new NoDataFoundException("No data found");
	}

	@Override
	public List<Expense> getAllExpenses() {
		List<ExpenseBO> list = expenseRepository.findAll();
		if (isObjectNull(list))
			return BOUtils.transformObjectList(list, Expense.class);
		throw new NoDataFoundException("No data found");
	}

	@Override
	public List<Expense> getAllUserExpenses(User user) {
		UserBO userBO = BOUtils.transformObject(user, UserBO.class);
		List<ExpenseBO> list = expenseRepository.findByUser(userBO);
		if (isObjectNull(list))
			return BOUtils.transformObjectList(list, Expense.class);
		throw new NoDataFoundException("No data found");
	}

	private boolean isObjectNull(Object object) {
		return object != null;
	}
}